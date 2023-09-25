class Solution {
    public char findTheDifference(String s, String t) {
        int arr[]= new int[26];
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
        }
        char c = '\0';
        for(char c1: t.toCharArray()){
           arr[c1-'a']--; 
        }
        for(int i=0;i<arr.length; i++){
            if(arr[i]!=0){
                c = (char)(i+'a');
            }
        }
        return c;
    }
}