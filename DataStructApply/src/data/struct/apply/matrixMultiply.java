package data.struct.apply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 二维数组相乘
 */
public class matrixMultiply {
    public static void matrix_multi(int[][] arrA,int[][] arrB,int[][] arrC,int m,int n, int p){
        int i,j,k,temp;
        if(m<=0 || n<=0 || p<=0){
            System.out.println("维数m,n,p必须大于0");
        }
        for(i=0;i<=m;i++){
            for(j=0;j<=p;j++){
                temp=0;
                for(k=0;k<=n;k++){
                    temp+=arrA[i][k]*arrB[k][j];
                }
                arrC[i][j]=temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int m,n,p;
        int i,j;
        String strM;
        String strN;
        String strP;
        String strTemp;
        BufferedReader keyin  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入矩阵A的维数（m,n）：");
        System.out.print("请先输入矩阵A的m值：");
        strM = keyin.readLine();
        m=Integer.parseInt(strM);
        System.out.print("输入矩阵A的n值：");
        strN = keyin.readLine();
        n=Integer.parseInt(strN);
        int[][] A = new int[m][n];
        System.out.println("请输入A的各个元素：");
        System.out.println("没输入一个值按下enter键确认");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print("a"+i+j+"=");
                strTemp = keyin.readLine();
                A[i][j]=Integer.parseInt(strTemp);
            }
        }


        System.out.println("请输入矩阵B的维数（m,p）：");
        System.out.print("请先输入矩阵B的m值：");
        strM = keyin.readLine();
        m=Integer.parseInt(strM);
        System.out.print("输入矩阵A的p值：");
        strP = keyin.readLine();
        p=Integer.parseInt(strP);
        int[][] B = new int[m][n];
        System.out.println("请输入B的各个元素：");
        System.out.println("没输入一个值按下enter键确认");
        for(i=0;i<m;i++){
            for(j=0;j<p;j++){
                System.out.print("b"+i+j+"=");
                strTemp = keyin.readLine();
                B[i][j]=Integer.parseInt(strTemp);
            }
        }
        int[][] C  = new int[m][p];
        matrix_multi(A,B,C,m,n,p);
        System.out.println("A*B的结果是：");
        for(i=0;i<m;i++){
            for(j=0;j<p;j++){
                System.out.print(C[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
