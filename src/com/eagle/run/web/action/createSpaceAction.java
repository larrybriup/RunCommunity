package com.eagle.run.web.action;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.eagle.run.common.bean.Memberinfo;
import com.eagle.run.common.bean.Memberspace;
import com.eagle.run.common.transaction.HibernateTransaction;
import com.eagle.run.common.util.AddPoint;
import com.eagle.run.common.util.BeanFactory;
import com.eagle.run.common.util.HibernateSessionFactory;
import com.eagle.run.service.IMemberService;
import com.eagle.run.service.impl.MemberServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//创建个人空间
public class createSpaceAction extends ActionSupport {
	private String opinion;
	private String runtime;
	private String runhabit;
	private String runstar;
	private String cellphone;
	private String runplace;
	private File image;
	private String imageFileName;
	private String icon;
	private IMemberService service=
			(IMemberService) BeanFactory.getBean(BeanFactory.MEMBERSERVICE);
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Memberinfo memberinfo=(Memberinfo) session.get("memberinfo");
		
		//头像保存路径
		String path=icon+"/"+memberinfo.getNickName()+"_"+imageFileName;
		Memberspace space= new Memberspace(memberinfo, opinion, runtime, 
				runplace, runstar, runhabit, cellphone, path);
		Memberinfo findMemberinfoByName = service.findMemberinfoByName(memberinfo.getNickName());
		
		HibernateTransaction tran= new HibernateTransaction();
		tran.beginTransaction();
		try {
			if(findMemberinfoByName.getMemberSpace()!=null){
				service.delSpace(findMemberinfoByName.getMemberSpace().getId());
			}
			findMemberinfoByName.setMemberSpace(space);
			
			findMemberinfoByName = AddPoint.addpoint(AddPoint.CREATEPERSONALSPACE, findMemberinfoByName);//加分
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		session.put("memberinfo", findMemberinfoByName);
		
		String realPath = ServletActionContext.getServletContext().getRealPath(icon);
		
		File target= new File(realPath,memberinfo.getNickName()+"_"+imageFileName);
		
		FileUtils.copyFile(image, target);
		
		return SUCCESS;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getRunhabit() {
		return runhabit;
	}
	public void setRunhabit(String runhabit) {
		this.runhabit = runhabit;
	}
	public String getRunstar() {
		return runstar;
	}
	public void setRunstar(String runstar) {
		this.runstar = runstar;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getRunplace() {
		return runplace;
	}
	public void setRunplace(String runplace) {
		this.runplace = runplace;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
}
