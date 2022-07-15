package sg.edu.rp.c346.id21021397.nationaldayparadethemesongcompilation;

import java.io.Serializable;

public class Song implements Serializable {
    int id;
    String title;
    String singers;
    int year;
    int stars;

    public Song( int id, String title, String singers,int year,int stars ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {  return id;  }

    public String getTitle() { return title; }

    public String getSinger() { return singers; }

    public int getYear() { return year; }

    public int getStars() { return stars; }

    public void setTitle(String Title){
        this.title = Title;
    }

    public void setSinger(String Singer){
        this.singers = Singer;
    }

    public void setYear(int Year){
        this.year = Year;
    }

    public void setStars(int Stars){
        this.stars = Stars;
    }

    public String toString(){ return "ID: " + id + ", " + "Title: " + title + ", " + "Singer: " + singers + ", " + "Year: " + year + ", " + "Stars: " + stars; }
}
