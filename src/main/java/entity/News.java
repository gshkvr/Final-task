package entity;

import java.sql.Date;
import java.util.Objects;

public class News extends AbstractEntity {

    private Date date;
    private String ruTitle;
    private String enTitle;
    private String defaultTitle;
    private String ruText;
    private String enText;
    private String defaultText;

    public News(int id, Date date, String ruTitle, String enTitle, String defaultTitle, String ruText, String enText, String defaultText) {
        this.id = id;
        this.date = date;
        this.ruTitle = ruTitle;
        this.enTitle = enTitle;
        this.defaultTitle = defaultTitle;
        this.ruText = ruText;
        this.enText = enText;
        this.defaultText = defaultText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRuTitle() {
        return ruTitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public String getRuText() {
        return ruText;
    }

    public void setRuText(String ruText) {
        this.ruText = ruText;
    }

    public String getEnText() {
        return enText;
    }

    public void setEnText(String enText) {
        this.enText = enText;
    }

    public String getDefaultTitle() {
        return defaultTitle;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        News news = (News) o;
        return Objects.equals(date, news.date) &&
                Objects.equals(ruTitle, news.ruTitle) &&
                Objects.equals(enTitle, news.enTitle) &&
                Objects.equals(defaultTitle, news.defaultTitle) &&
                Objects.equals(ruText, news.ruText) &&
                Objects.equals(enText, news.enText) &&
                Objects.equals(defaultText, news.defaultText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, ruTitle, enTitle, defaultTitle, ruText, enText, defaultText);
    }

    @Override
    public String toString() {
        return "News{" +
                "date=" + date +
                ", ruTitle='" + ruTitle + '\'' +
                ", enTitle='" + enTitle + '\'' +
                ", defaultTitle='" + defaultTitle + '\'' +
                ", ruText='" + ruText + '\'' +
                ", enText='" + enText + '\'' +
                ", defaultText='" + defaultText + '\'' +
                '}';
    }
}
