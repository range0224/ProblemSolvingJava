import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m, k;
    static int arr[][] = new int[510][2];
    static int seat[] = new int[110];

    public static int get_seat(){
        int dist[] = new int[110];
        int mx, idx;

        for(int i = 1; i <= n; i++){
            dist[i] = 1000000;
            for(int j = 1; j <= n; j++){
                if(seat[j] != 0){
                    dist[i] = Math.min(dist[i], Math.abs(i - j));
                }
            }
        }

        mx = 0;
        idx = 1;
        for(int i = 1; i <= n; i++){
            if(mx < dist[i]){
                mx = dist[i];
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();
        int cnt;

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= m; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            
            if(arr[i][0] == arr[i][1]){
                arr[i][0] = -1;
                arr[i][1] = -1;
            }
        }

        cnt = 0;
        for(int i = 9; i <= 20; i++){
            for(int j = 0; j <= 59; j++){
                for(int k = 1; k <= m; k++){
                    if(arr[k][1] / 100 == i && arr[k][1] % 100 == j){
                        for(int l = 1; l <= n; l++){
                            if(seat[l] == k) seat[l] = 0;
                        }
                    }
                }

                v.clear();
                for(int k = 1; k <= m; k++) {
                    if (arr[k][0] / 100 == i && arr[k][0] % 100 == j) {
                        v.add(arr[k][1] * 1000 + k);
                    }
                }

                Collections.sort(v);
                for(int k = 0; k < v.size(); k++){
                    seat[get_seat()] = v.get(k) % 1000;
                }

                if(seat[k] == 0) cnt++;
            }
        }

        System.out.print(cnt);
    }
}
