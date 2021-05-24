package test3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MultipleChoiceTest {
	private int nrStudents;
	private int studentID;
	private Student[] studentArray;
	private ArrayList<Question> questionArray;

	public MultipleChoiceTest(int nrStudents) throws IOException {
		studentID = 0;
		this.nrStudents = nrStudents;
		questionArray = new ArrayList<Question>();
		addStudents(nrStudents);
		addQuestions();
		start();
	}

	public void addStudents(int nrStudents) {
		studentArray = new Student[nrStudents];
		Scanner sc = new Scanner(System.in);
		System.out.println("Input name of student:  ");
		for (int i = 0; i < nrStudents; i++) {
			studentArray[i] = new Student(sc.nextLine());
			System.out.println("Wellcome: " + studentArray[i].getName());
		}
	}

	public void addQuestions() throws IOException {
		FileHandling file = new FileHandling();
		ArrayList<Question> questionArray = new ArrayList<>();
		questionArray = file.loadFile();
		int nrQuestions = questionArray.size();
		for (int i = 0; i < nrQuestions; i++) {
			questionArray.add(new Question());
		}

	}

	private void end() {
		ArrayList<Integer> scoreArray = new ArrayList<Integer>();
		for (int i = 0; i < nrStudents; i++) {
			scoreArray.add(studentArray[i].getPoints());
		}
		Collections.sort(scoreArray, Collections.reverseOrder());
		Student winner = studentArray[0];
		if (scoreArray.get(0) == scoreArray.get(1)) {
			System.out.println("");
		} else {
			System.out.println("" + winner.getName() + "");
		}
		System.out.println("----Point Table----");
		for (int i = 0; i < nrStudents; i++) {
			System.out.println(i + 1 + "" + studentArray[i].getName() + " " + scoreArray.get(i) + "");

		}
	}

	public void start() {
		Iterator<Question> questionIterator = questionArray.iterator();
		while (questionIterator.hasNext()) {
			Question q = questionIterator.next();	
			for (int i = 0; i < nrStudents; i++) {
				String answer = printQuestion(q);
				fetchAnswer(answer);
				System.out.println(studentArray[studentID].getName() + ":" + studentArray[studentID].getPoints());
				changeStudents();
			}
		}
		end();
	}

	private String printQuestion(Question q) {
		System.out.println(q.getAnswer());
		System.out.println("A)" + q.getChoices().get(0));
		System.out.println("B)" + q.getChoices().get(1));
		System.out.println("C)" + q.getChoices().get(2));
		System.out.println("D)" + q.getChoices().get(4));
		return q.getAnswer();
	}

	private void fetchAnswer(String answer) {
		Scanner sc = new Scanner(System.in);
		String answerS = sc.nextLine();
		answerS.toUpperCase();
		for (Question q : questionArray) {
			if (q.getAnswer().substring(0, 7).equals(answerS)) {
				System.out.println("Correct!");
				studentArray[studentID].addPoint();
			} else if (!(answerS.equals("A") || answerS.equals("B") || answerS.equals("C") || answerS.equals("D"))) {
				System.out.println("Choose A, B, C, D....Try again");
				fetchAnswer(answer);
			} else {
				System.out.println("Incorrect!");
			}
		}

	}

	public void changeStudents() {
		studentID++;
		studentID = studentID % nrStudents;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Chương trình thi trắc nghiệm");
		Scanner sc = new Scanner(System.in);
		MultipleChoiceTest mct = new MultipleChoiceTest(sc.nextInt());
	}
}
