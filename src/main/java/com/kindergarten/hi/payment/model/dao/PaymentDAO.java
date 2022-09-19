package com.kindergarten.hi.payment.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kindergarten.hi.common.paging.SelectCriteria;
import com.kindergarten.hi.payment.model.dto.PaymentDTO;
import com.kindergarten.hi.payment.model.dto.PaymentFileDTO;

@Mapper
public interface PaymentDAO {

	int insertPaymentSubmit(PaymentDTO payment);

	int selectTotalCount(Map<String, String> searchMap);

	List<PaymentDTO> selectSpendList(@Param("selectCriteria")SelectCriteria selectCriteria, @Param("userNo")String userNo);

	int insertPaymentFile(PaymentFileDTO file);
	
	PaymentDTO paymentDetail(int no);

	int insertPaymentHis(int empNo);

	PaymentFileDTO selectPaymentFile(int no);

	int updatePayment(PaymentDTO payment);

	int deletePayment(int no);

	int deletePaymentHis(int no);

	int deletePaymentFile(int no);

	int updatePaymentToSup(int no);

	int updateSubmitedPayment(int no);

	int updatePaymentFinal(@Param("no")int no, @Param("yN")String yN);


}
