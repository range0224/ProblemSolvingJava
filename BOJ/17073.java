import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main{
    static int n, m;
    static ArrayList<Integer> v[] = new ArrayList[500010];
    static double ans[] = new double[500010];

    public static void dfs(int cur, int prv, double val){
        ans[cur] = val;

        for(int i = 0; i < v[cur].size(); i++){
            if(v[cur].get(i) == prv) continue;

            ans[cur] = 0;
            dfs(v[cur].get(i), cur, val / (v[cur].size() - 1));
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        double answer;
        int cnt;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            v[a].add(b);
            v[b].add(a);
        }

        v[1].add(0);
        dfs(1, -1, m);

        answer = 0;
        cnt = 0;
        for(int i = 1; i <= n; i++){
            answer += ans[i];
            if(ans[i] != 0) cnt++;
        }

        System.out.print(answer / cnt);
    }
}
