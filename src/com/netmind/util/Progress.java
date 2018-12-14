package com.netmind.util;

import com.netmind.pojos.file.Measurable;

public class Progress {
	private Measurable aMeasurableContent=null;
	
	public Progress(Measurable amea){
		this.aMeasurableContent=amea;
	}
	
	public float getAsPercent(){
		return aMeasurableContent.getSent()*100/aMeasurableContent.getLength();
	}
	
}
