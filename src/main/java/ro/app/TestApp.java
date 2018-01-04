package ro.app;

import java.util.Arrays;

public class TestApp {
	public static void main(String... a) {
		int[] x = { 0, 1, 2, 3, 4, 5 };
		TestApp app = new TestApp();
		System.out.println(app.inverseModulo(-1, 5) == 4);
		System.out.println(app.inverseModulo(1, 5) == 1);
		System.out.println(app.inverseModulo(0, 5) == 0);
		System.out.println(app.inverseModulo(6, 5) == 1);
		System.out.println(app.inverseModulo(-6, 5) == 4);

		Arrays.stream(app.solution(x, 4)).forEach(System.out::println);

	}

	public int[] solution(int[] A, int K) {
		return mySolution(A, K);
	}

	private int[] mySolution(int[] a, int k) {
		int step;
		final int length = a.length;
		if (length < 1) {
			return a;
		}
		int[] result = new int[length];

		int j = 0;

		step = inverseModulo(k, length);
		for (int i = 0; i < length - step; i++) {
			result[i + step] = a[i];
		}

		for (int i = step; i > 0; i--) {
			int l = length - j - 1;
			result[i - 1] = a[l];
			j++;
		}

		return result;
	}

	private int inverseModulo(int k, int modulo) {
		int result = k;
		if (k < 0 && -k > modulo) {
			result = modulo - (-k) % modulo;
		} else if (k < 0 && -k <= modulo) {
			result = modulo - (-k);
		}
		if (k > modulo) {
			result = k % modulo;
		}

		return result;
	}
}
