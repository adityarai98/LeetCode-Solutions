import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[0];
        }

        List<LinkedList<Integer>> diagonals = new ArrayList<>();

        // Traverse the matrix
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int diagonalSum = i + j;

                // If the diagonalSum is encountered for the first time, create a new list
                while (diagonals.size() <= diagonalSum) {
                    diagonals.add(new LinkedList<>());
                }

                // Add the current element to the corresponding diagonal list
                diagonals.get(diagonalSum).addFirst(row.get(j));
            }
        }

        List<Integer> result = new ArrayList<>();

        // Iterate through the diagonals and add them to the result list
        for (LinkedList<Integer> diagonal : diagonals) {
            result.addAll(diagonal);
        }

        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
