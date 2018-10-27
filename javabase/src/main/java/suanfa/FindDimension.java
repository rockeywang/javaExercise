package suanfa;

/**
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1 2 3
 * 2 3 4
 * 3 4 5
 */
public class FindDimension {

    /**
     * 解析：比较经典的一题，解法也比较巧妙，由于数组从左向右和从上到下的都是递增的，所以找一个数可以先从最右开始找。
     * 假设最右值为a，待查数为x，那么如果x < a说明x在a的左边，往左找即可，如果x > a，
     * 说明x 在 a的下面一行，到下面一行继续按照该规则查找，就可以遍历所有数。
     * 算法的时间复杂度是O(M * N)
     */

    public static boolean Find(int target, int[][] array) {
        if (array[0][0] > target) {
            return false;
        }

        int row = 0;
        int col = 0;

        while (row < array.length && col > 0) {
            if(target==array[row][col]){
                return  true;
            }
            else if(target<array[row][col]){
                col--;
            }else if(target>array[row][col]){
                col++;
            }
            else row++;
        }
        return  false;
    }


    public static void main(String [] args){
        int [] [] array=new int[1][5];
        int target=6;
        Find(target,array);
    }

}
