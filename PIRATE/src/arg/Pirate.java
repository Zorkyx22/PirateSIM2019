package arg;

import java.awt.Point;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class Pirate {

	private Pane groupage;
	private ImageView img;
	private Button eye;
	private Polygon hat, parrot;
	private AudioPlayer audio;
	private Point pos;
	private SimpleDoubleProperty posX = new SimpleDoubleProperty(), posY = new SimpleDoubleProperty();

	public Pirate() {

		setPos(new Point(0, 0));
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

	public Point getPos() {
		return pos;
	}

	public SimpleDoubleProperty getPosX() {
		return posX;
	}

	public SimpleDoubleProperty getPosY() {
		return posY;
	}

	public void setPos(Point pPoint) {
		if (pPoint != null) {
			pos = pPoint;
//			getGroupe().relocate(pos.getX(), pos.getY());

			posX.set(pos.getX());
			posY.set(pos.getY());
		}
	}

	public Pane getGroupe() {
		return groupage;
	}

}
