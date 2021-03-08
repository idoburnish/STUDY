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
전깃줄이 연결되어 있는 순서가 입력값으로 들어옴. 이때, 전깃줄을 최소한으로 끊어서 꼬여있는 전깃줄이 없도록 해야함.

[알고리즘]
- 가장 긴 증가하는 부분 수열 구하기(LIS)

[문제점]
- 가장 긴 증가하는 부분 수열인 것을 알고, 아래의 코드와 같이 arr[i] 배열에 각각 위치에서의 수열의 최대 길이를 저장하려고 했었으나, 
입력값의 범위가 (1 <= N <= 100,000)이여서 시간초과가 났음.

for (int i=0; i<N; i++) {
	int temp = 0;

	for (int j=0; j<=i; j++) {
		if (input[i] > input[j] && arr[j] > temp) temp = arr[j];
	}
	arr[i] += temp;
}

[해결방안]
- 가장 긴 증가하는 부분 수열을 구하는 방법 중 하나인 '이분 탐색'을 이용한 알고리즘을 적용
- 이분 탐색을 이용한 알고리즘은 가장 긴 수열의 길이는 구할 수 있으나, 구한 수열이 실제로 가장 긴 증가하는 수열과 일치하지는 않음. 
*/
