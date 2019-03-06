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

    boolean isForRedirect() {
        return forRedirect;
    }

    String getUrl() {
        return url;
    }
}
