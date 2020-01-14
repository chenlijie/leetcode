package amazon.design.video.video;

public enum Category {

    MOVIE(null),
        ACTION(MOVIE),
        ROMANCE(MOVIE),
        CARTOON(MOVIE),
    SPORT(null),
        BASKETBALL(SPORT),
        PINGPANG(SPORT),
        F1(SPORT),
    MUSIC(null),
        HIPHOP(MUSIC),
        ROCK(MUSIC);

    private Category parent;

    Category(Category parent) {
        this.parent = parent;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
