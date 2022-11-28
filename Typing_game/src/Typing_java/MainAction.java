package Typing_java;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainAction extends JFrame implements ActionListener, KeyListener {

	Scanner sc = new Scanner(System.in); // 스캐너

	// 각 레벨의 객체를 생성한다.
	Level level;
	LevelOne levelone = new LevelOne();
	LevelTwo leveltwo = new LevelTwo();
	LevelThree levelthree = new LevelThree();
	LevelFour levelfour = new LevelFour();

	Calculator cal; // 시작시간과 종료시간을 계산해주는 Calculator 객체 생성

	int count;// 몇개의 단어를 입력되었는지 확인하기 위한 변수
	int charCount; // 전체 글자수를 카운트하기 위한 변수
	double ok; // 정타 수 변수 선언
	double no; // 오타 수 변수 선언
	String outputString, inputString; // 출력되는 문자열과 사용자가 입력하는 문자열

	JFrame mainFrame;

	JButton level1, level2, level3, level4;
	JPanel topPanel;
	JPanel centorPanel;
	JPanel midPanel;
	JPanel buttomPanel;
	JPanel correctPanel, missPanel, speedPanel;

	JLabel mainlabel, label1, label2, label3, label4, label5, label6;

	JTextField mainTextfield;

	Font font;

	public MainAction() {

		// GUI 디자인 설정
		setTitle("TaTa");
		setSize(400, 300);
		setLocation(100, 200);

		font = new Font("명조", Font.BOLD, 15); // 폰트 설정

		topPanel = new JPanel(new GridLayout(1, 4));
		buttomPanel = new JPanel();
		centorPanel = new JPanel();
		correctPanel = new JPanel(new GridLayout(1, 2));
		missPanel = new JPanel(new GridLayout(1, 2));
		speedPanel = new JPanel(new GridLayout(1, 2));

		mainTextfield = new JTextField();
		mainTextfield.setFont(font);

		mainlabel = new JLabel("Typing practice with BTS");
		mainlabel.setHorizontalAlignment(JLabel.CENTER);
		mainlabel.setFont(font);

		label1 = new JLabel("Accuracy : ");
		label2 = new JLabel("0");
		label3 = new JLabel("Typo : ");
		label4 = new JLabel("0");
		label5 = new JLabel("Speed : ");
		label6 = new JLabel("0");

		buttomPanel.setLayout(new FlowLayout());
		correctPanel.add(label1);
		correctPanel.add(label2);
		missPanel.add(label3);
		missPanel.add(label4);
		speedPanel.add(label5);
		speedPanel.add(label6);

		buttomPanel.add(correctPanel);
		buttomPanel.add(missPanel);
		buttomPanel.add(speedPanel);
		buttomPanel.setBorder(new TitledBorder("Result"));

		centorPanel.setLayout(new GridLayout(2, 1));
		centorPanel.add(mainlabel);
		centorPanel.add(mainTextfield);
		centorPanel.setBorder(new TitledBorder("Input"));

		level1 = new JButton("LevelOne");
		level2 = new JButton("LevelTwo");
		level3 = new JButton("LevelThree");
		level4 = new JButton("LevelFour");

		topPanel.add(level1);
		topPanel.add(level2);
		topPanel.add(level3);
		topPanel.add(level4);

		add(topPanel, BorderLayout.NORTH);
		add(centorPanel, BorderLayout.CENTER);
		add(buttomPanel, BorderLayout.SOUTH);

		mainTextfield.addKeyListener(this); // 사용자가 입력할 수 있는 입력란에 키 리스너 추가
		level1.addActionListener(this); // 버튼에 액션 리스너 추가
		level2.addActionListener(this); // 버튼에 액션 리스너 추가
		level3.addActionListener(this); // 버튼에 액션 리스너 추가
		level4.addActionListener(this); // 버튼에 액션 리스너 추가

		setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼이 눌리면 실행되는 액션이벤트
		String b = e.getActionCommand();

		// 초성 선택한 경우
		if (b.equals("LevelOne")) {

			level = levelone; // 레벨1로 동적 바인딩

			cal = new Calculator(); // 새로운 계산기 객체 생성
			mainTextfield.enable(); // 입력란에 입력이 가능해진다.
			mainlabel.setText("Press to start Ctrl"); // 랜덤 위치의 문자열 출력

		}

		else if (b.equals("LevelTwo")) { // 글자를 선택한 경우

			level = leveltwo; // 레벨2로 동적 바인딩

			cal = new Calculator(); // 새로운 계산기 객체 생성
			mainTextfield.enable(); // 입력란에 입력이 가능해진다.
			mainlabel.setText("Press to start Ctrl"); // 랜덤 위치의 문자열 출력

		}

		else if (b.equals("LevelThree")) { // 단어를 선택한 경우

			level = levelthree; // 레벨3로 동적 바인딩

			cal = new Calculator(); // 새로운 계산기 객체 생성
			mainTextfield.enable(); // 입력란에 입력이 가능해진다.
			mainlabel.setText("Press to start Ctrl"); // 랜덤 위치의 문자열 출력

		}

		else if (b.equals("LevelFour")) { // 문장 선택한 경우

			level = levelfour; // 레벨4로 동적 바인딩

			cal = new Calculator(); // 새로운 계산기 객체 생성
			mainTextfield.enable(); // 입력란에 입력이 가능해진다.
			mainlabel.setText("Press to start Ctrl"); // 랜덤 위치의 문자열 출력

		}

	}

	@Override
	public void keyPressed(KeyEvent e) { // 컨트롤키가 눌리면 측정이 시작된다.
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_CONTROL) { // 컨트롤 키가 눌리면 타자 연습이 시작된다.

			// 오타수 정확도 등등 변수를 0으로 초기화
			count = 0;
			charCount = 0;
			ok = 0;
			no = 0;

			cal.start(); // 시간 측정이 시작된다.
			outputString = level.randomPrint(); // 레벨1 배열에서의 랜덤값을 받는다.
			count++; // 출력횟수 1 증가
			charCount += outputString.length(); // 입력한 전체 문자의 갯수 계산
			mainlabel.setText(outputString); // 랜덤 위치의 문자열 출력

		}

		else if (key == KeyEvent.VK_ENTER) { // 엔터를 누르면

			if (count == 10) { // 10번 출력이 완료되면

				inputString = mainTextfield.getText(); // 텍스트 필드의 입력값을 inputString에 저장한다.
				mainTextfield.setText(""); // 텍스트 필드를 초기화한다.

				if (outputString.length() > inputString.length()) { // 사용자가 입력한 문자열의 길이가 입력해야 할 문자열의 길이보다 짧은 경우
					for (int j = 0; j < inputString.length(); j++) { // 입력한 문자열의 길이만큼만 반복한다.
						if (outputString.charAt(j) == inputString.charAt(j)) { // 두 문자열을 비교하여 정타수와 오타수를 계산한다.
							ok++;
						} else {
							no++;
						}
						no += outputString.length() - inputString.length(); // 모자란 문자의 갯수만큼 오타수를 증가시킨다.
					}
				} else { // 사용자가 입력한 문자열의 길이가 입력해야할 문자열의 길이보다 길거나 같은 경우.
					for (int j = 0; j < outputString.length(); j++) { // 입력해야 할 문자열의 길이만큼만 반복한다.
						if (outputString.charAt(j) == inputString.charAt(j)) { // 두 문자열을 비교하여 정타수와 오타수를 계산한다.
							ok++;
						} else {
							no++;
						}
					}
				}

				cal.end(); // 측정을 종료한다.
				mainlabel.setText("Finish");
				mainTextfield.setText("");
				mainTextfield.disable(); // 텍스트필드를 초기화시키고 입력을 불가능하게 만든다.

				label2.setText(String.format("%.2f", (ok / charCount * 100)) + "%"); // 정확도를 계산해서 출력한다
				label4.setText(no + ""); // 오타수를 출력한다
				label6.setText(String.format("%.2f", ((60 * ok) / cal.secDiffTime)) + ""); // 분당 타수를 계산해서 출력한다.

			}

			else { // 10번 반복이 아직 안되었을때

				inputString = mainTextfield.getText(); // 텍스트 필드의 입력값을 inputString에 저장한다.
				mainTextfield.setText(""); // 텍스트 필드를 초기화한다.

				if (outputString.length() > inputString.length()) { // 사용자가 입력한 문자열의 길이가 입력해야 할 문자열의 길이보다 짧은 경우
					for (int j = 0; j < inputString.length(); j++) { // 입력한 문자열의 길이만큼만 반복한다.
						if (outputString.charAt(j) == inputString.charAt(j)) { // 두 문자열을 비교하여 정타수와 오타수를 계산한다.
							ok++;
						} else {
							no++;
						}
						no += outputString.length() - inputString.length(); // 모자란 문자의 갯수만큼 오타수를 증가시킨다.
					}
				} else { // 사용자가 입력한 문자열의 길이가 입력해야할 문자열의 길이보다 길거나 같은 경우.
					for (int j = 0; j < outputString.length(); j++) { // 입력해야 할 문자열의 길이만큼만 반복한다.
						if (outputString.charAt(j) == inputString.charAt(j)) { // 두 문자열을 비교하여 정타수와 오타수를 계산한다.
							ok++;
						} else {
							no++;
						}
					}
				}

				outputString = level.randomPrint(); // 레벨1 배열에서의 랜덤값을 받는다.
				charCount += outputString.length(); // 입력한 전체 문자 수 계산
				mainlabel.setText(outputString); // 랜덤 위치의 문자열 출력
				count++;

			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}