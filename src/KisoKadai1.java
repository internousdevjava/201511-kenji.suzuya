import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = null;
		String y = null;
		int a = 0;
		int b = 0;
		int c = 0;

		do {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				// １回目スルー
				if (c == 0) {
					c++;
					//ループしたら画面出力させる
				} else {
					System.out.println("もう一度入力してください。");
				}
				System.out.println("1～100まで入力してください。x軸");
				// x軸の入力待ち
				x = br.readLine();

				// x軸が数値に直せるかtry。
				// 直せなかったらもう一度入力させる。
				try {
					Integer.parseInt(x);
				} catch (NumberFormatException nfex) {
					continue;
				}
				// 入力された値が１～１００の間じゃなかったら繰り返す
				if (Integer.parseInt(x) > 100 || Integer.parseInt(x) < 1) {
					continue;
				}

				System.out.println("1～100まで入力してください。y軸");
				// y軸の入力待ち
				y = br.readLine();

				// y軸が数値に直せるかtry。
				// 直せなかったらもう一度入力させる。
				try {
					Integer.parseInt(y);
				} catch (NumberFormatException nfex) {
					continue;
				}
				// 入力された値が１～１００の間じゃなかったら繰り返す
				if (Integer.parseInt(y) > 100 || Integer.parseInt(y) < 1) {
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// a,bにx,yを代入
			a = Integer.parseInt(x);
			b = Integer.parseInt(y);
		} while (a > 100 || a <= 0 || b > 100 || b <= 0);

		// y軸の繰り返し
		for (int i = 1; i <= b; i++) {
			// x軸の繰り返し
			for (int j = 1; j <= a; j++) {
				int kotae = i * j;
				System.out.print(String.format("%1$5d", kotae));
			}
			// x軸が全部表示されたら改行
			System.out.println("");
		}
	}
}
