## log 파일 만들어서 합치기

### day12 밑에 log 디렉토리 생성

1. accessLog 파일 만들기
   - `Thread.sleep()` 사용해서 3초마다 현재 시간 넣어서 로그 n줄 기록  
   - n은 입력받아도 되고, 하드코딩으로 숫자 넣어놔도 가능.
   - 기록한 내용을 accessLog.txt로 파일 만들어서 log 디렉토리에 저장

2. errorLog 파일 만들기
   - `Thread.sleep()` 사용해서 3초마다 현재 시간 넣어서 에러로그 n줄 기록  
   - n은 입력받아도 되고, 하드코딩으로 숫자 넣어놔도 가능.
   - 기록한 내용을 errorLog.txt로 파일 만들어서 log 디렉토리에 저장


```java
for ( //.. ) {
    Thread.sleep(3000);
    writer.println(현재시간);
}
```
***

### (+) 시간이 남는다면

3. 파일이 모두 만들어진 후, accessLog와 errorLog 파일을 모두 읽어와서 mergeLog.txt를 만들어서 합쳐서 저장

4. accessLog1, accessLog2 이렇게 파일 여러개 생성 해도 됨  

#### 예시
```text
accessLog1 파일 생성
accessLog2 파일 생성
-> accessLog_0904.txt 로 저장

errorLog1 파일 생성
errorLog2 파일 생성
-> errorLog_0904.txt 로 저장

accessLog_0904.txt + errorLog_0904.txt
= mergeLog_0904.txt 생성
```