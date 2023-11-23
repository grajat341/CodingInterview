public class Solution {
    public boolean check(List<Integer> arr) {
        int n = arr.size();
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> st = new HashSet<>();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            st.add(num);
        }

        if ((maxElement - minElement) % (n - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (n - 1);
        int curr = minElement + diff;

        while (curr < maxElement) {
            if (!st.contains(curr)) {
                return false;
            }
            curr += diff;
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> subArray = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                subArray.add(nums[j]);
            }
            result.add(check(subArray));
        }

        return result;
    }
}