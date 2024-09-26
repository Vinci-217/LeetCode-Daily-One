class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        changeStackStatus();
        return stack2.pop();
    }

    public int peek() {
        changeStackStatus();
        return stack2.peek();

    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void changeStackStatus(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


 // 第二次自己做的版本
 class MyQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;


    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void push(int x) {
        stackA.push(x);
    }
    
    public int pop() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.peek());
            stackA.pop();
        }
        int peek = stackB.pop();
        while(!stackB.isEmpty()){
            stackA.push(stackB.peek());
            stackB.pop();
        }
        return peek;
    }
    
    public int peek() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.peek());
            stackA.pop();
        }
        int peek = stackB.peek();
        while(!stackB.isEmpty()){
            stackA.push(stackB.peek());
            stackB.pop();
        }
        return peek;
    }
    
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */