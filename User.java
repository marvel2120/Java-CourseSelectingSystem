package jiaowu;

public class User{
	private int uid;
	private String uname;
	private String upwd;
	private int upower;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getUpower() {
		return upower;
	}

	public void setUpower(int upower) {
		this.upower = upower;
	}

	public User(){
		super();
	}
	public User(int uid,String uname,String upwd,int upower){
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.upower = upower;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", upower=" + upower + "]";
	}
	
}