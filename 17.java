class Solution {
    private static final String[] MAPPING = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz" };
    private final List<String> ans = new ArrayList<>();
    private char[] digits, path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n==0)
            return List.of();
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    private void dfs(int i){
        if(i==digits.length){
            ans.add(new String(path));
            return ;
        }
        for(char c: MAPPING[digits[i]-'0'].toCharArray()){
            path[i]=c;
            dfs(i+1);
        }
    }
}

// 第二次做法：统一回溯的写法
class Solution {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> ans  = new ArrayList<>();
    private char[] path;
    private char[] nums;
    public List<String> letterCombinations(String digits) {
        this.nums = digits.toCharArray();
        int n = nums.length;
        if(n==0){
            return List.of();
        }
        path = new char[n];
        dfs(0);
        return ans;
    }

    private void dfs(int length){
        if(length == nums.length){
            ans.add(new String(path));
            return;
        }
        for(char c :MAPPING[nums[length]-'0'].toCharArray()){
            path[length] = c;
            length++;
            dfs(length);
            length--;
        }
    }

}