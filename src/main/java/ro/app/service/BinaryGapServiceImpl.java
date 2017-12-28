package ro.app.service;

import org.springframework.stereotype.Service;

@Service
public class BinaryGapServiceImpl implements BinaryGapService {

	public int binaryGap(int n) {
		int result = 0;
		int gapSize = 0;
		String binaryString = Integer.toBinaryString(n);
		char[] dst = new char[binaryString.length()];
		binaryString.getChars(0, binaryString.length(), dst, 0);
		for (char c : dst) {
			if (c == '0') {
				gapSize++;
				if (gapSize > result) {
					result = gapSize;
				}
			} else {
				gapSize = 0;
			}
		}

		return result;
	}

	public int binaryGapNoTrail(int n) {
		int result = 0;
		int gapSize = 0;
		int index = 0;
		boolean hasGap = false;
		String binaryString = Integer.toBinaryString(n);
		char[] dst = new char[binaryString.length()];
		binaryString.getChars(0, binaryString.length(), dst, 0);

		for (char c : dst) {
			if (c == '0' && index == 0) {
				index++;
				continue;
			}
			if (c == '0' && hasOneFromCurrentIndex(dst, index)) {
				gapSize++;
			} else if (c == '1') {
				hasGap = true;
				gapSize = 0;
			}
			if (gapSize > result) {
				result = gapSize;
			}
			index++;
		}
		return result;
	}

	public int oddElement(int[] a) {
		int result = 0;
		int index = 0;
		boolean pairFound = false;
		for (; index < a.length; index++) {
			if (a[index] < 0) {
				continue;
			}
			result = a[index];
			int j = index + 1;
			for (; j < a.length; j++) {
				if (a[index] == a[j]) {
					// pair found
					pairFound = true;
					a[j] = -1;
					a[index] = -1;
					break;
				}
			}
			if (pairFound) {
				index = -1;
				pairFound = false;
				continue;
			}
			if (!pairFound) {
				return result;
			}
		}
		return result;
	}

	private boolean hasOneFromCurrentIndex(char[] a, int index) {
		boolean result = false;
		while (a.length > index) {
			if (a[index] == '1') {
				return true;
			}
			index++;
		}

		return result;
	}

}
