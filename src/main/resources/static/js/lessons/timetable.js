$(document).ready(function() {

	let param = $("#lpIdx").val();

	select(param);

});

function select(param) {

	$.ajax({
		url: "/lessons/timetable/select",
		type: "POST",
		data: { param: param },
		success: function(data) {

			console.table(data);

			if (Object.keys(data).length !== 0) {

				const $table = $("#timetable tbody");
				$table.html("");

				let jsonObjList = JSON.parse(data.list);
				let jsonObjEmpList = JSON.parse(data.empList);

				$("#empList").val(JSON.stringify(jsonObjEmpList));

				console.log(jsonObjList);
				console.log(jsonObjEmpList);
				console.log(jsonObjEmpList.empNo);

				

				if (jsonObjList == 0) {

			
					$tr = $("<tr>");

					$period = $("<input name='period' style='border:0; text-align:center;' size='1' readonly>").val('1');
					$select = $("<select name='emp'>");

					$select = $("<select name='emp'>");
					$text = $("<input type='text' name='contents'>");
					$plus_btn = $("<button type='button' class='btn-danger' onclick='plus(this); return false;'>+</button>");
					$minus_btn = $("<button type='button' class='btn-success' onclick='minus(this); return false;'>-</button>");

					for (let j in jsonObjEmpList) {

						$option = $("<option value=" + jsonObjEmpList[j].empNo + ">").text(jsonObjEmpList[j].empName + "(" + jsonObjEmpList[j].empId + ")");

						$select.append($option);

					}

					$td0 = $("<td>");
					$td1 = $("<td>");
					$td2 = $("<td>");
					$td3 = $("<td>");

					$td0.append($period);
					$td1.append($select);
					$td2.append($text);
					$td3.append($plus_btn);
					$td3.append($minus_btn);

					$tr.append($td0);
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);

					$table.append($tr);

				} else {

					for (let i in jsonObjList) {

						$tr = $("<tr>");
						//$period = $("<td>").text(jsonObjList[i].period);
						$period = $("<input name='period' style='border:0; text-align:center;' size='1' readonly>").val(jsonObjList[i].period);
						$select = $("<select name='emp'>");
						$text = $("<input type='text' name='contents' value="+ jsonObjList[i].specialNote +">");
						$plus_btn = $("<button type='button' class='btn-danger' onclick='plus(this); return false;'>+</button>");
						$minus_btn = $("<button type='button' class='btn-success' onclick='minus(this); return false;'>-</button>");

						for (let j in jsonObjEmpList) {

							if(jsonObjList.title == jsonObjEmpList[j].empNo){
								$option = $("<option value=" + jsonObjEmpList[j].empNo + "selected >").text(jsonObjEmpList[j].empName + "(" + jsonObjEmpList[j].empId + ")");
							} else {
								$option = $("<option value=" + jsonObjEmpList[j].empNo + ">").text(jsonObjEmpList[j].empName + "(" + jsonObjEmpList[j].empId + ")");
							}
							$select.append($option);

						}

						$td0 = $("<td>");
						$td1 = $("<td>");
						$td2 = $("<td>");
						$td3 = $("<td>");


						$td0.append($period);
						$td1.append($select);
						$td2.append($text);
						$td3.append($plus_btn);
						$td3.append($minus_btn);

						$tr.append($td0);
						$tr.append($td1);
						$tr.append($td2);
						$tr.append($td3);

						$table.append($tr);

					}




				}
			}

		},
		error: function(error) {
			console.log(error);
		}
	});

}

function plus(e) {

	const $body = $("#timetable tbody");
	let $tr = $("#timetable tbody tr");
	let cnt = $tr.length;

	console.log("총 개수 > " + cnt);
	console.log("로우 > " + e.parentNode.parentNode.rowIndex);

	let empList = $("#empList").val();

	console.table(JSON.parse(empList));

	let empListObj = JSON.parse(empList);

	console.log(empListObj[0].empNo);

	if (cnt > 7) {
		alert("더 이상 추가하실 수 없습니다.");
		return false;
	}

	$tr = $("<tr>");

	$period = $("<input name='period' style='border:0; text-align:center;' size='1' readonly>").val(cnt + 1);
	$select = $("<select name='emp'>");
	$text = $("<input type='text' name='contents'>");
	$plus_btn = $("<button type='button' class='btn-danger' onclick='plus(this); return false;'>+</button>");
	$minus_btn = $("<button type='button' class='btn-success' onclick='minus(this); return false;'>-</button>");

	for (let i = 0; i < empListObj.length; i++) {

		$option = $("<option value=" + empListObj[i].empNo + ">").text(empListObj[i].empName + "(" + empListObj[i].empId + ")");

		$select.append($option);

	}

	$td0 = $("<td>");
	$td1 = $("<td>");
	$td2 = $("<td>");
	$td3 = $("<td>");

	$td0.append($period);
	$td1.append($select);
	$td2.append($text);
	$td3.append($plus_btn);
	$td3.append($minus_btn);

	$tr.append($td0);
	$tr.append($td1);
	$tr.append($td2);
	$tr.append($td3);

	$body.append($tr);

}

function minus(e) {

	let $tr = $("#timetable tbody tr");
	let cnt = $tr.length;

	console.log("총 개수 > " + cnt);
	console.log("로우 > " + e.parentNode.parentNode.rowIndex);

	if (cnt < 2) {
		alert("더 이상 삭제하실 수 없습니다.");
		return false;
	}

	let clickRow = (e.parentNode.parentNode.rowIndex - 1);
	$tr.eq(clickRow).remove();

	for (let i = 0; i < cnt - 1; i++) {

		$("#timetable tbody tr").eq(i).find("td").eq(0).text(i + 1);

	}


}

function submit_btn(){
	
	let lpIdx = $("#lpIdx").val();
	let classIdx = $("#classIdx").val();
	let mainTeacher = $("#mainTeacher").val();
	let age = $("#age").val();
	let resDate = $("#resDate").val();
	let ttlNum = $("#ttlNum").val();
	
	let url = "/lessons/timetable/submit?lpIdx=" + lpIdx + "&"
		 + "classIdx=" + classIdx + "&"
		 + "mainTeacher=" + mainTeacher + "&"
		 + "age=" + age + "&"
		 + "resDate=" + resDate + "&"
		 + "ttlNum=" + ttlNum; 
	console.log(url);
	
	location.href = url;
	
}















