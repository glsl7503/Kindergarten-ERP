    
    /* form 태그 액션값 및 메소드 지정해주기 스크립트 문 */
    $("#insert").click(function () {
        $("form").attr("action", "/food/trader/insert").attr("method", "post");
 	 });
  
 	$("#back").click(function () {
        $("form").attr("action", "/food/trader").attr("method", "get");
 	});
 	
 	//휴대폰 번호 유효성 검사
 	let userPhone = document.querySelector("#phoneNumber");
 	userPhone.addEventListener("change", (e) => {
 	  validPhone(e.target);
 	});
 	function validPhone(obj) {
 	  console.log(obj);
 	  if (validPhoneCheck(obj) == false) {
 	    alert("올바른 번호를 입력하세요.");
 	    obj.value = "";
 	    obj.focus();
 	    return false;
 	  }
 	}
 	function validPhoneCheck(obj) {
 	  let pattern = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
 	  return obj.value.match(pattern) != null;
 	}

 	// 전화번호 입력 시 하이픈 넣는 코드
 	const autoHypen = (target) => {
 	  target.value = target.value
 	    .replace(/[^0-9]/g, "")
 	    .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3")
 	    .replace(/(\-{1,2})$/g, "");
 	};
