import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int arr[] = new int[500010];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;
        Stack<Integer> st = new Stack<>();
        int i;

        n = Integer.parseInt(bf.readLine());
        s = new StringTokenizer(bf.readLine());
        for(i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(s.nextToken());
        }

        arr[0] = 1 << 30;
        st.push(0);
        for(i = 1; i <= n; i++){
            while(!st.empty() && arr[st.peek()] < arr[i]) st.pop();

            System.out.print(st.peek() + " ");
            st.push(i);
        }
    }
}
