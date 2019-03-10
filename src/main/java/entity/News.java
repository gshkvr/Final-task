package entity;

import java.sql.Date;
import java.util.Objects;

/**
 * The type News.
 * Representation of table "news".
 *
 * @author George Kvirikashvili
 */
public class News extends AbstractEntity {

    private Date date;
    private String ruTitle;
    private String enTitle;
    private String defaultTitle;
    private String ruText;
    private String enText;
    private String defaultText;

    /**
     * Instantiates a new News.
     *
     * @param id           the id
     * @param date         the date
     * @param ruTitle      the ru title
     * @param enTitle      the en title
     * @param defaultTitle the default title
     * @param ruText       the ru text
     * @param enText       the en text
     * @param defaultText  the default text
     */
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

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets ru title.
     *
     * @return the ru title
     */
    public String getRuTitle() {
        return ruTitle;
    }

    /**
     * Gets en title.
     *
     * @return the en title
     */
    public String getEnTitle() {
        return enTitle;
    }

    /**
     * Gets ru text.
     *
     * @return the ru text
     */
    public String getRuText() {
        return ruText;
    }

    /**
     * Sets ru text.
     *
     * @param ruText the ru text
     */
    public void setRuText(String ruText) {
        this.ruText = ruText;
    }

    /**
     * Gets en text.
     *
     * @return the en text
     */
    public String getEnText() {
        return enText;
    }

    /**
     * Sets en text.
     *
     * @param enText the en text
     */
    public void setEnText(String enText) {
        this.enText = enText;
    }

    /**
     * Gets default title.
     *
     * @return the default title
     */
    public String getDefaultTitle() {
        return defaultTitle;
    }

    /**
     * Gets default text.
     *
     * @return the default text
     */
    public String getDefaultText() {
        return defaultText;
    }

    /**
     * Sets default text.
     *
     * @param defaultText the default text
     */
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
