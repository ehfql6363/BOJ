package baekjoon;

import java.io.*;

public class plus1000 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strx = br.readLine();
		String stry = br.readLine();
		
		int x = Integer.parseInt(strx);
		int y = Integer.parseInt(stry);
		
		if(x>0 && y<10) {
			int sum = x+y;
			bw.write(sum);
		}
		bw.flush();
		bw.close();
	}

}
//console�� ����� ����