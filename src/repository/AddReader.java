package repository;

import java.util.Scanner;

import domain.UserData;

public class AddReader {

	private final Scanner addName;
	private final Scanner addEmail;
	
	public AddReader(Scanner addName,Scanner addEmail) {
		this.addName=addName;
		this.addEmail=addEmail;
	}
	
	public UserData AddReadLine() {
		System.out.println("ユーザー名を入力してください。");
		String username = this.addName.nextLine();
		System.out.println("メールアドレスを入力してください。");
		String email = this.addEmail.nextLine();
		return new UserData(username,email);
	}
}
