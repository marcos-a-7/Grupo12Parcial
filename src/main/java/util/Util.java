package util;

import java.util.Random;

public class Util {
	private static Random r = new Random();
	
	public static void espera(int max) {
		try {
			Thread.sleep(r.nextInt(max)); //milisegundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
