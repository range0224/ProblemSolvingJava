import java.util.Scanner;

public class Main {
    static int toNum[] = new int[300];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s;
        String str;
        int ans;
        int mul;
        int MOD = 900528;

        s = sc.nextLine();

        for(int i = 0; i < s.length(); i++){
            toNum[s.charAt(i)] = i + 1;
        }

        str = sc.nextLine();

        ans = 0;
        mul = 1;
        for(int i = str.length() - 1; i >= 0; i--){
            ans += toNum[str.charAt(i)] * mul;
            ans %= MOD;

            mul *= s.length();
            mul %= MOD;
        }

        System.out.print(ans);
    }
}
