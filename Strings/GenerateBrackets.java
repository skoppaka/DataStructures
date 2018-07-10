class Solution {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        List<String> result = new ArrayList<String>();
        if(n >= 1)
            genPar(result, left, right, "");
        
        return result;
    }
    
    public void genPar(List<String> result, int left, int right, String sb) {
        if(left < 0 || right < 0 || left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            result.add(sb);
            return;
        }
        
        genPar(result, left -1, right, sb + '(');
        genPar(result, left, right -1, sb + ')');
        
    }
}
