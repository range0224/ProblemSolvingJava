import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        TreeMap<String, Integer> m = new TreeMap<>();
        ArrayList<String> v = new ArrayList<>();
        int cnt = 0;

        while(true){
            try {
                str = bf.readLine();

                if(m.containsKey(str)) m.put(str, m.get(str) + 1);
                else{
                    m.put(str, 1);
                    v.add(str);
                }

                cnt++;
            } catch(Exception e){
                break;
            }
        }

        Collections.sort(v);

        for(int i = 0; i < v.size(); i++){
            System.out.printf("%s %.4f\n", v.get(i), 100.0 * m.get(v.get(i)) / cnt);
        }
    }
}
