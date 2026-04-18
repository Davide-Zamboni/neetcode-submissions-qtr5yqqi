class Solution {
    public int leastInterval(char[] tasks, int n) {
       Map<Character, Integer> taskFreq = new HashMap<>();

        for(char c : tasks){
            taskFreq.put(c, taskFreq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int feq : taskFreq.values()){
            queue.offer(feq);
        }

        int time = 0;
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int cycle = n + 1;

            while(!queue.isEmpty() && cycle > 0){
                int freq = queue.poll();
                if (freq > 1){
                    tmp.add(freq - 1);
                }
                cycle --;
                time++;
            }

            for (int element : tmp){
                queue.offer(element);
            }

            if(queue.isEmpty()){
                break;
            }

            time = time + cycle;
        }

        return time;
        
    }
}
