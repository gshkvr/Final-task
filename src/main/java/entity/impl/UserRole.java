package entity.impl;

public enum UserRole {
    ADMIN(1, "admin"),
    CLIENT(2, "client");

    public static final String ID ="role_id";
    public static final String NAME = "role_name";


    private int id;
    private String value;

    UserRole(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public static UserRole getById(int id) {
        switch (id){
            case 1: return UserRole.ADMIN;
            case 2: return UserRole.CLIENT;
            default: throw new IllegalArgumentException("No such UserRole");
        }
    }

    public int getId() {
        return id;
    }

    //    private String name;
//
//    public UserRole(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getValue() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    }
