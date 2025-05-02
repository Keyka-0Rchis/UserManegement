package service;

import presentation.AddReader;
import repository.IdGenerator;
import repository.UserFileManager;
import repository.UserMap;

public class AddUserService {

	private AddReader addReader;
	
	public AddUserService(AddReader addReader) {
		this.addReader = addReader;
	}
	
	public ServiceResult addUserExecute() {
		try {
			UserMap userMap = UserFileManager.loadMap();
			userMap.addUser(IdGenerator.generateNextID(userMap.getGeneratedIdSet()),this.addReader.AddReadLine());
			UserFileManager.saveMap(userMap.getInternalMap());
			return new ServiceResult(true , "ユーザーの追加に成功しました。");  
		}catch(Exception e) {
			return new ServiceResult(false, "ユーザーの追加に失敗しました。"+ e.getMessage());
		}
	}
}
