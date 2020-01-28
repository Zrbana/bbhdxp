package hm.code;

/**
 * 将16进制转换成2进制
 */
public class HexToBinary {
    private final int LONG_BITS = 8;
    public void convert(String hexNum){
        //16进制字符串
        int conHex = Integer.parseInt(hexNum,16);

        String binary = Integer.toBinaryString(conHex);
        System.out.println(hexNum+"="+completeDigits(binary));

    }

    public String completeDigits(String binNum){
        for(int i = binNum.length();i<LONG_BITS;i++){
            binNum  ="0"+binNum;
        }
        return binNum;
    }
    public static void main(String[] args) {

        //Testing Numbers:
        String[] hexNums = {"1", "A1", "ef", "BA", "AA", "BB",
                "19", "01", "02", "03", "04"};
        HexToBinary objConvert = new HexToBinary();

        for (String num : hexNums) {
            objConvert.convert(num);
        }
    }

}
