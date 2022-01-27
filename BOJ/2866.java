import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    static int n, m;
    static char arr[][] = new char[1010][1010];

    public static boolean check(int idx){
        TreeMap<String, Integer> mp = new TreeMap<>();
        String str;

        for(int j = 0; j < m; j++) {
            str = "";
            for (int i = idx; i < n; i++) {
                str += arr[i][j];
            }

            if(mp.getOrDefault(str, 0) == 1) return false;

            mp.put(str, 1);
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String temp[] = br.readLine().split(" ");
        int ans;
        int s, e;
        int mid;

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        ans = 0;
        s = 0;
        e = n - 1;
        while(s <= e){
            mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                s = mid + 1;
            }else e = mid - 1;
        }

        System.out.print(ans);
    }
}
