package hack.sportsapp;

public class event {
    private int id;
    private String where;
    private String time;
    private String who;
    private int image;

    public int getId() {
        return id;
    }

    public String getWhere() {
        return where;
    }

    public String getTime() {
        return time;
    }

    public String getWho() {
        return who;
    }

    public int getImage() {
        return image;
    }



    public event(int id, String where, String time, String who, int image) {
        this.id = id;
        this.where = where;
        this.time = time;
        this.who = who;
        this.image = image;
    }


}