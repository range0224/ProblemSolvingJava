import java.util.Scanner;

public class Main {
    static int n;
    static int arr[] = new int[15];
    static int op[] = new int[4];
    static int mn, mx;

    public static int calc(int x, int y, int type){
        if(type == 0) return x + y;
        else if(type == 1) return x - y;
        else if(type == 2) return x * y;
        else return x / y;
    }

    public static void recur(int cur, int sum){
        if(cur == n - 1){
            mn = Math.min(mn, sum);
            mx = Math.max(mx, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;
                recur(cur + 1, calc(sum, arr[cur + 1], i));
                op[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++){
            op[i] = sc.nextInt();
        }

        mn = 1 << 30;
        mx = -(1 << 30);
        recur(0, arr[0]);

        System.out.println(mx);
        System.out.print(mn);
    }
}
