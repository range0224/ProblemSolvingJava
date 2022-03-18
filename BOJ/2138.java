import java.util.Scanner;

public class Main{
    static int n;
    static String str;
    static String s;
    static int push[] = new int[100010];

    public static int check(int x){
        int cnt = x;

        push[1] = x;
        for(int i = 2; i <= n; i++){
            if((str.charAt(i - 1) - '0' + push[i - 1] + push[i - 2]) % 2 != s.charAt(i - 1) - '0') {
                push[i] = 1;
                cnt++;
            }
            else push[i] = 0;
        }

        if((str.charAt(n) + push[n - 1] + push[n]) % 2 == s.charAt(n) - '0') return cnt;
        else return 1 << 30;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ans = 1 << 30;

         n = sc.nextInt();
         str = "0" + sc.next();
         s = "0" + sc.next();

         ans = Math.min(check(0), check(1));

         if(ans == (1 << 30)) ans = -1;

         System.out.print(ans);
    }
}
