package java7.daily.learning.test;

/**
 * @ClassName CircleQueue
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/24 23:38
 */

public class MyCircularQueue {
    private int front;//队列头
    private int rear;//队列尾
    private int usedSize;//数据个数
    private int[] elem;//数组
    public MyCircularQueue(int k){
        this.elem=new int[k];
        this.front=0;
        this.rear=0;
        this.usedSize=0;
    }
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[this.rear]=value;
        this.usedSize++;
        this.rear=(this.rear+1)%this.elem.length;
        return true;
    }
    //队尾下标加上1在%
    public boolean isFull(){
        if((this.rear+1)%this.elem.length==this.front){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return this.rear==this.front;
    }
    public boolean deQueue(int value){
        if(isEmpty()){
            return false;
        }
        this.elem[front]=value;
        this.front=(this.front+1)%this.elem.length;
        this.usedSize--;
        return true;
    }
    public int Front(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.elem[this.front];
    }
    public int Rear(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int index=this.rear == 0 ? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

}

