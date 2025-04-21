import java.util.Scanner;

import domain.UserMap;
import repository.AddReader;
import repository.DeleteReader;
import repository.ModeReader;
import service.ManegementService;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		new ManegementService(new ModeReader(new Scanner(System.in)),new AddReader(new Scanner(System.in), new Scanner(System.in)),new DeleteReader(new Scanner(System.in)),new UserMap()).execute();
		
	}

}
