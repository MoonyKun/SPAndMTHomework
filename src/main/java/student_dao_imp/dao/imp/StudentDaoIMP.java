package student_dao_imp.dao.imp;



import student_dao_imp.connection.MysqlConnection;
import student_dao_imp.dao.StudentDAO;
import student_dao_imp.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoIMP implements StudentDAO {

    public void insert(Student s) {
        String sql = "INSERT INTO students (id, name) values (?,?)";
        //PreparedStatement 对象的 setXxx() 方法来设置这些参数. setXxx() 方法有两个参数，
        // 第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值
        PreparedStatement pstmt = null;
        MysqlConnection conn = null;

        try {
            conn = new MysqlConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,s.getId());
            pstmt.setString(2,s.getName());

            //增、删、改 用executeUpdate（）
            //返回值为int型，表示被影响的行数
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(Student s) {
        String sql="UPDATE students set name= ? where id= ?";
        PreparedStatement pstmt;
        MysqlConnection conn;
        try {
            conn=new MysqlConnection();

            pstmt=conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getName());
            pstmt.setInt(2,s.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int iD) {
        String sql="delete from students where id= ?";
        PreparedStatement pstmt;
        MysqlConnection conn;
        try {
            conn=new MysqlConnection();

            pstmt=conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,iD);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student findByID(long iD) {
        String sql="select id,name from students where id= ?";
        PreparedStatement pstmt;
        MysqlConnection conn;
        ResultSet result;
        Student stu=new Student(0,"none");
        try {
            conn=new MysqlConnection();

            pstmt=conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,iD);

            result=pstmt.executeQuery();
            while (result.next()) {
                stu = new Student(result.getInt(1), result.getString(2));
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }

    public List<Student> findAll() {
        String sql="select * from students";
        PreparedStatement pstmt;
        MysqlConnection conn;
        ResultSet result;
        List<Student> students=new ArrayList<Student>();
        try {
            conn=new MysqlConnection();

            pstmt=conn.getConnection().prepareStatement(sql);

            result=pstmt.executeQuery();
            while (result.next()){
                int id=result.getInt(1);
                String name=result.getString(2);
                Student stu=new Student(id,name);
                students.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
