package hello.core.Order;

public interface OrderService {
    //아이디 이름 가격이오면 order 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
