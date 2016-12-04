package com.jiyun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity //테이블 매핑
public class Qna {
	
	@Id //pk
	@GeneratedValue //자동 증가값
	private int index;
	
	@Column(nullable=false) //컬럼 명시 (컬럼 속성 값 지정)
	private String writer;
	
	@ManyToOne //한 유저가 여러 글을 쓸 수도 있고,하나만 쓸 수도 있음.
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_Qna_writer"))
	private User user;
	
	@Column(nullable=false, length=120)
	private String title;
	
	@Column(nullable=false)
	private String contents;
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
