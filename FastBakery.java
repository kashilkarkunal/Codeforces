import java.util.*;


public class FastBakery{
    static class Node{
        int label;
        int cost;

        Node(int value, int weight){
            this.label = value;
            this.cost = weight;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int n, m, k;
        n = Integer.parseInt(line1.split(" ")[0]);
        m = Integer.parseInt(line1.split(" ")[1]);
        k = Integer.parseInt(line1.split(" ")[2]);

        if(k == 0 || k == n){
            System.out.print(-1);
            return;
        }

        boolean[] storageLocations = new boolean[n];
        ArrayList<ArrayList<Node>> adjList = new ArrayList();
        for(int i = 0; i < n; i+=1){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < m; i+=1){
            line1 = sc.nextLine();
            String[] edge = line1.split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            int weight = Integer.parseInt(edge[2]);

            ArrayList<Node> v1AdjList = adjList.get(v1 - 1);
            if(v1AdjList == null){
                v1AdjList = new ArrayList();
            }
            v1AdjList.add(new Node(v2 - 1, weight));

            ArrayList<Node> v2AdjList = adjList.get(v2 - 1);
            if(v2AdjList == null){
                v2AdjList = new ArrayList();
            }
            v2AdjList.add(new Node(v1 - 1, weight));
        }

        line1 = sc.nextLine();
        String[] storage = line1.split(" ");
        for(int i = 0; i < k; i+=1){ 
            storageLocations[Integer.parseInt(storage[i]) -1] = true;
        }
        int result = Integer.MAX_VALUE;
        boolean noBakeryLocation = true;
        for(int i = 0;i < n; i++){
            if(storageLocations[i]){
                continue;
            }
            ArrayList<Node> adj = adjList.get(i);
            for(Node node : adj){
                if(!storageLocations[node.label]){
                    continue;
                }
                noBakeryLocation = false;
                if(node.cost < result){
                    result = node.cost;
                }
            }
        }
        if(noBakeryLocation){
            System.out.print(-1);
            return;
        }
        System.out.print(result);
    }
}
