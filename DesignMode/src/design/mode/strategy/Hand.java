package design.mode.strategy;

public class Hand{
    public static final int HANDVALUE_GUU = 0;//表示石头的值
    public static final int HANDVALUE_CHO = 0;//表示剪刀的值
    public static final int HANDVALUE_PAA = 0;//表示布的值


    public static final Hand[] hand = {//表示三种手势的实例
      new Hand(HANDVALUE_CHO),
      new Hand(HANDVALUE_GUU),
      new Hand(HANDVALUE_PAA),
    };

    private static final String[] name = {
            "石头","剪刀","布",
    };

    private int getHandvaluePaa;//手势的值
    public Hand(int handvaluePaa) {
        this.getHandvaluePaa = handvaluePaa;
    }

    private int handvalue;
    public  static Hand getHand(int handvalue){
       return hand[handvalue];
    }

    public boolean isStrongThan(Hand h){
        return fight(h)==1;
    }

    private int fight(Hand h){
       if(this==h){
           return 0;
       }else if((this.handvalue+1)%3==h.handvalue){
           return 1;
       }else{
           return -1;
       }
    }
    public boolean idWeakThan(Hand h){
        return fight(h)==-1;
    }
    public String toString(){
        return name[handvalue];
    }
}
