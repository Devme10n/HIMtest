package GoodsDb;

import java.util.*;
import Bot.ObserverNotify.Observer;

abstract class Subject {
    private static final List<Observer> observers = new ArrayList<>(); //ArrayList 인스턴스를 생성한 다음, 그 인스턴스의 주소를 Observer타입을 리턴하는 List 인터페이스의 참조변수 observers에 저장 //@@통보받을 대상들의 리스트
    //List에 final을 선언하여 observers 변수의 변경은 불가능하지만 observers 내부에 있는 변수들은 변경이 가능하다.
    public static void attach(Observer observer) {
        observers.add(observer);
    } //Observer 인터페이스를 구현한 객체를 observers 리스트에 추가, 통보 대상 추가

    public void detach(Observer observer) {
        observers.remove(observer);
    } //Observer 인터페이스를 구현한 객체를 observers 리스트에서 제거, 통보 대상 제거

    public static void notifyObservers() {
        for (Observer o : observers) o.update();
    } //통보 대상 Observer에 변경을 통보
}
