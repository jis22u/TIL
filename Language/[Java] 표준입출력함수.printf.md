## printf()

### 설명

- 포맷(출력할 형식) 개수 == 포맷을 적용할 데이터(출력할 데이터)의 개수
- printf() 메서드는 오른쪽 정렬이 기본
- % 다음에 마이너스 표시(-)가 있으면 왼쪽 정렬로 출력
- % 다음에 숫자가 있다면 출력될 자릿수를 지정
- 실수는 %a.b로 표현  
  a : 소수점 이하의 숫자까지 포함해 출력될 최소 자릿수  
  b : 소수점 이하 자릿수
- 출력할 내용이 자릿수보다 작으면 공백으로 채우지만, % 다음에 0이 있으면 0으로 채움
- 탭(Tab)은 \t, 줄 바꿈은 \n, % 기호는 %%로 표현하여 출력

<br>

### 지시자

- %b : boolean 형식으로 출력
- %c : char 형식으로 출력
- %d : integer(decimal) 형식으로 출력
- %e : 지수 표현식의 형식으로 출력
- %f : float 형식으로 출력
- %n : 줄바꿈
- %o : 8진수(octal) integer 형식으로 출력
- %s : String 형식으로 출력
- %t : date, time 형식으로 출력
- %x : 16진수(hexadecimal) integer 형식으로 출력

<br>

### 예제코드

```java
public class Main {
    public static void main(String[] args) {
        System.out.printf("%d", 1000);          //1000(10진수로 출력)
        System.out.printf("%8d", 1000);         //    1000(8자리, 빈자리는 공백으로 처리)
        System.out.printf("%-8d", 1000);        //1000    (8자리, 빈자리는 공백으로 처리, 왼쪽정렬)
        System.out.printf("%08d", 1000);        //00001000(8자리, 빈자리는 0으로 채움)

        System.out.printf("%s", "hello");
        System.out.printf("%7s", "hello");
        System.out.printf("%-7s", "hello");

        System.out.printf("%f", 3.14);		//3.140000(10진수 실수, 소수점 이하 자릿수의 default는 6자리)
        System.out.printf("%5.1f", 3.14);	//  3.1(소수점 이하 포함 5자리, 소수점 이하 1자리)
        System.out.printf("%-5.1f", 3.14);	//3.1  (소수점 이하 포함 5자리, 소수점 이하 1자리, 왼쪽정렬)
        System.out.printf("%05.1f", 3.14);	//003.1(소수점 이하 포함 5자리, 소수점 이하 1자리, 빈자리 0)
   }
}

```
