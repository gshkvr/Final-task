package entity.impl;

import entity.AbstractEntity;

import java.sql.Date;
import java.util.Objects;

public class News extends AbstractEntity {

    public static final String TABLE_NAME = "news";
    public static final String DATE_COLUMN = "date";
    public static final String RU_TITLE_COLUMN = "ru_title";
    public static final String RU_TEXT_COLUMN = "ru_text";
    public static final String EN_TITLE_COLUMN = "en_title";
    public static final String EN_TEXT_COLUMN = "en_text";
    public static final String DEFAULT_TITLE_COLUMN = "default_title";
    public static final String DEFAULT_TEXT_COLUMN = "default_text";

    private Date date;
    private String ruTitle;
    private String enTitle;
    private String defaultTitle;
    private String ruText;
    private String enText;
    private String defaultText;

    public News() {
    }

    public News(Date date, String ruTitle, String enTitle, String defaultTitle, String ruText, String enText, String defaultText) {
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

    public void setRuTitle(String ruTitle) {
        this.ruTitle = ruTitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
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

    public void setDefaultTitle(String defaultTitle) {
        this.defaultTitle = defaultTitle;
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
