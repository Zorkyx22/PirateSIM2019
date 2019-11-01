package arg;

import java.awt.Point;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Mouvement implements Runnable {

	final double VITESSE = 5.5;
	Pane root, groupage;
	Pirate pirate;

	public Mouvement(Pane pGroupage, Pane pRoot, Pirate pPirate) throws Exception {
		if (pGroupage != null && pRoot != null && pPirate != null) {
			groupage = pGroupage;
			root = pRoot;
			pirate = pPirate;
//			
		} else
			throw new Exception();
	}

	@Override
	public void run() {

		final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

			double deltaX = 1;
			double deltaY = 1;

			@Override
			public void handle(final ActionEvent t) {

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

				pirate.setPos(new Point(((int) (pirate.getPos().getX() + VITESSE * deltaX)),
						((int) (pirate.getPos().getY() + VITESSE * deltaY))));
//				groupage.relocate(groupage.getLayoutX() + deltaX, groupage.getLayoutY() + deltaY);
			}
		}));

		loop.setCycleCount(Timeline.INDEFINITE);
		loop.play();

	}

}
