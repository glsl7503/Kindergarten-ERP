function plan_delete(){
	
	let index = $("#dtParam").val();
	let url = "/lessons/plan/delete?param=" + index;
	
	location.href = url;
	
}

function plan_submit(){
	
	let index = $("#dtParam").val();
	let url = "/lessons/plan/submit?param=" + index;
	
	location.href = url;
	
}

function plan_modify(){
	
	let index = $("#dtParam").val();
	let url = "/lessons/plan/modify?param=" + index;
	
	location.href = url;
	
}