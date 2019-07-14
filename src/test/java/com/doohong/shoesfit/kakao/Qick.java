package com.doohong.shoesfit.kakao;

import java.util.Arrays;

public class Qick {
    public static void main(String[] args) {
        int[] array = {1,5,2,4,3,7,6};
        Qick q = new Qick();
        q.qsort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public int fivot(int[] array , int start, int end){
        int middle = array[(start+end)/2];
        while(start<end){
            while(array[start]<middle && start<end) start++;
            while(middle<array[end] &&  start<end)end--;
            if(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }

        }
        return start;
    }
    public void qsort(int[] array,int start, int end){
        if(start<end){
            int middle = fivot(array,start,end);
            qsort(array,start,middle);
            qsort(array,middle+1 ,end);
        }

    }
}
