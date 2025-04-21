package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class UserMap {
	//mapはユーザーID,ユーザー名,メールアドレスっていう順序で保管はしないらしい。順序が必要かというと・・・わからんね
	//IDの数字に対して二つの変数を持つUserDataを紐づける。これで拡張性も確保できる。わが軍はあと10年は戦える・・・。
	private TreeMap <Integer, UserData> usermap;
	
	//this.userlistとしてもよいが、右辺とことなるため不要らしい。ウーム例外。
	public UserMap() {
		usermap = new TreeMap<>();
	}
	
	//ユーザー追加メソッド
	//3行出かけてるし、これはストリームいらんくない？
	public void AddUser(Integer newID,UserData userdata) {
		usermap.put(newID, userdata);
	}
	
	//ユーザー削除メソッド
	public void DeleteUser(Integer deleteID) {
		if(deleteID != null) {
			UserData userdata = usermap.get(deleteID);
			if (userdata != null) {
				usermap.remove(deleteID);
				userdata = null;
				//=nullにするとあらゆるところからの参照がなくなる=>javaが勝手に消してくれる（かしこい）
				System.out.println("ユーザーが削除されました。");
			}else {
				System.out.println("該当するデータがありません。");
			}
		}else {
			System.out.println("ユーザーIDが不正です。");
		}
	}
	
	//ユーザー閲覧メソッド
	//ストリームまじわからん
	////ストリーム使わない版
	//public void ViewUser() {
	//	for (Entry<Integer, UserData> entry : usermap.entrySet()) {
	//		System.out.println("ユーザーID:" + entry.getKey() + " ユーザー名:" + entry.getValue().GetName() + " メールアドレス:" +  entry.getValue().GetEmail());
	//	}
	//}
	////ストリームを使う
	public void ViewUser() {
		if (this.usermap.size() != 0) {
			this.usermap.entrySet()
						.stream()
						.forEach(
								entry -> System.out.println("ユーザーID:" + entry.getKey() + " ユーザー名:" + entry.getValue().GetName() + " メールアドレス:" +  entry.getValue().GetEmail())
								);
		}else {
			System.out.println("登録されているユーザーがありません。");
		}
	}
	
	public void SaveMap() {
		File file = new File("user.csv");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			//このtry-catch文をtry-with-resourceというらしい。自動でBufferedWriterとFileWriterをcloseしてくれる。
			//というか、これらはcloseしないとヤバいシリーズらしい。
			this.usermap.entrySet()
			.stream()
			.forEach(
				entry -> {
					try {
					bw.write(entry.getKey() + "," + entry.getValue().GetName() + "," +  entry.getValue().GetEmail());
					bw.newLine();
					}catch(IOException e) {
						System.err.println("エラー：" + e.getMessage());
					}
				}
			);
		}catch(IOException e) {
			System.err.println("エラー：" + e.getMessage());
		}
	}
	
	public void LoadMap() { //これはusermapに書き込むからstaticではないと判断したが果たして・・・
		File file = new File("user.csv");
		try {
			if (!file.exists()) {
				file.createNewFile(); // ファイルがなければ空ファイル作る（中身は空）
			}
		} catch (IOException e) {
			System.err.println("ファイル作成エラー：" + e.getMessage());
			return;
		}
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;	//1行分のデータ
			int lineNum = 1;
			while((line = br.readLine()) != null) {		//lineに1行読み込んで確認。何か入っている限りループ。
				String[] importData = line.split(",");	//カンマ区切りで配列を作成。
				try {
					int loadID = Integer.parseInt(importData[0]);
					//csvいじられて数値IDじゃなくなったとき用
					this.usermap.put(loadID, new UserData(importData[1],importData[2]));
					//↑の行を調べずに書いたことは賞賛に値するのではないだろうか。
				}catch(NumberFormatException e){
					System.out.println(lineNum + "行目に不正なIDがあります。");
				}
				lineNum ++ ;
			}
		}catch(IOException e) {
			System.err.println("エラー：" + e.getMessage());
		}	
	}
}



