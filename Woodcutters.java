import java.util.*;

public class Woodcutters{
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

        int [] treeStatus = new int[n];
        int result = 0;
        for(int i = 0; i < n; i+=1){
            if( i == 0){
                result+=1;
                treeStatus[i] = -1;
            } else if( i == n - 1){
                result+=1;
                treeStatus[i] = 1;
            } else {
                if(treeStatus[i - 1] == -1){
                    if(position[i] - height[i] > position[i -1]){
                        result+=1;
                        treeStatus[i] = -1;
                    } else if( position[i] + height[i] < position[i + 1]){
                        result+=1;
                        treeStatus[i] = 1;
                    }else{
                        treeStatus[i] = 0;
                    }
                }else if(treeStatus[i - 1] == 1){
                    if(position[i] - height[i] > position[i-1] + height[i-1]){
                        result+=1;
                        treeStatus[i] = -1;
                    }else if(position[i] + height[i] < position[i + 1]){
                        result+=1;
                        treeStatus[i] = 1;
                    }else{
                        treeStatus[i] = 0;
                    }
                }else{
                    if(position[i] - height[i] > position[i -1]){
                        result+=1;
                        treeStatus[i] = -1;
                    } else if( position[i] + height[i] < position[i + 1]){
                        result+=1;
                        treeStatus[i] = 1;
                    }else{
                        treeStatus[i] = 0;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
