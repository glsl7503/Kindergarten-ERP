package com.kindergarten.hi.item.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.item.model.dao.ItemDAO;
import com.kindergarten.hi.item.model.dto.ItemDTO;
import com.kindergarten.hi.item.model.dto.ItemManagementHisDTO;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemDAO itemDao;

	@Autowired
	public ItemServiceImpl(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<ItemDTO> selectItemList(SelectCriteria selectCriteria) {

		return itemDao.selectItemList(selectCriteria);
	}

	@Override
	public int selectTotalCount(Map<String, String> searchMap) {

		return 0;
	}

	@Override
	public ItemDTO goitemManagementDetail(Long itemNo) {

		ItemDTO result = itemDao.goItemmanageMentDetail(itemNo);

		return result;
	}

	@Override
	@Transactional
	public void goItemDelete(ItemDTO item) throws DeleteException{
		int result1 = itemDao.getItemHisDelete(item);
		int result  = itemDao.goItemDelete(item);
		System.out.println("result 조회 : " + result);
	   if(result < 1) {
		   
		   throw new DeleteException("삭제 실패!!");
	   }
		
	}

	@Override
	public ItemManagementHisDTO goitemManagementHisDetail(Long itemNo) {
		
		ItemManagementHisDTO result = itemDao.goItemmanageMentHisDetail(itemNo);

		return result;
	}

	@Override
	public void getItemHisDelete(ItemDTO item) throws DeleteException {
		// TODO Auto-generated method stub
		
	}
	



}
