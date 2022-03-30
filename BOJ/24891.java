import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m;
    static String[] arr;
    static String[] arr2 = new String[10];
    static boolean flag;
    static boolean visited[] = new boolean[30];

    public static boolean check()
    {
        int i, j;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (arr2[i].charAt(j) != arr2[j].charAt(i)) return false;
            }
        }

        return true;
    }

    public static void recur(int cur)
    {
        int i;

        if (flag) return;

        if (cur == n)
        {
            if (check())
            {
                for (i = 0; i < n; i++)
                {
                    System.out.println(arr2[i]);
                }
                flag = true;
            }
            return;
        }

        for (i = 0; i < m; i++)
        {
            if (visited[i]) continue;

            visited[i] = true;
            arr2[cur] = arr[i];
            recur(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int i;

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[m];
        for (i = 0; i < m; i++)
        {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);

        recur(0);

        if (!flag) System.out.print("NONE");
    }
}
