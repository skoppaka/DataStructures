class Solution {
    
    private Map<Character, char[]> cmap = new HashMap<Character, char[]>() {
    {
    put('2', new char[]{'a', 'b', 'c'});
    put('3', new char[]{'d', 'e', 'f'});
    put('4', new char[]{'g', 'h', 'i'});
    put('5', new char[]{'j', 'k', 'l'});
    put('6', new char[]{'m', 'n', 'o'});
    put('7', new char[]{'p', 'q', 'r', 's'});
    put('8', new char[]{'t', 'u', 'v'});
    put('9', new char[]{'w', 'x', 'y', 'z'});
}
};

public List<String> letterCombinations(String digits) {
List<String> result = new ArrayList<String>();

if(digits.length() > 0)
combinations(digits, 0, result, "");
return result;
}

public void combinations(String digits, int si, List<String> result, String sb) {
if(si >= digits.length()) {
result.add(sb);
return;
}

char[] cur = cmap.get(digits.charAt(si));
for(int j = 0; j < cur.length; j++) {
combinations(digits, si+1, result, sb+cur[j]);
}

}
}
