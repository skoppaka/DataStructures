class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charmap = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray()) {
            if(!charmap.containsKey(c))
                charmap.put(c, 1);
            else
                charmap.put(c, charmap.get(c) +1);
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(charmap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
