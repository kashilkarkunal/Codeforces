import java.util.*;

// Codeforces 766B

public class Triangles{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        s.nextLine();
        String line = s.nextLine();
        String[] arr = line.split(" ");
        
        Integer[] len = new Integer[n];
        for(int i = 0; i < n; i+=1){
            len[i] = Integer.valueOf(arr[i]);
        }

        Arrays.sort(len, Collections.reverseOrder());

        boolean result = false;
        for(int i = 0; i < n; i+=1){
            if(i + 1 < n && i + 2 < n){
                if(len[i] < len[i+1] + len[i+2]){
                    result = true;
                }
            }
        }

        if(result)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
