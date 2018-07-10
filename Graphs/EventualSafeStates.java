class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int num = graph.length;
        boolean[] safe = new boolean[num];
        List<Set<Integer>> child = new ArrayList();
        List<Set<Integer>> parent = new ArrayList();
        for (int i = 0; i < num; ++i) {
            child.add(new HashSet());
            parent.add(new HashSet());
        }
        
        Queue<Integer> que = new LinkedList();
        
        for (int i = 0; i < num; ++i) {
            if (graph[i].length == 0)
                que.add(i);
            for (int j: graph[i]) {
                child.get(i).add(j);
                parent.get(j).add(i);
            }
        }
        
        while (!que.isEmpty()) {
            int j = que.poll();
            safe[j] = true;
            for (int i: parent.get(j)) {
                child.get(i).remove(j);
                if (child.get(i).isEmpty())
                    que.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList();
        for (int i = 0; i < num; ++i) if (safe[i])
            result.add(i);
        
        return result;
        
    }
    
    
}
