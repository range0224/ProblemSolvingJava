import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static ArrayList<Integer> v[] = new ArrayList[110];
    static int dist[] = new int[110];

    public static void bfs(int s){
        int cur;
        Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[110];
        int size;
        int d;

        d = 0;
        que.add(s);
        visited[s] = true;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                cur = que.poll();

                dist[cur] = d;

                for(int i = 0; i < v[cur].size(); i++){
                    if(visited[v[cur].get(i)]) continue;

                    que.add(v[cur].get(i));
                    visited[v[cur].get(i)] = true;
                }
            }
            d++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int mn;
        int idx;
        int sum;

        for(int i = 1; i < 110; i++) v[i] = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        mn = 100000000;
        idx = 0;
        for(int i = 1; i <= n; i++){
            bfs(i);

            sum = 0;
            for(int j = 1; j <= n; j++){
                sum += dist[j];
            }

            if(mn > sum){
                mn = sum;
                idx = i;
            }
        }

        System.out.print(idx);
    }
}
