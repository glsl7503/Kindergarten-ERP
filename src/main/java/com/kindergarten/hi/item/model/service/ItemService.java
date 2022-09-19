package com.kindergarten.hi.item.model.service;

import java.util.List;
import java.util.Map;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.food.controller.DeleteException;
import com.kindergarten.hi.item.model.dto.ItemDTO;

public interface ItemService {

	List<ItemDTO> selectItemList(SelectCriteria selectCriteria);

	int selectTotalCount(Map<String, String> searchMap);

	ItemDTO goitemManagementDetail(Long itemNo);

	void goItemDelete(ItemDTO item) throws DeleteException;



}
