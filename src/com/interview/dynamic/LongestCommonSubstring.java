package com.interview.dynamic;

/**
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 */
public class LongestCommonSubstring {

    /**
     * Dynamic way of calculating lcs
     */
    public int longestCommonSubstring(char str1[], char str2[]){
        int[][] matrix = new int[str1.length][str2.length];
        int max = 0;
        for(int i=0; i< str1.length; i++) {
            for(int j=0; j< str2.length; j++) {
                if(str1[i] == str2[j]) {
                    if(i==0 || j==0 ) matrix[i][j] = 1;
                    else matrix[i][j] = matrix[i-1][j-1] + 1;
                    if(max < matrix[i][j]) max = matrix[i][j];
                }
            }
        }
        return max;
    }
    
    /**
     * Recursive way of calculating lcs
     */
    public int longestCommonSubstringRec(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){
            if(str1[pos1] == str2[pos2]){
                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
            }else{
                return 0;
            }
        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }
        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }
    
    public static void main(String args[]){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdeamf".toCharArray();
        System.out.println(lcs.longestCommonSubstring(str1, str2));
        //System.out.println(lcs.longestCommonSubstringRec(str1, str2,str1.length-1, str2.length-1,false));
    }
    
}
