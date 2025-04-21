package service;

import domain.ModeList;
import domain.UserMap;
import repository.AddReader;
import repository.DeleteReader;
import repository.ModeReader;
import repository.NumberManeger;

public class ManegementService {
	
	private ModeReader modereader;
	private AddReader addreader;
	private DeleteReader deletereader;
	private UserMap usermap;

	public ManegementService(ModeReader modereader,AddReader addreader,DeleteReader deletereader,UserMap usermap) {
		this.modereader = modereader;
		this.addreader = addreader;
		this.deletereader = deletereader;
		this.usermap = usermap;
}
	
	
	public void execute() {
		boolean endFlag = false;
		NumberManeger.LoadID();
		usermap.LoadMap();
		while (endFlag == false) {
			ModeList mode = ModeList.ModeSelect(this.modereader.readLine());
			switch(mode) {
				case SIGNUP -> {
					usermap.AddUser(NumberManeger.nextID(),this.addreader.AddReadLine());
					System.out.println("正常に終了しました。");
					break;
				}
				case VIEW ->{
					usermap.ViewUser();
				}
				case DELETE ->{
					usermap.DeleteUser(this.deletereader.deleteReadLine());
				}
				case QUIT ->{
					endFlag = true;
				}
				case ERROR ->{
					System.out.println("入力値が不正です。もう一度やり直してください。");
				}
			}
		NumberManeger.SaveID();
		usermap.SaveMap();
		}
	}
	
	
	
}
