package web.webproject.webproject20220804.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Comment1 {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long c_seq;
    @Column(updatable = false)
    private String c_writer;

    private String comment1;
    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private String c_createDate;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


}
