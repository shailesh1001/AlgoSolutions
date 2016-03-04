/*
 * Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....
 Notice

Please complete the problem in-place.

Example
Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {

    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }
    }

    public void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for (int i = nums.length - 1, j = 0, k = i / 2 + 1; i >= 0; --i) {
            nums[i] = tmp[i % 2 == 0 ? j++ : k++];
        }
    }

}
