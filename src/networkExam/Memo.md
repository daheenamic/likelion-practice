### 1. SimpleEchoServer.java
- ServerSocket과 accept()의 역할
- 클라이언트와 연결되면 소켓이 생성되고, 입출력 스트림으로 통신
- 서버가 받은 메시지를 그대로 돌려주는 “에코” 동작
- 단일 클라이언트만 처리 가능, 여러 명은 아직 안 됨 → 한계

### 2. SimpleEchoClient.java
- Socket 객체로 서버에 접속
- 키보드 입력 → 서버로 전송 → 서버 응답을 다시 받아 출력
- “bye” 입력 시 종료 로직
- 서버-클라이언트가 1:1 통신하는 기본 구조 이해

### 3. MultiThreadEchoServer.java
- 여러 클라이언트를 동시에 처리하기 위해 ExecutorService (스레드풀) 사용
- 클라이언트마다 ClientHandler 스레드가 따로 동작 → 동시 대화 가능
- 스레드풀 장점: 무한 스레드 생성 방지, 자원 효율적 관리
- 멀티스레드로 확장하면서 서버가 실용적으로 발전

### 4. ChatClient.java
- 서버 접속 후 입력을 서버로 보내고, 동시에 서버 메시지를 읽기 위해 readerThread 사용
- 송신/수신을 분리 → 실시간 채팅 가능
- “bye”로 종료 처리
- 채팅은 수신 스레드 분리가 필수 (안 하면 입력 대기 중 메시지 못 받음)

### 5. ChatServer.java
- 여러 클라이언트 관리: ConcurrentHashMap.newKeySet()으로 clients 보관
- broadcast() 메서드로 메시지를 모두에게 전송
- 닉네임 설정, 타임스탬프 출력, 입장/퇴장 알림
- 단순 에코 → 멀티스레드 → 브로드캐스트 채팅 서버로 발전한 완성 단계