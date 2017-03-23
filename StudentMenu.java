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
		System.out.println("1.新增学生");
		System.out.println("2.删除学生");
		System.out.println("3.修改学生");
		System.out.println("4.查询学生");
		System.out.println("5.显示全部");
		System.out.println("6.登陆");
		System.out.println("7.退出");
		System.out.println("===================");
		System.out.println("请选择(0-7):");
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
			System.out.println("您已退出thank you!!");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误系统终止ֹ");
			System.exit(-1);
			break;
		}
	}

	private int checkInt() {
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch (Exception e) {
			System.out.println("必须输入整数!!");
		}
		return choice;
	}

	// 添加学员信息
	private void insert() {
		System.out.println("请输入编号：");
		int sid = input.nextInt();
		System.out.println("请输入学号：");
		input.nextLine();
		String sno = input.nextLine();
		System.out.println("请输入姓名：");
		String sname = input.nextLine();
		System.out.println("请输入性别：");
		String sex = input.nextLine();
		System.out.println("请输入出生日期：****-**-**");
		String sdate = input.nextLine();
		System.out.println("请输入电话：");
		String stel = input.nextLine();
		System.out.println("请输入住址：");
		String sadd = input.nextLine();
		System.out.println("请输入密码：");
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
		System.out.println("请输入想删除的学生编号");
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
		System.out.println("请输入你想更新的学生编号：");
		int sid = input.nextInt();
		System.out.println("请输入更新信息：");
		System.out.println("请输入学号：");
		input.nextLine();
		String sno = input.nextLine();
		System.out.println("请输入姓名：");
		String sname = input.nextLine();
		System.out.println("请输入姓名：");
		String sex = input.nextLine();
		System.out.println("请输入出生日期：****-**-**");
		String sdate = input.nextLine();
		System.out.println("请输入电话：");
		String stel = input.nextLine();
		System.out.println("请输入住址：");
		String sadd = input.nextLine();
		System.out.println("请输入密码：");
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
		System.out.println("==》查询学生");
		System.out.println("输入编号：");
		int sid = input.nextInt();
		User user = studentDao.search(sid);
		if (null != user) {
			System.out.println("==》查询成功" + user.toString());
		} else {
			System.out.println("==》查询失败");
		}
		returnMain();
	}

	private void showAll() {
		studentDao.show();
		returnMain();
	}

	private void login() {
		System.out.println("===》登录系统");
		Tools tools = new Tools();
		String code = tools.getCode();
		System.out.println("验证码：" + code);
		System.out.println("请输入登录名");
		String name = input.next();
		System.out.println("请输入密码");
		String spwd = input.next();

		while (true) {
			System.out.println("��������֤��");
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
		System.out.println("按0返回");
		int answer = input.nextInt();
		while (answer != 0) {
			System.out.println("输入0返回");
			answer = input.nextInt();
		}
		if (answer == 0) {
			mainMenu();
		}
	}
}