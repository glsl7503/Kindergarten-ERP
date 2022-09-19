
/* form 태그 액션값 지정해주는 스크립트문  */
$("#insert").click(function () {
    $("form").attr("action", "/food/stock/insert").attr("method", "post");
 });
  
$("#back").click(function () {
    $("form").attr("action", "/food/stock").attr("method", "get");
});

/* 핸드폰 번호 정규 표현식 스크립트문 */
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

 
