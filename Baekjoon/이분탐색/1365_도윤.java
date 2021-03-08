package baekjoon;

import java.util.*;
import java.io.*;

public class B1365 {

	static int cnt = 0;
	static int[] arr;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		check = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		check[cnt++] = arr[0];
		for (int i=1; i<N; i++) {
			if (arr[i] > check[cnt-1]) {
				check[cnt++] = arr[i];
			}
			else {
				int index = BS(arr[i]);
				check[index] = arr[i];
			}
		}
		
		System.out.println(N - cnt);
		//System.out.println(Arrays.toString(check));
	}
	
	public static int BS(int x) {
		int right = cnt, left = 0;
		int index = 0;
		
		while (left <= right) {
			int mid = (right + left) / 2;
			if (check[mid] > x) {
				index = mid;
				right = mid - 1;
			}
			else if (check[mid] < x){
				left = mid + 1;
			}
		}
		
		return index;
	}

}

/*
[문제 설명]

*/
