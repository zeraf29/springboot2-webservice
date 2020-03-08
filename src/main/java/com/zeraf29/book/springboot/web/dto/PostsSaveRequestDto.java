package com.zeraf29.book.springboot.web.dto;

import com.zeraf29.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    /*
    @NoArgsConstructor will generate a constructor with no parameters.
    If this is not possible (because of final fields), a compiler error will result instead,
    unless @NoArgsConstructor(force = true) is used, then all final fields are initialized with 0 / false / null.
     */

    /*
    Entity 클래스(Posts.java)와 비슷한 구조이지만, 별도로 Dto 클래스 추가
    >>절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
    >>Entity 클래스 : DB와 맞닿은 핵심 클래스(Entity 클래스 기준으로 테이블 생성, 스키마 변경)
    >>화면 변경은 비중이 훨씬 낮은 작업 --> 이를 위해 Entity 변경을 하는 것은 리스크가 큼 // Request, Response용 DTO는 변경이 잦은 부분.
    >>!! View Layer 와 DB Layer의 역할 분리를 철저하게 하는게 좋음  >> 꼭 Entity 클래스와 Contoller에서 쓸 Dto는 분리해서 사용!!
     */

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
