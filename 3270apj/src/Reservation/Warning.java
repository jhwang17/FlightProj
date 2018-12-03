package Reservation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Warning extends Stage {
	
	public Application nextStage;
	public Stage previousStage;
	public Button exitBtn, cancelBtn;
	
	public Warning(Stage previousStage, Application nextStage) {
		this.previousStage = previousStage;
		this.nextStage = nextStage;
		Scene scene = sceneLayout();
		this.initModality(Modality.APPLICATION_MODAL);
		this.setTitle("Warning!");
		this.setResizable(false);
		this.setScene(scene);
		//this.UIHandler();
	}
	
	private Scene sceneLayout() {
		VBox layout = new VBox();
		layout.setPadding(new Insets(10, 0, 0, 0));
		
		VBox row1 = new VBox();
		row1.setAlignment(Pos.CENTER);
		
		Label text1 = new Label();
		text1.setText("Unsaved changes will be lost.");
		text1.setFont(new Font("Arial", 18));
		Label text2 = new Label();
		text2.setText("Leave page?");
		text2.setFont(new Font("Arial", 18));
		
		row1.getChildren().addAll(text1, text2);
		
		HBox row2 = new HBox();
		row2.setPadding(new Insets(10, 0, 0, 0));
		row2.setAlignment(Pos.CENTER);
		row2.setSpacing(40);
		
		exitBtn = new Button();
		exitBtn.setText("Exit");
		cancelBtn = new Button();
		cancelBtn.setText("Cancel");
		row2.getChildren().addAll(exitBtn, cancelBtn);
		
		layout.getChildren().addAll(row1, row2);
		
		Scene scene = new Scene(layout, 300, 100);
		
		exitBtn.setOnAction(e -> {
			/*
			Stage loginStage = new Stage();
			LogIn loginScreen = new LogIn();
			loginScreen.start(loginStage);
			currentStage.close();
			this.close();
			*/
			try {
				Stage tempStage = new Stage();
				nextStage.start(tempStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			previousStage.close();
			this.close();
		});
		
		cancelBtn.setOnAction(e -> {
			this.close();
		});
		
		//UIHandler();
		return scene;
	}
	
	/*
	private void UIHandler() {
		exitBtn.setOnAction(e -> {
			Stage loginStage = new Stage();
			LogIn loginScreen = new LogIn();
			loginScreen.start(loginStage);
			parentStage.close();
			this.close();
		});
		
		cancelBtn.setOnAction(e -> {
			this.close();
		});
	}*/
}
