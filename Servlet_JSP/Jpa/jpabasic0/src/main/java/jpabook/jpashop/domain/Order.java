package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // Order 입장에서 OrderItem을 가지고 있는 양방향 관계는 비지니스적으로 유리(Order에서 OrderItem에 접근하고 싶은 것)
    // 연관관계의 주인이 아닌 것은 읽기만 가능하고, 값을 대입해도 DB에 반영되는건 없다.
    // mappedBy = "order" 의 order는 OrderItem 클래스의 order 필드를 가리킨다.
    // 최대한 단방향 관계로 설계 하는 것을 추천(단, 실무에선 때에 따라 양방향이 필요하기도..)
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems =  new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 양방향 연관관계 적용시 편의성을 위해 추가
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
