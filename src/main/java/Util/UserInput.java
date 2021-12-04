package Util;
//추가 라이브러리 불러옴
import org.json.simple.JSONArray;

import java.util.Objects;
import java.util.Scanner;

//데코레이터 디자인 패턴을 사용해서 사용자에게 값을 받고 예외처리를 한 뒤 돌려주는 클래스
public class UserInput {
    //반환할 문자열타입 변수 선언
    String returnString;

    //사용자가 입력한 값을 예외처리를 안하고 그대로 반환하는 메소드
    public String simple(String print){
        Check simpleCheck = new UserWrite(print);
        returnString = simpleCheck.check();
        return returnString;
    }

    //사용자가 입력한 값을 정수인지 확인하고 년도값이 올바른지 확인한 후 반환하는 메소드
    public String year(String print){
        Check yearCheck = new YearCheck(new IntCheck(new UserWrite(print)));
        returnString = yearCheck.check();
        if (returnString == "error")
            year(print);
        return returnString;
    }
    //사용자가 입력한 값을 정수인지 확인하고 월값이 올바른지 확인한 후 반환하는 메소드
    public String month(String print){
        Check monthCheck = new MonthCheck(new IntCheck(new UserWrite(print)));
        returnString = monthCheck.check();
        if (returnString == "error")
            month(print);
        return returnString;
    }
    //사용자가 입력한 값을 정수인지 확인하고 일값이 올바른지 확인한 후 반환하는 메소드
    public String day(String print){
        Check dayCheck = new DayCheck(new IntCheck(new UserWrite(print)));
        returnString = dayCheck.check();
        if (returnString == "error")
            day(print);
        return returnString;
    }
    //사용자가 입력한 값을 정수인지만 확인하고 반환하는 메소드
    public String integer(String print){
        Check intDraw = new IntCheck(new UserWrite(print));
        returnString = intDraw.check();
        if (returnString == "error")
            integer(print);
        return returnString;
    }
    public String selTwo(String print){
        Check twoCheck = new QuitCheck(new TwoCheck(new IntCheck(new UserWrite(print))));
        returnString = twoCheck.check();
        if (returnString == "error")
            selTwo(print);
        return returnString;
    }
    public String selFour(String print){
        Check fourCheck = new QuitCheck(new FourCheck(new IntCheck(new UserWrite(print))));
        returnString = fourCheck.check();
        if (returnString == "error")
            selFour(print);
        return returnString;
    }
    public String selFive(String print){
        Check fourCheck = new QuitCheck(new FiveCheck(new IntCheck(new UserWrite(print))));
        returnString = fourCheck.check();
        if (returnString == "error")
            selFour(print);
        return returnString;
    }


}

//클래스의 상속에서 가장 상위에 있는 클래스. 문자열 변수를 먼저 선언하고 draw 추상메소드를 구현함
abstract class Check {
    String userInput;
    public abstract String check();
}

//사용자에게 입력값을 받는 클래스
class UserWrite extends Check {
    Scanner sc = new Scanner(System.in);
    String outString;

    public UserWrite(String out){
        outString = out;
    }
    @Override
    public String check() {
        System.out.print(outString);
        userInput = sc.next();
        return userInput;
    }
}

//Check클래스를 상속한 뒤 아래의 손자 클래스(Check기준)들의 속성을 정의해주는 클래스
abstract class CheckDecorator extends Check {
    private final Check DECORATED_CHECK;

    public CheckDecorator(Check checkedDisplay) {
        this.DECORATED_CHECK = checkedDisplay;
    }

    @Override
    public String check() {
        userInput = DECORATED_CHECK.check();
        return userInput;
    }
}

//부모 클래스를 먼저 탐색한 뒤 사용자가 입력한 값이 0보다 큰 정수인지 확인하는 클래스
class IntCheck extends CheckDecorator {
    public IntCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String check() {
        userInput = super.check();
        userInput = checkInt(userInput);
        return userInput;
    }
    private String checkInt(String checkString) {
        userInput = checkString;
        boolean intBoolean = userInput.matches("-?\\d+");
        if (!intBoolean) {
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
    public String check() {
        userInput = super.check();
        userInput = checkYear(userInput);
        return userInput;
    }
    private String checkYear(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){
            return userInput;
        }
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
    public String check() {
        userInput = super.check();
        userInput = checkMonth(userInput);
        return userInput;
    }
    private String checkMonth(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; } //리턴 유저인풋
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
    public String check() {
        userInput = super.check();
        userInput = checkDay(userInput);
        return userInput;
    }
    private String checkDay(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; }
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
class TwoCheck extends CheckDecorator {
    public TwoCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String check() {
        userInput = super.check();
        userInput = checkTwo(userInput);
        return userInput;
    }
    private String checkTwo(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; }
        if (Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 2){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.1에서 2사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}
class FourCheck extends CheckDecorator {
    public FourCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String check() {
        userInput = super.check();
        userInput = checkFour(userInput);
        return userInput;
    }
    private String checkFour(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; }
        if (Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 4){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.1에서 4사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}

class FiveCheck extends CheckDecorator {
    public FiveCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String check() {
        userInput = super.check();
        userInput = checkFive(userInput);
        return userInput;
    }
    private String checkFive(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; }
        if (Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 5){
            return userInput;
        }
        else {
            userInput = "error";
            System.out.println("\n error.1에서 5사이의 정수를 입력해주세요.");
            return userInput;
        }
    }
}
class QuitCheck extends CheckDecorator {
    public QuitCheck(Check checkedDisplay) {
        super(checkedDisplay);
    }
    @Override
    public String check() {
        userInput = super.check();
        userInput = checkQuit(userInput);
        return userInput;
    }
    private String checkQuit(String checkString) {
        userInput = checkString;
        if(Objects.equals(userInput, "error")){ return userInput; }
        if (userInput == "q"){
            userInput = "q";
            System.out.println("\n 나가기를 선택하셨습니다.");
            return userInput;
        }
        return userInput;
    }
}