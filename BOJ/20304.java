import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n;
    static boolean visited[] = new boolean[1000010];
    static int dist[] = new int[1000010];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int q;
        int x;
        int nxt;
        int mx;

        n = sc.nextInt();
        q = sc.nextInt();
        while(q-->0){
            x = sc.nextInt();

            que.add(x);
            visited[x] = true;
        }

        while(!que.isEmpty()){
            x = que.poll();

            for(int i = 1; i <= (1 << 20); i <<= 1){
                nxt = x ^ i;

                if(nxt <= n && !visited[nxt]){
                    visited[nxt] = true;
                    dist[nxt] = dist[x] + 1;
                    que.add(nxt);
                }
            }
        }

        mx = -1;
        for(int i = n; i >= 0; i--){
            mx = Math.max(mx, dist[i]);
        }

        System.out.print(mx);
    }
}
