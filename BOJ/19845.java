import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, q;
    static int arr[] = new int[250010];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int x, y;
        int s, e;
        int mid;
        int idx;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            idx = y - 1;
            s = y;
            e = n;
            while(s <= e){
                mid = (s + e) / 2;

                if(arr[mid] >= x){
                    idx = mid;
                    s = mid + 1;
                }
                else e = mid - 1;
            }

            sb.append((idx - y + 1 + Math.max(0, arr[y] - x)) + "\n");
        }

        System.out.print(sb);
    }
}
