class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();

        // 遍历之后，每个元素显示的都是最后出现的位置，因为后面覆盖前面的了
        for(int i=0;i<length;i++){
            last[s.charAt(i)-'a']=i;
        }

        List<Integer> partition = new ArrayList<>();
        int start = 0,end = 0;

        // start和end标记一个区间范围
        for(int i=0;i<length;i++){

            // end每次遇到新的字符的时候，需要更新一个区间最后位置
            end= Math.max(end,last[s.charAt(i)-'a']);

            // 如果i等于end，说明这个区间走到末尾了，那么就可以将这段长度添加到列表中，并且移动到新的区间了
            if(i==end){
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;

    }
}