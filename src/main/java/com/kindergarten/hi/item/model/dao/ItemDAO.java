package com.kindergarten.hi.item.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.item.model.dto.ItemDTO;
import com.kindergarten.hi.item.model.dto.ItemManagementHisDTO;

@Mapper
public interface ItemDAO {	

	List<ItemDTO> selectItemList(SelectCriteria selectCriteria);
	
	int selectTotalCount(Map<String, String> searchMap);
	
	ItemDTO goItemmanageMentDetail(Long itemNo);

	int goItemDelete(ItemDTO item);

	ItemManagementHisDTO goItemmanageMentHisDetail(Long itemNo);


	int getItemHisDelete(ItemDTO item);

	int insertItemgoods(ItemDTO item);

	int itemUpdate(ItemDTO item);
	
}
