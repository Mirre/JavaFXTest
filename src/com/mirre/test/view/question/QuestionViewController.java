package com.mirre.test.view.question;

import java.util.List;
import java.util.Random;

import com.mirre.test.utils.Answer;
import com.mirre.test.utils.Question;
import com.mirre.test.utils.Randomizer;
import com.mirre.test.utils.StringUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QuestionViewController {

	@FXML
	public Button firstAnswer, secondAnswer, thirdAnswer, fourthAnswer;
	
	@FXML
	private Label currentQuestionLabel, currentScoreLabel, extraChancesLabel;
	
	private int currentScore = 0, extraChances = 2;
	private Question currentQuestion = null;
	private List<Question> questions;
	
	public QuestionViewController(){}
	
	@FXML
	public void initialize(){
		firstAnswer.setOnAction((event) -> {
			if(((Answer)firstAnswer.getUserData()).isCorrect()){
				onAnswer(true);
			}else{
				onAnswer(false);
			}
		});
		secondAnswer.setOnAction((event) -> {
			if(((Answer)secondAnswer.getUserData()).isCorrect()){
				onAnswer(true);
			}else{
				onAnswer(false);
			}
		});
		thirdAnswer.setOnAction((event) -> {
			if(((Answer)thirdAnswer.getUserData()).isCorrect()){
				onAnswer(true);
			}else{
				onAnswer(false);
			}
		});
		fourthAnswer.setOnAction((event) -> {
			if(((Answer)fourthAnswer.getUserData()).isCorrect()){
				onAnswer(true);
			}else{
				onAnswer(false);
			}
		});
		updateScoreLabel();
		updateChanceLabel();
	}
	
	private void onAnswer(boolean correct){
		if(correct){
			System.out.println("Correct Answer");
			currentScore++;
			updateScoreLabel();
			nextQuestion();
		}else{
			if(extraChances != 0){
				//Popup om man vill andvända extra försök att svara på frågan.
			}
			System.out.println("Wrong Answer");
		}
	}
	
	private void updateScoreLabel(){
		currentScoreLabel.setText(StringUtils.stringifyIntegers("" + currentScore + " poäng"));
	}
	
	private void updateChanceLabel(){
		currentScoreLabel.setText("Extra chanser: " + extraChances);
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
