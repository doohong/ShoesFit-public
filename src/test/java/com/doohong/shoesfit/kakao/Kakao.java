package com.doohong.shoesfit.kakao;

import java.util.*;

public class Kakao {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(7);
        a.add(3);
        reassignedPriorities(a);
        System.out.println(a.toString());
    }
    public static long findRange(int num) {
        // Write your code here
        int maxIndex = -1;
        int maxChange = -1;

        int minIndex = -1;
        int minChange = -1;
        int minFlag=0;
        long answer =0;
        String sNum = Integer.toString(num);
        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();
        for(int i=0; i<sNum.length();i++){
            int iNum = sNum.charAt(i)-'0';
            if(iNum ==maxChange) maxNum.append(9);
            else maxNum.append(iNum);
            if(iNum==minChange) minNum.append(minFlag);
            else minNum.append(iNum);
            if(maxIndex==-1&&iNum !=9){
                maxIndex=i;
                maxChange = iNum;
                maxNum.replace(i,i+1,"9");
            }
            if(minIndex==-1 && i==0 &&iNum!=1 ){
                minIndex=i;
                minChange =iNum;
                minFlag =1;
                minNum.replace(i,i+1, "1");
            }
            else if(minIndex==-1 &&i!=0 &&iNum !=0 &&iNum!=sNum.charAt(0)-'0'){
                minIndex=i;
                minChange = iNum;
                minFlag=0;
                minNum.replace(i, i+1, "0");
            }
        }
        System.out.println(maxNum.toString());
        System.out.println(minNum.toString());
        answer = Long.parseLong(maxNum.toString())-Long.parseLong(minNum.toString());
        return answer;
    }
    public static List<Integer> reassignedPriorities(List<Integer> issuePriorities) {
        // Write your code here
        List<Integer> answerList = new ArrayList<>();
        int[] array = new int[100];
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<issuePriorities.size();i++) {
            hashSet.add(issuePriorities.get(i));
        }
        List<Integer> hashList = new ArrayList<>(hashSet);
        Collections.sort(hashList);
        int count =1;
        for(int j=0;j<hashList.size();j++){
            array[hashList.get(j)]=count;
            count++;
        }
        for(int k=0; k<issuePriorities.size();k++){
            answerList.add(array[issuePriorities.get(k)]);
        }

        return answerList;
    }
    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        // Write your code here
        int arraySize = a.size();
        int maxNum = 0;
        int maxIndex=0;
        for(int i=0;i<arraySize;i++){
            if(maxNum<a.get(i)){
                maxNum=a.get(i);
                maxIndex=i;
            }
        }
        List<Integer> answerList = new ArrayList();
        for(int j=0; j<rotate.size();j++){
            int rotateNum = rotate.get(j)%arraySize;
            if(rotateNum>maxIndex)answerList.add(maxIndex+arraySize-rotateNum);
            else answerList.add(maxIndex-rotateNum);
        }


        return answerList;

    }
}
