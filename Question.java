package test3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Question implements Serializable{
	private String question;
	private ArrayList<String> choices;
	private String answer;

	public Question() {

	}

	public Question(String question, ArrayList<String> choices, String answer) throws UnsupportedOperationException {
		this.question = question;
		this.choices = new ArrayList<String>();
//		for (int i = 0; i < choices.size(); i++) {
//			this.choices.add(choices.get(i));
//		}
		Collections.shuffle(this.choices);
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QUESTION: " + question + "A)" + choices.get(0) + "B)" + choices.get(1) + "C)" + choices.get(2) + "D)"
				+ choices.get(4);
	}

}
