class Solution {
    public int minDistance(String word1, String word2) {
        //return minDistanceRecur(word1, word2);
        return minDistanceIter(word1, word2);
        
    }
    
    public int minDistanceIter(String word1, String word2) {
        int minDist[][] = new int[word1.length()+1][word2.length()+1];
        minDist[0][0] = 0;
        
        for(int i = 1; i <= word2.length(); i++) {
            minDist[0][i] = minDist[0][i-1] + 1;
        }
        for(int i = 1; i <= word1.length(); i++) {
            minDist[i][0] = minDist[i-1][0] + 1;
        }
        
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    minDist[i][j] = minDist[i-1][j-1];
                }
                else {
                    minDist[i][j] = 1 + Math.min(minDist[i-1][j-1], Math.min(minDist[i][j-1], minDist[i-1][j]));
                }
            }
        }
        return minDist[word1.length()][word2.length()];
        
    }
    
    public int minDistanceRecur(String word1, String word2) {
        
        if(word1.length() == 0)
            return word2.length();
        else if(word2.length() == 0)
            return word1.length();
        
        if(word1.charAt(word1.length() -1) == word2.charAt(word2.length() -1)) {
            return minDistanceRecur(word1.substring(0, word1.length() -1), word2.substring(0, word2.length() -1));
        }
        else {
            int del = minDistanceRecur(word1.substring(0, word1.length() -1), word2);
            int sub = minDistanceRecur(word1.substring(0, word1.length() -1), word2.substring(0, word2.length() -1));
            int add = minDistanceRecur(word1, word2.substring(0, word2.length() -1));
            
            return (1 + Math.min(del, Math.min(sub, add)));
        }
    }
}
