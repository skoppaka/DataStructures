class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;
        
        for(char c : moves.toCharArray()) {
            switch(c) {
                case 'U' : vertical++;
                    break;
                case 'D' : vertical--;
                    break;
                case 'L' : horizontal--;
                    break;
                case 'R' : horizontal++;
                    break;
                default  : return false;
            }
        }
        if(vertical == 0 && horizontal == 0)
            return true;
        
        return false;
    }
}
