package com.zeraf29.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity Class, PK Type>
//@Repository 추가할 필요 없음
//*Entity 클래스와 기본 Entity Repository 함께 위치 해야함. (Entity 클래스는 기본 Repository 없이 제대로 역할 할수 없음)
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
