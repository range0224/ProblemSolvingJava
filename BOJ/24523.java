import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static int n;
    static int arr[] = new int[1000010];
    static int ans[] = new int[1000010];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            while(!s.isEmpty() && arr[s.peek()] != arr[i]){
                ans[s.peek()] = i;
                s.pop();
            }

            ans[i] = -1;
            s.add(i);
        }

        for(int i = 1; i <= n; i++){
            sb.append(ans[i] + " ");
        }
        
        System.out.print(sb);
    }
}
