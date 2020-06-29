import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String args[]) {
      int[] inputArray = {2, 7, 11, 15};
      int target = 9;
      
      try {
        int[] result = findIndices(inputArray, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
      } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
      }
    }
    
    public static int[] findIndices(int[] inputs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int partnerValue = target - inputs[i];
            if (map.containsKey(partnerValue)) {
                return new int[] { map.get(partnerValue), i };
            }
            map.put(inputs[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}