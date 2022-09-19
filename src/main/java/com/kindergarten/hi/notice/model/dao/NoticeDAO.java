package com.kindergarten.hi.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.notice.model.dto.NoticeDTO;

@Mapper
public interface NoticeDAO {

	int selectTotalCount(Map<String, String> searchMap);

	List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

	int registNotice(NoticeDTO noticeDTO);

	NoticeDTO selectNoticeDetail(Long no);

	int updateNotice(NoticeDTO noticeDTO);

	int deleteNotice(int no);

	int incrementNoticeCount(Long no);

}
