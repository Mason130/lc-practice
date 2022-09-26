class MyCircularQueue {
    private int[] q;
    private int front, rear;
    private int num; //number of elements in the queue
    private int k;
    
    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.k = k;
        this.front = 0;
        this.num = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        else{
            if(front+num < k)
                rear = front + num;
            else
                rear = front + num - k;
            //rear = (front + num) % k;
            q[rear] = value;
            num++;
            return true;
        }
        
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        else{
            if(front+1 < k)
                front++;
            else
                front = 0;
            //front = (front + 1) % k;
            num--;
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        else{
            return q[front];
        }
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        else{
            return q[rear];
        }
    }
    
    public boolean isEmpty() {
        if(num == 0)
            return true;
        else
            return false;
    }
    
    public boolean isFull() {
        if(num == k)
            return true;
        else
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
