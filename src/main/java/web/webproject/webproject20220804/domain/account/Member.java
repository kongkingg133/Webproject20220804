package web.webproject.webproject20220804.domain.account;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(length = 40 ,nullable = false )
    private String id;
    @Column(nullable = false)
    private String password;
    @Column
    private String email;
    @Column
    private String address;


    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Temporal(TemporalType.DATE)
    private Date updateDate;

}
