import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixSearch {
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

    public static boolean searchMatrixFlatMap(int[][] matrix, int target){

        return search(
        Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray(),
                target
        ) != -1;


    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = (row * col) - 1;
        while (l <= r){
            int mid = l + ((r - l) / 2);
            if(matrix[mid / col][mid % col] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l < row * col && matrix[l / col][l % col] == target;
    }

    public static boolean searchMatrixOther(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int row = -1;
        while(start <= end){
            int mid = (start + ((end - start) / 2));
            if(target >= matrix[mid][matrix[mid].length - 1] && target <= matrix[mid][matrix[mid].length - 1]){
                row = mid;
                break;
            }else if(target >= matrix[mid][matrix[mid].length - 1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
//        if(row == -1) return false;
        return search(matrix[row], target) != -1;
    }


    public static void main(String[] args) {
        System.out.println(
                searchMatrixOther(
                        new int[][]{
                                new int[]{1,3,5,7},
                                new int[]{10,11,16,20},
                                new int[]{23,30,34,60}
                        },
                        3
                )
        );
    }
}
