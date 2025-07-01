package com.yedam.app.di;

public class SamsungTV {
	private SonySpeaker speaker;
	
	public SamsungTV(SonySpeaker speaker){
		this.speaker = speaker;
	}
	
	public SamsungTV() {};
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		speaker.on();
	}
	
	public void powerOff() {
		speaker.off();
	}
	public void volumUp() {
		speaker.volumUp();
	}
	public void volumDown() {
		speaker.volumDown();
	}
}
