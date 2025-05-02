package service;

import presentation.DeleteReader;
import repository.UserFileManager;
import repository.UserMap;

public class DeleteUserService {
	
	private DeleteReader deleteReader;
	
	public DeleteUserService(DeleteReader deleteReader) {
		this.deleteReader = deleteReader;
	}
	
	public ServiceResult deleteUserExecute() {
		try {
			UserMap userMap = UserFileManager.loadMap();
			userMap.deleteUser(this.deleteReader.deleteReadLine());
			UserFileManager.saveMap(userMap.getInternalMap());
			return new ServiceResult(true,"以上です");
		}catch(Exception e) {
			return new ServiceResult(false,"エラーが発生しました。" + e.getMessage());
		}
	}
}
