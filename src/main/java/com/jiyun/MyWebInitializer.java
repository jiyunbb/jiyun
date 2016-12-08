package com.jiyun;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MyWebInitializer extends SpringBootServletInitializer{
	@Override //임베디드 톰캣과의 관계를 끊어야함 --> 외부 톰캣 서버에 배포할 준비가 끝난 상태
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyJiyunApplication.class); //메인 메서드를 가지는 클래스
	}
}
