package student_dao_imp.dao;

import student_dao_imp.entity.Student;
import java.util.List;

public interface StudentDAO {
    public void insert(Student s);
    public void update(Student s);
    public void delete(int iD);
    public Student findByID(long iD);
    public List<Student> findAll();

}
