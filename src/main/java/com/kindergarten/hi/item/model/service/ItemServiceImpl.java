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
		
		int result  = itemDao.goItemDelete(item);
		System.out.println("result 조회 : " + result);
	   if(result < 1) {
		   
		   throw new DeleteException("삭제 실패!!");
	   }
		
	}
	



}
