package domain;

public enum ModeList {
	
	//ユーザーの追加
	SIGNUP ,
	//ユーザー閲覧
	VIEW,
	//ユーザー削除
	DELETE,
	//終了
	QUIT,
	//その他
	ERROR;
	
	public static ModeList ModeSelect(String modereader) {
		return switch(modereader) {
			case "1" -> SIGNUP;
			case "2" -> VIEW;
			case "3" -> DELETE;
			case "quit" -> QUIT;
			default -> ERROR;
			//throw new IllegalArgumentException("入力値が不正です。もう一度やり直してください。");
			//これをするとやり直せないんだよね。アプリが落ちるってやつか。
		};
	}
}
