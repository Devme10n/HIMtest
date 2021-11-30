package util;
//추가 라이브러리 불러옴
import java.util.Scanner;

//데코레이터 디자인 패턴을 사용해서 사용자에게 값을 받고 예외처리를 한 뒤 돌려주는 클래스
public class UserInput {
    //반환할 문자열타입 변수 선언
    String returnString;

    //사용자가 입력한 값을 예외처리를 안하고 그대로 반환하는 메소드
    public String simple(String print){
        Check simpleDraw = new UserWrite(print);
        returnString = simpleDraw.draw();
        return returnString;
    }

    //사용자가 입력한 값을 정수인지 확인하고 년도값이 올바른지 확인한 후 반환하는 메소드
    public String year(String print){
        Check yearDraw = new YearCheck(new IntCheck(new UserWrite(print)));
        returnString = yearDraw.draw();
        return returnString;
    }
    //사용자가 입력한 값을 정수인지 확인하고 월값이 올바른지 확인한 후 반환하는 메소드
    public String month(String print){
        Check monthDraw = new MonthCheck(new IntCheck(new UserWrite(print)));
        returnString = monthDraw.draw();
        return returnString;
    }
    //사용자가 입력한 값을 정수인지 확인하고 일값이 올바른지 확인한 후 반환하는 메소드
    public String day(String print){
        Check dayDraw = new DayCheck(new IntCheck(new UserWrite(print)));
        returnString = dayDraw.draw();
        return returnString;
    }
    //사용자가 입력한 값을 정수인지만 확인하고 반환하는 메소드
    public String integer(String print){
        Check intDraw = new IntCheck(new UserWrite(print));
        returnString = intDraw.draw();
        return returnString;
    }


}

//클래스의 상속에서 가장 상위에 있는 클래스. 문자열 변수를 먼저 선언하고 draw 추상메소드를 구현함
abstract class Check {
    String userInput;
    public abstract String draw();
}

//사용자에게 입력값을 받는 클래스
class UserWrite extends Check {
    Scanner sc = new Scanner(System.in);
    String outString;
    String returnString;

    public UserWrite(String out){
        outString = out;
    }
    @Override
    public String draw() {
        System.out.print(outString);
        returnString = sc.next();
        return returnString;
    }
}

//Check클래스를 상속한 뒤 아래의 손자 클래스(Check기준)들의 속성을 정의해주는 클래스
abstract class CheckDecorator extends Check {
    private final Check DECORATED_CHECK;
    boolean intBoolean;

    public CheckDecorator(Check checkedDisplay) {
        this.DECORATED_CHECK = checkedDisplay;
    }

    @Override
    public String draw() {
        userInput = DECORATED_CHECK.draw();
        return userInput;
    }
}

//부모 클래스를 먼저 탐색한 뒤 사용자가 입력한 값이 0보다 큰 정수인지 확인하는 클래스
class IntCheck extends CheckDecorator {
    public IntCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String draw() {
        userInput = super.draw();
        userInput = drawInt(userInput);
        return userInput;
    }
    private String drawInt(String checkString) {
        userInput = checkString;
        intBoolean = userInput.matches("-?\\d+");
        if (intBoolean == false) {
            userInput = "error";
            System.out.println("\n error.문자열이 아닌 0보다 큰 정수를 입력해주세요.");
            return userInput;
        }
        else if (Integer.parseInt(checkString) <= 0){
            userInput = "error";
            System.out.println("\n error.0보다 큰 정수를 입력해주세요.");
            return userInput;
        }
        else{
            return userInput;
        }

    }
}

//부모 클래스를 먼저 탐색한 뒤 사용자가 입력한 년도값이 올바른지 확인하는 클래스
class YearCheck extends CheckDecorator {
    public YearCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String draw() {
        userInput = super.draw();
        userInput = drawYear(userInput);
        return userInput;
    }
    private String drawYear(String checkString) {
        userInput = checkString;
        if(userInput == "error"){ return userInput; }
        if (Integer.parseInt(userInput) >= 2000 && Integer.parseInt(userInput) <= 2100){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.2000에서 2100사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}

//부모 클래스를 먼저 탐색한 뒤 사용자가 입력한 월값이 올바른지 확인하는 클래스
class MonthCheck extends CheckDecorator {
    public MonthCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String draw() {
        userInput = super.draw();
        userInput = drawMonth(userInput);
        return userInput;
    }
    private String drawMonth(String checkString) {
        userInput = checkString;
        if(userInput == "error"){ return userInput; }
        if (Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 12){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.1에서 12사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}

//부모 클래스를 먼저 탐색한 뒤 사용자가 입력한 날짜값이 올바른지 확인하는 클래스
class DayCheck extends CheckDecorator {
    public DayCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String draw() {
        userInput = super.draw();
        userInput = drawDay(userInput);
        return userInput;
    }
    private String drawDay(String checkString) {
        userInput = checkString;
        if(userInput == "error"){ return userInput; }
        if (Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 31){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.1에서 31사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}