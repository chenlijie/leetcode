package amazon.design.twitter;

import java.util.*;

public class Twitter {

    Map<Integer, User> users = new Hashtable<>();

    void post(int userId, String content) {
        long time = System.currentTimeMillis();
        User user = users.get(userId);
        Feed newFeed = new Feed(time, content);
        newFeed.pre = user.feedHead.pre;
        user.feedHead.pre = newFeed;
    }

    void follow(int userId, int followId) {
        users.get(userId).follows.add(followId);
    }

    void unFollow(int userId, int followId) {
        users.get(userId).follows.remove(followId);
    }

    List<Feed> getFeed(int userId) {
        List<Feed> res = new ArrayList<>();

        PriorityQueue<Feed> q = new PriorityQueue<>((f1,f2) -> (int)(f2.id - f1.id));

        for (int id : users.get(userId).follows) {
            if (users.get(id).feedHead.pre != null) {
                q.offer(users.get(id).feedHead.pre);
            }
        }

        while (!q.isEmpty() && res.size() < 10) {
            Feed feed = q.poll();

            res.add(feed);

            if (feed.pre != null)
                q.offer(feed.pre);
        }

        return res;
    }

    public static void main(String[] args) {
    }

}
