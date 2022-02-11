import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int cnt;
    static boolean fin;

    public static int ncm(int a, int b){
        long ret = 1;

        if(b > a - b) b = a - b;
        for(int i = 1; i <= b; i++){
            ret *= a - i + 1;
            ret /= i;

            if(ret > k) {
                ret = 1000000000;
                break;
            }
        }

        return (int)ret;
    }

    public static void recur(String str, int a, int b){
        if(fin) return;

        if(cnt + ncm(a + b, b) < k){
            cnt += ncm(a + b, b);
            return;
        }

        if(a == 0 && b == 0){
            System.out.print(str);
            fin = true;
            return;
        }

        if(a > 0)  recur(str + "a", a - 1, b);
        if(b > 0) recur(str + "z", a, b - 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        recur("", n, m);

        if(!fin) System.out.print(-1);
    }
}
