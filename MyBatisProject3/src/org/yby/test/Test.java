package org.yby.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.yby.entity.Student;


//diyici
//ciyidi
public class Test {
	
	public static void queryStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "org.yby.entity.studentMapper.queryStudentByStuno";
		Student student = session.selectOne(statement,1);
		System.out.println(student);
		session.close();

	}
	public static void queryAllStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "org.yby.entity.studentMapper."+"queryAllStudent";
		List<Student> students = session.selectList(statement);
		System.out.println(students);
		session.close();

	}
	public static void addStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "org.yby.entity.studentMapper."+"insertStudent";
		Student student = new Student(4,"ww",25,"g1"); 
		int count = session.insert(statement, student);
		session.commit();
		System.out.println("增加"+count+"个学生");
		session.close();

	}
	public static void deleteStudentByStuno() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "org.yby.entity.studentMapper."+"deleteStudentByStuno";
		int count = session.delete(statement,2);
		session.commit();
		System.out.println("删除"+count+"个学生");
		session.close();

	}
	public static void updateStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		String statement = "org.yby.entity.studentMapper."+"updateStudent";
		Student student = new Student(); 
		student.setStuNo(3);
		student.setName("laji");
		student.setStuAge(33);
		student.setGraName("h4");
		int count = session.update(statement,student);
		session.commit();
		System.out.println("更改"+count+"个学生");
		session.close();

	}
	public static void main(String[] args) throws IOException {
		queryAllStudent();
		// addStudent();
		// deleteStudentByStuno();
//		updateStudent();
//		queryAllStudent();
	}
}
