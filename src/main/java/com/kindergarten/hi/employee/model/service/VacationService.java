package com.kindergarten.hi.employee.model.service;

import java.util.List;
import java.util.Map;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.student.model.dto.StudentDTO;

public interface VacationService {

	int selectTotalCount(Map<String, String> searchMap);

	List<StudentDTO> selectAllStudentListt(SelectCriteria selectCriteria);

}
