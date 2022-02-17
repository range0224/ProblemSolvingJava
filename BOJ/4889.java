import java.util.Scanner;

public class Main {
    static String str;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        int x;
        int cnt;

        while(true){
            str = sc.next();

            if(str.contains("-")) break;

            x = 0;
            cnt = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '{') x++;
                else x--;

                if(x < 0){
                    cnt++;
                    x += 2;
                }
            }

            System.out.println(t + ". " + (cnt + x / 2));
            t++;
        }
    }
}
