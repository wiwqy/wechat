package xiaoquan.wechat.controller;

import java.util.Arrays;
/**
 *  希尔排序算法
 *  
 *  
 * @author Administrator
 *
 */
public class TestSort {

	public static void main(String[] args) {

		int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50,43,7,10,24,65 };
        shellSortSmallToBig(data);
        System.out.println("");
        System.out.println(Arrays.toString(data));
	}

	public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
        	System.out.println("");
            System.out.println("increment:" + increment);
            for (int i = increment; i < data.length; i++) {
                 System.out.println("i:" + i);
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                     System.out.println("j:" + j);
                     System.out.println("temp:" + temp);
                     System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");
        }
    }

}
