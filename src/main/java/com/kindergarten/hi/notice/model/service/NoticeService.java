package com.kindergarten.hi.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.notice.model.dao.NoticeDAO;
import com.kindergarten.hi.notice.model.dto.NoticeDTO;

public interface NoticeService {

	int selectTotalCount(Map<String, String> searchMap);

	List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

	int registNotice(NoticeDTO noticeDTO);

	NoticeDTO selectNoticeDetail(Long no);

	int updateNotice(NoticeDTO noticeDTO);

	int deleteNotice(int no);
}
