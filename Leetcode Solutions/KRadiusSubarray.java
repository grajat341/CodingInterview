class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
            return nums;

        long kAverageSize = (k*2)+1;
        int n = nums.length;
        int[] avg = new int[n];
        if(kAverageSize>n)
        {
            Arrays.fill(avg,-1);
            return avg;
        }

        long[] prefixSum = new long[n+1];
        prefixSum[0] = 0;
        for(int i=0;i<n;i++)
        {
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        for(int i=0;i<n;i++)
        {
            if(i-k<0||i+k>=n)
            {
                avg[i]=-1;
            }
            else{
                avg[i] = (int)Math.floor((prefixSum[i+k+1]-prefixSum[i-k])/kAverageSize);
            }
        }

        return avg;
    }
}