class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++){
            int temp=queue.peek();
            queue.remove();
            queue.add(temp);
        }
    }
    
    public int pop() {
        int x= queue.peek();
        queue.remove();
        return x;
    }
    
    public int top() {
        return queue.peek();

    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */