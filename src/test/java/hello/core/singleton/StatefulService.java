package hello.core.singleton;

public class StatefulService {
//    private int price;//상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("nema = "+name+"price = "+price);
//        this.price =price;// 이 곳이 문제임
        return price;
    }
//    public int getPrice() {
////        return price;
//    }
}
