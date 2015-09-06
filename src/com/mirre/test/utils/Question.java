package com.mirre.test.utils;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private final String question;
	private final Answer[] answers;
	
	public Question(String question, String[] answers, int correctAnswer){
		this.question = question;
		List<Answer> list = new ArrayList<Answer>();
		for(int i = 0 ; i < answers.length ; i++){
			list.add(new Answer(answers[i], i == correctAnswer));
		}
		this.answers = list.toArray(new Answer[list.size()]);
	}



	public Answer[] getAnswers() {
		return answers;
	}

	public String getQuestion() {
		return question;
	}
	
	//"Whatever is this?:shit,something,everything,nothing:0"
	//Question:answer1,answer2,answer3,answer4:correctAnswerIndex
	public static Question fromString(String line){
		String[] split = line.split(":");
		if(split.length < 2 || split.length > 3 && split[2].length() != 1)
			throw new IllegalArgumentException("Wrong format.");
		String[] answers = split[1].split(",");
		int index = Integer.parseInt(split[2].replaceAll("\\s+", ""));
		return new Question(split[0], answers, index);
	}
}
