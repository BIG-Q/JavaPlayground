package com.java8;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0){
            return result;
        }
        
        boolean rowInc = false;
        boolean rowDec = false;
        boolean colInc = false;
        boolean colDec = false;
        
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        
        int i = 0;
        int j = 0;
        colInc = true;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            if(colInc) {
                result.add(matrix[i][j]);
                
                if(j < colEnd){
                    j++;
                }
                else {
                    rowInc = true;
                    colInc = false;
                    i++;
                    rowStart++;
                }
            }
            else if(rowInc){
                result.add(matrix[i][j]);
                
                if(i < rowEnd){
                    i++;
                }
                else{
                    colDec = true;
                    rowInc = false;
                    colEnd--;
                    j--;
                }
            }
            else if(colDec){
                result.add(matrix[i][j]);
                
                if(j > colStart){
                    j--;
                }
                else{
                    colDec = false;
                    rowDec = true;
                    i--;
                    rowEnd--;
                }
            }
            else if(rowDec){
                result.add(matrix[i][j]);
                
                if(i > rowStart){
                    i--;
                }
                else{
                    rowDec = false;
                    colInc = true;
                    j++;
                    colStart++;
                }
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[][] data = new int[][]{{1,2,3},{4,5,6}, {7,8,9}};
		
		spiralOrder(data);
	}
}
