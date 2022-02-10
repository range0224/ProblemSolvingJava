import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n;
        long ans;

        ans = 0;
        n = sc.nextLong();
        for(long i = 1; i * i <= n; i++){
            ans = i;
        }

        System.out.print(ans);
    }
}
