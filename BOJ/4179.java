import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static char arr[][] = new char[1010][1010];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        int size;
        int time = 1;
        int x, y;
        int nx, ny;
        String s;

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            s = sc.next();
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'J') que.add(new int[]{i, j});
                else if (arr[i][j] == 'F') fire.add(new int[]{i, j});
            }
        }

        while (!que.isEmpty())
        {
            size = que.size();
            while (size-->0)
            {
                x = que.peek()[0];
                y = que.peek()[1];
                que.poll();

                if (arr[x][y] != 'J') continue;

                for (int i = 0; i < 4; i++)
                {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    {
                        System.out.print(time);
                        return;
                    }

                    if (arr[nx][ny] == '.')
                    {
                        arr[nx][ny] = 'J';
                        que.add(new int[]{nx, ny});
                    }
                }
            }

            size = fire.size();
            while (size-->0)
            {
                x = fire.peek()[0];
                y = fire.peek()[1];
                fire.poll();

                for (int i = 0; i < 4; i++)
                {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == '#' || arr[nx][ny] == 'F') continue;

                    arr[nx][ny] = 'F';
                    fire.add(new int[]{nx, ny});
                }
            }

            time++;
        }

        System.out.print("IMPOSSIBLE");
    }
}
