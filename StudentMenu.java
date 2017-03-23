package jiaowu;

import java.util.Scanner;

public class StudentMenu extends StudentDao {
	private IStudentDao studentDao;
	private Scanner input = null;

	public StudentMenu() {
		super();
		this.studentDao = new StudentDao();
		this.input = new Scanner(System.in);
	}

	public void startSystem() {
		mainMenu();
	}

	private void mainMenu() {
		System.out.println("===================");
		System.out.println("1.insert student");
		System.out.println("2.delete student");
		System.out.println("3.modify student");
		System.out.println("4.find student");
		System.out.println("5.show all students");
		System.out.println("6.login");
		System.out.println("7.exit");
		System.out.println("===================");
		System.out.println("please choose from (0-7):");
		int choice = checkInt();
		switch (choice) {
		case 1:
			insert();
			break;
		case 2:
			delete();
			break;
		case 3:
			update();
			break;
		case 4:
			search();
			break;
		case 5:
			showAll();
			break;
		case 6:
			login();
			break;
		case 7:
			System.out.println("Exit successfully, thank you!!");
			System.exit(0);
			break;
		default:
			System.out.println("The input is invaild please try again");
			System.exit(-1);
			break;
		}
	}

	private int checkInt() {
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch (Exception e) {
			System.out.println("must input integers!!");
		}
		return choice;
	}

	// 添加学员信息
	private void insert() {
		System.out.println("please input sid：");
		int sid = input.nextInt();
		System.out.println("please input student number：");
		input.nextLine();
		String sno = input.nextLine();
		System.out.println("please input name：");
		String sname = input.nextLine();
		System.out.println("please input gender：");
		String sex = input.nextLine();
		System.out.println("please input date of birth：****-**-**");
		String sdate = input.nextLine();
		System.out.println("please input phone number：");
		String stel = input.nextLine();
		System.out.println("please input address：");
		String sadd = input.nextLine();
		System.out.println("please input password：");
		String pwd = input.nextLine();

		Student student = new Student(sid, sno, sname, sex, sdate, stel, sadd,
				pwd);
		boolean result = studentDao.insert(student);
		if (result == true) {
			System.out.println("successful");
		} else {
			System.out.println("fail");
		}
		returnMain();
	}

	// 按学号删除
	private void delete() {
		System.out.println("please input the sid who you want to delete：");
		int sid = input.nextInt();
		boolean result = studentDao.delete(sid);
		if (result == true) {
			System.out.println("successful");
		} else {
			System.out.println("fail");
		}
		returnMain();
	}

	// 按学号删除
	private void update() {
		System.out.println("please input the sid who you want to modify：");
		int sid = input.nextInt();
		System.out.println("please input update information:");
		System.out.println("please input sid：");
		input.nextLine();
		String sno = input.nextLine();
		System.out.println("please input name：");
		String sname = input.nextLine();
		System.out.println("please input gender："); 
		String sex = input.nextLine();
		System.out.println("please input date of birth：****-**-**");
		String sdate = input.nextLine();
		System.out.println("please input phone number：");
		String stel = input.nextLine();
		System.out.println("please input address：");
		String sadd = input.nextLine();
		System.out.println("please input password：");
		String pwd = input.nextLine();
		Student student = new Student(sid, sno, sname, sex, sdate, stel, sadd,
				pwd);
		User user = new User(sid,sname,pwd,1);
		boolean result = studentDao.update(user,student);
		if (result == true) {
			System.out.println("successful");
		} else {
			System.out.println("fail");
		}
		returnMain();
	}

	private void search() {
		System.out.println("==》find student");
		System.out.println("please input sid：：");
		int sid = input.nextInt();
		User user = studentDao.search(sid);
		if (null != user) {
			System.out.println("==》successful" + user.toString());
		} else {
			System.out.println("==》failed");
		}
		returnMain();
	}

	private void showAll() {
		studentDao.show();
		returnMain();
	}

	private void login() {
		System.out.println("===》login system");
		Tools tools = new Tools();
		String code = tools.getCode();
		System.out.println("verify code：" + code);
		System.out.println("please input account name：");
		String name = input.next();
		System.out.println("please input password");
		String spwd = input.next();

		while (true) {
			System.out.println("verify code");
			String scode = input.next();
			if (scode.equals(code)) {
				User user = studentDao.login(name, spwd);
				if (user != null) {
					System.out.println("successful");
				} else {
					System.out.println("fail");
				}
				returnMain();
			} else {
				System.out.println("invaild verified code");
				System.out.println("try again");
			}
		}
	}

	private void returnMain() {
		System.out.println("press 0 to return");
		int answer = input.nextInt();
		while (answer != 0) {
			System.out.println("press 0 to return");
			answer = input.nextInt();
		}
		if (answer == 0) {
			mainMenu();
		}
	}
}
