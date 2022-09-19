//package com.kindergarten.hi.employee.model.service;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import com.kindergarten.hi.common.paging.SelectCriteria;
//import com.kindergarten.hi.employee.model.dao.VacationServiceDAO;
//import com.kindergarten.hi.student.model.dto.StudentDTO;
//
//@Service
//public class VacationServiceImp implements VacationService {
//	
//	private final VacationServiceDAO mapper;
//	
//	public VacationServiceImp(VacationServiceDAO mapper) {
//		this.mapper = mapper;
//	}
//
//	@Override
//	public int selectTotalCount(Map<String, String> searchMap) {
//
//		return mapper.selectTotalCount(searchMap);
//	}
//
//	@Override
//	public List<StudentDTO> selectAllStudentListt(SelectCriteria selectCriteria) {
//		
//		return mapper.selectAllStudentListt(selectCriteria);
//	}
//}
