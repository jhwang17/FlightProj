package Reservation;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {
	private Pane splashLayout;
	private Label splashText;
	private ProgressBar loadProgress;
	private static final int SPLASH_WIDTH = 200;
	private static final int SPLASH_HEIGHT = 145;
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
	@Override
	public void init(){
		splashText = new Label("APJ Booking");
		splashText.setLayoutX(SPLASH_WIDTH);
		
		ImageView splashArt = new ImageView("./IMG/Main.png");
		splashArt.setFitHeight(350);
		splashArt.setFitWidth(400);
		
		loadProgress = new ProgressBar();
		loadProgress.setMaxWidth(400);
		splashLayout = new VBox();
		splashLayout.getChildren().addAll(splashText, splashArt, loadProgress);
		splashLayout.setEffect(new DropShadow());
	}
	
	@Override
	public void start(Stage splashStage) throws Exception {
		//create the splashStage
		showSplash(splashStage);
		
		splashStage.setWidth(400);
		splashStage.setHeight(400);
		//transition from splash stage to login stage after 4 seconds
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(4), splashLayout);
		fadeOut.setFromValue(3);
		fadeOut.setToValue(1);
		fadeOut.setCycleCount(1);
		fadeOut.play();
		
		//close the splash stage and start login
		fadeOut.setOnFinished((e) -> {
		try
		{
			splashStage.close();
			Stage loginStage = new Stage();
			LogIn showLogin = new LogIn();
			showLogin.start(loginStage);
			loginStage.show();
			
		} catch (Exception ex) {}
		});
	}
	
	private void showSplash(Stage splashStage)
	{
		Scene splashScene = new Scene(splashLayout);
		splashStage.initStyle(StageStyle.UNDECORATED);
		splashStage.setScene(splashScene);
		splashStage.setX(SPLASH_WIDTH);
		splashStage.setY(SPLASH_HEIGHT);
		splashStage.show();
	}
}
