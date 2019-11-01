package arg;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class myVue {

	Scene scene;
	Pane root, groupage;
	Button eye;
	Polygon hat, parrot;

	Pirate pirate;
	Mouvement move;

	ImageView img;
	AudioPlayer audio;

	public myVue() {
		root = new AnchorPane();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
		scene.getStylesheets().add(getClass().getResource("/styles/PIRATESTYLE.css").toString());
		root.getStyleClass().add("root");
		audio = new AudioPlayer();

		img = new ImageView(getClass().getResource("/images/Pirate.png").toExternalForm());
		img.setPreserveRatio(true);
		img.setFitHeight(400);
		img.setFitWidth(400);
		setupEye();
		setupHat();
		setupParrot();

		groupage = new AnchorPane();
		groupage.getChildren().addAll(img, eye, hat, parrot);

		pirate = new Pirate();
		try {
			move = new Mouvement(groupage, root, pirate);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Watatatow");
			Platform.exit();
		}
		Thread t1 = new Thread(move);
		t1.start();

		root.getChildren().add(groupage);

		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				if (key.getCode().equals(KeyCode.ESCAPE)) {
					Platform.exit();
				}
			}

		});
//		groupage.layoutXProperty().bind(pirate.getPosX());
//		groupage.layoutYProperty().bind(pirate.getPosY());

	}

	public void setupEye() {
		eye = new Button();
		eye.setMinSize(30, 30);
		eye.setLayoutX(170);
		eye.setLayoutY(110);
		eye.getStyleClass().add("eyeBouton");

		eye.setOnAction(e -> {
			audio.playEA(Sonorisation.EYE);
		});
	}

	public void setupHat() {
		hat = new Polygon(95, 80, 160, 50, 190, 20, 240, 35, 265, 80, 300, 115, 290, 150, 245, 153, 245, 100, 220, 90,
				170, 95, 150, 110, 145, 140, 105, 125);
		hat.getStyleClass().add("hatBouton");

		hat.setOnMouseClicked(e -> {
			audio.playEA(Sonorisation.HAT);
		});
	}

	public void setupParrot() {
		parrot = new Polygon(70, 90, 130, 50, 135, 50, 150, 65, 150, 85, 135, 85, 130, 95, 129, 107, 110, 115, 100,
				130);
		parrot.setLayoutX(170);
		parrot.setLayoutY(110);
		parrot.getStyleClass().add("parrotBouton");

		parrot.setOnMouseClicked(e -> {
			audio.playEA(Sonorisation.PARROT);
		});
	}

	public void setMouv() {
		final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

			double deltaX = 5.5;
			double deltaY = 5.5;

			@Override
			public void handle(ActionEvent t) {

				boolean atRightBorder = groupage.getLayoutX() > root.getWidth() - groupage.getWidth();
				boolean atLeftBorder = groupage.getLayoutX() < 0;
				boolean atBottomBorder = groupage.getLayoutY() > root.getHeight() - groupage.getHeight();
				boolean atTopBorder = groupage.getLayoutY() < 0;

				if (atRightBorder || atLeftBorder) {
					deltaX *= -1;
				}
				if (atBottomBorder || atTopBorder) {
					deltaY *= -1;
				}
				groupage.relocate(groupage.getLayoutX() + deltaX, groupage.getLayoutY() + deltaY);
			}
		}));

		loop.setCycleCount(Timeline.INDEFINITE);
		loop.play();
	}

	public AudioPlayer getAudio() {
		return audio;
	}

	public ImageView getImg() {
		return img;
	}

	public Scene getScene() {
		return scene;
	}

	public Pane getGroupe() {
		return groupage;
	}

	public Pirate getPirate() {
		return pirate;
	}
}
