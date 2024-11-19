class Solution {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0,0);
        return ans;
    }
    // start 表示当前这段回文子串的开始位置
    private void dfs(int i,int start){
        if(i==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        
        // 不选i和i+1之间的逗号 (i=n-1的时候一定要选)
        if(i<s.length()-1){
            dfs(i+1,start);
        }

        // 选i和i+1之间的逗号 (把s[i]作为子串的最后一个字符)
        if(isReverse(s.substring(start,i+1))){
            path.add(s.substring(start,i+1));
            dfs(i+1,i+1);
            path.remove(path.size()-1);
        }
    }


    private boolean isReverse(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<=right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}


// 第二次做法，注意最后一个选择时，最后一个逗号是必选的，所以是s.length()-1
class Solution {
    private List<String> path = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();
    private String s; 
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0,0);
        return ans;
    }


    private void dfs(int length,int start){
        if(length == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        if(length<s.length()-1){
            dfs(length+1,start);
        }

        if(isOk(s.substring(start,length+1))){
            path.add(s.substring(start,length+1));
            dfs(length+1,length+1);
            path.remove(path.size()-1);
        }


    }


    private boolean isOk(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}