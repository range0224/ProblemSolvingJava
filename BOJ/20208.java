import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m, k;
    static int arr[][] = new int[20][20];
    static int sx, sy;
    static ArrayList<Integer> x, y;
    static int tarr[] = new int[20];
    static boolean visited[] = new boolean[20];
    static int ans;

    public static boolean check(int cur){
        int hp = m;
        int cx, cy;
        int dist;

        cx = sx;
        cy = sy;
        for(int i = 0; i < cur; i++){
            dist = Math.abs(x.get(tarr[i]) - cx) + Math.abs(y.get(tarr[i]) - cy);

            if(hp < dist) return false;

            hp -= dist;
            hp += k;
            cx = x.get(tarr[i]);
            cy = y.get(tarr[i]);
        }

        return hp >= Math.abs(cx - sx) + Math.abs(cy - sy);
    }

    public static void recur(int cur){
        if(check(cur)){
            ans = Math.max(ans, cur);
        }

        for(int i = 0; i < x.size(); i++){
            if(visited[i]) continue;

            tarr[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        x = new ArrayList<>();
        y = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1){
                    sx = i;
                    sy = j;
                }else if(arr[i][j] == 2){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        recur(0);

        System.out.print(ans);
    }
}
