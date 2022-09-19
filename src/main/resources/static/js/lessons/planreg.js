$(document).ready(function(){
	
	const now = new Date();
	const year = now.getFullYear();
	const month = now.getMonth() + 1;
	const date = now.getDate();

	let convert = year + "년 " + month + "월 " + date + "일";
	
	$(".dateText > td").text(convert);
	
	select();
	
});

function select(){
	
	$.ajax({
		url: "/lessons/plan/register/category",
		type: "POST",
		success: function(data){
			
			console.table(data);
			
			if(Object.keys(data).length !== 0) {
				
				const $class = $("#class");
				const $mainTeacher = $("#mainTeacher");
				
				$class.html("");
				$mainTeacher.html("");
				
				console.log(data.empList);
				console.log(data.ckList);
				
				let ckList = JSON.parse(data.ckList);
				let empList = JSON.parse(data.empList);
				
				let html1 = "";
				let html2 = "";
				
				for(let i in ckList){
					
					html1 += "<option value="+ ckList[i].classIdx +">" + ckList[i].className + "</option>"
					
				}
				
				for(let j in empList){
					
					html2 += "<option value="+ empList[j].empNo +">" + empList[j].empName + " (" + empList[j].empId + ")</option>"
					
				}
				
				$class.append(html1);
				$mainTeacher.append(html2);
			}
			
		},
		error: function(error){
			console.log(error);
		}
	});
	
}

function dateChangebyText(){
	
	let date = $(".datepickerNo").val();
	let splitDate = date.split("-");
	let convert = splitDate[0] + "년 " + splitDate[1] + "월 " + splitDate[2] + "일";
	
	$(".dateText > td").text(convert);
}















