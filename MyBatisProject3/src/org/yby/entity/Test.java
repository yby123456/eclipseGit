package org.yby.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.yby.mapper.StudentMapper;

public class Test {
	
	public static void queryStudentWithConverter() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentByStunoWithConverter(1);
		System.out.println(student);
		session.close();
 
	}
	
	public static void queryStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.queryStudentByStuno(1);
		System.out.println(student);
		session.close();
 
	}
	
	public static void queryStudentByStunameandstuage() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student stu = new Student();
		stu.setName("laji");
		stu.setStuAge(33);
		Student student = studentMapper.queryStudentByStunameandstuage(stu);
		System.out.println(student);
		session.close();
 
	}
	
	public static void queryStudentsWithStunosInGrade() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);	
		Grade grade = new Grade();
		List<Integer> stuNos = new ArrayList<>();
		stuNos.add(1);
		stuNos.add(3);
		stuNos.add(6);
		grade.setStuNos(stuNos);
		List<Student> students = studentMapper.queryStudentsWithStunosInGrade(grade);
		System.out.println(students);
		session.close();
 
	}
	
	public static void queryAllStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.queryAllStudent();
		System.out.println(students);
		session.close();

	}
	
	public static void queryStudentByNoWithOTO() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		StudentBusiness studentBusiness = studentMapper.queryStudentByNoWithOTO(2);
		System.out.println(studentBusiness);
		session.close();

	}
	
	public static void queryStudentByAddress() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Address address = new Address();
		address.setHomeAddress("huaiji");
		address.setSchoolAddress("shanghai");
		Student student = new Student();
		student.setAddress(address);
		List<Student> students = studentMapper.queryStudentByAddress(student);
		System.out.println(students);
		session.close();

	}
	public static void queryCountByGranameWithProcedure() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Map<String,Object> params = new HashMap<>();
		params.put("gName", "g1");
		studentMapper.queryCountByGranameWithProcedure(params);
		Object count = params.get("scount");
		System.out.println(count);
		session.close();

	}
	
	
	public static void queryStudentByStuageOrStuNameWithHashMap() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Map<String,Object> studentMap = new HashMap();
		studentMap.put("stuAge", 33);
		studentMap.put("name", "zs");
		List<Student> students = studentMapper.queryStudentByStuageOrStuNameWithHashMap(studentMap);
		System.out.println(students);
		session.close();

	}
	
	public static void addStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = new Student(6,"wb",29,"g2");
		studentMapper.insertStudent(student);
		session.commit();
		System.out.println("增加成功");
		session.close();

	}
	public static void addStudentWithConverter() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = new Student(64,"dsj",22,"g10");
		student.setStuSex(true);
		studentMapper.insertStudentWithConverter(student);
		session.commit();
		System.out.println("增加成功");
		session.close();

	}
	
	public static void deleteStudentByStuno() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.deleteStudentByStuno(4);
		session.commit();
		session.close();

	}
	
	public static void deleteStudentByStunoWithProcedure() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Map<String,Object> deleteMap = new HashMap<>();
		deleteMap.put("sno", 29);
		studentMapper.deleteStudentByStunoWithProcedure(deleteMap);
		System.out.println("调用存储过程删除成功");
		session.commit();
		session.close();

	}
	
	public static void updateStudent() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = new Student(); 
		student.setStuNo(3);
		student.setName("laji");
		student.setStuAge(33);
		student.setGraName("oo");
		studentMapper.updateStudent(student);
		session.commit();
		System.out.println("更改成功");
		session.close();

	}
	public static void main(String[] args) throws IOException {
//		queryStudent();
//		 addStudent();
//		 deleteStudentByStuno();
//		updateStudent(); 
//		queryAllStudent();
//		queryStudentWithConverter();
//		addStudentWithConverter();
//		queryStudentByAddress();
//		queryStudentByStuageOrStuNameWithHashMap();
//		queryCountByGranameWithProcedure();
//		deleteStudentByStunoWithProcedure();
//		queryStudentByStunameandstuage();
//		queryStudentsWithStunosInGrade();
		queryStudentByNoWithOTO();
	}
}
