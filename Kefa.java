import java.util.*;

public class Kefa{

    static int result = 0;
    static HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap();
    static int[] nodes;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        line = sc.nextLine();
        nodes = new int[n];
        String[] arr = line.split(" ");
        for(int i = 0; i < n; i+=1){
            nodes[i] = Integer.parseInt(arr[i]);
        }

        hashmap = new HashMap();

        for(int i = 0; i < n - 1; i +=1){
            line = sc.nextLine();
            int key = Integer.parseInt(line.split(" ")[0]);
            int value = Integer.parseInt(line.split(" ")[1]);
            addElement(hashmap, key, value);
            addElement(hashmap, value, key);
        }

        dfs(1, 0, m, 0);
        System.out.print(result);

    }

    private static void dfs(int currentNode, int prev_node, int m, int cats){
        if(cats > m){
            return;
        }

        ArrayList<Integer> adjList = hashmap.get(currentNode);

        if(adjList.size() == 1 && adjList.get(0) == prev_node){
            if(nodes[currentNode - 1] + cats > m){
                return;
            }
            result+=1;
            return;
        }

        for(Integer adj : adjList){
            if(adj == prev_node){
                continue;
            }
            if(nodes[currentNode - 1] == 0){
                dfs(adj, currentNode, m, 0);
            }else{
                dfs(adj, currentNode, m, cats + 1);
            }
        }
        return;
    }

    private static void addElement(HashMap<Integer, ArrayList<Integer>> hashmap, int key, int value){
        if(!hashmap.containsKey(key)){
            hashmap.put(key, new ArrayList());
        }
        hashmap.get(key).add(value);
    }
}
