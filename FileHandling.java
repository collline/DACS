package test3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import test1.BaseQuestion;

public class FileHandling {
	public ArrayList<Question> loadFile() throws NullPointerException, FileNotFoundException, IOException {
		File fileName = new File("questionss.txt");
		ArrayList<Question> questionArray = new ArrayList<Question>();
		String line;
		String question = "";
		ArrayList<String> choices = new ArrayList<>();
		String answer = "";
		try {
			FileReader fIn = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fIn);
			while ((line = br.readLine()) != null) {
				for (Question q : questionArray) {
					if (line.contains("QUESTION: ") || (line.contains("?"))) {
						question = line;
						q.setQuestion(question);
					} else if (line.contains("ANSWER: ")) {
						answer = line;
						q.setAnswer(answer);
					} else {
						for (int i = 0; i < 4; i++) {
							choices.add(line);
							q.setChoices(choices);
						}
					}
				}
				br.close();
				return questionArray;
			}
		} catch (IOException e) {
			System.out.println("Not found");
		}
		return questionArray;
	}
}
