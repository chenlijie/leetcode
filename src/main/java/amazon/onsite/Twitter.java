package amazon.onsite;

import java.util.*;

public class Twitter {

    class Tweet {
        public int tweetId;
        public long time;

        public Tweet(int tweetId, long time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class Feed {
        List<Tweet> feed;
        int idx;

        public Feed(List<Tweet> feed) {
            this.feed = feed;
        }
    }

    /** Initialize your data structure here. */
    Map<Integer, Set<Integer>> follows = new HashMap<>();
    Map<Integer, List<Tweet>> tweets = new HashMap<>();

    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        List<Tweet> feed = tweets.get(userId);
        feed.add(0, new Tweet(tweetId, System.currentTimeMillis()));
        if (feed.size() > 10)
            feed.remove(feed.size() - 1);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Feed> feeds = new ArrayList<>();

        if (follows.containsKey(userId)) {
            for (int id : follows.get(userId)) {
                if (tweets.containsKey(id) && !tweets.get(id).isEmpty()) {
                    feeds.add(new Feed(tweets.get(id)));
                }
            }
        }

        if (tweets.containsKey(userId) && !tweets.get(userId).isEmpty()) {
            feeds.add(new Feed(tweets.get(userId)));
        }

        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Feed> q = new PriorityQueue<>((t1, t2) -> {
            long r = t2.feed.get(t2.idx).time - t1.feed.get(t1.idx).time;
            if (r > 0)
                return 1;
            else if (r < 0)
                return -1;
            else
                return 0;
        });

        for (Feed f : feeds)
            q.offer(f);

        while (!q.isEmpty() && feed.size() < 10) {
            Feed v = q.poll();
            feed.add(v.feed.get(v.idx).tweetId);

            if (++v.idx < v.feed.size())
                q.offer(v);
        }

        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            follows.putIfAbsent(followerId, new HashSet<>());
            follows.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId))
            follows.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        t.postTweet(1, 3);
//        t.getNewsFeed(1);
//        t.follow(1, 2);
//        t.postTweet(2, 6);
//        t.getNewsFeed(1);
//        t.unfollow(1, 2);
        t.getNewsFeed(1);


    }
}
