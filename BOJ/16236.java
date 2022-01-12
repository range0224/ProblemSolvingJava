import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int n;
    static int arr[][] = new int[30][30];
    static int x, y;
    static int fishSize = 2, fishCnt = 0;
    static ArrayList<Integer> v1, v2, v3;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void get_list(){
        Queue<Integer> xque = new LinkedList<>();
        Queue<Integer> yque = new LinkedList<>();
        boolean visited[][] = new boolean[30][30];
        int nx, ny;
        int size;
        int d;

        v1 = new ArrayList<>();
        v2 = new ArrayList<>();
        v3 = new ArrayList<>();

        d = 0;
        xque.add(x);
        yque.add(y);
        visited[x][y] = true;
        while(!xque.isEmpty()){
            size = xque.size();
            while(size-->0){
                x = xque.poll();
                y = yque.poll();

                if(arr[x][y] != 0 && arr[x][y] < fishSize){
                    v1.add(x);
                    v2.add(y);
                    v3.add(d);
                }

                for(int i = 0; i < 4; i++){
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if(!in_range(nx, ny) || visited[nx][ny] || arr[nx][ny] > fishSize) continue;

                    visited[nx][ny] = true;
                    xque.add(nx);
                    yque.add(ny);
                }
            }
            d++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans;
        int mn;
        int tx = 0, ty = 0;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 9){
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }
        }

        ans = 0;
        while(true){
            get_list();

            if(v1.isEmpty()) break;

            mn = 1000000;
            for(int i = 0; i < v1.size(); i++){
                if(mn > v3.get(i)){
                    tx = v1.get(i);
                    ty = v2.get(i);
                    mn = v3.get(i);
                }else if(mn == v3.get(i) && (tx > v1.get(i) || (tx == v1.get(i) && ty > v2.get(i)))){
                    tx = v1.get(i);
                    ty = v2.get(i);
                    mn = v3.get(i);
                }
            }

            ans += mn;
            x = tx;
            y = ty;
            arr[x][y] = 0;
            fishCnt++;

            if(fishCnt == fishSize){
                fishSize++;
                fishCnt = 0;
            }
        }

        System.out.print(ans);
    }
}
