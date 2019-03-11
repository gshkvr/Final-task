package controller;

import java.util.Objects;

/**
 * Page contains url and flag which shows
 * that page should be redirected or forwarded
 * to given url.
 *
 * @author George Kvirikashvili
 */
public class Page {
    private boolean forRedirect;
    private String url;

    /**
     * Instantiates a new Page.
     *
     * @param url the url
     */
    public Page(String url) {
        this.url = url;
        this.forRedirect = false;
    }

    /**
     * Instantiates a new Page.
     *
     * @param url         the url
     * @param forRedirect shows if should make forward or redirect to url
     */
    public Page(String url, boolean forRedirect) {
        this.url = url;
        this.forRedirect = forRedirect;
    }

    /**
     * Is for redirect boolean.
     *
     * @return the boolean
     */
    boolean isForRedirect() {
        return forRedirect;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Page page = (Page) o;
        return forRedirect == page.forRedirect &&
                Objects.equals(url, page.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forRedirect, url);
    }
}
