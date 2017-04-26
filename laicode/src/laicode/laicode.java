package laicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class laicode {
	
	public laicode () {
		int[] array = new int[]{1, 2, 3, 4, 5};
		int target = 6;
		List<List<Integer>> res = allPairs(array, target);
		System.out.println(res.toString());
	}
	public List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here.
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (array == null) {
	      return res;
	    }
	    Arrays.sort(array);
	    int left = 0;
	    int right = array.length - 1;
	    while (left < right) {
	      if (array[left] + array[right] == target) {
	        res.add(Arrays.asList(left, right));
	        left++;
	        right--;
	      } else if (array[left] + array[right] < target) {
	        left++;
	      } else {
	        right--;
	      }
	    }
	    return res;
	    
	  }
}
