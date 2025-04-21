package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NumberManeger {
	public static int newID = 1;
	
	public static int nextID() {
		return newID ++ ;
	}
	
	public static void saveID() {
		File file = new File("lastID.txt");
		try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
			br.write(newID);
		}catch(IOException e) {
			System.err.println("エラー：" + e.getMessage());
		}
		
	}
	
	public static void LoadID(){
		File file = new File("lastID.txt");	
		try {
			if (!file.exists()) {
				file.createNewFile(); // ファイルがなければ空ファイル作る（中身は空）
				newID = 1;
				return;
			}
		} catch (IOException e) {
			System.err.println("ファイル作成エラー：" + e.getMessage());
			return;
		}
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = br.readLine();
			//readLineは一回使うごとに一行使い捨ててしまう。ここで一括取得しておく。
			if (line != null){
				try {
					newID = Integer.parseInt(line);
				}catch(NumberFormatException e){
					System.err.println("lastID.txtに異常があります。");
				}
			}else{
				newID = 1;
			}
		}catch(IOException e) {
			System.err.println("エラー：" + e.getMessage());
		}	
	}
	
	public static void SaveID() {
		File file = new File("lastID.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write(Integer.toString(newID));
		}catch(IOException e) {
			System.err.println("エラー：" + e.getMessage());
		}
	}
	
	
}
