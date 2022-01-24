import java.util.Scanner;

public class Main {
    static int arr[][] = new int[30][30];
    static int dx[] = {1, 0, 1, -1};
    static int dy[] = {0, 1, 1, 1};
    static int x, y;

    public static boolean check(int num){
        int cnt;
        boolean visited[][][] = new boolean[30][30][4];
        int nx, ny;

        for(int j = 1; j <= 19; j++){
            for(int i = 1; i <= 19; i++){
                for(int dir = 0; dir < 4; dir++){
                    if(visited[i][j][dir]) continue;

                    nx = i;
                    ny = j;
                    cnt = 0;
                    while(arr[nx][ny] == num){
                        cnt++;
                        visited[nx][ny][dir] = true;
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if(cnt == 5) {
                        x = i;
                        y = j;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 19; i++){
            for(int j = 1; j <= 19; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        if(check(1)){
            System.out.println(1);
            System.out.print(x + " " + y);
        }else if(check(2)){
            System.out.println(2);
            System.out.print(x + " " + y);
        }else{
            System.out.println(0);
        }
    }
}
