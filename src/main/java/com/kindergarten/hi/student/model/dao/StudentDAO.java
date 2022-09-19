package com.kindergarten.hi.student.model.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.Mapper;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.student.model.dto.AttendanceDTO;
import com.kindergarten.hi.student.model.dto.ClassDTO;
import com.kindergarten.hi.student.model.dto.Employee1DTO;
import com.kindergarten.hi.student.model.dto.ParentsDTO;
import com.kindergarten.hi.student.model.dto.StudentDTO;

@Mapper
public interface StudentDAO {

	int selectTotalCount(Map<String, String> searchMap);

	List<StudentDTO> selectAllStudentListt(SelectCriteria selectCriteria);

	StudentDTO incrementStudentCount(Long no);

	List<StudentDTO> selectChStudentDetail(Long no);

	List<StudentDTO> selectAdStudentDetail(Long no);	

	int insertstudent(StudentDTO student);	

	int insertSelectstudentto(ParentsDTO parents);

	Employee1DTO selectEmployee(int empNo);

	StudentDTO selectStudentinforDetail(Long no);

	int insertstudentinfor(AttendanceDTO attendance);

	ClassDTO selectClassname(String name);

	int removeStudent(Long no);

	int modifyStudent(StudentDTO student);

	


}
