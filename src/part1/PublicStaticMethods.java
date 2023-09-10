package src.part1;

public class PublicStaticMethods {
	public static void greet() {
		System.out.println("Hello, world!");
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int getMax(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}

	public static int getMin(int n1, int n2) {
		return n1 < n2 ? n1 : n2;
	}

	public static int[] findMax(int[] arr) {
		int min = arr[0];
		int max = arr[0];

		for (int num : arr) {
			min = getMin(min, num);
			max = getMax(max, num);
		}

		return new int[]{min, max};
	}

	public static void main(String[] args) {
		greet();

		int sum = add(4, 6);
		System.out.println("4 + 6 = " + sum);

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] minMax = findMax(arr);
		System.out.println("Min: " + minMax[0] + ", max: " + minMax[1]);
	}
}
