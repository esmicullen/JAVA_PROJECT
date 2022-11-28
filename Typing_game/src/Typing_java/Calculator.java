package Typing_java;

public class Calculator { //시작시간과 종료시간을 계산해 줄 수 있는 클래스

	
	long startTime; // 시작 시간
	long endTime; // 종료 시간
	long secDiffTime; // 실행시간

	Calculator(){ // 생성자
		startTime = 0;
		endTime = 0;
		secDiffTime = 0;
	}
	
	public void start() {
		startTime = System.currentTimeMillis(); // 코드 실행 전 시간
	}

	public void end() {
		endTime = System.currentTimeMillis(); // 코드 실행 후 시간
		secDiffTime = (endTime - startTime) / 1000; // 두 시간의 차
	}

}