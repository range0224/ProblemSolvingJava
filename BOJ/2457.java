import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();
    static int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int toDay(int m, int d){
        for(int i = 1; i < m; i++){
            d += days[i];
        }

        return d;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        int s, e;
        int cur;
        int cnt;
        int idx;
        int mx;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();

            v.add(new int[]{toDay(a, b), toDay(c, d)});
        }

        Collections.sort(v, new Comparator<int[]>(){
           @Override
           public int compare(int[] a, int[] b){
               return Integer.compare(a[0], b[0]);
           }
        });

        e = toDay(11, 30);
        cur = toDay(3, 1);

        cnt = 0;
        idx = 0;
        while(idx < n && cur <= e){
            mx = 0;
            while(idx < n && v.get(idx)[0] <= cur){
                mx = Math.max(mx, v.get(idx)[1]);
                idx++;
            }

            if(mx <= cur) break;

            cur = mx;
            cnt++;
        }

        if(cur > e) System.out.print(cnt);
        else System.out.print(0);
    }
}
