class Solution {
    Set<String> set = new HashSet<>();
    char[] s;
    int n, maxScore, maxLen;
    StringBuilder path = new StringBuilder();

    public List<String> removeInvalidParentheses(String S) {
        s = S.toCharArray();
        n = s.length;
        int left = 0;
        int right = 0;
        for (char c : s) {
            if (c == '(')
                left++;
            else if (c == ')')
                right++;
        }
        maxScore = Math.min(left, right);
        dfs(0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(int i, int score) {
        if (score < 0 || score > maxScore)
            return;
        if (i == n) {
            if (score == 0 && path.length() >= maxLen) {
                if (path.length() > maxLen) {
                    set.clear();
                    maxLen = path.length();
                }
                set.add(path.toString());
            }
            return;
        }
        char c = s[i];
        if (c == '(') {
            path.append(c);
            dfs(i + 1, score + 1);
            path.deleteCharAt(path.length() - 1);
            dfs(i + 1, score);
        } else if (c == ')') {
            path.append(c);
            dfs(i + 1, score - 1);
            path.deleteCharAt(path.length() - 1);
            dfs(i + 1, score);
        } else {
            path.append(c);
            dfs(i + 1, score);
            path.deleteCharAt(path.length() - 1);
        }
    }
}