import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int arr[] = new int[6000010];
    static int cnt[] = new int[3010];
    static int cnt2;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x;

        n = Integer.parseInt(st.nextToken());
        st.nextToken();
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = n; i < 2 * n; i++) arr[i] = arr[i - n];

        for(int i = 0; i < m; i++){
            cnt[arr[i]]++;

            if(cnt[arr[i]] == 1) cnt2++;
        }

        x = cnt2;
        if(cnt[k] == 0) x++;

        ans = x;
        for(int i = m; i < 2 * n; i++){
            cnt[arr[i - m]]--;
            if(cnt[arr[i - m]] == 0) cnt2--;

            cnt[arr[i]]++;
            if(cnt[arr[i]] == 1) cnt2++;

            x = cnt2;
            if(cnt[k] == 0) x++;

            ans = Math.max(ans, x);
        }

        System.out.print(ans);
    }
}
