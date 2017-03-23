package jiaowu;

public interface IStudentDao{
	public abstract boolean insert(Student student);
	public abstract boolean delete(int sid);
	public abstract User search(int sid);
	public abstract User login(String name,String pwd);
	public abstract boolean update(User user,Student student);
	public abstract void show();
}