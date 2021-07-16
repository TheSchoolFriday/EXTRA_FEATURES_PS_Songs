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

    @Override
    public String toString() {
        return "Song{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", singers='" + singers + '\'' +
                ", year=" + year +
                ", stars=" + stars +
                '}';
    }
}
