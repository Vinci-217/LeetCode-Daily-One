class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        dfs(0, set);
        return ans;
    }

    private void dfs(int i, Set<Integer> set) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (Integer j : set) {
            path.add(j);
            Set<Integer> t = new HashSet<>(set);
            t.remove(j);
            dfs(i + 1, t);
            path.remove(j);
        }
    }
}


// 第二次做法：我真是天才
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs();
        return ans;
    }

    private void dfs(){
        if(set.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int num:nums){
            if(!set.contains(num)){
                path.add(num);
                set.add(num);
                dfs();
                path.remove(path.size()-1);
                set.remove(num);
            }
        }
    }

    
}


// 第三次做法，一种更加通用的方法
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private Set<Integer> set = new HashSet<>();
    private int length;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs();
        return ans;
    }

    private void dfs() {
        if (length == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (!set.contains(num)) {
                path.add(num);
                set.add(num);
                length++;
                dfs();
                length--;
                path.remove(path.size()-1);
                set.remove(num);
            }
        }
    }
}

// 第四次做法：将length方法作为参数传入，便于通用方法
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int length) {
        if (length == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (!set.contains(num)) {
                path.add(num);
                set.add(num);
                length++;
                dfs(length);
                length--;
                path.remove(path.size()-1);
                set.remove(num);
            }
        }
    }
}