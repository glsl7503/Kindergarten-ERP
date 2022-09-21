
/* form태그 지정해주기 스크립트문 */
$(".update").click(function () {
    $("form").attr("action", "/food/stock/update");
	 });

	$(".delete").click(function () {
    $("form").attr("action", "/food/stock/delete");
	});

/* 전화번호 정규표현식 스크립트문 */ 
 	let userPhone = document.querySelector("#stockCount");
 	userPhone.addEventListener("change", (e) => {
 	  validPhone(e.target);
 	});
 	
 	function validPhone(obj) {
 	  console.log(obj);
 	  if (validPhoneCheck(obj) == false) {
 	    alert("올바른 수량을 입력하세요.");
 	    obj.value = "";
 	    obj.focus();
 	    return false;
 	  }
 	}
 	function validPhoneCheck(obj) {
 	  let pattern = /^[0-9]/g;
 	  return obj.value.match(pattern) != null;
 	}


