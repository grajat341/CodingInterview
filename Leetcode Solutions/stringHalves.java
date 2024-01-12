class Solution {
    public boolean halvesAreAlike(String s) {
        int left = 0, right = s.length() - 1;
        int leftCount = 0, rightCount = 0;
        while(left < right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if(c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u'
               || c1 == 'A' || c1 == 'E' || c1 == 'I' || c1 == 'O' || c1 == 'U'
            ){
                leftCount++;
            }
            if(c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u'
               || c2 == 'A' || c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U'
            ){
                rightCount++;
            }

            left++;
            right--;
        }

        return (leftCount == rightCount);
    }
}