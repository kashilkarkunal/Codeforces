import java.util.*;

public class Equality{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int people = s.nextInt();
        s.nextLine();

        int max = 0;
        int[] wealth = new int[people];
        String string = s.nextLine();
        String[] strSplit = string.split(" ");
        for(int i = 0; i < people; i+=1){
            wealth[i] = Integer.valueOf(strSplit[i]);
            if(max < wealth[i]){
                max = wealth[i];
            }
        }

        long result = 0;
        for(int i = 0; i < people; i+=1){
            result+=(max - wealth[i]);
        }
        System.out.print(result);
    }
}
