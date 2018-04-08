package iotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class IO_comparator {
	public static void main(String[] args) throws IOException {
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int num = o2.getSum() - o1.getSum();
				int num2 = (num == 0) ? o1.getMath() - o2.getMath() : num;
				int num3 = (num2 == 0) ? o1.getChinese() - o2.getChinese() : num2;
				int num4 = (num3 == 0) ? o1.getEnglish() - o2.getEnglish() : num3;
				int num5 = (num4 == 0) ? o1.getName().compareTo(o2.getName()) : num4;
				return num5;
			}

		});
		for (int x = 1; x <= 5; x++) {

			Scanner sc = new Scanner(System.in);
			System.out.println("请输入第 " + x + "个学生的信息");
			System.out.println("name: ");
			String name = sc.nextLine();
			System.out.println("math: ");
			int math = sc.nextInt();
			System.out.println("chinese: ");
			int chinese = sc.nextInt();
			System.out.println("english: ");
			int english = sc.nextInt();

			Student s = new Student(name, math, chinese, english);
			ts.add(s);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
		bw.write("学生信息如下： ");
		bw.newLine();
		bw.write("姓名，语文，数学，英语 /n");
		bw.newLine();
		for (Student s : ts) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.getName()).append(s.getMath()).append(s.getChinese()).append(s.getEnglish());
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.close();
	}
}

class Student {
	private String name;
	private int math;
	private int chinese;
	private int english;

	public Student(String name, int math, int chinese, int english) {
		super();
		this.name = name;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getSum() {
		return english + math + chinese;
	}
}