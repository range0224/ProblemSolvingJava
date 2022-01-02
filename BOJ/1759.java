import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static char arr[];
    static String aeiou = "aeiou";

    public static void recur(int cur, int a, int b, String str){
        int is_aeiou;

        if(str.length() == n){
            if(a >= 1 && b >= 2) System.out.println(str);

            return;
        }
        if(cur == m) return;

        is_aeiou = 0;
        for(int i = 0; i < 5; i++){
            if(arr[cur] == aeiou.charAt(i)){
                is_aeiou = 1;
                break;
            }
        }

        recur(cur + 1, a + is_aeiou, b + (is_aeiou ^ 1), str + arr[cur]);
        recur(cur + 1, a, b, str);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new char[m];

        for(int i = 0; i < m; i++){
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        recur(0, 0, 0, "");
    }
}
