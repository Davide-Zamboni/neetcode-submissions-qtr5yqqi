class Twitter {

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int time;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);
        Set<Integer> usersToCheck = new HashSet<>();
        usersToCheck.add(userId);

        if (followMap.containsKey(userId)) {
            usersToCheck.addAll(followMap.get(userId));
        }

        for (int followeeId : usersToCheck) {
            List<Tweet> tweets = tweetMap.get(followeeId);
            if (tweets == null) continue;

            for (Tweet tweet : tweets) {
                minHeap.offer(tweet);
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().tweetId);
        }
        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) return;
        followMap.get(followerId).remove(followeeId);
    }
}