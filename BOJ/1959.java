import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m;
        long a, b, c, d;
        long temp;
        long dif;
        long ans = 0;

        n = sc.nextLong();
        m = sc.nextLong();

        a = 1;
        b = 1;
        c = n;
        d = m;

        while ((c - a) > 1 && (d - b) > 1)
        {
            temp = Math.min(c - a, d - b);

            dif = 1;
            while (dif <= temp)
            {
                dif *= 2;
            }
            dif /= 4;

            ans += dif * 4;
            a += dif;
            b += dif;
            c -= dif;
            d -= dif;
        }

        if (c - a == 0) b += d - b;
        else if (d - b == 0)
        {
            ans++;
            a += c - a;
        }
        else if (c - a == 1)
        {
            ans += 2;
            a++;
        }
        else
        {
            ans += 3;
            a++;
        }

        System.out.println(ans);
        System.out.print(a + " " + b);
    }
}
