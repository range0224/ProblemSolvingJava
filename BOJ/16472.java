import java.util.Scanner;

public class Main {
    static int n;
    static String str;
    static int cnt[] = new int[30];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s, e;
        int ans;
        int cnt2;

        n = sc.nextInt();
        str = sc.next() + "a";

        ans = 1;
        s = 0;
        e = 0;
        cnt[str.charAt(0) - 'a'] = 1;
        cnt2 = 1;
        while(e < str.length() - 1){
            if(cnt2 <= n){
                ans = Math.max(ans, e - s + 1);
                e++;
                cnt[str.charAt(e) - 'a']++;
                if(cnt[str.charAt(e) - 'a'] == 1) cnt2++;
            }else{
                cnt[str.charAt(s) - 'a']--;
                if(cnt[str.charAt(s) - 'a'] == 0) cnt2--;
                s++;
            }
        }

        System.out.print(ans);
    }
}
