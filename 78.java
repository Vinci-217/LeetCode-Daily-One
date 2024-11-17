class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        dfs(0,n,nums);
        return ans;
    }
    private void dfs(int i,int n,int[] nums){
        if(i==n){
            ans.add(new ArrayList<>(path));
            return;
        }
        // System.out.println(nums[i]);
        // 没它
        dfs(i+1,n,nums);
        // 有它
        path.add(nums[i]);
        dfs(i+1,n,nums);
        path.remove(path.size()-1);
    }
}


// 第二种做法：选或不选
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int length){
        if(length==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        length++;
        dfs(length);

        path.add(nums[length-1]);
        dfs(length);
        path.remove(path.size()-1);
    }
}


// 第三种做法：获取的是路径而不是叶子节点，所以其实通过i控制了待选择的元素
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int length){

        ans.add(new ArrayList<>(path));

        for(int i = length;i<nums.length;i++){
            path.add(nums[i]);
            dfs(i+1);
            path.remove(path.size()-1);
        }
    }
}