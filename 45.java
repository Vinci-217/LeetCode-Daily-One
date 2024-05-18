class Solution {
    public int jump(int[] nums) {

        // end表示上一轮中的范围（即这一轮需要遍历i的范围）
        int end = 0;
        // maxPosition表示这一轮中的最大范围（如果走了，最远能走多远）
        int maxPosition = 0;
        int steps = 0;

        for(int i=0;i<nums.length-1;i++){

            // 更新每一轮中的最大范围，看看这一轮最大能走多远
            maxPosition = Math.max(maxPosition,nums[i]+i);


            // 如果i等于end，说明这一轮已经遍历完了，让end等于这一轮可以到达的最大范围，即下一轮的范围，表示走了一步，然后进行下一轮遍历
            if(i==end){
                end=maxPosition;
                steps++;
            }
        }
        return steps;

    }
}