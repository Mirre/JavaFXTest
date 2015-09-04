package com.mirre.test.view.field;

import java.io.IOException;

import com.mirre.test.TestMain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class FieldViewController {

	@FXML
	public Button testKategori;
	
	private TestMain main;
	
	public FieldViewController(){}
	
	@FXML
	public void initialize(){
		
	}
	
	public FieldViewController supply(TestMain main){
		this.main = main;
		return this;
	}
	
	@FXML
	public void chooseTestKategori(){
		main.getRootLayout().getChildren().clear();
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TestMain.class.getResource("view/testkategori/TestKategoriView.fxml"));
			main.getRootLayout().setCenter(loader.load());
			//fieldController = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
