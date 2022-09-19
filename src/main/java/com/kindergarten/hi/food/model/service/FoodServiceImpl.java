package com.kindergarten.hi.food.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;
import com.kindergarten.hi.food.model.dao.FoodDAO;
import com.kindergarten.hi.food.model.dto.CalenderDTO;
import com.kindergarten.hi.food.model.dto.FoodDTO;
import com.kindergarten.hi.food.model.dto.FoodEmployeeDTO;
import com.kindergarten.hi.food.model.dto.TraderDTO;


@Service
public class FoodServiceImpl implements FoodService{

	private final FoodDAO foodDao;
	
	@Autowired
	public FoodServiceImpl(FoodDAO foodDao) {
		this.foodDao = foodDao;
	}
 	
	// 음식품목 재고 리스트 조회!
	@Override
	public List<FoodDTO> selectFoodStockList(SelectCriteria selectCriteria) {
		
		List<FoodDTO> foodList = foodDao.selectFoodStockList(selectCriteria);
		
		return foodList;
	}

	/* 음식품목 등록 메소드 */
	@Override
	@Transactional
	public void insertFoodStock(FoodDTO food) throws InsertException{
		
		System.out.println("서비스 까지는 들고오네 : " + food);
		
		int result = foodDao.insertFoodStock(food);
		
		if(!(result > 0)) {
			throw new InsertException("게시글 등록에 실패하셨습니다.");
		}
		
	}

	/* 해당 게시글 전체 개수 조회 메소드 */
	@Override
	public int selectTotalCount(Map<String, String> searchMap) {

        int result = foodDao.selectTotalCount(searchMap);

        return result;    
	}

	/* 음식품목 상세조회 메소드  */
	@Override
	public FoodDTO selectStockDetail(Long no) {
		
		FoodDTO foodDetail = foodDao.selectStockDetail(no);
		
		return foodDetail;
	}

	/* 음식품목 수정하기 메소드 */
	@Override
	@Transactional
	public void updateStock(FoodDTO food) throws UpdateException{
		
	    int result = foodDao.updateStock(food);

        if(!(result > 0)) {
            throw new UpdateException("게시글 수정에 실패하셨습니다.");
        }
		
		
	}

	/* 음식품목 삭제하기 메소드 */
	@Override
	@Transactional
	public void deleteStock(FoodDTO food) throws DeleteException{

		int result = foodDao.deleteStock(food);
		
		  if(!(result > 0)) {
	            throw new DeleteException("게시글 삭제에 실패하셨습니다.");
	        }
		
	}

	
	// 거래업체 전체 개수 조회 메소드
	@Override
	public int selectTraderTotalCount(Map<String, String> searchMap) {

		int result = foodDao.selectTraderTotalCount(searchMap);

        return result;    
		
	}

	/* 거래업체 조회 메소드 */
	@Override
	public List<TraderDTO> selectTraderList(SelectCriteria selectCriteria) {
		
		System.out.println("여기까지는 확인");
		List<TraderDTO> traderList = foodDao.selectTraderList(selectCriteria);
		
		return traderList;
	}

	/* 거래업체 등록하기 메소드 */
	@Override
	@Transactional
	public void insertTrader(TraderDTO trader) throws InsertException {

		System.out.println("서비스 TraderDTO 들어오는거 확인 : " + trader);
		
		int result = foodDao.insertTrader(trader);
		
		if(!(result > 0)) {
			throw new InsertException("게시글 추가에 실패하셨습니다.");
		}

	}
	
	/* 거래업체 상세페이지 조회 메소드 */
	@Override
	public TraderDTO selectTraderDetail(Long no) {

		TraderDTO trader = foodDao.selectTraderDetail(no);
		
		return trader;
	}

	/* 거래업체 수정하기 메소드 */
	@Override
	@Transactional
	public void updateTrader(TraderDTO trader) throws UpdateException {
		
		System.out.println("서비스 까지 들어옴 : " + trader);
		
		int result = foodDao.updateTrader(trader);
		
		if(!(result > 0)) {
			throw new UpdateException("게시글 수정에 실패하셨습니다.");
		}
		
	}

	/* 거래업체 삭제하기 메소드 */
	@Override
	@Transactional
	public void deleteTrader(TraderDTO trader) throws DeleteException {

		int result = foodDao.deleteTrader(trader);
		
		if(!(result > 0)) {
			throw new DeleteException("게시글 삭제에 실패하셨습니다.");
		}
	}

	
	// 식단표 조회하기 메소드
	@Override
	public List<CalenderDTO> selectCalenderList() {

		System.out.println("서비스 까지 들어오는거 확인");
		List<CalenderDTO> calenderList = foodDao.selectCalenderList();
		return calenderList;
	}

	/* 식단표 추가하기 메소드 */
	@Override
	@Transactional
	public void insertCalender(CalenderDTO calender) throws InsertException{

		System.out.println("서비스 TraderDTO 들어오는거 확인 : " + calender);
		
		int result = foodDao.insertCalender(calender);
		
		if(!(result > 0)) {
			throw new InsertException("식단표 추가에 실패하셨습니다.");
		}
	}

	/* 식단표 수정하기 메소드 */
	@Override
	@Transactional
	public void updateCalender(CalenderDTO calender) throws UpdateException{
		
		int result = foodDao.updateCalender(calender);
		
		if(!(result > 0)) {
			throw new UpdateException("식단표 수정에 실패하셨습니다.");
		}
	}

	/* 식단표 삭제하기 메소드 */
	@Override
	@Transactional
	public void deleteCalender(CalenderDTO calender) throws DeleteException {

		int result = foodDao.deleteCalender(calender);
		
		if(!(result > 0)) {
			throw new DeleteException("식단표 삭제에 실패하셨습니다.");
		}
	}

	/* 식단표 카테고리 조회 메소드 */
	@Override
	public List<FoodEmployeeDTO> calenderCategoryEmp() {
		
		List<FoodEmployeeDTO> empList = foodDao.calenderCategoryEmp();
		
		return empList;
	}

}
