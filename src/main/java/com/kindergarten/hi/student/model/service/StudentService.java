package com.kindergarten.hi.student.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.student.model.dao.StudentDAO;
import com.kindergarten.hi.student.model.dto.AttendanceDTO;
import com.kindergarten.hi.student.model.dto.ParentsDTO;
import com.kindergarten.hi.student.model.dto.StudentDTO;


@Service
public class StudentService {

	private final StudentDAO mapper;
    @Autowired
	public StudentService(StudentDAO mapper) {
		this.mapper = mapper;
	}

	/* 해당 게시글 전체 갯수 조회용 메소드 */
	public int selectTotalCount(Map<String, String> searchMap) {

		int result = mapper.selectTotalCount(searchMap);
		return result;
	}

	/* 죄회용 메소드 */
	public List<StudentDTO> selectAllStudentListt(SelectCriteria selectCriteria) {

		List<StudentDTO> studentList = mapper.selectAllStudentListt(selectCriteria);
		System.out.println("studentList 조회 : " + studentList);
		return studentList;
	}

	/**
	 * <pre>
	 *   원생 상세조
	 * </pre>
	 * 
	 * @param no
	 * @return
	 */
	public StudentDTO selectStudentDetail(Long no) {
		StudentDTO studentDetail = null;

		studentDetail = mapper.incrementStudentCount(no);
		System.out.println("studentDetail 조회 : " + studentDetail);
		return studentDetail;
	}

	public List<StudentDTO> selectChStudentDetail(Long no) {

		List<StudentDTO> choice = mapper.selectChStudentDetail(no);
		return choice;
	}

	public List<StudentDTO> selectAdStudentDetail(Long no) {

		List<StudentDTO> attendance = mapper.selectAdStudentDetail(no);
		return attendance;
	}
	public StudentDTO selectStudentinforDetail(Long no) {
		StudentDTO studentinforDetail = null;

		studentinforDetail = mapper.selectStudentinforDetail(no);
		System.out.println("studentinforDetail 조회 : " + studentinforDetail);
		return studentinforDetail;
		
	}

	/* 공지사항 등록 */
	@Transactional
	public int registstudent(StudentDTO student, ParentsDTO parents, Map<String, Object> hm) {

		System.out.println("student 조회" + student);
		
		String name = student.getClassDTO().getName();
		
		System.out.println("name: " + name);
		
		System.out.println("no1 =" + student);
	 	student.setClassDTO(mapper.selectClassname(name));
	 	System.out.println("no2 =" + student);
	 	// 2. 원생정보 insert하기
	 	int result = mapper.insertstudent(student);
	 	
	 	for(int i = 1; i < 7; i++) {
	 		
	 		AttendanceDTO attendance = (AttendanceDTO) hm.get("attendence" + i);
	 		System.out.println("insert attendance" + i + " = " + attendance);
	 		result = mapper.insertstudentinfor(attendance);
	 	}
	 	
//	 	Employee1DTO employee = mapper.selectEmployee(student.getEmpNo());
//	 	System.out.println("employee =" + employee);
//	 	student.setEmployee(employee);
//	 	System.out.println("no3 =" + student);
	 	
		
		System.out.println("result =" + result);
		if (result > 0) {
			
			System.out.println("hm 조회 : " + hm);
			System.out.println("attendence1 조회 : " + hm.get("attendence1"));
			//mapper.insertSelectstudent(hm.get("attendence1"));
			mapper.insertSelectstudentto(parents);

		}
		return result;

	}
	/* 삭제 */
	@Transactional
	public void removeStudent(Long no) {
		 int result = mapper.removeStudent(no);
	        }
	/* 수정 */
	@Transactional
	public int modifyStudent(StudentDTO student) {
		 int result = mapper.modifyStudent(student);
		 
		return result;

//	        if(!(result > 0)) {
//	            throw new NoticeModifyException("공지사항 수정에 실패하셨습니다.");
//	        }		
	}
}

	


