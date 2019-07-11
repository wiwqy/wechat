package xiaoquan.wechat.controller;

import java.util.Arrays;
/**
 * 希尔排序算法
 * @author Administrator
 *
 */
public class TestSort2 {
	public static void main(String[] args) {
		int[] a = { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50,43,7,10,24,65 };
		// 希尔排序
		int d = a.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 0) {
				break;
			}
			System.out.println(Arrays.toString(a));
		}
	}

}
