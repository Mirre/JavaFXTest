package com.mirre.test;
	
import java.io.IOException;

import com.mirre.test.view.start.StartViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class TestMain extends Application {
	
	private BorderPane rootLayout;
	private Stage stage;
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		rootLayout = new BorderPane();
		rootLayout.setPrefSize(primScreenBounds.getWidth() * 0.66, primScreenBounds.getHeight() * 0.66);
		loadController();
		
		
		
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
	private void loadController(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TestMain.class.getResource("view/start/StartView.fxml"));
			rootLayout.setCenter(loader.load());
			((StartViewController)loader.getController()).supply(this);
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
