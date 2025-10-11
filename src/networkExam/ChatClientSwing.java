package networkExam;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientSwing extends JFrame {
    private JTextPane textPane;
    private JTextField inputField;
    private JButton sendButton;
    private PrintWriter out;

    private static final String SELF_TAG = "__SELF__";
    private static final String TIMESTAMP_TAG = "__TS__";
    private static final String NICKNAME_TAG = "__NN__";
    private static final String MSG_TAG = "__MSG__";
    private static final String SYSTEM_TAG = "__SYS__";

    public ChatClientSwing(String host, int port) {
        setTitle("채팅 클라이언트");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignore) { }

        System.setProperty("swing.aatext", "true");
        System.setProperty("awt.useSystemAAFontSettings", "on");

        // UI 구성
        Font uiFont = new Font("Apple SD Gothic Neo", Font.PLAIN, 14);
        if (uiFont.getFamily().equals("Dialog")) {
            uiFont = new Font("NanumGothic", Font.PLAIN, 14);
        }

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(uiFont);
        JScrollPane scrollPane = new JScrollPane(textPane);

        inputField = new JTextField();
        inputField.setFont(uiFont);
        sendButton = new JButton("전송");
        sendButton.setFont(uiFont);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼/엔터키 이벤트
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        // 서버 연결 스레드
        new Thread(() -> connect(host, port)).start();
    }

    private void connect(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

            // 서버 메시지 읽는 스레드
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        renderTaggedLine(line);
                    }
                } catch (IOException e) {
                    appendMessage("서버 연결이 종료되었습니다.", Color.RED);
                }
            }).start();

        } catch (IOException e) {
            appendMessage("서버 연결 실패: " + e.getMessage(), Color.RED);
        }
    }

    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty() && out != null) {
            out.println(msg);
            inputField.setText("");
        }
    }

    private void appendMessage(String msg) {
        appendMessage(msg, Color.BLACK); // 기본 검은색
    }

    private void appendMessage(String msg, Color color) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = textPane.getStyledDocument();
                Style style = textPane.addStyle("Style", null);
                StyleConstants.setForeground(style, color);
                doc.insertString(doc.getLength(), msg + "\n", style);
                textPane.setCaretPosition(doc.getLength());
            } catch (BadLocationException e) {
                // ignore
            }
        });
    }

    private void renderTaggedLine(String raw) {
        boolean isSelf = false;
        String s = raw;

        // 1) SELF 태그 제거/판단
        if (s.startsWith(SELF_TAG)) {
            isSelf = true;
            s = s.substring(SELF_TAG.length());
        }

        // 2) 시스템 메시지 우선 처리: __SYS____TS__<ts>__MSG__<text>
        if (s.startsWith(SYSTEM_TAG)) {
            String ts = null, body = null;
            int tsPos = s.indexOf(TIMESTAMP_TAG);
            int msgPos = s.indexOf(MSG_TAG);
            if (tsPos >= 0 && msgPos > tsPos) {
                ts = s.substring(tsPos + TIMESTAMP_TAG.length(), msgPos);
                body = s.substring(msgPos + MSG_TAG.length());
            } else {
                body = s; // 예상치 못한 형식이면 전체 출력
            }
            appendSystem(ts, body);
            return;
        }

        // 3) 일반 채팅 메시지: __TS__<ts>__NN__<nick>__MSG__<text>
        int tsPos   = s.indexOf(TIMESTAMP_TAG);
        int nickPos = s.indexOf(NICKNAME_TAG);
        int msgPos  = s.indexOf(MSG_TAG);

        String ts = null, nick = null, msg = null;
        if (tsPos == 0 && nickPos > tsPos && msgPos > nickPos) {
            ts   = s.substring(tsPos + TIMESTAMP_TAG.length(), nickPos);
            nick = s.substring(nickPos + NICKNAME_TAG.length(), msgPos);
            msg  = s.substring(msgPos + MSG_TAG.length());
        } else {
            // 태그 형식이 아니면 통째로 본문 처리
            msg = s;
        }

        // 4) 닉네임/색상
        String displayName = (isSelf ? "[나]" : (nick != null && !nick.isEmpty() ? "[" + nick + "]" : ""));
        Color bodyColor = isSelf ? Color.BLUE : Color.BLACK;

        // 5) 출력
        appendRich(ts, displayName, msg, bodyColor);
    }

    private void appendRich(String ts, String displayName, String msg, Color bodyColor) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = textPane.getStyledDocument();

                // 공통 폰트 크기
                int baseSize = 14;

                // 타임스탬프 스타일 (작게/회색)
                if (ts != null && !ts.isEmpty()) {
                    Style tsStyle = textPane.addStyle("tsStyle", null);
                    StyleConstants.setFontSize(tsStyle, 11);         // 더 작게
                    StyleConstants.setForeground(tsStyle, Color.GRAY);
                    doc.insertString(doc.getLength(), "[" + ts + "] ", tsStyle);
                }

                // 이름 스타일 (굵게, 기본색 그대로)
                if (displayName != null && !displayName.isEmpty()) {
                    Style nameStyle = textPane.addStyle("nameStyle", null);
                    StyleConstants.setFontSize(nameStyle, baseSize);
                    StyleConstants.setBold(nameStyle, true);
                    doc.insertString(doc.getLength(), displayName + " ", nameStyle);
                }

                // 구분자 ": "
                Style sepStyle = textPane.addStyle("sepStyle", null);
                StyleConstants.setFontSize(sepStyle, baseSize);
                doc.insertString(doc.getLength(), ": ", sepStyle);

                // 본문 스타일 (내 메시지면 파랑, 아니면 검정)
                Style bodyStyle = textPane.addStyle("bodyStyle", null);
                StyleConstants.setFontSize(bodyStyle, baseSize);
                StyleConstants.setForeground(bodyStyle, bodyColor);
                doc.insertString(doc.getLength(), (msg != null ? msg : "") + "\n", bodyStyle);

                textPane.setCaretPosition(doc.getLength());
            } catch (BadLocationException ignore) {}
        });
    }

    private void appendSystem(String ts, String body) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = textPane.getStyledDocument();

                int baseSize = 14;

                // 타임스탬프 (작게/회색)
                if (ts != null && !ts.isEmpty()) {
                    Style tsStyle = textPane.addStyle("sysTsStyle", null);
                    StyleConstants.setFontSize(tsStyle, 11);
                    StyleConstants.setForeground(tsStyle, Color.GRAY);
                    doc.insertString(doc.getLength(), "[" + ts + "] ", tsStyle);
                }

                // 본문 (회색)
                Style bodyStyle = textPane.addStyle("sysBodyStyle", null);
                StyleConstants.setFontSize(bodyStyle, baseSize);
                StyleConstants.setForeground(bodyStyle, Color.GRAY);
                doc.insertString(doc.getLength(), (body != null ? body : "") + "\n", bodyStyle);

                textPane.setCaretPosition(doc.getLength());
            } catch (BadLocationException ignore) {}
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.setProperty("sun.java2d.metal", "false");
            System.setProperty("apple.awt.application.appearance", "system");
            ChatClientSwing client = new ChatClientSwing("localhost", 12345);
            client.setVisible(true);
        });
    }
}
