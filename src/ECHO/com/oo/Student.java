package ECHO.com.oo;

public class Student {
	int english;
	int math;
	int chinese;
	String name;
public Student(){}//�n�O�H�~�ӥL���ɭԥ��g(�ūغc�l)

	public Student(String name, int english, int math, int chinese) {
		this.english = english;
		this.math = math;
		this.chinese = chinese;
		this.name = name;
	}

	public Student(String name) {
		this.name = name;

	}

	
	public void print() {
		System.out.println(english + " " + math + " " + chinese);
	}

	public int getAverange() {
		return ((english + math + chinese) / 3);
	}
}
