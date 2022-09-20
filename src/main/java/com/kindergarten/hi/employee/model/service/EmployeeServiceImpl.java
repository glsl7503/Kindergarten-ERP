package com.kindergarten.hi.employee.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.employee.controller.employeeCalenderException;
import com.kindergarten.hi.employee.controller.employeeDeleteException;
import com.kindergarten.hi.employee.controller.employeeUpdateException;
import com.kindergarten.hi.employee.controller.managementDeleteException;
import com.kindergarten.hi.employee.controller.managementRegisterException;
import com.kindergarten.hi.employee.controller.managementUpdateException;
import com.kindergarten.hi.employee.model.dao.EmployeeDAO;
import com.kindergarten.hi.employee.model.dto.CalenderEmployeeDTO;
import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.employee.model.dto.HolidayDTO;
import com.kindergarten.hi.employee.model.dto.ManagementDTO;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;

@Service
public class EmployeeServiceImpl implements EmployeeService	 {

	private final PasswordEncoder passwordEncoder;
	
	private final EmployeeDAO employeedao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeedao, PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder = passwordEncoder;
		this.employeedao = employeedao;
		
	}
	
	@Override
	public List<EmployeeDTO> selectEmployeeList(SelectCriteria selectCriteria) {
		List<EmployeeDTO> employeeList = employeedao.selectEmployeeList(selectCriteria);	
		return employeeList;
	}

	@Override
	public int selectTotalCount(Map<String, String> searchMap) {
		int result = employeedao.selectTotalCount(searchMap);
		return result;
	}

	@Override
	@Transactional
	public int insertEmployee(EmployeeDTO employeeDTO, EmplAuthDTO emplAuthDTO) {

//		int result = employeeDao.insertEmployee(employeeDTO, value);
		System.out.println(employeeDTO);
		System.out.println(emplAuthDTO);
		int result = 0;
		result = employeedao.insertEmployee(employeeDTO);
		if(result > 0) {
			employeedao.insertInSelectEmployee(emplAuthDTO);
		}
		
		
//		if(!(result > 0 )) {
//			throw new EmployeeRegistException("회원 가입에 실패였습니다.");
//		}
		
		return result;
	}

	@Override
	public boolean selectEmployeeById(String id) {
		
		String result = employeedao.selectEmployeeById(id);

        return result != null? true : false;
	}
	
	@Override
	@Transactional
	public void employeeDelete(EmployeeDTO employee) throws employeeDeleteException {
		
		int result = employeedao.deleteEmployee(employee);
		
		if(!(result>0)) {
			throw new employeeDeleteException("회원정보가 삭제되었습니다 ! ");
		}
	}
	
	@Override
	@Transactional
	public void employeeUpdate(EmployeeDTO employee) throws employeeUpdateException {
		int result = employeedao.employeeUpdate(employee);
		
		 if(!(result > 0)) {
	            throw new employeeUpdateException("회원정보가 수정되었습니다 ! ");
		 }
		
	}

	/* 휴가관리 토탈 카운트 조회 메소드 */
	@Override
	public int selectVacationTotalCount(Map<String, Object> searchMap) {


        int result = employeedao.selectVacationTotalCount(searchMap);

        return result;    
	}
	
	@Override
	public List<HolidayDTO> selectVacationList(Map<String, Object> foodMap) {
		
		List<HolidayDTO> empList = employeedao.selectVacationList(foodMap);
		
		return empList;
	
	}

	@Override
	@Transactional
	public void insertVacation(HolidayDTO holi) throws InsertException{

		System.out.println("서비스 까지는 들고오네 : " + holi);
		
		int result = employeedao.insertVacation(holi);
		
		if(!(result > 0)) {
			throw new InsertException("게시글 등록에 실패하셨습니다.");
		}
	}

	@Override
	public HolidayDTO selectVacationDetail(Long no) {
		
		HolidayDTO holiDetail = employeedao.selectVacationDetail(no);
		
		return holiDetail;
	}
	
	@Override
	@Transactional
	public void updateVacation(HolidayDTO holi) throws UpdateException{
		  int result = employeedao.updateVacation(holi);

	        if(!(result > 0)) {
	            throw new UpdateException("게시글 수정에 실패하셨습니다.");
	        }
	}
	
	@Override
	@Transactional
	public void deteleVacation(HolidayDTO holi) throws DeleteException{
		
		  int result = employeedao.deteleVacation(holi);

	        if(!(result > 0)) {
	        	
	            throw new DeleteException("게시글 수정에 실패하셨습니다.");
	        }
	}
	
	@Override
	@Transactional
	public void detailInsertVacation(HolidayDTO holi) throws InsertException{

		  int result = employeedao.detailInsertVacation(holi);

	        if(!(result > 0)) {
	        	
	            throw new InsertException("게시글 제출에 실패하셨습니다.");
	        }
	}

	
	
	
	@Override
	public EmployeeDTO selectEmployeeDetail(Long no) {

		EmployeeDTO employeeDetail = employeedao.selectEmployeeDetail(no);
		
		return employeeDetail;
	}

	@Override
	public List<ManagementDTO> selectManagementList(SelectCriteria selectCriteria,String userNo) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("selectCriteria", selectCriteria);
		map.put("userNo", userNo);
		
		System.out.println("map check : " + map);
		List<ManagementDTO> managementList = employeedao.selectManagementList(map);
		return managementList;
	}
	
