package student_dao_imp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    //数据库驱动器
    private final String DBDriver="com.mysql.cj.jdbc.Driver";
    //url=jdbc:mysql://127.0.0.1:3306/数据库名,jdbc:mysql:是一个规范，必须遵守。
    private final String DBURL="jdbc:mysql://localhost:3306/student";
    private final String DBUSER="root";
    private final String DBPASSWORD="fame0815";
    private Connection conn = null;

    public MysqlConnection(){
        try {
            Class.forName(DBDriver);
            conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.conn; }

    public void close() throws SQLException {
        this.conn.close(); }
}
