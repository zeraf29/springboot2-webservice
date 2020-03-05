package com.zeraf29.book.springboot.web;

import com.zeraf29.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController: JSON 반환 컨트롤러로 선언
@RestController
public class HelloController {

    //HTTP Method Get 요청을 받을 수 있는 API 생성
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //@RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
    //ex: 외부에서 name으로 넘긴 파라미터를 String name에 저장
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

}
