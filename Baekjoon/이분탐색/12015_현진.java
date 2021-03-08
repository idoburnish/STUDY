package binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class project12015 {
	/*가장 긴 증가하는 부분 수열2*/
	static int count;
	static int dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		dp = new int[N];
		String arr1[] = (bf.readLine()).split(" ");
		for(int i = 0 ;i<N;i++)
			arr[i] = Integer.parseInt(arr1[i]);
		
		dp[0] = arr[0];
		count++;
		for(int i=1;i<N;i++) {
			if(dp[count-1]<arr[i]) {
				dp[count] = arr[i];
				count++;
			}
			else {
				int ans = BS(arr[i]);
				dp[ans] = arr[i];
			}
		}
		System.out.println(count);
		
	}

	public static int BS(int x) {
		int ans = 0;
		int l=0;
		int r=count-1;
		int mid=0;
		while(l<=r) {
			mid = (l+r)/2;
			if(x<=dp[mid]) {
				r = mid-1;
				ans = mid;
			}
			else
				l = mid+1;	
		}	
		return ans;
		
	}
}
/*1365문제랑 알고리즘 동일*/
