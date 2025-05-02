package repository;

import java.util.Set;
import java.util.TreeMap;

import domain.UserData;

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
	public void addUser(Integer newID,UserData userdata) {
		usermap.put(newID, userdata);
	}
	
	//ユーザー削除メソッド
	public void deleteUser(Integer deleteID) {
		if(deleteID != null) {
			UserData userData = usermap.get(deleteID);
			if (userData != null) {
				
				userData.setExist(false);;
				
//				usermap.entrySet()
//						.stream()
//						.filter(entry -> entry.getKey()==deleteID)
//						.;
//				
//				usermap.remove(deleteID);
//				userID = null;
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
	public void viewUser() {
		if (this.usermap.size() != 0) {
			this.usermap.entrySet()
						.stream()
						.filter(entry -> entry.getValue().userExist() == true)
						.forEach(
								entry -> System.out.println("ユーザーID:" + entry.getKey() + " ユーザー名:" + entry.getValue().getName() + " メールアドレス:" +  entry.getValue().getEmail())
								);
		}else {
			System.out.println("登録されているユーザーがありません。");
		}
	}
	
	
	//saveMapにTreeMapを受け渡すためのゲッター
	public TreeMap<Integer,UserData> getInternalMap(){
		return this.usermap;
	}
	
	//IdGeneratorにkeyのsetを受け渡すためのゲッター
	public Set<Integer> getGeneratedIdSet(){
		Set<Integer> generatedIdSet = this.usermap.keySet();
//		this.usermap.entrySet()
//					.stream()
//					.forEach(
//							entry -> generaterIdSet.put(entry.getKey())
//							);
		return generatedIdSet;
	}
}