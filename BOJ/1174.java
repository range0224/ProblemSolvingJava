import java.util.Scanner;

public class Main {
    static int n;
    static int cnt;

    public static void recur(String s, int len, int prv){
        if(s.length() == len){
            cnt += 1;
            if(cnt == n) System.out.print(s);

            return;
        }

        for(int i = 0; i < prv; i++){
            recur(s + i, len, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 1; i <= 10; i++){
            recur("", i, 10);
        }

        if(cnt < n) System.out.print(-1);
    }
}
