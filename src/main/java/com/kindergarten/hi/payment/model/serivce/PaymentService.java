package com.kindergarten.hi.payment.model.serivce;


import java.util.List;
import java.util.Map;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.payment.model.dto.PaymentDTO;
import com.kindergarten.hi.payment.model.dto.PaymentFileDTO;

public interface PaymentService {
	
	void insertPaymentSubmit(PaymentDTO payment, List<PaymentFileDTO> list);

	int selectTotalCount(Map<String, String> searchMap);

	List<PaymentDTO> selectSpendList(SelectCriteria selectCriteria, String userNo);

	PaymentDTO paymentDetail(int no);

	PaymentFileDTO selectPaymentFile(int no);

	void updatePayment(PaymentDTO payment);

	void deletePayment(int no);

	void updatePaymentToSup(int no);

	void updatePaymentFinal(int no, String yN);


}
