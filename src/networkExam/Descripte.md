```text
[서버]                                [클라이언트]

new ServerSocket(12345)
   |
   |--- listen 상태 진입 (문 열고 기다림) ---->
   |

                                     new Socket("127.0.0.1", 12345)
                                     |
                                     |--- connect 요청 (SYN) ---------->
                                     |
                     
serverSocket.accept()  <--- 대기 큐에 연결 요청 도착
   |
   |--- 큐에서 하나 꺼내서 ------------------>
   |    Socket clientSocket 생성
   |
   |--- clientSocket ↔ socket -------------
   |       (양방향 통신 채널 개설)
```