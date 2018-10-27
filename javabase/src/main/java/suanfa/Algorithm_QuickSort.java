package suanfa;


/**
 * 快速排序(挖坑填数+分治法）
 *
 * @author wangchao4
 * 通过查找一个待排序的序列中的一个基准位置（一般以第一个数为基准），
 * 使得基准左边的都小于这个基准，基准右边的都大于这个基，
 * 然后使用递归等方法对左右两边执行同样的快速排序
 */
public class Algorithm_QuickSort {

    /**
     * 该算法的基本思想是：每次排序都找一个基准位，
     * 使得基准位前端的部分每个数都小于该基准位上的数，
     * 基准位后端的部分每个数都大于该基准位上的数，
     * 然后递归该过程，知道待排序序列中的所有元素都有序为止。
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] data = new int[]{7, 1, 6, 4, 3, 2, 1, 23};

        Algorithm_QuickSort.quickSort(data);
    }


    private static void quickSort(int[] data) {
        qucik_recursion(0, data.length - 1, data);

        StringBuilder playnum = new StringBuilder();

        for (int i : data) {
            playnum.append(i + ",");
        }
        System.out.println(playnum.toString());
    }

    //第二步，采用递归的方式处理基准左右两堆
    public static void qucik_recursion(int low, int high, int[] data) {
        int base;
        if (low < high) {
            base = getPart(low, high, data); //获取基准
            qucik_recursion(low, base - 1, data);  //对低基准位段进行递归排序
            qucik_recursion(base + 1, high, data);  //对高基准位段进行递归排序
        }
    }

    //第一步，查找一个基准位
    public static int getPart(int low, int high, int[] data) {
        //设定一个初始基准
        int comData = data[low];
        while (low < high) {
            while (low < high && data[high] >= comData) {  //从右向左查找
                high--;
            }
            if (low < high) {
                data[low] = data[high];  //小于基准的移到低端
            }
            while (low < high && data[low] <= comData) {  //从左向右查找
                low++;
            }
            if (low > high) {
                data[high] = data[low];  //大于基准的移到高端
            }
        }
        data[low] = comData;//基准位置不再变化时
        return low;
    }


}
