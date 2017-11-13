import java.util.*;

public class Permutation{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String line = sc.nextLine();
        String[] arr = line.split(" ");

        int[] a = new int[n];
        for(int i = 0; i < n ; i +=1){
            a[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(a);
        int minValue = 1;
        long result = 0;
        for(int i = 0; i < n; i+=1){
            if(minValue > a[i]){
                result+=(minValue - a[i]);
            }else{
                result+=(a[i] - minValue);
            }
            minValue+=1;
        }

        System.out.print(result);
    }
}
