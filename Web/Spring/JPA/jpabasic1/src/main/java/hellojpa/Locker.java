package hellojpa;

// 비지니스 로직 : 멤버 1명당 1개의 락커를 가질 수 있다.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // Locker애서도 Member를 앍고 싶다. 양방향 관계 매핑
    // 마찬가지로 읽기 전용
    // 아래의 locker는 Member 클래스의 locker 필드
    @OneToOne(mappedBy = "locker")
    private Member member;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
