/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Joseph Clancy
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n == k) {
			return 1;
		} else if (k == 1) {
			return n;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String number = String.valueOf(n);
		return intWithCommas(number);
	}

	private String intWithCommas(String number) {
		if (number.length() <= 3) {
			return number;
		} else {
			return intWithCommas(number.substring(0, number.length() - 3)) + ","
					+ number.substring(number.length() - 3, number.length());
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index < len / 2) {
			int temp = x[len - 1 - index];
			x[len - 1 - index] = x[index];
			x[index] = temp;
			reverseArray(x, index + 1, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private int arrayRange(int[] a, int index, int max, int min) {
		if (index == a.length) {
			return max - min;
		}

		if (max < a[index]) {
			max = a[index];
		}
		if (min > a[index]) {
			min = a[index];
		}

		return arrayRange(a, index + 1, max, min);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length < 2) {
			return true;
		} else {
			return isSorted(nums, 0);
		}
	}

	private boolean isSorted(int[] nums, int index) {
		if (index == nums.length - 2) {
			return nums[index] <= nums[index + 1];
		} else {
			return nums[index] <= nums[index + 1] && isSorted(nums, index + 1);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	private boolean found(String search, String[] strs, int index) {
		if (index == strs.length) {
			return false;
		} else {
			return search.equals(strs[index]) || found(search, strs, index + 1);
		}
	}
}
