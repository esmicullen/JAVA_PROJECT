package Typing_java;

public class Level {

	String[] stringArr = null;

	public String randomPrint() {

		String str = stringArr[(int) (Math.random() * stringArr.length)];
		return str;

	}
}