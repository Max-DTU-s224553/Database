package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Footage {
    private final String title;
    private final Date programDate;
    private final Integer duration;
    private final String footageID;

    public Footage(String title, Date programDate, Integer duration, String footageID) {
        this.title = title;
        this.programDate = programDate;
        this.duration = duration;
        this.footageID = footageID;

    }

    public String getTitle() {
        return title;
    }
    public Date getprogramDate() { return programDate; }
    public Integer getDuration() {
        return duration;
    }
    public String getFootageID() {return title; }

    @Override
    public String toString() {
        final String D = ";";
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");

        return getTitle() +D + dateFormatter.format(getprogramDate()) +D + getDuration() + D + getFootageID();
    }

}



