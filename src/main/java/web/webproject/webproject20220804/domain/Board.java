package web.webproject.webproject20220804.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
//Entity 이 클래스가 JPA를 통해 데이터베이스 테이블로 쓰겠다고 명시
public class Board {
    //@id : PK sql문의 기본키
    //@Gemeratedvalue 자동생성 속성
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long seq;

    private String title;
    //title 필드 값을 컬럼화 할때 길이와  null 입력 가능여부 옵션
    @Column(updatable = false)
    private String writer;

    private String content;

    private String category;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private Long cnt;
}
