package xiaoquan.wechat.controller;

import java.util.Arrays;

/**
 * 希尔排序算法
 * 
 * @author Administrator
 *
 */
public class TestSort3 {
	public static void main(String[] args) {
		int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50, 43, 7, 10, 24, 65 };
		sort(data);
		System.out.println("");
		System.out.println(Arrays.toString(data));
	}

	public static void sort(int[] a) {
		int length = a.length;
		int h = 1;
		while (h < length / 3)
			h = 3 * h + 1;
		System.out.println(length);
		System.out.println(h);
		for (; h >= 1; h /= 3) {
			for (int i = 0; i < a.length - h; i += h) {
				System.out.println("i="+i+" h="+h);
				for (int j = i + h; j > 0; j -= h) {
					System.out.println(j);
					if (a[j] < a[j - h]) {
						int temp = a[j];
						a[j] = a[j - h];
						a[j - h] = temp;
					}
				}
			}
		}
	}
}
