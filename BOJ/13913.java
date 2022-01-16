import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int n, m;
    static int prv[] = new int[200010];
    static boolean visited[] = new boolean[200010];
    static int mul[] = {2, 1, 1};
    static int add[] = {0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int cur;
        int nxt;
        int size;
        int d = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        que.add(n);
        visited[n] = true;
        prv[n] = -1;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0) {
                cur = que.poll();

                if(cur == m){
                    System.out.println(d);
                    while(cur != -1){
                        st.add(cur);
                        cur = prv[cur];
                    }

                    while(!st.empty()){
                        System.out.print(st.peek() + " ");
                        st.pop();
                    }
                    return;
                }

                for (int i = 0; i < 3; i++) {
                    nxt = cur * mul[i] + add[i];

                    if (nxt >= 0 && nxt <= 200000 && !visited[nxt]) {
                        que.add(nxt);
                        visited[nxt] = true;
                        prv[nxt] = cur;
                    }
                }
            }

            d++;
        }
    }
}
