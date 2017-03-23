package jiaowu;

public class Student extends User{
	private int sid;//编号
	private String sno;//学号
	private String sname;
	private String sex;
	private String sdate;
	private String stel;
	private String sadd;
	private String pwd;


	public Student(){
		super();
	}
	public Student(int sid,String sno,String sname,String sex,String sdate,String stel,String sadd,String pwd){
		super();
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.sdate = sdate;
		this.stel = stel;
		this.sadd = sadd;
		this.pwd = pwd;
	}
	public void setSid(int sid){
		this.sid = sid;
	}
	public int getSid(){
		return this.sid;
	}
	public void setSno(String sno){
		this.sno = sno;
	}
	public String getSno(){
		return this.sno;
	}
	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(){
		return this.sname;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setSdate(String sdate){
		this.sdate = sdate;
	}
	public String getSdate(){
		return this.sdate;
	}
	public void setStel(String stel){
		this.stel = stel;
	}
	public String getStel(){
		return this.stel;
	}
	public void setSadd(String sadd){
		this.sadd = sadd;
	}
	public String getSadd(){
		return this.sadd;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public String getPwd(){
		return this.pwd;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sno=" + sno + ", sname=" + sname
				+ ", sex=" + sex + ", sdate=" + sdate + ", stel=" + stel
				+ ", sadd=" + sadd + ", pwd=" + pwd + "]";
	}
}