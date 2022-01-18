import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static ArrayList<Integer> v[] = new ArrayList[110];
    static ArrayList<Integer> rv[] = new ArrayList[110];
    static boolean visited[] = new boolean[110];
    static boolean rvisited[] = new boolean[110];

    public static void dfs(int cur, ArrayList<Integer> v[], boolean visited[]){
        visited[cur] = true;

        for(int i = 0; i < v[cur].size(); i++){
            if(!visited[v[cur].get(i)]) dfs(v[cur].get(i), v, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int cnt;

        for(int i = 0; i < 110; i++){
            v[i] = new ArrayList<>();
            rv[i] = new ArrayList<>();
        }

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            rv[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                visited[j] = false;
                rvisited[j] = false;
            }

            dfs(i, v, visited);
            dfs(i, rv, rvisited);

            cnt = 0;
            for(int j = 1; j <= n; j++){
                if(!visited[j] && !rvisited[j]) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
