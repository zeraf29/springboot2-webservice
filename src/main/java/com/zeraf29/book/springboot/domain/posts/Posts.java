package com.zeraf29.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자 자동 추가, public Posts(){}와 같은 효과
@Entity //@Entity: 테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭(ex) SalesManager.java -> sales_manager table
public class Posts {

    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙을 나타냄,스프링부트2.0 이상부터 GenerationType.IDENTITY 옵션을 추가해야 auto increment 됨
    private Long id;
    /*
    @GeneratedValue(strategy = 는 persistence provider가 엔티티의 주키를 생성할 때 사용해야 하는 주키생성 전략을 의미. 디폴트 값은 AUTO
    GenerationType 종류별 내용
    1. AUTO : (persistence provider가) 특정 DB에 맞게 자동 선택
    2. IDENTITY : DB의 identity 컬럼을 이용
    3. SEQUENCE : DB의 시퀀스 컬럼을 이용
    4. TABLE : 유일성이 보장된 데이터베이스 테이블을 이용
    *참고: https://jsaver.tistory.com/entry/Id%EC%99%80-GeneratedValue-%EC%95%A0%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98

    *가급적 Entity PK는 Long 타입 Auto_increment 추천
     */

    //테이블 컬럼을 의미. 굳이 선언 안해도 해당 클래스 필드는 모두 컬럼이 됨.
    //사용이유는 기본값 오에 추가로 변경이 필요한 옵션이 있으면 사용.
    //문자열의 경우 VARCHAR(255)가 기본인데, 사이즈를 변경하고 싶거나 타입을 변경하고 싶을 때 사용.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /*
    1. getter/setter 클래스를 무작정 생성하면 안됨 -> 해당 클래스의 인스턴스 값들이 언제/어디서 변하는지 코드상으로 명확히 파악 불가 -> 수정 어려움
    2. Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다. 단, 해당 필드 값 변경 필요 시 명확히 목적/의도를 나타낼 수 있는 메소드를 추가
    예)
    Public class Order{
        public void cancelOrder(){
            this.status = false;
        }
    }

    public void 주문서비스의_취소이멘트(){
        order.cancelOrder();
    }

    3. Setter 없이 DB삽입 방법: 생성자를 통해 최종값 채운 후 DB Insert
       값 변경 필요 시 해당 이벤트에 맞는 public 메소드 호출
       --> Builder 패턴 사용 : 보다 명확하게 어떤 필드에 맞는 값이 들어가는지 확인 가능
       ex) Example.builder().a(a).b(b).build();
     */



}
