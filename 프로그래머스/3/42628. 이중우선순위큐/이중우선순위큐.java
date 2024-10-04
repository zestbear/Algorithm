import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        for(String operation : operations) {
            st = new StringTokenizer(operation);
            String option = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(option.equals("I")) {
                // insert
                queue.put(num, queue.getOrDefault(num, 0) + 1);
            } else if(option.equals("D")) {
                // delete
                if(!queue.isEmpty()) {
                    if(num == -1) {
                        int min = queue.firstKey();
                        if(queue.get(min) == 1) {
                            queue.remove(min);
                        } else {
                            queue.put(min, queue.get(min) - 1);
                        }
                    } else if(num == 1) {
                        int max = queue.lastKey();
                        if(queue.get(max) == 1) {
                            queue.remove(max);
                        } else {
                            queue.put(max, queue.get(max) - 1);
                        }
                    }
                }
            }
        }
        
        if(queue.isEmpty()) return new int[] {0, 0};
        else return new int[] {queue.lastKey(), queue.firstKey()};
    }
}