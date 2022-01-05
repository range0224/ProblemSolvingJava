import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n;
    static boolean can_use[] = new boolean[10];

    public static int can_make(int x){
        int cnt;

        if(x == 0) {
            if(can_use[0]) return 1;
            else return -1;
        }

        cnt = 0;
        while(x > 0){
            if(!can_use[x % 10]) return -1;
            x /= 10;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int q;
        int ans;
        int x;

        for(int i = 0; i < 10; i++){
            can_use[i] = true;
        }

        n = sc.nextInt();
        q = sc.nextInt();
        while(q-->0){
            can_use[sc.nextInt()] = false;
        }

        ans = Math.abs(n - 100);
        for(int i = 0; i <= 1000000; i++){
            x = can_make(i);
            if(x != -1){
                ans = Math.min(ans, Math.abs(n - i) + x);
            }
        }

        System.out.print(ans);
    }
}
