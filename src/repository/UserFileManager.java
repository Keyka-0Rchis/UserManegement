package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import domain.UserData;

public class UserFileManager {
	
	public static void saveMap(TreeMap <Integer, UserData> userMap) throws IOException{
		File file = new File("user.csv");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			//このtry-catch文をtry-with-resourceというらしい。自動でBufferedWriterとFileWriterをcloseしてくれる。
			//というか、これらはcloseしないとヤバいシリーズらしい。
			bw.write("userid,username,email,isExist");
	        bw.newLine(); // ← ヘッダー行に改行も忘れず
	        for (Map.Entry<Integer, UserData> entry : userMap.entrySet()) {
	            bw.write(
	            		 entry.getKey() + "," +
	                     entry.getValue().getName() + "," +
	                     entry.getValue().getEmail() + "," +
	                     entry.getValue().userExist()
	                     );
	            bw.newLine();
	        }
//			userMap.entrySet()
//			.stream()
//			.forEach(
//				entry -> {
//					try {
//						bw.write(entry.getKey() + "," + entry.getValue().getName() + "," +  entry.getValue().getEmail() +"," + entry.getValue().userExist());
//						bw.newLine();
//					} catch (IOException e) {
//						throw new IOException("エラー：ファイルの作成に失敗しました",e);
//					}
//				}
//			);	streamでthrowはできないらしいので没
		}catch(IOException e) {
			throw new IOException("エラー：ファイルの作成に失敗しました",e);
		}
	}
	
	public static UserMap loadMap() throws IOException{
		File file = new File("user.csv");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new IOException("エラー：ファイルの作成に失敗しました",e);
			} // ファイルがなければ空ファイル作
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
				bw.write("ユーザーID,名前,メールアドレス,isExist");
				bw.newLine();
			}catch(IOException e) {
				throw new IOException("エラー：ファイルの作成に失敗しました",e);
			}
		}
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			UserMap userMap = new UserMap();
			String line;	//1行分のデータ
			br.readLine(); // ヘッダー行読み飛ばし
			int lineNum = 2;	//ヘッダー行を読み飛ばした←エラーの文章用
			while((line = br.readLine()) != null) {		//lineに1行読み込んで確認。何か入っている限りループ。
				String[] importData = line.split(",");	//カンマ区切りで配列を作成。
				try {
					int loadID = Integer.parseInt(importData[0]);
					boolean existFlag = Boolean.valueOf(importData[3]);
					//csvいじられて数値IDじゃなくなったとき用
					userMap.addUser(loadID, new UserData(importData[1],importData[2],existFlag));
				}catch(NumberFormatException e){
					System.out.println(lineNum + "行目に不正なIDがあります。");
				}
				lineNum ++ ;
			}
			return userMap;
		}catch(IOException e) {
			throw new IOException("エラー：ファイルの読み込みに失敗しました",e);
		}
	}
}
