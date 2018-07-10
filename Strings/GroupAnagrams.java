class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<String, List<String>>();
        if(strs.length < 1)
            return new ArrayList();
        
        for(int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String temp = String.valueOf(str);
            if(!hmap.containsKey(temp)) {
                hmap.put(temp, new ArrayList<String>());
            }
            hmap.get(temp).add(strs[i]);
            
        }
        
        return new ArrayList<List<String>>(hmap.values());
    }
}
