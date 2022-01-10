package string;

import java.util.Scanner;

public class B1213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int size = str.length();
        int[] arr = new int[26];

        for (char x : str.toCharArray()) {
            arr[x - 65]++;
        }

        int odd = 0;
        int midIdx = -1;
        for (int i=0; i<26; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                midIdx = i;
            }

            if (odd > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        char[] chars = new char[size];
        if (midIdx != -1) {
            chars[size/2] = (char) (midIdx + 'A');
            arr[midIdx]--;
        }

        int idx = 0;
        for (int i=0; i<26; i++) {
            while (arr[i] != 0) {
                chars[idx] = (char) (i + 'A');
                chars[size - 1 - idx] = (char) (i + 'A');
                idx += 1;
                arr[i] -= 2;
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
