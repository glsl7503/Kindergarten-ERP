package com.kindergarten.hi.food.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.model.dto.CalenderDTO;
import com.kindergarten.hi.food.model.dto.FoodDTO;
import com.kindergarten.hi.food.model.dto.FoodEmployeeDTO;
import com.kindergarten.hi.food.model.dto.TraderDTO;

@Mapper
public interface FoodDAO {

	List<FoodDTO> selectFoodStockList(SelectCriteria selectCriteria);

	int insertFoodStock(FoodDTO food);

	int selectTotalCount(Map<String, String> searchMap);

	FoodDTO selectStockDetail(Long no);

	int updateStock(FoodDTO food);

	int deleteStock(FoodDTO food);

	int selectTraderTotalCount(Map<String, String> searchMap);

	List<TraderDTO> selectTraderList(SelectCriteria selectCriteria);

	int insertTrader(TraderDTO trader);

	TraderDTO selectTraderDetail(Long no);

	int updateTrader(TraderDTO trader);

	int deleteTrader(TraderDTO trader);

	List<CalenderDTO> selectCalenderList();

	int insertCalender(CalenderDTO calender);

	int updateCalender(CalenderDTO calender);

	int deleteCalender(CalenderDTO calender);

	List<FoodEmployeeDTO> calenderCategoryEmp();

}
