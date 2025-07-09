package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private Integer bno;
	private String title;
	private String writer;
	private String contents;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image;
}
