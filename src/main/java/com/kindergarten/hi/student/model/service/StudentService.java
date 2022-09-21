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
import com.kindergarten.hi.student.model.dto.WonParDTO;


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
	 *   원생 상세조회
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
	public void registstudent(StudentDTO student, ParentsDTO parents, Map<String, Object> hm) {

		System.out.println("student 조회" + student);

	 	// 2. 원생정보 insert하기
	 	int result = mapper.insertstudent(student);
	 	
	 	for(int i = 1; i < 7; i++) {
	 		
	 		AttendanceDTO attendance = (AttendanceDTO) hm.get("attendence" + i);
	 		System.out.println("insert attendance" + i + " = " + attendance);
	 		result = mapper.insertstudentinfor(attendance);
	 	}
	 	
		System.out.println("result =" + result);
		if (result > 0) {
			
			System.out.println("hm 조회 : " + hm);
			System.out.println("attendence1 조회 : " + hm.get("attendence1"));
			//mapper.insertSelectstudent(hm.get("attendence1"));
			
			int parenttest = 0;
			int wonClassNotest = 0;
			// 1
			ParentsDTO parent1 = (ParentsDTO) hm.get("parent1");
			int n1 = mapper.insertSelectstudentto(parent1);

			wonClassNotest = mapper.selectClassNo();
			parenttest = mapper.selectParentSelect();
			
			WonParDTO wonPar1 = new WonParDTO();
			wonPar1.setWonClassNo(wonClassNotest);
		    wonPar1.setParentsNo(parenttest);
		    int n3 = mapper.lastInsert(wonPar1);
		    
			// 2
			ParentsDTO parent2 = (ParentsDTO) hm.get("parent2");
			int n2 = mapper.insertSelectstudentto(parent2);
			System.out.println("n2" + n2);
			wonClassNotest = mapper.selectClassNo();
			parenttest = mapper.selectParentSelect();
			
			WonParDTO wonPar2 = new WonParDTO();
			wonPar2.setWonClassNo(wonClassNotest);
		    wonPar2.setParentsNo(parenttest);
		    int n4 = mapper.lastInsert(wonPar2);
			
			System.out.println("n4" + n4);
		    
		    
//		   
		}
	}
	/* 삭제 */
	@Transactional
	public void removeStudent(Long no) {
		 int result = mapper.removeStudent(no);
	        }
	
	
	/* 수정 */
	@Transactional
	public void modifyStudent(StudentDTO student, Map<String, Object> hm) {
		
		
		
		System.out.println("student 조회" + student);

	 	// 2. 원생정보 insert하기
	 	int result = mapper.modifyStudent(student);
	 	
	 	int num1 = mapper.selectStudentNum(student);
	 	int num2= num1 - 1;
	 	System.out.println("애들 출결 번호 조회 : " + num1);

	 	int classno = student.getNo();
	 	for(int i = 1; i < 7; i++) {	 		
	 		AttendanceDTO attendance = (AttendanceDTO) hm.get("attendence" + i);
	 		attendance.setClassno(classno);
	 		System.out.println("insert attendance" + i + " = " + attendance);
	 		int number = num2 + i;
	 		attendance.setNo(number);
	 		result = mapper.updatestudentinfor(attendance);
	 	}
	 	

	 	
		System.out.println("result =" + result);
		if (result > 0) {
			
			System.out.println("hm 조회 : " + hm);
			System.out.println("attendence1 조회 : " + hm.get("attendence1"));
			//mapper.insertSelectstudent(hm.get("attendence1"));
			
			// 1
			ParentsDTO parent1 = (ParentsDTO) hm.get("parent1");
			
			
			int n1 = mapper.updateSelectstudentto(parent1);
			System.out.println("n1" + n1);
		    
			// 2
			ParentsDTO parent2 = (ParentsDTO) hm.get("parent2");
			int n2 = mapper.updateSelectstudentto(parent2);
			System.out.println("n2" + n2);
	 
    	}
    }
}

	


