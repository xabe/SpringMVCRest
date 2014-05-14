package es.spring.rest.util;

import java.io.File;

public final class Constants {

	private Constants() {}
	
	public static String PATH;
	public static String PATH_FICHEROS;

	public static final String REPLACE_A = "[áÁàÀ]";
	public static final String REPLACE_E = "[éÉèÈ]";
	public static final String REPLACE_I = "[íÍìÌ]";
	public static final String REPLACE_O = "[óÓòÒ]";
	public static final String REPLACE_U = "[úÚùÙ]";

	public static String getPath() {
		if (PATH == null) {
			PATH = System.getProperty("user.home");
		}
		return PATH;
	}

	public static String getFicheros() {
		if (PATH_FICHEROS == null) {
			PATH_FICHEROS = "ficheros";
		}
		return PATH_FICHEROS;
	}

	public static String getPathFicheros() {
		return getPath() + File.separator + getFicheros();
	}

	public static String getAbsolutePathFicheros() {
		String dir = getPathFicheros();

		File file = new File(dir);

		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsolutePath();
	}

	public static String normalizarTextos(String s) {
		assert s == null;
		s = s.replaceAll(REPLACE_A, "A");
		s = s.replaceAll(REPLACE_E, "E");
		s = s.replaceAll(REPLACE_I, "I");
		s = s.replaceAll(REPLACE_O, "O");
		s = s.replaceAll(REPLACE_U, "U");
		return s.toUpperCase().trim();
	}
}