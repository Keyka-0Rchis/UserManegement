package repository;

import java.util.Scanner;

public class ModeReader {
	
	private final Scanner modereader;
	
	public ModeReader(Scanner scan) {
		this.modereader = scan;
	}

	public String readLine() {
		System.out.println("ユーザー登録は 1 ");
		System.out.println("ユーザーの一覧表示は 2 ");
		System.out.println("ユーザーの削除は 3 ");
		System.out.println("終了する際は quit ");
		System.out.println("を入力してください。");
		return this.modereader.nextLine();
	}
	
	public void close() {
		this.modereader.close();
	}
}
