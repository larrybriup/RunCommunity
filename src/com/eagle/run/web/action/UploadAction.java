package com.eagle.run.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File image;
	// 一定是xxxFileName,本地上传的文件的名字
	private String imageFileName;
	// 上传的文件的类型
	private String imageContentType;
	// 文件上传的目录,可以通过struts.xml中的配置action传过来
	private String dir;
	private String msg;

	@Override
	public String execute() {
		try {
			String realPath = ServletActionContext.getServletContext().getRealPath(dir);
			System.out.println(realPath);
			//第一个参数要把文件上传到服务器哪一个路径
			//第二个参数上传之后的文件的名字.
			File target= new File(realPath,imageFileName);
			//image上传的文件
			//target要从内存中写入硬盘中的目标
			FileUtils.copyFile(image, target);
			msg="上传成功!";
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
