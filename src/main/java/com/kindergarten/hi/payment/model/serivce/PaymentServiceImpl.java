package com.kindergarten.hi.payment.model.serivce;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.payment.model.dao.PaymentDAO;
import com.kindergarten.hi.payment.model.dto.PaymentDTO;
import com.kindergarten.hi.payment.model.dto.PaymentFileDTO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentDAO mapper;
	
	@Autowired
	public PaymentServiceImpl (PaymentDAO mapper) {
		
		this.mapper = mapper;
	}
	
	
	@Override
	@Transactional
	public void insertPaymentSubmit (PaymentDTO payment, List<PaymentFileDTO> list) {
		
		int result = mapper.insertPaymentSubmit(payment);
		
		
		
		if(!(result > 0 )) {
			System.out.println("실패");
		}else {
			int result2 = 0;
			
			int result3 = mapper.insertPaymentHis(payment.getEmpNo());
			
			if(!(result3 > 0)) {
				System.out.println("실패");
			}else {
				result2++;
				
				if(!(list.size() >= 1)) {
					System.out.println("파일이 없습니다.");
					
				}
				
			for(int i=0; i<list.size(); i++) {
				
				PaymentFileDTO file = list.get(i);
				
				  int result4 = mapper.insertPaymentFile(file);
				
				  if(!(result4 > 0)) {
				  	System.out.println("실패");
				  }
				 	
			  }
			}
			if(!(result2 > 0)) {
				System.out.println("실패");
			}
		}
		

	}

	
	
	@Override
	public int selectTotalCount(Map<String, String> searchMap) {
		int result = mapper.selectTotalCount(searchMap);

		return result;
	}

	@Override
	public List<PaymentDTO> selectSpendList(SelectCriteria selectCriteria, String userNo) {
		
		List<PaymentDTO> spendList = mapper.selectSpendList(selectCriteria, userNo);
		
		
		return spendList;
	}


	@Override
	public PaymentDTO paymentDetail(int no) {

		PaymentDTO detail = mapper.paymentDetail(no);
		
		
		return detail;
	}


	@Override
	public PaymentFileDTO selectPaymentFile(int no) {

		PaymentFileDTO file = mapper.selectPaymentFile(no);
		return file;
	}


	@Override
	@Transactional
	public void updatePayment(PaymentDTO payment) {
		int result = mapper.updatePayment(payment);
		
		if(!(result > 0 )) {
			System.out.println("실패");
		}
		
	}


	@Override
	@Transactional
	public void deletePayment(int no) {
		
		int result = mapper.deletePayment(no);
		
		if(!(result > 0 )) {
			System.out.println("실패");
		}else {
			int result2 = mapper.deletePaymentHis(no);
			
			int result3 = mapper.deletePaymentFile(no);
			
			if(!(result2 > 0 )) {
				System.out.println("실패");
			}
			
			if(!(result3 > 0 )) {
				System.out.println("실패");
			
			}
			
			
		}
		
		
	}


	@Override
	@Transactional
	public void updatePaymentToSup(int no) {
		int result = mapper.updatePaymentToSup(no);
		
		if(!(result > 0 )) {
			System.out.println("실패");

		}else {
			int result2 = mapper.updateSubmitedPayment(no);
			
			if(!(result2 > 0 )) {
				System.out.println("실패");
			}
		}
		
	}


	@Override
	@Transactional
	public void updatePaymentFinal(int no, String yN) {
		int result = mapper.updatePaymentFinal(no,yN);
		
		if(!(result > 0 )) {
			System.out.println("실패");

		}
		
	}

}
