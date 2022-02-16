import java.util.Scanner;

public class Main {
    static int n, m;
    static String arr[] = new String[60];
    static boolean canRead[] = new boolean[30];
    static String antic = "antic";
    static int ans = 0;

    public static void recur(int cur, int cnt){
        boolean flag;

        if(cnt == m){
            cnt = 0;
            for(int i = 0; i < n; i++){
                flag = true;
                for(int j = 0; j < arr[i].length(); j++){
                    if(!canRead[arr[i].charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }

            ans = Math.max(ans, cnt);
            return;
        }

        if(cur == 26){
            return;
        }

        if(canRead[cur]){
            recur(cur + 1, cnt);
            return;
        }

        canRead[cur] = true;
        recur(cur + 1, cnt + 1);
        canRead[cur] = false;
        recur(cur + 1, cnt);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) canRead[antic.charAt(i) - 'a'] = true;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        if(m < 5){
            System.out.print(0);
            return;
        }

        recur(0, 5);

        System.out.print(ans);
    }
}
