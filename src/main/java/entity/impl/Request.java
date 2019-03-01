package entity.impl;

import entity.AbstractEntity;

public class Request extends AbstractEntity {
    public static final String TABLE_NAME = "request";
    public static final String REQUEST_ID = "request_id";
    public static final String REQUEST_NAME = "request_name";
    public static final String REQUEST_FILE_LINK = "request_file_link";
    public static final String REQUEST_FILE = "request_file";

    private String name;
    private String fileLink;

    public Request(int id, String name, String fileLink) {
        this.id = id;
        this.name = name;
        this.fileLink = fileLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
