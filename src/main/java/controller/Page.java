package controller;

public class Page {
    private boolean forRedirect;
    private String url;

    public Page(String url) {
        this.url = url;
        this.forRedirect = false;
    }

    public Page(String url, boolean forRedirect) {
        this.url = url;
        this.forRedirect = forRedirect;
    }

    public boolean isForRedirect() {
        return forRedirect;
    }

    public void setForRedirect(boolean forRedirect) {
        this.forRedirect = forRedirect;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
