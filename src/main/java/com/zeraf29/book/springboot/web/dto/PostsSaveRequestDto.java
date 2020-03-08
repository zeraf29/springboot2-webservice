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
