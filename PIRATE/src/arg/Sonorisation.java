package arg;

public enum Sonorisation {
	BACKGROUND("/clips/BGM.wav"), EYE("/clips/MeEyeNew.wav"), HAT("/clips/HatNew.wav"),
	PARROT("/clips/JackNew.wav");

	String path;

	private Sonorisation(String pPath) {
		path = pPath;
	}

	public String getPath() {
		return path;
	}

	public String toString() {
		return getPath();
	}

}
