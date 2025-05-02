package presentation;

import java.util.Scanner;

public class DeleteReader {
	
	private final Scanner deleteReader;
	
	public DeleteReader(Scanner scan) {
		this.deleteReader = scan;
	}

	public Integer deleteReadLine() {
		System.out.println("削除するユーザーIDを入力してください。");
		try {
			return Integer.parseInt(this.deleteReader.nextLine());
		}catch(NumberFormatException ex) {
			System.out.println("入力値が不正です。" + ex);
			//throw ex;
			return null ;
		}
	}
	
	public void close() {
		this.deleteReader.close();
	}
}