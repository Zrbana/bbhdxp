package DataStructs.Queues;

 class Queues {
    //默认初始化容量
    private static final int DEFALUT_CAPACITY  = 10;

    //队列的最大值
    private int maxSize;

    private int[] queueArray;

    //队头
    private int font;

    //对尾
    private int rear;

    private int nItems;

    public Queues(){
        this(DEFALUT_CAPACITY);
    }
    public Queues(int size){
        maxSize = size;
        queueArray = new int[size];
        font = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 队列是否满
     * true->满
     * @return
     */
    public boolean isFull(){
        return nItems == maxSize;
    }

    /**
     * 判断队列是否为空
     * true->空
     * @return
     */
    public boolean isEmpty(){
        return nItems == 0;
    }

    /**
     * 队列中的元素个数
     * @return
     */
    public int getSize(){
        return nItems;
    }

    /**
     *
     * @return 返回队尾元素
     */
    public int peekRear(){
        return queueArray[rear];
    }

    /**
     *
     * @return 返回队头元素
     */
    public int peekFront(){
        return queueArray[font];
    }

    /**
     * 在队尾插入元素
     * @param x
     * @return
     */
    public boolean insert(int x){
        if(isFull()){
            return false;
        }
        rear = (rear+1)%maxSize;
        queueArray[rear] = x;
        nItems++;
        return true;
    }


    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int temp = queueArray[font];
        font = (font+1)%maxSize;
        nItems --;
        return temp;
    }


     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("[");
         for(int i = font;;i= ++i%maxSize){
             sb.append(queueArray[i]).append(",");
             if(i == rear){
                 break;
             }
         }
         sb.replace(sb.length()-2,sb.length(),"]");
         return sb.toString();
     }
 }

 public class Queue{
     public static void main(String[] args) {
         Queues myQueue = new Queues();
         myQueue.insert(1);
         myQueue.insert(2);
         myQueue.insert(4);
         myQueue.insert(9);

         System.out.println(myQueue.isFull());

         myQueue.remove();
         myQueue.insert(45);

         System.out.println(myQueue.peekFront());
         System.out.println(myQueue.peekRear());
         System.out.println(myQueue.toString());
     }
 }














