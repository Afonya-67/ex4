interface User {
	void setLogin(String login);

	String getLogin();

	void setPassword(String password);

	String getPassword();

	boolean checkPassword(String inputPassword);
}

abstract class People implements User {
	private String fullName;
	private int age;
	private String position;

	private String login;
	private String password;

	public People(String fullName, int age, String position, String login, String password) {
		this.fullName = fullName;
		this.age = age;
		this.position = position;
		this.login = login;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean checkPassword(String inputPassword) {
		return this.password != null && this.password.equals(inputPassword);
	}

	public abstract void showInfo();

	@Override
	public String toString() {
		return String.format("%s, %d лет, %s | логин: %s", fullName, age, position, login);
	}
}

class Tich extends People {
	private String subject;

	public Tich(String fullName, int age, String position, String login, String password, String subject) {
		super(fullName, age, position, login, password);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void showInfo() {
		System.out.println("Преподаватель: " + this + ", предмет: " + subject);
	}
}

class Student extends People {
	private String group;

	public Student(String fullName, int age, String position, String login, String password, String group) {
		super(fullName, age, position, login, password);
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public void showInfo() {
		System.out.println("Студент: " + this + ", группа: " + group);
	}
}

public class ex4 {

	public static void main(String[] args) {
		Tich t1 = new Tich("Морозов Александр Дмитриевич", 40, "Доцент", "mad", "mad2006", "физика");
		Tich t2 = new Tich("Ковалева Елена Сергеевна", 40, "Старший преподаватель", "kovaleva", "winter2026!",
				"английский");

		Student s1 = new Student("Волков Максим Андреевич", 19, "Студент 2 курса", "m.volkov_2007", "Vlkv_Max99!",
				"ИСП-211");
		Student s2 = new Student("Соколова Анна Игоревна", 20, "Студент 3 курса", "sokolova.anya", "A_Sokol_2026#",
				"ЭК-302");

		t1.showInfo();
		String sel1 = "12345";
		String sel2 = "qwerty";
		String sel3 = "pass";
		System.out.println("Логин: " + t1.getLogin());
		System.out.println("Проверка пароля '" + sel1 + "': " + t1.checkPassword(sel1));
		System.out.println("Проверка пароля '" + sel2 + "': " + t1.checkPassword(sel2));
		System.out.println();

		t2.showInfo();
		String newpass = "newpass";
		t2.setPassword("newpass");
		System.out.println("Новый пароль: " + t2.getPassword());
		System.out.println("Проверка пароля '" + newpass + "': " + t2.checkPassword(newpass));
		System.out.println();

		s1.showInfo();
		s1.setLogin("volkov_new");
		System.out.println("Новый логин: " + s1.getLogin());
		s1.showInfo();
		System.out.println("Проверка пароля '" + sel3 + "': " + s1.checkPassword(sel3));
		System.out.println();

		s2.showInfo();
		System.out.println("Возраст: " + s2.getAge() + ", Должность: " + s2.getPosition());

	}

}
