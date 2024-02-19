package hello.core.singleton;

//상태 유지시 발생하는 문제점 예시
public class StatefulService {
    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; //문제가 되는 부분
    }

    public int getPrice(){
        return this.price;
    }
}
