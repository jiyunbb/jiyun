package com.jiyun.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Answer {
	
	@Id //pk
	@GeneratedValue //자동 증가값
	private long id;
	
	@ManyToOne //한 유저가 여러 글을 쓸 수도 있고,하나만 쓸 수도 있음.
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;
	
	@ManyToOne //한 유저가 여러 글을 쓸 수도 있고,하나만 쓸 수도 있음.
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_qna"))
	private Qna question;
	
	@Column(nullable=false, length=120)
	private String title;
	
	@Lob //CLOB, BLOB
	@Column(nullable=false)
	private String contents;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy="question")
	@OrderBy("id ASC")
	private List<Answer> answer;
	
	public Answer(){}
	
	public Answer(User writer, Qna question, String contents){
		this.writer = writer;
		this.question = question;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", createDate=" + createDate + "]";
	}
	
	
}
