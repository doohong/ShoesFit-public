package com.doohong.shoesfit.joom;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
    int max =0;
    int xlength;
    int ylength;
    public void solution(int[][] Board) {
        // write your code in Java SE 8
        xlength=Board.length;
        ylength=Board[0].length;

        int boardMax=1;
        for(int i=0;i<xlength;i++){
            for(int j=0;j<ylength;j++){
                    boolean[][] checkArray = new boolean[xlength][ylength];
                    if(Board[i][j]==0) continue;
                    dfs(Board,i,j,4,0);
                    boardMax = Board[i][j];

            }
        }


    }
    public void dfs(int[][] Board,int x,int y , int count ,int num){
        if(count==0){
            System.out.println(num);
            max= Math.max(max,num);
            return;
        }
        else if(Board[x][y]==-1) return;
        num += Math.pow(10,count-1)*Board[x][y] ;
        //Board[x][y]=-1;
        if(x<xlength-1) {
            dfs(Board,x+1,y,count-1,num);
        }
        if(y<ylength-1){
            dfs(Board,x,y+1,count-1,num);
        }
        if(x>0){
            dfs(Board,x-1,y,count-1,num);
        }
        if(y>0){
            dfs(Board,x,y-1,count-1,num);
        }

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(new int[][]{{9, 1, 1, 0, 7}, {1, 0, 2, 1, 0},{1, 9, 1, 1, 0}});
    }
}
