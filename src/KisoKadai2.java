import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KisoKadai2 {

	public static void main(String[] args) {
		String str = null;
		int in=0;
		int ran = 0;
		boolean hantei = true;

		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		//Randomクラスのインスタンス化
		Random rnd = new Random();
		//1～100まで
		ran = rnd.nextInt(100);
		ran+=1;
	//	System.out.println(ran);

	    while(hantei){
	    	try{
	    		System.out.println("1～100までの間で、コンピュータが選んだ数字を当ててください。");
	    		//入力待ち
	    		str = br.readLine();
	    		//String型からInt型に変換してaに代入
	    		in=Integer.parseInt(str);
	    		//1～100までの範囲外だったら繰り返し
	    		if(in > 100 || in < 1){
	    			continue;
	    		}
	    	}catch (NumberFormatException nfex) {
	    		System.out.println("整数を入力してください");
	    		continue;
	    	}catch(IOException e){
	    		System.out.println("何かエラー出たよ!");
	    		e.printStackTrace();
	    	}

	    	//答えが合ってたらクリア！
	    	if(in == ran){
	    		System.out.println("Congratulations!!");
	    		hantei = false;

	    		//選んだ数字よりコンピュータの数字の方が低かったら処理される。
	    	}else if(ran < in){
	    		System.out.println("--- 残念。。。もっと低い数字だよ ---");
	    		System.out.println("--- もう一度入力してください。 ---");

	    		//選んだ数字よりコンピュータの数字の方が高かったら処理される。
	    	}else{
	    		System.out.println("--- 残念。。。もっと高い数字だよ ---");
	    		System.out.println("--- もう一度入力してください。 ---");
	    	}
	    }
	}
}