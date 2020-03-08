package com.zeraf29.book.springboot.web;

import com.zeraf29.book.springboot.services.posts.PostsSrvice;
import com.zeraf29.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성해줌, final이 없는 필드는 생성자의 필드에 포함되지 않음.
@RestController
public class PostsApiController {

    /*
    @RequiredArgsConstructor generates a constructor with 1 parameter for each field that requires special handling.
    All non-initialized final fields get a parameter,
    as well as any fields that are marked as @NonNull that aren't initialized where they are declared.

    final이 선언된 모든 필드를 인자값으로 하는 생성자 생성 --> Bean 주입에 쓰임. (@Autowired 미사용)
     */

    private final PostsSrvice postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){ //@RequestBody annotation maps the HttpRequest body to a transfer or domain object
        return postsService.save(requestDto);
    }
}
