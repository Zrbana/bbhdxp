package data.struct.apply;

/**
 * 用栈实现扑克牌洗牌功能
 */
public class CardGame {
    static int top = -1;
    public static void push(int[] stack,int MAX,int val){
        if(top>=MAX-1){
            System.out.println("栈已经满了！");
        }else{
            top++;
            stack[top]=val;
        }
    }
    public static int pop(int[] stack){
        if(top<0){
            System.out.println("栈为空，无法出栈");
        }else{
            top--;
        }
        return stack[top];
    }


    public static void main(String[] args) {
        int[] card = new int[52];
        int[] stack = new int[52];
        char str ='s';
        for(int i = 0;i<52;i++){
            card[i]=i;
        }
        System.out.println("洗牌中，请稍后...");
        int k=0;
        while(k<30){
            for(int i=0;i<51;i++){
                for(int j=i+1;j<52;j++){
                    if((int)(Math.random()*5)==2){
                        int test = card[i];//洗牌
                        card[i] = card[j];
                        card[j] = test;

                    }
                }
            }
            k++;
        }
        int i =0;
        while(i!=52){
            push(stack,52,card[i]);//将52张牌入栈
            i++;
        }
        System.out.println("[逆时针发牌]");
        System.out.println("[显示各个玩家]\n 玩家1\t  玩家2\t  玩家3\t  玩家4\t");
        System.out.println("================================");
        while(top>=0){

            int style=stack[top]/13;//计算牌的花色
            switch (style){
                case 0:
                    str = 'P';//梅花
                    break;
                case 1:
                    str = 'F';//方块
                    break;
                case 2:
                    str='R';//红桃
                    break;
                case 4:
                    str = 'B';//黑桃
                    break;
            }
            System.out.print("["+str+(stack[top%13+1])+"]");
            System.out.print("\t");
            if(top%4==0){
                System.out.println();
            }
            top--;
        }
    }
}
