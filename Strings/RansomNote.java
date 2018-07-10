class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> charmap= new HashMap<Character, Integer>();
        
        for(char c : magazine.toCharArray()) {
            if(!charmap.containsKey(c))
                charmap.put(c, 1);
            else
                charmap.put(c, charmap.get(c) + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(!charmap.containsKey(c) || charmap.get(c) <= 0)
                return false;
            else
                charmap.put(c, charmap.get(c) -1);
        }
        return true;
    }
}
