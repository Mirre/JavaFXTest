package com.mirre.test.view.start;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.mirre.test.TestMain;
import com.mirre.test.utils.Question;
import com.mirre.test.view.question.QuestionViewController;
import com.mirre.test.view.question.resources.Questions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class StartViewController {

	@FXML
	public Button firstCategory, secondCategory, thirdCategory, fourthCategory;
	
	private TestMain main;
	
	private final int MAX_QUESTIONS = 4;
	
	public StartViewController(){}
	
	@FXML
	public void initialize(){
		firstCategory.setOnAction((event) -> {
			chooseCategory(0);
		});
		
		secondCategory.setOnAction((event) -> {
			chooseCategory(1);
		});

		thirdCategory.setOnAction((event) -> {
			chooseCategory(2);
		});
		
		fourthCategory.setOnAction((event) -> {
			chooseCategory(3);
		});
	}
	
	public void supply(TestMain main){
		this.main = main;
	}
	
	public void chooseCategory(int i){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TestMain.class.getResource("view/question/QuestionView.fxml"));
			List<Question> questions = null;
			for(Questions q : Questions.values()){
				if(q.ordinal() == i){
					questions = q.getQuestions();
				}
			}
			while(questions.size() > MAX_QUESTIONS){
				int integer = new Random().nextInt(questions.size());
				questions.remove(integer);
			}
			main.getRootLayout().setCenter(loader.load());
			((QuestionViewController)loader.getController()).supplyQuestions(questions);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
