package org.yby.mapper;

import java.util.List;
import java.util.Map;

import org.yby.entity.Address;
import org.yby.entity.Grade;
import org.yby.entity.Student;
import org.yby.entity.StudentBusiness;

public interface StudentMapper {
	
	Student queryStudentByStuno(int stuno);
	void insertStudent(Student student);
	List<Student> queryAllStudent();
	void deleteStudentByStuno(int stuno);
	void updateStudent(Student student);
	Student queryStudentByStunoWithConverter(int stuno);
	void insertStudentWithConverter(Student student);
//	List<Student> queryStudentByAddress(Address address);
	List<Student> queryStudentByAddress(Student address);
	List<Student> queryStudentByStuageOrStuNameWithHashMap(Map<String,Object> map);
	void queryCountByGranameWithProcedure(Map<String,Object> params);
	void deleteStudentByStunoWithProcedure(Map<String,Object> map);
	Student queryStudentByStunameandstuage(Student student);
	List<Student> queryStudentsWithStunosInGrade(Grade grade);
	StudentBusiness queryStudentByNoWithOTO(int stuno);
}
