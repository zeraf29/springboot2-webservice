package com.zeraf29.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication 으로 스프링 부트의 자동 설정, 스프링 Bean 읽기/생성 모두 자동 설정
//@SpringBootApplication이 있는 위치부터 설정을 읽어가므로, 이 클래스는 항상 프로젝트 최상단에 위치
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        //SpringApplication.run : 내장 WAS 활성
    }
}


