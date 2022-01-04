import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static int n, m;
    static ArrayList<Integer> v[];
    static boolean visited[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;

        n = sc.nextInt();
        m = sc.nextInt();

        v = new ArrayList[n];
        for(int i = 0; i < n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(dfs(i, 0)){
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }

    public static boolean dfs(int cur, int depth){
        int nxt;

        if(depth == 4) return true;

        visited[cur] = true;
        for(int i = 0; i < v[cur].size(); i++){
            nxt = v[cur].get(i);

            if(!visited[nxt] && dfs(nxt, depth + 1)) return true;
        }
        visited[cur] = false;

        return false;
    }
}
