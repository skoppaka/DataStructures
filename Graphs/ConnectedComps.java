class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int count = 0;
        
        for(int i = 0; i < edges.length; i++) {
            int num1 = edges[i][0];
            int num2 = edges[i][1];
            List<Integer> edgelistnum1 = null;
            List<Integer> edgelistnum2 = null;
            if(map.containsKey(num1)) {
                edgelistnum1 = map.get(num1);
            }
            else {
                edgelistnum1 = new ArrayList<Integer>();
                map.put(num1, edgelistnum1);
            }
            edgelistnum1.add(num2);
            if(map.containsKey(num2)) {
                edgelistnum2 = map.get(num2);
            }
            else {
                edgelistnum2 = new ArrayList<Integer>();
                map.put(num2, edgelistnum2);
            }
            edgelistnum2.add(num1);
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, map);
            }
        }
        return count;
    }
    
    public void dfs(int vertex, boolean[] visited, Map< Integer, List<Integer>> map) {
        if(visited[vertex])
            return;
        
        visited[vertex] = true;
        if(!map.containsKey(vertex))
            return;
        
        for(int i = 0; i < map.get(vertex).size(); i++) {
            dfs(map.get(vertex).get(i), visited, map);
        }
    }
}
