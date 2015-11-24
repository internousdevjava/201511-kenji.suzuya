import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {

	public static void main(String[] args) throws IOException {
		boolean loop = true;
		boolean p_loop = true;
		String str = null;
		String ff = null;
		File file;

		int j = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (p_loop) {
			System.out.println("どちらにアクセスしますか？");
			System.out.println("1ファイル  ２ディレクトリ  ");
			ff = br.readLine();

			// ファイルにアクセス
			if (ff.equals("1")) {
				System.out.println("アクセスしたいファイルの絶対パスを指定してください。");
				try {
					str = br.readLine();
				} catch (IOException e) {
					System.out.println(e);
				}
				file = new File(str);
				// パスが正常に入力された場合
				if (str.indexOf(":") != -1) {

					File dir = new File(file.getParent());

					if (!dir.exists()) {
						// ディレクトリが存在しなかった場合
						dir.mkdirs();
					} else {
					}

					if (file.exists()) {
						// ファイルが存在する場合
						System.out.println("すでにファイルがあります。");
						p_loop = false;
						loop = true;
					} else {
				//		System.out.println("ファイルがありません。:" + file.getAbsolutePath());
						try {
							file.createNewFile();
							System.out.println("ファイルを作成しました。");
							p_loop = false;
							loop = true;

						} catch (IOException e) {
							System.out.println(e);
						}
					}
				} else {
					System.out.println("もう一度初めからやり直してください。");
					loop = false;
				}

			} else if (ff.equals("2")) {
				System.out.println("ディレクトリの作成のみとなります。");
				System.out.println("作りたいディレクトリへのパスを入力してください。");
				str = br.readLine();
				file = new File(str);
				if (str.indexOf(":") != -1) {

					File dir = new File(file.getAbsolutePath());
					if (!dir.exists()) {
						dir.mkdirs();
					} else {
						System.out.println("そのディレクトリは存在します。1");

					}
					System.out.println("フォルダを作成しました。");
				} else {
					System.out.println("もう一度初めからやり直してください。");
					loop = false;
				}

			} else {
				System.out.println("もう一度初めからやり直してください。");
				loop = false;

			}
		}

		//読み込み、書き込みなどのメニュー
		String menu = "4";
		while (loop) {
			switch (menu) {
			// 読み込んで出力処理
			case "1":
				System.out.println("読み込みます");

				FileReader in = new FileReader(str);

				int ch;
				try {
					// 1文字ずつ表示。読み込む文字がなくなったら-1を返す
					while ((ch = in.read()) != -1) {
						System.out.print((char) ch);
					}
					System.out.println("");
					in.close();
				} catch (FileNotFoundException e) {
					System.out.println(e);
				} catch (IOException e) {
					System.out.println(e);
				}
				menu = "4";
				break;
			// 書き込み処理
			case "2":

				boolean b = true;
				System.out.println("== 1:上書き　　2:追記　　3:戻る ==");
				try {
					String s = br.readLine();
					j = Integer.parseInt(s);
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
				// 上書き保存の場合
				if (j == 1) {
					System.out.println("上書き");
					System.out.println("\".\"のみの行で終了");
					b = false;
					FileWriter fw = new FileWriter(str, b);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
					boolean a = true;
					// 1行ずつ書き込み
					// "."一文字のときのみ終了
					while (a) {
						String st = br.readLine();
						if (st.equals(".")) {
							a = false;
							continue;
						}
						pw.println(st);
					}
					pw.close();
					// メニューに戻る
					menu = "4";
					System.out.println("上書きしました。");
					// 追記の場合
				} else if (j == 2) {
					System.out.println("追記します");
					System.out.println(".のみの行で終了");
					b = true;
					FileWriter fw = new FileWriter(str, b);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
					boolean a = true;
					// 1行ずつ書き込み
					// "."一文字のときのみ終了
					while (a) {
						String st = br.readLine();
						if (st.equals(".")) {
							a = false;
							continue;
						}
						pw.println(st);
					}
					pw.close();
					System.out.println("追記しました");
					menu = "4";
				} else if (j == 3) {
					// 戻るボタンが押されたときの処理
					menu = "4";
				} else {
					// 1～3以外の文字が入力された場合メニューに戻る
					System.out.println("もう一度入力してください。");
				}
				break;
			// 終了処理
			case "3":
				loop = false;
				System.out.println("終了しました。");
				break;
			// メニュー表示
			default:
				System.out.println("=======================================");
				System.out.println("== 1:読み込み	2:書き込み	3:終了==");
				System.out.println("=======================================");

				menu = br.readLine();
			}
		}
	}
}
