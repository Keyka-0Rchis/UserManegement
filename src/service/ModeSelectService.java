package service;

import java.util.Scanner;

import domain.ModeList;
import presentation.AddReader;
import presentation.DeleteReader;
import presentation.ModeReader;

public class ModeSelectService {
	
	private ModeReader modeReader;

	public ModeSelectService(ModeReader modeReader) {
		this.modeReader = modeReader;
	}
	
	public void execute() {
		boolean endFlag = false;
		while (endFlag == false) {
			ModeList mode = ModeList.ModeSelect(this.modeReader.readLine());
			switch(mode) {
				case SIGNUP -> {
					ServiceResult result = new AddUserService(new AddReader(new Scanner(System.in))).addUserExecute();
					System.out.println(result.getResultMessage());
				}
				case VIEW ->{
					ServiceResult result = new ViewUserService().viewUserExecute();
					System.out.println(result.getResultMessage());
				}
				case DELETE ->{
					ServiceResult result = new DeleteUserService(new DeleteReader(new Scanner(System.in))).deleteUserExecute();
					System.out.println(result.getResultMessage());
				}
				case QUIT ->{
					endFlag = true;
				}
				case ERROR ->{
					System.out.println("モード選択が不正です。もう一度やり直してください。");
				}
			}
		}
	}
	
	
	
	
	
	
	
}
