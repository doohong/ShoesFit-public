package com.doohong.shoesfit.joom;

import java.util.Stack;

class Solution {
    public String solution(int U, int L, int[] C) {
        int length=C.length;
        int u=U;
        int l=L;
        int vaC=0;
        Stack<Integer> stack = new Stack<>();
        String answer;
        StringBuffer sb1 = new StringBuffer();

        StringBuffer sb2 = new StringBuffer();
        for(int i=0;i<length;i++)
        {
            if(C[i]==2){
                sb1.append(1);
                sb2.append(1);
                u--;
                l--;
            }
            else if(C[i]==1){
                vaC++;
                sb1.append(2);
                sb2.append(2);
                stack.push(i);
            }
            else if(C[i]==0){
                sb1.append(0);
                sb2.append(0);
            }
        }
        if(vaC!=u+l) return "IMPOSSIBLE";
        for(int i=0; i<vaC;i++){
            int index=stack.pop();
            if(l!=0){
                l--;
                sb2.setCharAt(index,'1');
                sb1.setCharAt(index,'0');
            }
            else if(u!=0){
                u--;
                sb1.setCharAt(index,'1');
                sb2.setCharAt(index,'0');
            }
        }
        answer = sb1+","+sb2;
        //System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3,2,new int[]{2,1,1,0,1});
    }
}