package com.zeraf29.book.springboot;


import com.zeraf29.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith: 테스트 진행 시 JUnit 내장 실행자 외 다른 실행자 실행 >> SpringRunner(스프링부트 테스트)와 JUnit 간의 연결자 역활
//@WebMvcTest: 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
//             선언 시 @Controller, @ControllerAdvice 등 사용 가능
//             단, @Service, @Component, @Repository 등은 사용 불가
//             컨트롤러만 사용할 경우 이용
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class) //com.zeraf29.book.springboot의 HelloController에 대한 테스트
public class HelloControllerTest {


    //Bean?: "Spring Bean" is simply a Java Object.
    //When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".
    //Spring Beans are created from normal Java classes, just like Java objects.

    //@Autowired: 스프링이 관리하는 Bean 주입받음
    @Autowired
    private MockMvc mvc; //웹 API 테스트 시 사용. 스프링 MVC 테스트의 시작점. 이 클래스를 통해 HTTP Get, Post 등에 대한 API 테스트 진행

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP Get 요청을 한다. 체이닝이 지원되어 여러 검증 기능을 이어서 선언 가능
            .andExpect(status().isOk()) //mvc.perform의 결과 검증, HTTP Header의 Status 검증 (200,404,500 등의 상태 검증), isOk: 200 검증 >> /hello가 정상 호출 되는가?
            .andExpect(content().string(hello)); //mvc.perform의 결과 검증. 응답 본문 내용 검증, Controller 에서 "hello"리턴하기 떄문에 이 값이 맞는지 검증 //호출된 내용에 hello 가 콘텐츠가 있는가?
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("hello/dto")
                    .param("name",name) //param: API 테스트 시 사용될 요청 파라미터 설정. 값은 String만 가능 (숫자/날짜 등의 데이터도 문자열로 변경해야 함)
                    .param("amount", String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //jsonPath: JSON 응답값을 필드별로 검증하는 메소드, $를 기준으로 필드명 명시 ex)$.name, $.amount
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
