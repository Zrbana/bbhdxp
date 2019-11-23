package data.struct.apply;

/**
 * 二维数组相加
 */
public class matrixAdd {
    public static void matrix_add(int[][] arrA,int[][] arrB,int[][] arrC,int dimX,int dimY){
        int row,col;
        if(dimX<0 || dimY<0){
            System.out.println("矩阵维数必须大于0！");
        }
        for(row=1;row<=dimX;row++){
            for(col=1;col<=dimY;col++){
                arrC[(row-1)][(col-1)] = arrA[(row-1)][(col-1)]+arrB[(row-1)][(col-1)];
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int j;
        final int ROWS = 3;
        final int COLS = 3;
        int[][] A = {{1, 3, 5},{7,9,11},{13,15,17}};
        int[][] B = {{9,8,7},{6,5,4},{3,2,1}};
        int[][] C = new int[ROWS][COLS];
        System.out.println("[矩阵A的各个元素]");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("[矩阵B中的各个元素]");
        for(i=0;i<3;i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(B[i][j] + "\t");

            }
            System.out.println();
        }
        matrix_add(A,B,C,3,3);
        System.out.println("[显示矩阵A和矩阵B相加的结果]");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(C[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
