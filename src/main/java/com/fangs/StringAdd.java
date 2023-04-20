package com.fangs;

import java.util.Arrays;

/**
 * 415
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * @author fangs
 */
public class StringAdd {
    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        Solution solution = new Solution();
        System.out.println("答案");
        System.out.println(solution.addStrings(num1, num2));
    }
}


class Solution {
    public String addStrings(String num1, String num2) {
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        int jw = 0;
        int aa = '0'*2;
        int max =  (num1CharArray.length>num2CharArray.length?num1CharArray.length:num2CharArray.length) + 1;
        int[] res = new int[max];
        for (int i = 0; i <num1CharArray.length || i<num2CharArray.length; i++) {
            char c1 = num1CharArray.length>i?num1CharArray[num1CharArray.length-i-1]:'0';
            char c2 = num2CharArray.length>i?num2CharArray[num2CharArray.length-i-1]:'0';
            int c = c1+c2-aa+jw;
            if (c>9){
                jw = 1;
                c = c%10;
            }else{
                jw=0;
            }
            res[i] = c;
        }
        char[] aaa;
        if(jw>0){
            res[max-1] = jw;
            aaa = new char[max];
        }else {
            res[max-1] = 0;
            aaa = new char[max-1];
        }

        for (int i = max-1,j=0; i >= 0 ; i--) {
            if(aaa.length==max-1 && i==max-1){
                continue;
            }
            aaa[j++] = (char) (res[i]+'0');
        }
        return new String(aaa);
    }

}
