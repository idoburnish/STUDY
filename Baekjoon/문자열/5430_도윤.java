package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B5430 {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque;
        StringTokenizer st;

        while(N --> 0) {
            String command = br.readLine();
            int num = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            for (int i = 0; i < num; i++)
                deque.add(Integer.parseInt(st.nextToken()));

            AC(deque, command);
        }

        System.out.println(sb);
    }

    public static void AC(ArrayDeque<Integer> deque, String command) {
        boolean isRight = true;

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makeString(deque, isRight);
    }

    public static void makeString(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');

        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append("\n");
    }
}

// 문자열 뒤집으면 시간초과 --> deque 이용
