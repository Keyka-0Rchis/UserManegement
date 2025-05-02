package service;

import repository.UserFileManager;
import repository.UserMap;

public class ViewUserService {
	
	public ServiceResult viewUserExecute() {
		try {
			UserMap userMap = UserFileManager.loadMap();
			userMap.viewUser();
			return new ServiceResult(true,"以上です");
		}catch(Exception e) {
			return new ServiceResult(false,"エラーが発生しました。" + e.getMessage());
		}
	}
}
