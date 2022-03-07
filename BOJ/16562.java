import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m, k;
    static int arr[] = new int[10010];
    static ArrayList<Integer> v[] = new ArrayList[10010];
    static boolean visited[] = new boolean[10010];

    public static int dfs(int cur){
        int ret = arr[cur];

        visited[cur] = true;
        for(int i = 0; i < v[cur].size(); i++){
            if(visited[v[cur].get(i)]) continue;

            ret = Math.min(ret, dfs(v[cur].get(i)));
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int sum;

        for(int i = 0; i < 10010; i++) v[i] = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        sum = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;

            sum += dfs(i);
        }

        if(sum > k) System.out.print("Oh no");
        else System.out.print(sum);
    }
}
