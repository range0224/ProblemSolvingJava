import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m;
    static ArrayList<Integer> v = new ArrayList<>();

    public static boolean check(int x){
        int cnt = 1;
        int idx = 0;

        for(int i = 1; i < v.size(); i++){
            if(v.get(i) - v.get(idx) >= x){
                cnt++;
                idx = i;
            }
        }

        return cnt >= m;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s, e;
        int mid;
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            v.add(sc.nextInt());
        }

        Collections.sort(v);

        ans = 0;
        s = 0;
        e = 1000000000;
        while(s <= e){
            mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
