import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int arr[] = new int[1000010];

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s, e;
        int cnt;
        int ans;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        s = 0;
        e = 0;
        cnt = 0;
        if(arr[0] % 2 == 1) cnt = 1;
        while(e < n){
            if(cnt <= m){
                ans = Math.max(ans, e - s + 1 - cnt);
                e++;
                if(arr[e] % 2 == 1) cnt++;
            }else{
                if(arr[s] % 2 == 1) cnt--;
                s++;
            }
        }

        System.out.print(ans);
    }
}
