package www.utils;

public class GreateArr {
    public static final int[] arrRandom  = createRandom(100000,1,1000);
    public static final int[] arrSorty = createSort(10000,1);

    public static void main(String[] args) {
        int[] arr = createRandom(20,1,100);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"、");
        }
    }

    /**
     * 产生min-max的随机数
     * @param min
     * @param max
     * @return
     */
    public static int[] createRandom(int length,int min,int max){
        int[] arr  = new int[length];
        for(int i =0;i<arr.length;i++){
            int res = (int)(Math.random()*(max-min+1));
            arr[i] = res;
        }
        return arr;
    }

    public static int[] createSort(int length,int start){

        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i]=start;
            start++;
        }
        return arr;
    }
}










