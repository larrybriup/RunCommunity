package com.eagle.run.web.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	//下载文件的名字,客户端传过来
	private String fileName;
	//下载文件所在路径,可以通过atruts.xml中的配置action传过来
	private String dir;
	@Override
	public String execute(){
		// TODO Auto-generated method stub
		
		return SUCCESS;
	}
	//getXxxx  配置文件中写xxxx
	public InputStream getFileStream(){
		//file是要下载的文件的路径和名字
		String file=dir+"/"+fileName;
		
		//把文件以流的形式返回
		return ServletActionContext.getServletContext().
				getResourceAsStream(file);
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
}
