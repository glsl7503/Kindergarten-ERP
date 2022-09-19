$(document).ready(function(){
	
	const now = new Date();
	const year = now.getFullYear();
	const month = now.getMonth() + 1;
	const date = now.getDate();

	let convert = year + "년 " + month + "월 " + date + "일";
	
	$(".dateText > td").text(convert);
});

function dateChangebyText(){
	
	let date = $(".datepickerNo").val();
	
	let splitDate = date.split("-");
	let convert = splitDate[0] + "년 " + splitDate[1] + "월 " + splitDate[2] + "일";
	
	$(".dateText > td").text(convert);
}

function report_submit(){
	
	let index = $("#dtParam").val();
	let url = "/lessons/report/submit?param=" + index;
	
	location.href = url;
	
}













