package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    // <객체 지향스러운 설계에서의 양방향 관계> 
    // (DB에선 사실 방향 개념 자체가 없음. 객체에서의 방향은 참조에 유리하도록 설계하는 것)
    // (1) OrderItem -> Order 관계 : 단방향 관계
    // (2) Order -> OrderItem 관계까지 설정함으로써 : 양방향 연관관계(반대입장도 설정)
    //     외래키(ORDER_ID)가 있는 쪽이 연관관계의 주인!!!
    //     객체(DB x)에서 양쪽을 서로 참조하도록 개발할 때 활용
    @ManyToOne
    @JoinColumn(name= "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
