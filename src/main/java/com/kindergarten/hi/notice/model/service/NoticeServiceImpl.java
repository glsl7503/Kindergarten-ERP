package com.kindergarten.hi.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.notice.model.dao.NoticeDAO;
import com.kindergarten.hi.notice.model.dto.NoticeDTO;

@Service
public class NoticeServiceImpl implements NoticeService {

	private final NoticeDAO noticeDAO;

	@Autowired
	public NoticeServiceImpl(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	/* 해당 게시글 전체 갯수 조회용 메소드 */
	@Override
	public int selectTotalCount(Map<String, String> searchMap) {
		
		int result = noticeDAO.selectTotalCount(searchMap);
		
		return result;
	}

	@Override
	public List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria) {
		
		List<NoticeDTO> noticeList = noticeDAO.selectNoticeList(selectCriteria);

        return noticeList;
	}

	@Override
	@Transactional
	public int registNotice(NoticeDTO noticeDTO) {
		
		int result = noticeDAO.registNotice(noticeDTO);
		
		return result;
	}

	@Override
	@Transactional
	public NoticeDTO selectNoticeDetail(Long no) {
		NoticeDTO noticeDetail = null;
//		int result = noticeDAO.incrementNoticeCount(no);
		
//		if(result > 0) {
		noticeDetail = noticeDAO.selectNoticeDetail(no);
//		}
		return noticeDetail;
	}

	@Override
	@Transactional
	public int updateNotice(NoticeDTO noticeDTO) {
		
		int result = noticeDAO.updateNotice(noticeDTO);
		
		return result;
	}

	@Override
	@Transactional
	public int deleteNotice(int no) {
		
		int result = noticeDAO.deleteNotice(no);
		
		return result;
	}
	
}
