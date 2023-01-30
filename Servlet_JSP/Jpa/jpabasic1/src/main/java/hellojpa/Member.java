package hellojpa;

// 비지니스 로직 : 멤버 1명당 1개의 락커를 가질 수 있다.
import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    // 다대일 양방향 매핑처럼 외래키가 있는 곳이 연관관계의 주인
    // 반대편은 mappedBy 적용
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
