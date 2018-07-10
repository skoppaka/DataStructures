class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        
        for(String path: paths) {
            String[] token = path.split(" ");
            for(int i = 1; i < token.length; i++) {
                int index = token[i].lastIndexOf("(");
                String content = token[i].substring(index);
                String root_path = token[0]+"/"+token[i].substring(0, index);
                
                if(!map.containsKey(content)) {
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(root_path);
            }
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> content = entry.getValue();
            if(content.size() > 1) {
                result.add(content);
            }
        }
        
        return result;
    }
}
