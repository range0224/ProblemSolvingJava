import java.util.Scanner;

public class Main {
    public static int n;
    public static int cnt;

    public static void recur(String s, int len, int prv){
        if(s.length() == len){
            cnt++;
            if(cnt == n){
                System.out.print(s);
            }
            return;
        }

        for(int i = 0; i < prv; i++){
            if(s.isEmpty() && i == 0) continue;

            recur(s + i, len, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= 10; i++){
            recur("", i, 10);
        }

        if(n == 0) System.out.print(0);
        if(cnt < n) System.out.print(-1);
    }
}
