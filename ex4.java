interface user {
	void setLogin(String login);
	String getLogin();

	void setPassword(String password);
	String getPassword();

	boolean checkPassword(String inputPassword);
}

abstract class People implements user {
	private String fullName;
	private int age;
	private String position;

	private String login;
	private String password;

	public People(String fullName, int age, String position,
			String login, String password) {
		this.fullName = fullName;
		this.age = age;
		this.position = position;
		this.login = login;
		this.password = password;
	}

	
	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	public String getPosition() { return position; }
	public void setPosition(String position) { this.position = position; }

	
	@Override
	public void setLogin(String login) { this.login = login; }

	@Override
	public String getLogin() { return login; }

	@Override
	public void setPassword(String password) { this.password = password; }

	@Override
	public String getPassword() { return password; }

	@Override
	public boolean checkPassword(String inputPassword) {
		return this.password != null && this.password.equals(inputPassword);
	}

	
	public abstract void showInfo();

	@Override
	public String toString() {
		return String.format("%s, %d лет, %s | логин: %s",
				fullName, age, position, login);
	}
}

class Tich extends People {
	private String subject;

	public Tich(String fullName, int age, String position,
			String login, String password, String subject) {
		super(fullName, age, position, login, password);
		this.subject = subject;
	}

	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }

	@Override
	public void showInfo() {
		System.out.println("Преподаватель: " + this + ", предмет: " + subject);
	}
}

class student extends People {
    private String group;

    public student(String fullName, int age, String position,
                   String login, String password, String group) {
        super(fullName, age, position, login, password);
        this.group = group;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    @Override
    public void showInfo() {
        System.out.println("Студент: " + this + ", группа: " + group);
    }
}

public class ex4 {

	public static void main(String[] args) {
		Tich t1 = new Tich("ФИО", 10,
                "Доцент", "логин", "пароль", "предмет");
        Tich t2 = new Tich("ФИО", 10,
                "Старший преподаватель", "логин", "пароль", "предмет");

        student s1 = new student("ФИО", 10,
                "Студент 2 курса", "логин", "пароль", "группа ");
        student s2 = new student("ФИО", 10,
                "Студент 3 курса", "логин", "пароль", "группа ");

        
        // Обращение к методам интерфейса User
        t1.showInfo();
        String sel1 = "чоточото";
        String sel2 = "чоточото";
        String sel3 = "чоточото";
        System.out.println("Логин: " + t1.getLogin());
        System.out.println("Проверка пароля '"+sel1+"': " + t1.checkPassword(sel1));
        System.out.println("Проверка пароля '"+sel2+"':   " + t1.checkPassword(sel2));
        System.out.println();

        t2.showInfo();
        t2.setPassword("newpass");
        System.out.println("Новый пароль: " + t2.getPassword());
        System.out.println();

        s1.showInfo();
        s1.setLogin("sidorov_new");
        System.out.println("Новый логин: " + s1.getLogin());
        System.out.println("Проверка пароля '"+sel2+"': " + s1.checkPassword(sel3));
        System.out.println();

        s2.showInfo();
        System.out.println("Возраст: " + s2.getAge() + ", Должность: " + s2.getPosition());

	}

}
