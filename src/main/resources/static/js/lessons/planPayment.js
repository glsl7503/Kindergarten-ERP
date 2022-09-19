$(document).ready(function(){
	
	$("#btn_search").on("click", function(){
		fn_go_page(1);
	});
	
	fn_go_page(1);
	
});

function fn_go_page(pageNo){
	
	let startDate = $("#startDate").val();
	let endDate = $("#endDate").val();
	let selectVal = $("#selectVal").val();
	let searchVal = $("#searchVal").val();
	
	if(startDate != "" && endDate != ""){
		if(startDate > endDate){
			alert("시작날짜와 마지막 날짜를 확인하세요.");
			return false;	
		}
	}
	
	let currentPage = pageNo;
	
	let data = {
					startDate:startDate,
					endDate:endDate,
					selectVal:selectVal,
					searchVal:searchVal,
					currentPage:currentPage
				}
				
	console.log(data);
	
	$.ajax({
		url: "/lessons/plan/selectPaymentList",
		type: "GET",
		dataType : 'json',
		data: data,
		success: function(data){
			
			console.table(data);
				
			if(Object.keys(data).length !== 0) {
				const $table = $("#planTable tbody");
				$table.html("");
				
				let jsonObjList = JSON.parse(data.list);
				
				for(let index in jsonObjList){
					
					$tr = $("<tr onclick='fn_go_detail(\""+ jsonObjList[index].lpIdx +"\");'>");
					$lpIdx = $("<td>").text(jsonObjList[index].lpIdx);
					$rsGoals = $("<td>").text(jsonObjList[index].rsGoals);
					$age = $("<td>").text(jsonObjList[index].age);
					$className = $("<td>").text(jsonObjList[index].classKindDTO.className);
					$ttlNum = $("<td>").text(jsonObjList[index].ttlNum);
					$resDate = $("<td>").text(jsonObjList[index].resDate);
					$regMem = $("<td>").text(jsonObjList[index].lesEmployeeDTO.empName);
					$regDate = $("<td>").text(jsonObjList[index].regDate);
					$status = $("<td>").text(jsonObjList[index].status);
					$submit = $("<td>").text(jsonObjList[index].submit);
					$process = $("<td>").text(jsonObjList[index].lessonsManagementHisDTO.process);
					//$tr.append(index);
					$tr.append($lpIdx);
					$tr.append($rsGoals);
					$tr.append($age);
					$tr.append($className);
					$tr.append($ttlNum);
					$tr.append($resDate);
					$tr.append($regMem);
					$tr.append($regDate);
					$tr.append($submit);
					$tr.append($process);
					
					$table.append($tr);
				}
				
				let selectCriteria = JSON.parse(data.selectCriteria);
				
				const pageNo = selectCriteria.pageNo;
				const startPage = selectCriteria.startPage;
				const endPage = selectCriteria.endPage;
				const maxPage = selectCriteria.maxPage;
				
				page_draw(pageNo, startPage, endPage, maxPage);
				
			} else {
				const $table = $("#planTable tbody");
				$table.html("");
				$tr = $("<tr>");
				
				let html = "<td colspan='10' style='text-align: center;'>NOT FOUND DATA.</td>";
				$tr.append(html);
				$table.append($tr);
			}
			
		},
		error: function(error){
			
			console.log(error);
			
		}
		
	});
	
	
}

function page_draw(pageNo, startPage, endPage, maxPage){

	/*const buttonAmount = 5;				//한 번에 보여줄 페이징 버튼의 갯수
	const pageNo = 1; 						//요청한 페이지 번호
	const totalCount = 31;   				//전체 게시물 수
	const limit = 10;						//한 페이지에 보여줄 게시물 수
	const maxPage = 4;						//가장 마지막 페이지
	const startPage = 1;					//한 번에 보여줄 페이징 버튼의 시작하는 페이지 수
	const endPage = 4;						//한 번에 보여줄 페이징 버튼의 마지막 페이지 수
	const startRow = 1;						//DB 조회 시 최신 글 부터 조회해야 하는 행의 시작 수
	const endRow = 10;						//DB 조회 시 최신글부터 조회해야 하는 행의 마지막 수*/
	
	console.log("pageNo < "+pageNo);
	console.log("startPage < "+startPage);
	console.log("endPage < "+endPage);
	console.log("maxPage < "+maxPage);
	
	const $pageList = $(".dataTable-pagination-list");
	$pageList.html("");
	
	let html = "";
	
	if(pageNo != 1){
		html += "<li class='pager'><a href='#' onclick='fn_go_page("+ 1 +");'><</a></li>";
	}
	
	for(let i = startPage; i <= endPage; i++){
		
		html += "<li><a href='#' onclick='fn_go_page("+ i +");'>"+i+"</a></li>";
			
	}
	if(pageNo == maxPage){
		html
	} else {
		
	}
	
	if(endPage == maxPage){
		html += "<li class='pager'><a href='#' onclick='fn_go_page("+ (endPage) +");'>></a></li>";
	} else if(pageNo != maxPage){
		html += "<li class='pager'><a href='#' onclick='fn_go_page("+ (endPage+1) +");'>></a></li>";
	}
	
	
	$pageList.append(html);
	
	const buttonAmount = 5;	
	let activeNo = (pageNo%buttonAmount)-1;
	
	$(".dataTable-pagination-list > li:not('.pager')").eq(activeNo).addClass("active");
	
}

function fn_go_detail(no){
	
	url = "/lessons/plan/detailPy?param=" + no; 
	
	location.href = url;
	
}