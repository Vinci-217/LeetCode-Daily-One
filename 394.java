class Solution {
    public String decodeString(String s) {
        Deque<Integer> cnt = new ArrayDeque<>();
        Deque<StringBuilder> stack = new ArrayDeque<>();

        int cur = 0;
        StringBuilder curString = new StringBuilder();

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                cur = cur*10+c-'0';
            }
            else if(c=='['){
                cnt.push(cur);
                cur = 0;
                stack.push(curString);
                curString = new StringBuilder();
            }
            else if(c==']'){
                int num = cnt.pop();
                StringBuilder str = stack.pop();
                while(num-->0){
                    str.append(curString);
                }
                curString = str;
            }
            else{
                curString.append(c);
            }
        }

        return curString.toString();

    }

}