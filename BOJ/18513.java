import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt;
        int idx;
        int d;
        long ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        v.add(1000000);
        for(int i = 1; i < n; i++){
            if(arr.get(i) - arr.get(i - 1) - 1 > 0) v.add(arr.get(i) - arr.get(i - 1) - 1);
        }

        Collections.sort(v);

        cnt = 0;
        idx = 0;
        d = 1;
        ans = 0;
        while(true){
            for(int i = idx; i < v.size(); i++){
                ans += d;
                v.set(i, v.get(i) - 1);
                cnt++;

                if(cnt == m){
                    System.out.print(ans);
                    return;
                }

                if(v.get(i) == 0){
                    idx = i + 1;
                    continue;
                }

                ans += d;
                v.set(i, v.get(i) - 1);
                cnt++;

                if(cnt == m){
                    System.out.print(ans);
                    return;
                }

                if(v.get(i) == 0){
                    idx = i + 1;
                }
            }

            d++;
        }
    }
}
