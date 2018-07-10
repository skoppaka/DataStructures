class Solution {
    private static boolean is_vowel (char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
           || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
    
    private static void swap_char(char[] res, int i, int j) {
        char c = res[i];
        res[i] = res[j];
        res[j] = c;
    }
    
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        
        int i = 0, j = s.length() -1;
        
        while (i <=j) {
            while(i <= j && !is_vowel(res[i])) {
                i++;
            }
            while(i <= j && !is_vowel(res[j])) {
                j--;
            }
            if(i <= j) {
                swap_char(res, i, j);
            }
            i++;
            j--;
        }
        return (new String(res));
    }
}
