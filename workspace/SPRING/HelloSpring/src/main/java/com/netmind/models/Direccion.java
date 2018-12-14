package com.netmind.models;

import javax.inject.Named;

@Named("direccion")
public class Direccion {

	private int hid;
	private String calle;

	public int getHid() {

		System.out.println("Your Hid : " + hid);
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getCalle() {
		System.out.println("Your Street : " + calle);
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

}
