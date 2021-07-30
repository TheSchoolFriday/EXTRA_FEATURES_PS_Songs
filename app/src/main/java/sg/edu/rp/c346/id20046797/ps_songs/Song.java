package sg.edu.rp.c346.id20046797.ps_songs;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this._id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String starsToText() {
        String messageToStars = "";
        for (int i = 0; i < stars; i++) {
            messageToStars += "*";
        }

        return messageToStars;
    }
    @Override
    public String toString() {

        String messageToStars = "";
        for (int i = 0; i < stars; i++) {
            messageToStars += "*";
        }

        return title + "\n" + singers + " - " + year + "\n" + messageToStars;
    }
}
