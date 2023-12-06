public class Solution {
    public int totalMoney(int n) {
        int items = n / 7;
        int first = 28;
        int last = 28 + (items - 1) * 7;

        int arithmeticSum = items * (first + last) / 2;

        // Final week remaining days
        int mondayMoney = 1 + items;
        int finalWeek = 0;

        for (int day = 1; day <= (n % 7); day++) {
            finalWeek += mondayMoney++;
        }

        return arithmeticSum + finalWeek;
    }
}