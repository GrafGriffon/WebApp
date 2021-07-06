package ru.garf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

@Entity
public class Art implements Serializable, Comparable<Art> {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column(length = 1000000)
    @Lob
    private String content;
    @Column
    private long creationTimestamp;
    @Column
    private String typeArt;

    public Art() {
        this.creationTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Art that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }

    public String getTypeArt() {
        return typeArt;
    }

    public void setTypeArt(String typeArt) {
        this.typeArt = typeArt;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
        calendar.setTimeInMillis(creationTimestamp);
        return sdf.format(calendar.getTime());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
