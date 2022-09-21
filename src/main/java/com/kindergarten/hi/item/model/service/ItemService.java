package com.kindergarten.hi.item.model.service;

import java.util.List;
import java.util.Map;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.food.controller.InsertException;
import com.kindergarten.hi.food.controller.UpdateException;
import com.kindergarten.hi.food.model.dto.FoodDTO;
import com.kindergarten.hi.item.model.dto.ItemDTO;
import com.kindergarten.hi.item.model.dto.ItemManagementHisDTO;

public interface ItemService {

	List<ItemDTO> selectItemList(SelectCriteria selectCriteria);

	int selectTotalCount(Map<String, String> searchMap);

	ItemDTO goitemManagementDetail(Long itemNo);

	ItemManagementHisDTO goitemManagementHisDetail(Long itemNo);

	void goItemDelete(ItemDTO item) throws DeleteException;
	void getItemHisDelete(ItemDTO item) throws DeleteException;

	void insertItemgoods(ItemDTO item) throws InsertException;
	
	void itemUpdate(ItemDTO item) throws UpdateException;



}
