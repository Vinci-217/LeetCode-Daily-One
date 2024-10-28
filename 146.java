class LRUCache {
    private static class Node{
        int key,value;
        Node pre,next;
        Node(int k,int v){
            key = k;
            value = v;
        }
    }


    private int capacity;
    private Node dummy = new Node(0,0);
    private Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        pushFront(node);
        return node.value;
    }

    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void pushFront(Node node){
        node.pre = dummy;
        node.next = dummy.next;
        dummy.next.pre = node;
        dummy.next = node;
    }


    public void put(int key,int value){
        Node exist = map.get(key);
        if(exist!=null){
            exist.value = value;
            remove(exist);
            pushFront(exist);
            return;
        }
        Node node = new Node(key,value);
        map.put(key,node);
        pushFront(node);
        if(map.size()>capacity){
            Node last = dummy.pre;
            map.remove(last.key);
            remove(last);

        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */