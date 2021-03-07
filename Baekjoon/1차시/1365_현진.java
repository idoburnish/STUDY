package binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class project1365 {
	/*꼬인 전깃줄*/
	static int cnt; // dp의 개수
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(bf.readLine()); // Line 단위로 나뉘어짐
		int arr[] = new int[N];
		int dp[] = new int[N];
		String word = bf.readLine();
 		String arr1[] = word.split(" ");
 		for(int i =0 ;i<N;i++)
 			arr[i] = Integer.parseInt(arr1[i]);	
 		dp[0] = arr[0];
 		cnt++;
 		for(int i = 1; i < N; i++) {
 			if(dp[cnt-1]<arr[i]) {
 				dp[cnt] =arr[i];
 				cnt++;
 				
 			}
 			else {
 				int ans = Binary(arr[i],dp);
 				dp[ans] = arr[i];
 			}
 		}	
		
 		System.out.println(N-cnt);		
	}
	public static int Binary(int x,int dp[]) {
		int ans = 0;
		int l=0;
		int r=cnt;
		int mid =(l+r)/2;		
		while(l<=r) {
			mid = (l+r)/2;
			if(x<dp[mid]) {
				ans = mid;
				r = mid-1;
			}
			else {
				//ans = mid;
				l = mid+1;
			}
			
		
		}	
		return ans;	
	-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
<문제 설명>

--> 전깃줄이 꼬이지 않으려면 번호가 증가해야 하므로 가장 증가하는 긴 수열을 이용하면 '최대로' 전깃줄을 꼬이지 않고 연결 할 수 있는 경우의 수가 된다.
    전체 전깃줄 수에서 꼬이지 않은 경우를 빼주면 전깃줄을 최소로 자르는 경우의 수를 구할 수 있다.

<알고리즘>

 - dp에 증가하는 수열 입력
 - 이진 탐색으로 arr를 탐색하면서 dp 배열을 수정하면서 알맞은 곳에 넣어주기
 - dp의 배열 수(cnt)로 가장 긴 수열 크기 확인
 
<헷갈렸던 점>

   다이나믹 프로그래밍으로 문제를 풀었는데 답은 나오지만 테스트 범위가 너무 커서 시간 초과
   -->이분 탐색으로 문제를 풀어서 카운팅만 해줌

<해결X>

Binary함수 코드에서 if(x<dp[mid])일때만 ans = mid를 넣어야만 정답인지 아직 정확하게 잘 모르겠다.
x<=dp[mid]일때는 정답이다
근데 x<dp[mid]일때 ans=mid하면 틀렸다고 뜬다. 

*/
