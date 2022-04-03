package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "MBR") // 엔티티에서 DB에서 매핑할 테이블 이름을 지정하고 싶을 때 사용
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

//    @Id
//    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE,
//                    generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @Column(unique = true, length = 10)
//    private String name;
    @Column(name = "name", nullable = false) // 코드에서는 username, DB에서는 name이라는 컬럼을 사용하고 싶을 때 사용
    private String username;

//    private Integer age;

//    @Enumerated(EnumType.STRING) // enum타입을 String으로 사용
////    @Enumerated
//    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;

//    private LocalDate testLocalDate; // 년, 월
//    private LocalDateTime testLocalDateTime; // 년, 월, 일

//    @Lob
//    private String description;

//    @Transient // 컬럼에 매핑하지 않음(DB에 저장하지 않고 메모리에서만 임시로 사용할 때)
//    private int temp;

    public Member() {

    }

//    public String getId() {
//        return id;
//    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getTemp() {
//        return temp;
//    }
//
//    public void setTemp(int temp) {
//        this.temp = temp;
//    }

    //    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
