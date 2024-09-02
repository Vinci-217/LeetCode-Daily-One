class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}

// 灵神牛逼

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            // in
            while(!q.isEmpty()&&nums[q.getLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);

            // out
            if(i-q.getFirst()>=k){
                q.removeFirst();
            }

            if(i>=k-1){
                ans[i-k+1]=nums[q.getFirst()];
            }
        }
        return ans;
    }
}