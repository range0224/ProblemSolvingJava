import java.util.Scanner;

public class Main {
    static int n;
    static String arr[] = new String[20];
    static char alphabet[] = new char[30];
    static boolean visited[] = new boolean[30];
    static int toNum[] = new int[30];
    static int idx;
    static int mx;

    public static void calc(){
        int sum = 0;
        int x;

        for(int i = 0; i < n; i++){
            x = 0;
            for(int j = 0; j < arr[i].length(); j++){
                x *= 10;
                x += toNum[arr[i].charAt(j) - 'A'];
            }

            sum += x;
        }

        mx = Math.max(mx, sum);
    }

    public static void recur(int cur){
        if(cur == idx){
            calc();
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(visited[i]) continue;

            visited[i] = true;
            toNum[alphabet[cur] - 'A'] = i;
            recur(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < arr[i].length(); j++){
                if(!visited[arr[i].charAt(j) - 'A']){
                    visited[arr[i].charAt(j) - 'A'] = true;
                    alphabet[idx++] = arr[i].charAt(j);
                }
            }
        }

        for(int i = 0; i < 10; i++) visited[i] = false;

        mx = 0;
        recur(0);

        System.out.print(mx);
    }
}
