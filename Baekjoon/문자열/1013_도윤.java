package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        String pattern = "(100+1+|01)+";

        for (int i=0; i<T; i++){
            str[i] = br.readLine();
        }

        for (int i=0; i<T; i++) {
            System.out.println(str[i].matches(pattern) ? "YES" : "NO");
        }
    }
}

// 정규표현식 이용
