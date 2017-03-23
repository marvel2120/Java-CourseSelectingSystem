package jiaowu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StudentDao implements IStudentDao {
	
	private Map<User,Student> studentsMap = null;

	public StudentDao() {
		super();
		studentsMap = new HashMap<User,Student>();
	}

	public boolean insert(Student student) {
		User user = new User(student.getSid(),student.getSname(),student.getSname(),1);
		
		studentsMap.put(user, student);
		return true;
	}

	public boolean delete(int sid) {
		User user = search(sid);
		if(null!=user){
			studentsMap.remove(user);
			return true;
		}
		return false;
	}

	public boolean update(User user,Student student) {
		User user2 = search(student.getSid());
		if(studentsMap.remove(user2)!=null){
			studentsMap.put(user, student);
			return true;
		}
		return false;
	}

	public User search(int sid) {
		User user = null;
		Set<User> keys = studentsMap.keySet();
		for(User key:keys){
			if(sid == key.getUid()){
				user = key;
			}
		}
		return user;
	}

	public void show() {
		Set<Entry<User, Student>> entrys = studentsMap.entrySet();
		for(Entry<User, Student> entry: entrys){
			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
		}
	}
	

	public User login(String name, String pwd) {
		Set<User> keys = studentsMap.keySet();
		for (User s : keys) {
			if (s != null && name.equals(s.getUname())
					&& pwd.equals(s.getUpwd())) {
				return s;
			}
		}
		return null;
	}

	
}
