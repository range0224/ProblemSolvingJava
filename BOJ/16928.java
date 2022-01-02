import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int n, m;
        int move[] = new int[110];
        int dist[] = new int[110];
        int a, b;
        int cur;
        int nxt;

        for(int i = 1; i <= 100; i++){
            move[i] = i;
            dist[i] = 10000000;
        }

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n + m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            move[a] = b;
        }

        que.add(1);
        dist[1] = 0;
        while(!que.isEmpty()){
            cur = que.peek();
            que.poll();

            for(int i = 1; i <= 6; i++){
                if(cur + i > 100) break;

                nxt = move[cur + i];
                if(dist[nxt] > dist[cur] + 1){
                    dist[nxt] = dist[cur] + 1;
                    que.add(nxt);
                }
            }
        }

        System.out.print(dist[100]);
    }
}
