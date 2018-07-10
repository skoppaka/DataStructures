class Solution {
    public int romanToInt(String s) {
        int count = 0;
        Map<Character, Integer> nota = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        count += nota.get(s.charAt(s.length()-1));
        for(int i = s.length() - 2; i >= 0; i--) {
            if(nota.get(s.charAt(i)) < nota.get(s.charAt(i+1)))
                count -= nota.get(s.charAt(i));
            else
                count += nota.get(s.charAt(i));
        }
        return count;
    }
}
