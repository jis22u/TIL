## HTTP 통신과 SOCKET 통신의 비교

### HTTP와 WebSocket

HTTP와 WebSocket은 둘 다 통신 프로토콜이다. 프로토콜은 컴퓨터 내부에서, 또는 컴퓨터 사이에서 데이터의 교환 방식을 정의하는 규칙 체계이다. 기기 간 통신은 교환되는 데이터의 형식에 대해 상호 합의를 요구한다. 이런 형식을 정의하는 규칙의 집합을 프로토콜이라고 한다.

### HTTP 통신

- Client의 요청(Request)이 있을 때만 서버가 응답(Response)하여 해당 정보를 전송하고 곧바로 연결을 종료하는 방식

- HTTP 통신의 특징  
  1\) Client가 요청을 보내는 경우에만 Server가 응답하는 단방향 통신이다.  
  2\) Server로부터 응답을 받은 후에는 연결이 바로 종료된다.  
  3\) 실시간 연결이 아니고, 필요한 경우에만 Server로 요청을 보내는 상황에 유용하다.  
  4\) 요청을 보내 Server의 응답을 기다리는 어플리케이션의 개발에 주로 사용된다.

### WebSocket 통신

- Server와 Client가 특정 Port를 통해 실시간으로 양방향 통신을 하는 방식
- SOCKET 통신의 특징  
   1\) Server와 Client가 계속 연결을 유지하는 양방향 통신이다.  
   2\) Server와 Client가 실시간으로 데이터를 주고받는 상황이 필요한 경우에 사용된다.  
   3\) 실시간 동영상 Streaming이나 온라인 게임 등과 같은 경우에 자주 사용된다.  
   4\) WebSocket과의 주요 차이점은 예를 들어 HTTP에서 발생하는 것처럼 별도의 요청을 보내지 않고도 데이터를 수신할 수 있다는 것입니다. 연결이 설정되면 데이터는 요청을 보낼 필요 없이 저절로 올 것입니다. 지속적으로 업데이트되는 정보를 수신해야 하는 채팅이나 주식 보고서에서 WebSocket 프로토콜을 사용하는 이점이 있습니다.

  <br>

## SOCKET

(WebSocket과 Socket은 다르다.)

> 네트워크상에서 동작하는 프로그램 간 통신의 종착점. 1대1 통신의 경우 양 측 다 소켓이 존재해야 통신이 가능하다.

소켓(Socket)은 프로세스가 드넓은 네트워크 세계로 데이터를 내보내거나 혹은 그 세계로부터 데이터를 받기 위한 실제적인 창구 역할을 한다. 그러므로 프로세스가 데이터를 보내거나 받기 위해서는 반드시 소켓을 열어서 소켓에 데이터를 써보내거나 소켓으로부터 데이터를 읽어들여야 한다.  
다시말해 소켓은 떨어져 있는 두 호스트를 연결해주는 도구로써 인터페이스의 역할을 하는데 데이터를 주고 받을 수 있는 구조체로 소켓을 통해 데이터 통로가 만들어 진다. 이러한 소켓은 역할에 따라 서버 소켓, 클라이언트 소켓으로 구분된다.

- 서버(Server)  
  클라이언트 소켓의 연결 요청을 대기하고, 연결 요청이 오면 클라이언트 소켓을 생성하여 통신이 가능하게 한다.  
  1\) socket() 함수를 이용하여 소켓을 생성  
  2\) bind() 함수로 ip와 port 번호를 설정하게 됩니다.  
  3\) listen() 함수로 클라이언트의 접근 요청에 수신 대기열을 만들어 몇 개의 클라이언트를 대기 시킬지 결정  
  4\) accept() 함수를 사용하여 클라이언트와의 연결을 기다림

- 클라이언트(Client)  
  실제로 데이터 송수신이 일어나는 것은 클라이언트 소켓이다.  
  1\) socket() 함수로 가장먼저 소켓을 연다.  
  2\) connect() 함수를 이용하여 통신 할 서버의 설정된 ip와 port 번호에 통신을 시도  
  3\) 통신을 시도 시, 서버가 accept() 함수를 이용하여 클라이언트의 socket descriptor를 반환  
  4\) 이를 통해 클라이언트와 서버가 서로 read(), write() 를 하며 통신 (이 과정이 반복)