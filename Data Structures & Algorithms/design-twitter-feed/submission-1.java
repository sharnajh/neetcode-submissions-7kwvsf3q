class Twitter {

    int time;
    // key: userId, value: list of tweets
    HashMap<Integer,List<int[]>> userTweets;
    // key: userId, value: list of following
    HashMap<Integer,Set<Integer>> followMap;

    public Twitter() {
        time = 0;
        userTweets = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        for (int user : users) {
            List<int[]> tweets = userTweets.get(user);
            if (tweets != null) {
                pq.addAll(tweets);
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll()[1]);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = followMap.get(followerId);
        if (following != null && following.contains(followeeId))
        {
            following.remove(followeeId);
        }
    }
}