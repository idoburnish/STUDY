package twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수의 연속합
public class B1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int idx = 0;
        int[] prime = new int[N+1];
        boolean[] check = new boolean[N + 1];
        for (int i=2; i<N+1; i++) {
            if (!check[i]) prime[idx++] = i;
            for (int j=i; j<N+1; j+=i) {
                check[j] = true;
            }
        }

        int sum = 0;
        int lt = 0, rt = 0;
        while (rt < idx) {
            sum += prime[rt++];
            if (sum == N) answer++;
            while (sum >= N) {
                sum -= prime[lt++];
                if (sum == N) answer++;
            }
        }
        System.out.println(answer);
    }
}

// 두개의 포인터 이용
// 에라토스테네스의 체로 소수 구하기
