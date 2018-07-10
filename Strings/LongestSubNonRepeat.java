class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int start = 0;
        
        Map<Character, Integer> cmap=  new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(cmap.containsKey(c)) {
                start = Math.max(start, cmap.get(c)+1);
            }
            longest = Math.max(longest, i - start + 1);
            cmap.put(c, i);
        }
        
        return longest;
    }
}
