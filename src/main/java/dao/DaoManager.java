package dao;

import dao.impl.UserDao;

public class DaoManager {
    private DaoManager() {
    }

    public static DaoManager getInstance() {
        return DaoManager.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final DaoManager INSTANCE = new DaoManager();
    }

    public UserDao getUserDao() {
        return new UserDao();
    }


}
