package com.jiyun.model;

import org.springframework.data.jpa.repository.JpaRepository;

//어떠한 테이블을 바라보겠는지?
public interface UserRepository extends JpaRepository<User, Long> { //table, pk의 type을 param으로..
	User findByUserId(String userId);
	// findBy : 어떤 컬럼에 의해서 찾고 싶은지 (예약어) --> 이렇게 메소드를 만든다면 쿼리를 최소한으로 쓸 수 있다는 장점
}
