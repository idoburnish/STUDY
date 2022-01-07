package string;

import java.util.Scanner;

public class B1316 {

    static char[] checkChar = new char[100];
    static int check = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] inputWord = new String[N];
        int result = N;

        for (int i=0; i<N; i++) {
            inputWord[i] = scanner.next();

            char startChar = inputWord[i].charAt(0);
            checkChar[check++] = startChar;

            for (int j=1; j<inputWord[i].length(); j++) {
                char wordChar = inputWord[i].charAt(j);
                char wordCharBefore = inputWord[i].charAt(j - 1);

                if (wordChar == wordCharBefore) continue;

                boolean returnValue = findExistChar(wordChar);
                if (returnValue) {
                    checkChar[check++] = wordChar;
                } else {
                    result--;
                    break;
                }
            }

            checkChar = new char[100];
            check = 0;
        }

        System.out.println(result);
    }

    public static boolean findExistChar(char wordChar){
        for (int i=0; i<check; i++) {
            if (checkChar[i] == wordChar) {
                return false;
            }
        }
        return true;
    }
}
