//https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/?envType=daily-question&envId=2024-12-23
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class LeetcodeProblem2471 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int minSwaps(int[] arr) {
        int swaps = 0;
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            // If the element is already in the correct position, skip it.
            if (arr[i] != sorted[i]) {
                int correctIndex = map.get(sorted[i]);

                // Swap the current element with its correct position.
                swap(arr, i, correctIndex);

                // Update the map after swapping.
                map.put(arr[correctIndex], correctIndex);
                map.put(arr[i], i);

                swaps++;
            }
        }
        return swaps;
    }

    public static void main(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            int k = 0;

            // Process the current level of nodes and populate `arr`.
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.remove();
                arr[k++] = currentNode.val;
                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }

            // Calculate the minimum swaps required to sort the current level.
            count += minSwaps(arr);
        }
        System.out.println(count);
    }
}
