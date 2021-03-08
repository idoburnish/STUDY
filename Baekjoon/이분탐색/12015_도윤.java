package baekjoon;

import java.io.*;
import java.util.*;

public class B12015 {

	static int index = 0;
	static int[] arr;
	static int[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		check = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		check[index++] = arr[0];
		for (int i=1; i<N; i++) {
			if (arr[i] > check[index - 1])
				check[index++] = arr[i];
			else {
				int num = BS(arr[i]);
				check[num] = arr[i];
			}
		}
		
		System.out.println(index);

	}
	
	public static int BS(int x) {
		int left = 0;
		int right = index;
		int ans = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check[mid] >= x) {
				ans = mid;
				right = mid - 1;
			}
			else
				left = mid + 1;
		}
		
		return ans;
	}

}

/* 1365*/
