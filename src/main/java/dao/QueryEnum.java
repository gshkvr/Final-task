package dao;

public enum QueryEnum {

    SELECT_USER_ALL("SELECT interpol.user.id AS id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user"),

    SELECT_USER_BY_ID("SELECT interpol.user.id AS id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.id = ?"),

    SELECT_USER_BY_LOGIN("SELECT interpol.user.id AS id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.login = ?"),

    SELECT_USER_BY_EMAIL("SELECT interpol.user.id AS id,\n" +
            "       interpol.user.user_role_id AS user_role_id,\n" +
            "       interpol.user.login AS login,\n" +
            "       interpol.user.password AS password,\n" +
            "       interpol.user.email AS email,\n" +
            "       interpol.user.first_name AS first_name,\n" +
            "       interpol.user.last_name AS last_name\n" +
            "       FROM interpol.user user\n" +
            "       WHERE user.email = ?"),

    CREATE_USER("insert into interpol.user (user_role_id, login, password, email, first_name, last_name) " +
            "       values (?,?,?,?,?,?)"),

    UPDATE_USER("update interpol.user set user_role_id=?, login=?, password=?, email=?, first_name=?, last_name=? " +
            "       where id=?"),

    DELETE_USER("delete from interpol.user where id=?"),

    SELECT_NEWS_ALL("SELECT interpol.news.date AS date,\n" +
            "       interpol.news.ru_title AS ru_title,\n" +
            "       interpol.news.en_title AS en_title,\n" +
            "       interpol.news.default_title AS default_title,\n" +
            "       interpol.news.ru_text AS ru_text,\n" +
            "       interpol.news.en_text AS en_text,\n" +
            "       interpol.news.default_text AS default_text\n" +
            "       FROM interpol.news news"),

    SELECT_NEWS_BY_ID("SELECT interpol.news.date AS date,\n" +
            "       interpol.news.ru_title AS ru_title,\n" +
            "       interpol.news.en_title AS en_title,\n" +
            "       interpol.news.default_title AS default_title,\n" +
            "       interpol.news.ru_text AS ru_text,\n" +
            "       interpol.news.en_text AS en_text,\n" +
            "       interpol.news.default_text AS default_text\n" +
            "       FROM interpol.news news\n" +
            "       WHERE news.id = ?"),

    CREATE_NEWS("insert into interpol.news (date, ru_title, ru_text, en_title, en_text, default_title, default_text) " +
            "       values (?,?,?,?,?,?,?)"),

    UPDATE_NEWS("update interpol.news set date=?, ru_title=?, ru_text=?, en_title=?, en_text=?, default_title=?, default_text=? " +
            "       where id=?"),

    DELETE_NEWS("delete from interpol.news where id=?");


    private String query;

    QueryEnum(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
