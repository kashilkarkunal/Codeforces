import java.util.*;

public class WoodcuttersDp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [] position = new int[n];
        int [] height = new int[n];

        for(int i = 0; i < n; i+=1){
            String s = sc.nextLine();
            position[i] = Integer.parseInt(s.split(" ")[0]);
            height[i] = Integer.parseInt(s.split(" ")[1]);
        }

        int [] leftTrees = new int[n];
        int [] rightTrees = new int[n];
        int [] standingTrees = new int[n];

        for(int i = 0; i < n; i+=1){
            if( i == 0){
                leftTrees[i] = 1;
                rightTrees[i] = 0;
                standingTrees[i] = 0;
            }else {
                if(position[i] - height[i] > position[i-1]){
                    if(position[i] - height[i] > position[i - 1] + height[i - 1]){
                        leftTrees[i] = Math.max(leftTrees[i - 1], Math.max(rightTrees[i - 1], standingTrees[i-1])) + 1;
                    }else {
                        leftTrees[i] = Math.max(leftTrees[i - 1], standingTrees[i-1]) + 1;
                    }
                } else{
                    leftTrees[i] = leftTrees[i-1];
                }

                if(i == n - 1 || position[i] + height[i] < position[i + 1]){
                    rightTrees[i] = Math.max(leftTrees[i - 1], Math.max(rightTrees[i - 1], standingTrees[i-1])) + 1;
                }else{
                    rightTrees[i] = rightTrees[i -1];
                }

                standingTrees[i] = Math.max(leftTrees[i - 1], Math.max(rightTrees[i - 1], standingTrees[i-1]));
            }
        }

        int result = Math.max(leftTrees[n-1], Math.max(rightTrees[n-1], standingTrees[n-1]));
        System.out.print(result);
    }
}
