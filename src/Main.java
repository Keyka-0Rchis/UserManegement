import java.util.Scanner;

import presentation.ModeReader;
import service.ModeSelectService;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		new ModeSelectService(new ModeReader(new Scanner(System.in))).execute();
		
	}
}
