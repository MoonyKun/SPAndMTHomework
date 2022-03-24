package student_dao_imp;

import student_dao_imp.dao.StudentDAO;
import student_dao_imp.dao.imp.StudentDaoIMP;
import student_dao_imp.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {
    public static void main(String[] args){
        StudentDAO studentDAO=new StudentDaoIMP();
        Student student=new Student(1,"yy");
        studentDAO.update(student);
        List<Student> students=new ArrayList<Student>();
        students=studentDAO.findAll();
        System.out.println(students.size());
    }
}
