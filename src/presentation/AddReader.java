package presentation;

import java.util.Scanner;

import domain.UserData;

public class AddReader {

	private Scanner readLine;
	
	public AddReader(Scanner readLine) {
		this.readLine =readLine;
	}
	
	public UserData AddReadLine() {
		System.out.println("ユーザー名を入力してください。");
		String username = this.readLine.nextLine();
		System.out.println("メールアドレスを入力してください。");
		String email = this.readLine.nextLine();
		return new UserData(username,email, true);
	}
}
