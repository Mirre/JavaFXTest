package com.mirre.test;
	
import java.io.IOException;

import com.mirre.test.view.field.FieldViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class TestMain extends Application {
	
	private BorderPane rootLayout;
	private FieldViewController fieldController;
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		rootLayout = new BorderPane();
		loadController();
		Scene scene = new Scene(rootLayout,400,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void loadController(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TestMain.class.getResource("view/field/FieldView.fxml"));
			rootLayout.setCenter(loader.load());
			fieldController = loader.getController();
			fieldController.supply(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getStage() {
		return stage;
	}
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}
}
