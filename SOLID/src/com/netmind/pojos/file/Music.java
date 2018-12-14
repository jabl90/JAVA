package com.netmind.pojos.file;

public class Music implements Measurable{
	private int length;
	private int sent;

	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setSent(int sent) {
		this.sent = sent;
	}

	public int getSent() {
		// procesado complejo de lo que se ha enviado ya a streaming
		return sent;
	}
	
	private void updateSent(){
		sent=sent+2;
	}
}
