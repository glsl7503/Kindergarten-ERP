package com.kindergarten.hi.employee.model.service;

import java.util.List;
import java.util.Map;

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
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;
import com.kindergarten.hi.employee.model.dto.ManagementDTO;

public interface EmployeeService {

	int selectTotalCount(Map<String, String> searchMap);

	List<EmployeeDTO> selectEmployeeList(SelectCriteria selectCriteria);

	void employeeDelete(EmployeeDTO employee) throws employeeDeleteException;

	EmployeeDTO selectEmployeeDetail(Long no);

	void employeeUpdate(EmployeeDTO employee) throws employeeUpdateException;

	void managementRegister(ManagementDTO management) throws managementRegisterException;

	int selectTotalCount2(Map<String, String> searchMap);

	List<ManagementDTO> selectManagementList(SelectCriteria selectCriteria);

	ManagementDTO selectManagementDetail(Long no);

	void managementsubmit(ManagementDTO management) throws managementUpdateException;

	void managementUpdate(ManagementDTO management) throws managementUpdateException;

	void managementDelete(int no) throws managementDeleteException;

	List<CalenderEmployeeDTO> selectempCalenderList();

	void insertemployeeCalender(CalenderEmployeeDTO calender, int no) throws employeeCalenderException;

	void insertemployee2Calender(CalenderEmployeeDTO calender, int no) throws employeeCalenderException;

	int insertEmployee(EmployeeDTO employeeDTO, EmplAuthDTO emplAuthDTO);

	boolean selectEmployeeById(String id);

	int selectVacationTotalCountPy(Map<String, Object> searchMap);

	List<HolidayDTO> selectVacationListPy(Map<String, Object> foodMap);

	int selectVacationTotalCount(Map<String, Object> searchMap);

	List<HolidayDTO> selectVacationList(Map<String, Object> foodMap);

	void insertVacation(HolidayDTO holi) throws InsertException;

	void insertVacationEmp(int userNo) throws InsertException;

	HolidayDTO selectVacationDetail(Long no);

	void updateVacation(HolidayDTO holi) throws UpdateException;

	void deteleVacation(HolidayDTO holi) throws DeleteException;

	void detailInsertVacation(HolidayDTO holi) throws InsertException;

	void detailUpdateVacation(HolidayDTO holi) throws InsertException;

	void updateVacationPy(int no, String yN);

//	List<ManagementDTO> selectManagementList2(SelectCriteria selectCriteria, int no);



	
}
