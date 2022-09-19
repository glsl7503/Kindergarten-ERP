package com.kindergarten.hi.employee.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.employee.model.dto.CalenderEmployeeDTO;
import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.employee.model.dto.HolidayDTO;
import com.kindergarten.hi.employee.model.dto.ManagementDTO;

@Mapper
public interface EmployeeDAO {

	int selectTotalCount(Map<String, String> searchMap);

	List<EmployeeDTO> selectEmployeeList(SelectCriteria selectCriteria);
	
	int insertEmployee(EmployeeDTO employeeDTO);

	String selectEmployeeById(String id);

	int deleteEmployee(EmployeeDTO employee);

	List<ManagementDTO> selectManagementList(SelectCriteria selectCriteria);

	int deletemanagement(int no);

	int selectTotalCount2(Map<String, String> searchMap);

	EmployeeDTO selectEmployeeDetail(Long no);

	ManagementDTO selectManagementDetail(Long no);
	
	int managementRegister(ManagementDTO management);

	int managementUpdate(ManagementDTO management);

	int managementsubmit(ManagementDTO management);

	int insertInSelectEmployee(EmplAuthDTO emplAuthDTO);

	int insertVacation(HolidayDTO holi);

	int selectVacationTotalCount(Map<String, Object> searchMap);

	int insertVacationEmp(int userNo);
	
	List<CalenderEmployeeDTO> selectempCalenderList();

	HolidayDTO selectVacationDetail(Long no);

	int updateVacation(HolidayDTO holi);

	int deteleVacation(HolidayDTO holi);

	int detailInsertVacation(HolidayDTO holi);

	List<HolidayDTO> selectVacationList(Map<String, Object> foodMap);

	int selectVacationTotalCountPy(Map<String, Object> searchMap);

	List<HolidayDTO> selectVacationListPy(Map<String, Object> foodMap);

	void updateVacationPy(@Param("no")int no, @Param("yN")String yN);

	int detailUpdateVacation(HolidayDTO holi);

	int insertemployeeCalender(CalenderEmployeeDTO calender, int no);

	int insertemployee2Calender(CalenderEmployeeDTO calender, int no);

	int employeeUpdate(EmployeeDTO employee);



}
 