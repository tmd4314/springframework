package com.yedam.app.di.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
// @Data
//@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
//@RequiredArgsConstructor
// 생성자 주입

public class AppleTV {
	@Setter(onMethod_ = {@Autowired})
	private MarshallSpeaker speaker;
	
	public void powerOn() {
		System.out.println("스피커 온");
	};
	public void powerOff() {
		System.out.println("스피커 오프");
	};
}
