package com.zeraf29.book.springboot.services.posts;

import com.zeraf29.book.springboot.domain.posts.PostsRepository;
import com.zeraf29.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsSrvice {
    /*
    @RequiredArgsConstructor generates a constructor with 1 parameter for each field that requires special handling.
    All non-initialized final fields get a parameter,
    as well as any fields that are marked as @NonNull that aren't initialized where they are declared.

    final이 선언된 모든 필드를 인자값으로 하는 생성자 생성 --> Bean 주입에 쓰임. (@Autowired 미사용)
     */

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return null;
        //return postsRepository.save(requestDto.toEntity()).getId();
    }
}
