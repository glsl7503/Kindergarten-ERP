package com.kindergarten.hi.item.model.dto;

public class ItemHisDTO {

	private int itemNo;
	private int processNo;
	
	private ItemDTO item;
	private ItemManagementHisDTO itemManagementHis;
	
	
	public ItemHisDTO() {
	
	}
	public ItemHisDTO(int itemNo, int processNo, ItemDTO item, ItemManagementHisDTO itemManagementHis) {
		super();
		this.itemNo = itemNo;
		this.processNo = processNo;
		this.item = item;
		this.itemManagementHis = itemManagementHis;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getProcessNo() {
		return processNo;
	}
	public void setProcessNo(int processNo) {
		this.processNo = processNo;
	}
	public ItemDTO getItem() {
		return item;
	}
	public void setItem(ItemDTO item) {
		this.item = item;
	}
	public ItemManagementHisDTO getItemManagementHis() {
		return itemManagementHis;
	}
	public void setItemManagementHis(ItemManagementHisDTO itemManagementHis) {
		this.itemManagementHis = itemManagementHis;
	}
	@Override
	public String toString() {
		return "ItemHisDTO [itemNo=" + itemNo + ", processNo=" + processNo + ", item=" + item + ", itemManagementHis="
				+ itemManagementHis + "]";
	}
	
	
	
	
	
}
