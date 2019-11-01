package arg;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioPlayer {

	private MediaPlayer mediaPlayer, mpTemp;
	private Media media, mediaTemp;

	public AudioPlayer() {
		media = new Media(getClass().getResource(Sonorisation.BACKGROUND.getPath()).toExternalForm());
//		media = new Media(new File(Sonorisation.BACKGROUND.getPath()).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(Integer.MAX_VALUE);
		mediaPlayer.setVolume(0.7);
	}

	public MediaPlayer getMedia() {
		return mediaPlayer;
	}

	public void playEA(Sonorisation son) {
		mediaTemp = new Media(getClass().getResource(son.getPath()).toExternalForm());
		mpTemp = new MediaPlayer(mediaTemp);
		mpTemp.setVolume(1);
		mpTemp.setAutoPlay(true);
		mpTemp.setCycleCount(1);
		mpTemp.play();
	}

}
