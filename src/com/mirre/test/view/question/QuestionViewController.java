package com.mirre.test.view.question;

import java.util.List;
import java.util.Random;

import com.mirre.test.utils.Answer;
import com.mirre.test.utils.Question;
import com.mirre.test.utils.Randomizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuestionViewController {

	@FXML
	public Button firstAnswer, secondAnswer, thirdAnswer, fourthAnswer;
	
	@FXML
	private Label currentQuestionLabel;
	
	private Question currentQuestion = null;
	private List<Question> questions;
	
	public QuestionViewController(){}
	
	@FXML
	public void initialize(){
		firstAnswer.setOnAction((event) -> {
			if(((Answer)firstAnswer.getUserData()).isCorrect()){
				System.out.println("Correct Answer");
				nextQuestion();
			}else{
				System.out.println("Wrong Answer");
			}
		});
		secondAnswer.setOnAction((event) -> {
			if(((Answer)secondAnswer.getUserData()).isCorrect()){
				System.out.println("Correct Answer");
				nextQuestion();
			}else{
				System.out.println("Wrong Answer");
			}
		});
		thirdAnswer.setOnAction((event) -> {
			if(((Answer)thirdAnswer.getUserData()).isCorrect()){
				System.out.println("Correct Answer");
				nextQuestion();
			}else{
				System.out.println("Wrong Answer");
			}
		});
		fourthAnswer.setOnAction((event) -> {
			if(((Answer)fourthAnswer.getUserData()).isCorrect()){
				System.out.println("Correct Answer");
				nextQuestion();
			}else{
				System.out.println("Wrong Answer");
			}
		});
	}
	
	public void supplyQuestions(List<Question> questions){
		this.questions = questions;
		nextQuestion();
	}
	
	public void nextQuestion(){
		if(questions.size() == 0){
			//End of Quiz Screen with Score and then ability to go back to Category screen.
			return;
		}
		int integer = new Random().nextInt(questions.size());
		this.currentQuestion = questions.get(integer);
		questions.remove(integer);
		currentQuestionLabel.setText(currentQuestion.getQuestion());
		
		Randomizer<Answer> randomizer = new Randomizer<Answer>(currentQuestion.getAnswers());
		
		Answer first = randomizer.random();
		firstAnswer.setUserData(first);
		firstAnswer.setText(first.getAnswer());
		
		Answer second = randomizer.random();
		secondAnswer.setUserData(second);
		secondAnswer.setText(second.getAnswer());
		
		Answer third = randomizer.random();
		thirdAnswer.setUserData(third);
		thirdAnswer.setText(third.getAnswer());
		
		Answer fourth = randomizer.random();
		fourthAnswer.setUserData(fourth);
		fourthAnswer.setText(fourth.getAnswer());
		
	}
}
