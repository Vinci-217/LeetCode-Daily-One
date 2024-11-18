class Solution {
    private char[] path;
    private final List<String> ans = new ArrayList<>();

    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2]; // 所有括号长度都是一样的 n*2
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int num) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }

        // 选左括号
        if (num < n) {
            path[i]='(';
            dfs(i + 1, num + 1);
        }

        // 选右括号
        if (i - num < num) {
            path[i]=')';
            dfs(i + 1, num);
        }
    }
}

// 第二次自己的做法
class Solution {
    private List<String> ans = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int l, int r) {
        if (l == n && r == n) {
            ans.add(new String(path));
            return;
        }

        if (l == 0) {
            path.append("(");
            l++;
        }

        if (l < n) {

            path.append("(");
            l++;
            dfs(l, r);
            l--;
            path.setLength(path.length()-1);
        }
        if (r < n&&l>r) {

            path.append(")");
            r++;
            dfs(l, r);
            r--;
            path.setLength(path.length()-1);
        }

    }
}