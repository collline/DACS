package test3;

public class Student {
	private String name;
	private int points;

	public Student(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

	public void addPoint() {
		points++;
	}
}
