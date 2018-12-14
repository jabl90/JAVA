package com.netmind.util;

public class IntranetDownloader extends Downloader{

	@Override
	public void download() {
		
		System.out.println("Descargando en Intranet: "+this.getaBook().getCurrentPage());
		
	}

}
