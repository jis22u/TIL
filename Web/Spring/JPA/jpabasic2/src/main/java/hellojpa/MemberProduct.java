package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <다대다 한계 극복>
 * 연결 테이블용 엔티티를 추가한다. (연결 테이블을 엔티티로 승격)
 * @ManyToMany를 @OneToMany와 @ManyToOne로
 * 해당 클래스가 Orders 같은 테이블임.
 */

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;
}
