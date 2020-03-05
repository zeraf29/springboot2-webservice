package com.zeraf29.book.springboot.dto;


import com.zeraf29.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //asertThat: asertj라는 테스트 검증 라이브러리의 검증 메소드. 검증하고 싶은 대상을 메소드 인자로 받음. 메소드 체이닝 지원
        //isEqualTo: assertj의 동등비교 메소드,  assertThat에 있는 값과 isEqualTo값을 비교해서 같을 때만 성공
    }
}
