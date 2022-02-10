import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    static int n;
    static int arr[] = new int[10010];
    static ArrayList<Integer> v[] = new ArrayList[10010];
    static TreeMap<Integer, Integer> dp[] = new TreeMap[10010];

    public static int dfs(int cur, int prv){
        int ret = 0;

        if(dp[cur].getOrDefault(prv, -1) != -1) return dp[cur].get(prv);

        for(int i = 0; i < v[cur].size(); i++){
            if(v[cur].get(i) == prv) continue;

            ret = Math.max(ret, dfs(v[cur].get(i), cur));
        }

        dp[cur].put(prv, ret + arr[cur]);
        return ret + arr[cur];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int ans;
        int idx;

        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();

            v[i] = new ArrayList<>();
            dp[i] = new TreeMap<>();
        }
        for(int i = 0; i < n - 1; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        ans = -1;
        idx = 0;
        for(int i = 1; i <= n; i++){
            if(ans < dfs(i, 0)){
                ans = dfs(i, 0);
                idx = i;
            }
        }

        System.out.print(ans + " " + idx);
    }
}
