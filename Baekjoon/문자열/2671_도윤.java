package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2671 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ptn = "(100+1+|01)+";
        System.out.println(str.matches(ptn) ? "SUBMARINE" : "NOISE");
    }
}

// 정규표현식 이용
