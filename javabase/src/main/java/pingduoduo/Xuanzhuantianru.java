package pingduoduo;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.Scanner;

public class Xuanzhuantianru {
    /*顺时针螺旋填入
    从键盘输入一个整数（1~20）
	则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。例如：
	输入数字2，则程序输出：
	1 2
	4 3
	输入数字3，则程序输出：
	1 2 3
	8 9 4
	7 6 5
	输入数字4， 则程序输出：
	1  2   3   4
	12  13  14  5
	11  16  15  6
	10   9  8   7
	*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        rotating(n, m);
        print(n, m);
    }

    private static void rotating(int n, int[][] m) {
        int k = 1;
        for (int i = 0; i <= n ; i++) {
            for (int j = i; j < n - i; j++) {
                m[i][j] = k++;
            }
            print(n, m);
            for(int j=i+1;j<n-i;i++){
                m[j][n-i-1]=k++;
            }

            for(int j = n-i-2;j>=i;j--){
                m[n-i-1][j] = k++;							//下方行方向
            }
            for(int j = n-i-2;j>i;j--){
                m[j][i] = k++;			//左侧列方向
            }
        }

    }

    private static void print(int n, int[][] m) {

        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%4d",m[i][j]);
            }
            System.out.print("\n");
        }
    }

}
