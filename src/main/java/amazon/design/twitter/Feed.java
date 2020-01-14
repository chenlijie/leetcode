package amazon.design.twitter;

public class Feed {

    long id;
    String content;
    Feed pre;

    public Feed(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
