package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixOrder {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[r].length; c++) {
        System.out.print(matrix[r][c] + " ");
        if (r == 0) {
          result.add(matrix[r][c]);
        }
        if (r == 1) {
          int length = matrix[c].length;
          result.add(matrix[r][length - 1]);
          break;
        }
      }
      System.out.println();
    }
    return result;
  }
}

/// attempted solutions
/// 1. add the numbers into result array, in ordered manner
/// 'result.add(matrix[0][c]);' result '[1, 2, 3, 1, 2, 3, 1, 2, 3]'
/// 2. I put if condition when the column loop reach second one 'if (r == 1){
///           int length = matrix[c].length;
///           result.add(matrix[r][length-1]);
///         }'
/// 3. I think I should break down how the sequence is inserted 'if (r == 0) {
///           result.add(matrix[r][c]);
///         }
///         if (r == 1){
///           int length = matrix[c].length;
///           result.add(matrix[r][length-1]);
///         }' result '[1, 2, 3, 6, 6, 6]'
