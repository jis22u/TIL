### 웹 서버란(Web Server)

- 클라이언트(웹 브라우저)의 HTTP 프로토콜 기반의 요청을 서비스하는 기능 담당
- 정적 콘텐츠 제공  
   : WAS를 거치지 않고 바로 자원 제공  
   : 웹 상의 정적 콘텐츠(CSS, Javascript, Image)를 처리
- 동적 콘텐츠 제공을 위한 요청 전달  
   : 클라이언트 요청을 WAS에 보내고, WAS에서 처리한 결과를 클라이언트에게 전달
- Apache 웹 서버, IIS 웹 서버, Google Web Server, Nginx 등

<br>

### 웹 애플리케이션 서버 (WAS, Web Application Server)

- DB 조회나 다양한 로직 처리를 요구하는 동적 콘텐츠(Servlet, JSP)를 처리하기 위해 사용
- Tomcat, Weblogic, Jeus, JBoss, Resin 등

💡[Web Server와 WAS 참고 링크](https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html)

<br>

### 데이터베이스 서버 (DBMS, DataBase Management System)

- 데이터베이스를 운영하고 관리하는 소프트웨어
- MySQL, Oracle, MS-SQL, DB2 등

<br>

### 파일 서버

- 파일 저장 하드웨어로 물리 저장 장치를 활용한 서버
- 대용량 HDD, SSD 등
