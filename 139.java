class Solution {
    String s ;
    Set<String> words;
    int maxLen = 0;
    int[] memo = new int[1001];
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        Arrays.fill(memo,-1);
        for(String word : wordDict) maxLen = Math.max(maxLen,word.length());
        words = new HashSet<>(wordDict);
        return dfs(s.length());
    }

    private boolean dfs(int i){
        if(i==0) return true;
        if(memo[i]!=-1) return memo[i] == 1 ;
        for(int j = i-1;j>=Math.max(i-maxLen,0);j--){
            if(words.contains(s.substring(j,i)) && dfs(j)){
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0; // 0表示算过 1表示算过 -1表示没算过，所以用boolean的二元态会超时
        return false;
    }
}