package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    // Order와 양방향 관계 매핑시
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

}
