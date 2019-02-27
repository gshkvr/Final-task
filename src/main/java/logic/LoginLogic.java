package logic;

import org.mindrot.jbcrypt.BCrypt;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "$2a$10$5cXbc/vvmRXhp1fAyoK4C.rh9GeGD36qHtChfxzMlkMSarTqMHxvq";
    public static boolean checkLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && BCrypt.checkpw(enterPass, ADMIN_PASS);
    }

//    public void doLogic(int id) throws SQLException {
//// 1. создание-получение соединения
//        Connection conn = ConnectionPool.getConnection();
//// 2. открытие транзакции
//        conn.setAutoCommit(false);
//// 3. инициализация необходимых экземпляров DAO
//        AbonentDAO abonentDAO = new AbonentDAO(conn);
//        PaymentDAO paymentDAO = new PaymentDAO(conn);
//// 4. выполнение запросов
//        abonentDAO.findAll();
//        paymentDAO.findEntityById(id);
//        paymentDAO.delete(id);
//// 5. закрытие транзакции
//        conn.commit();
//// 6. закрытие-возвращение соединения
//        conn.setAutoCommit(true);
//        ConnectionPool.close(conn);
//    }
}
