import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[110];
    static int arr2[][] = new int[110][110];
    static int arr3[][] = new int[110][110];
    static int x;
    static int s, e;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int a, int b){
        return a >= 0 && a <= 100 && b >= s && b < n;
    }

    public static void get_arr(){
        int idx = 0;

        for(int j = s; j < n; j++){
            for(int i = 100; i >= x; i--){
                if(arr2[i][j] == 0) continue;

                arr[idx++] = arr2[i][j];
            }
        }
    }

    public static void get_arr1(){
        int tx, ty;

        for(int i = 0; i < 110; i++){
            for(int j = 0; j < 110; j++){
                arr2[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            arr2[100][i] = arr[i];
        }

        x = 99;
        s = 1;
        e = 1;
        arr2[99][1] = arr2[100][0];
        while(true){
            if(n - 1 - e < 101 - x) break;

            tx = 99;
            ty = e + 1;
            for(int i = 100; i >= x; i--){
                for(int j = e; j >= s; j--){
                    arr2[tx][ty] = arr2[i][j];
                    tx--;
                }
                ty++;
                tx = 99;
            }

            x = 100 - (e - s + 1);
            s = e + 1;
            e = ty - 1;
        }
    }

    public static void get_arr2(){
        for(int i = 0; i < 110; i++){
            for(int j = 0; j < 110; j++){
                arr2[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            arr2[100][i] = arr[i];
        }

        for(int i = n / 2; i < n; i++){
            arr2[99][i] = arr2[100][n - i - 1];
        }

        for(int i = n / 2 + n / 4; i < n; i++){
            arr2[98][i] = arr2[99][n / 2 + n - i - 1];
            arr2[97][i] = arr2[100][n / 2 + n - i - 1];
        }

        x = 97;
        s = n / 2 + n / 4;
        e = n - 1;
    }

    public static void give_fish(){
        int nx, ny;

        for(int i = x; i <= 100; i++){
            for(int j = s; j < n; j++){
                arr3[i][j] = arr2[i][j];
            }
        }

        for(int i = x; i <= 100; i++){
            for(int j = s; j < n; j++){
                if(arr2[i][j] == 0) continue;

                for(int k = 0; k < 4; k++){
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(!in_range(nx, ny) || arr2[nx][ny] == 0) continue;

                    arr3[i][j] += (arr2[nx][ny] - arr2[i][j]) / 5;
                }
            }
        }

        for(int i = x; i <= 100; i++){
            for(int j = s; j < n; j++){
                arr2[i][j] = arr3[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mx, mn;
        int ans = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        while(true)
        {
            mx = -1;
            mn = 1000000;
            for(int i = 0; i < n; i++){
                mx = Math.max(mx, arr[i]);
                mn = Math.min(mn, arr[i]);
            }

            if(mx - mn <= m) break;

            for(int i = 0; i < n; i++){
                if(arr[i] == mn) arr[i]++;
            }

            get_arr1();

            give_fish();

            get_arr();

            get_arr2();

            give_fish();

            get_arr();

            ans++;
        }

        System.out.print(ans);
    }
}
