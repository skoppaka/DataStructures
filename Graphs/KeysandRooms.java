class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        
        dfs(visited, rooms, 0);
        
        for(int i = 0; i < rooms.size(); i++) {
            if(!visited[i])
                return false;
        }
        return true;
        
    }
    
    public void dfs(boolean[] visited, List<List<Integer>> rooms, int index) {
        if(visited[index])
            return;
        visited[index] = true;
        
        for(int i = 0; i < rooms.get(index).size(); i++) {
            dfs(visited, rooms, rooms.get(index).get(i));
        }
    }
}