//	@Override
//	public List<ManagementDTO> selectManagementList2(SelectCriteria selectCriteria,int no) {
//		List<ManagementDTO> managementList = employeedao.selectManagementList2(selectCriteria, no);
//		return managementList;
//	}

	@Override
	@Transactional
	public void managementRegister(ManagementDTO management) throws managementRegisterException {
		
		int result = employeedao.managementRegister(management);
		
		if(!(result>0)) {
			throw new managementRegisterException("근태등록에 실패하셨습니다.");
		}			
	}

	@Override
	@Transactional
	public void managementDelete(int no) throws managementDeleteException {
		
		int result = employeedao.deletemanagement(no);
		
		if(!(result>0)) {
			throw new managementDeleteException("근태정보가 삭제되었습니다 ! ");
		}
		
	}

	@Override
	public int selectTotalCount2(Map<String, String> searchMap) {
		
		System.out.println(searchMap);
		int result = employeedao.selectTotalCount2(searchMap);
		return result;
	}

	@Override
	public ManagementDTO selectManagementDetail(Long no) {
		
		ManagementDTO managementDetail = employeedao.selectManagementDetail(no);
		
		return managementDetail;
	}

	@Override
	@Transactional
	public void managementUpdate(ManagementDTO management) throws managementUpdateException {
		
		int result = employeedao.managementUpdate(management);
		
		 if(!(result > 0)) {
	            throw new managementUpdateException("게시글 수정에 실패하셨습니다.");
		 }
}
	
	@Override
	@Transactional
	public void managementsubmit(ManagementDTO management) throws managementUpdateException {
		
		int result = employeedao.managementsubmit(management);
		
		 if(!(result > 0)) {
	            throw new managementUpdateException("제출에 실패하셨습니다.");
		 }
	}

	@Override
	public List<CalenderEmployeeDTO> selectempCalenderList() {
		
		List<CalenderEmployeeDTO> empcalList = employeedao.selectempCalenderList();
		return empcalList;
	}

	@Override
	@Transactional
	public void insertVacationEmp(int userNo) throws InsertException{
		
		int result = employeedao.insertVacationEmp(userNo);
		
		if(!(result > 0)) {
			throw new InsertException("게시글 등록에 실패하셨습니다.");
		}
		
	}

	@Override
	public int selectVacationTotalCountPy(Map<String, Object> searchMap) {

        int result = employeedao.selectVacationTotalCountPy(searchMap);

        return result;  
	}

	@Override
	public List<HolidayDTO> selectVacationListPy(Map<String, Object> foodMap) {
		List<HolidayDTO> empList = employeedao.selectVacationListPy(foodMap);
		
		return empList;	
	}
	
	@Override
	@Transactional
	public void updateVacationPy(int no, String yN) {
		
		employeedao.updateVacationPy(no,yN);
		
	}

	/*  제출 여부 Y 로 업데이트 해주는 메소드 */
	@Override
	@Transactional
	public void detailUpdateVacation(HolidayDTO holi) throws InsertException{
		
		int result = employeedao.detailUpdateVacation(holi);
		
		if(!(result > 0)) {
			throw new InsertException("게시글 등록에 실패하셨습니다.");
		}
	}

	@Override
	public void insertemployeeCalender(CalenderEmployeeDTO calender, int no) throws employeeCalenderException {
		
		int result = employeedao.insertemployeeCalender(calender, no);
				
		if(!(result>0)) {
			throw new employeeCalenderException();
		}
	}
	@Override
	@Transactional
	public void insertemployee2Calender(CalenderEmployeeDTO calender,int no) throws employeeCalenderException {
		
		int result = employeedao.insertemployee2Calender(calender, no);
		
		if(!(result>0)) {
			throw new employeeCalenderException();
		}
		
	}

	
}
