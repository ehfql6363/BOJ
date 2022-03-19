package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Island4963 {
	public static int[][] island;
	public static boolean[][] check;
	public static int[] rows = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static int[] cols = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int count;
	public static int m;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

	    while(true) {
	        st = new StringTokenizer(br.readLine());
	        
	        m = Integer.parseInt(st.nextToken());
	        n = Integer.parseInt(st.nextToken());

	        if(n == 0 && m == 0) break;

	        island = new int[n][m];
	        check = new boolean[n][m];

	        for(int i=0; i<n; i++) {
	        	StringTokenizer str = new StringTokenizer(br.readLine());
	            for(int j=0; j<m; j++) {
	                island[i][j] = Integer.parseInt(str.nextToken());
	            }
	        }
	        count = 0;
	        for(int i=0; i<n; i++) {
	            for(int j=0; j<m; j++) {
	            	if(!check[i][j] && island[i][j] == 1) {
	            		search(i, j);
	            		count++;
	            	}
	            }
	        }
	        sb.append(count).append("\n");
	    }
	    System.out.println(sb);
	    br.close();
	}

	public static void search(int i, int j) {
		check[i][j] = true;

		for(int k=0; k<8; k++) {
			int a = i + rows[k];
			int b = j + cols[k];

			if(a >= 0 && b >= 0 && a < n && b < m) {
				if (island[a][b] == 1 && !check[a][b]) search(a, b);
			}
		}
	}

}
