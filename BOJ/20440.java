import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();
    static ArrayList<Integer> tv = new ArrayList<>();
    static int idx[] = new int[2000010];
    static int cnt[] = new int[2000010];
    static int len;

    public static int get_idx(int v)
    {
        int s, e;
        int mid;

        s = 0;
        e = len - 1;
        while (s <= e)
        {
            mid = (s + e) / 2;

            if (idx[mid] == v) return mid;
            else if (idx[mid] < v) s = mid + 1;
            else e = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        int mx;
        int sum;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            v.add(new int[]{a, b});
            tv.add(a);
            tv.add(b);
        }

        Collections.sort(tv);

        idx[0] = tv.get(0);
        len = 1;
        for (int i = 1; i < tv.size(); i++)
        {
            if (tv.get(i) == tv.get(i - 1)) continue;

            idx[len++] = tv.get(i);
        }

        for (int i = 0; i < v.size(); i++)
        {
            cnt[get_idx(v.get(i)[0])]++;
            cnt[get_idx(v.get(i)[1])]--;
        }

        mx = -1;
        sum = 0;
        for (int i = 0; i < 2000010; i++)
        {
            sum += cnt[i];

            if (mx < sum) mx = sum;
        }

        System.out.println(mx);

        sum = 0;
        for (int i = 0; i < 2000010; i++)
        {
            sum += cnt[i];

            if (sum == mx)
            {
                System.out.print(idx[i] + " ");

                int j;
                for (j = i + 1; cnt[j] == 0; j++);

                System.out.print(idx[j]);
                return;
            }
        }
    }
}
