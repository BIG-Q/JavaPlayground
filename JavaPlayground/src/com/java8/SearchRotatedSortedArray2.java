package com.java8;

public class SearchRotatedSortedArray2 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		int len = nums.length;

		int head = 0;
		int tail = len - 1;

		int rs = -1;

		while (head <= tail) {
			int mid = (head + tail) / 2;

			if (nums[mid] == target) {
				rs = mid;
				break;
			} else if (nums[mid] < nums[head]) {
				if (target > nums[mid] && target < nums[head]) {
					while (mid < tail && (nums[mid] == nums[mid + 1])) {
						mid++;
					}

					head = mid + 1;
				} else {
					while (mid > head && nums[mid] == nums[mid - 1]) {
						mid--;
					}

					tail = mid - 1;
				}
			} else if (nums[mid] > nums[tail]) {
				if (target < nums[mid] && target > nums[tail]) {
					while (mid > head && nums[mid] == nums[mid - 1]) {
						mid--;
					}

					tail = mid - 1;
				} else {
					while (mid < tail && nums[mid] == nums[mid + 1]) {
						mid++;
					}

					head = mid + 1;
				}
			} else {
				if (target > nums[mid]) {
					while (mid < tail && nums[mid] == nums[mid + 1]) {
						mid++;
					}

					head = mid + 1;
				} else {
					while (mid > head && nums[mid] == nums[mid - 1]) {
						mid--;
					}

					tail = mid - 1;
				}
			}
		}

		return rs;
	}
}
