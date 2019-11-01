package arg;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ARGDANGER extends Application {

	private myVue vue;

	@Override
	public void start(Stage arg0) throws Exception {
		vue = new myVue();

		arg0.setScene(vue.getScene());

		arg0.initStyle(StageStyle.TRANSPARENT);
		vue.getScene().setFill(Color.TRANSPARENT);

		arg0.setOnCloseRequest(e -> {
			e.consume();
		});

		arg0.sizeToScene();
		arg0.setAlwaysOnTop(true);
		arg0.setMaximized(true);

		arg0.show();

		vue.getGroupe().layoutXProperty().bind(vue.getPirate().getPosX());
		vue.getGroupe().layoutYProperty().bind(vue.getPirate().getPosY());

//		vue.setMouv();
//		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "/system32/" + "tasklist.exe");
//		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		String contenu;
//
//		while ((contenu = br.readLine()) != null) {
//			if (br.lines(). {
//				p = Runtime.getRuntime()
//						.exec("runas /profile /user:Administrator \"cmd.exe /c taskkill /F /IM \"taskmgr.exe\" /T\"");
//			}
//			if ((contenu).contains("cmd.exe")) {
//				p = Runtime.getRuntime()
//						.exec("runas /profile /user:Administrator \"cmd.exe /c taskkill /F /IM \"cmd.exe\" /T\"");
//			}
//		}

	}

	public static void main(String[] args) {
		ARGDANGER.launch();
	}

}
