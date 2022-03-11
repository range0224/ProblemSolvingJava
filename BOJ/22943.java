import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static int n, m;
    static boolean isPrime[] = new boolean[100010];
    static ArrayList<Integer> v = new ArrayList<>();
    static boolean visited[] = new boolean[20];
    static int ans;

    public static void recur(int cur, int num){
        int s, e;
        boolean flag;

        if(cur != 0 && num == 0) return;

        if(cur == n){
            s = 0;
            e = v.size() - 1;
            flag = false;
            while(s < e){
                if(v.get(s) + v.get(e) == num){
                    flag = true;
                    break;
                } else if(v.get(s) + v.get(e) < num){
                    s++;
                } else{
                    e--;
                }
            }

            if(!flag) return;

            while(num % m == 0) num /= m;

            for(int i = 2; i <= num; i++){
                if(num % i == 0){
                    if(isPrime[i] && isPrime[num / i]) ans++;
                    break;
                }
            }

            return;
        }

        for(int i = 0; i <= 9; i++){
            if(visited[i]) continue;

            visited[i] = true;
            recur(cur + 1, num * 10 + i);
            visited[i] = false;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 100010; i++) isPrime[i] = true;

        isPrime[1] = false;
        for(int i = 2; i * i < 100010; i++){
            if(!isPrime[i]) continue;

            for(int j = i * i; j < 100010; j += i){
                isPrime[j] = false;
            }
        }

        for(int i = 2; i < 100010; i++){
            if(isPrime[i]) v.add(i);
        }

        n = sc.nextInt();
        m = sc.nextInt();

        recur(0, 0);

        System.out.print(ans);
    }
}
