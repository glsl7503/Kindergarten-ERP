package com.kindergarten.hi.food.model.service;

import java.util.List;
import java.util.Map;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;
import com.kindergarten.hi.food.model.dto.CalenderDTO;
import com.kindergarten.hi.food.model.dto.FoodDTO;
import com.kindergarten.hi.food.model.dto.FoodEmployeeDTO;
import com.kindergarten.hi.food.model.dto.TraderDTO;

public interface FoodService {

	List<FoodDTO> selectFoodStockList(SelectCriteria selectCriteria);

	void insertFoodStock(FoodDTO food) throws InsertException;

	int selectTotalCount(Map<String, String> searchMap);

	FoodDTO selectStockDetail(Long no);

	void updateStock(FoodDTO food) throws UpdateException;

	void deleteStock(FoodDTO food) throws DeleteException;

	int selectTraderTotalCount(Map<String, String> searchMap);

	List<TraderDTO> selectTraderList(SelectCriteria selectCriteria);

	void insertTrader(TraderDTO trader) throws InsertException;

	TraderDTO selectTraderDetail(Long no);

	void updateTrader(TraderDTO trader) throws UpdateException;

	void deleteTrader(TraderDTO trader) throws DeleteException;

	List<CalenderDTO> selectCalenderList();

	void insertCalender(CalenderDTO calender) throws InsertException;

	void updateCalender(CalenderDTO calender) throws UpdateException;

	void deleteCalender(CalenderDTO calender) throws DeleteException;

	List<FoodEmployeeDTO> calenderCategoryEmp();
}