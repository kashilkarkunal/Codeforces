import java.util.*;

public class Cormen{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String line1 = s.nextLine();
        String[] arr1 = line1.split(" ");
        int n = Integer.valueOf(arr1[0]);
        int k = Integer.valueOf(arr1[1]);

        String line2 = s.nextLine();
        int [] walks = new int[n];
        int j = 0;
        for(String str : line2.split(" ")){
            walks[j] = Integer.valueOf(str);
            j+=1;
        }

        int extra = 0;
        for(int i = 1; i < n; i+=1){
            int temp = Math.max(0, k - walks[i] - walks[i-1]);
            extra+=temp;
            walks[i]+=temp;
        }

        System.out.println(extra);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i+=1){
            sb.append(walks[i] + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
