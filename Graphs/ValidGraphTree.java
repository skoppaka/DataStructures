class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        
        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (visited[cur])
                return false;
            for(int i = 0; i < n; i++){
                if (!visited[i] && graph[cur][i] > 0){
                    queue.add(i);
                }
            }
            visited[cur] = true;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
    
    
}
