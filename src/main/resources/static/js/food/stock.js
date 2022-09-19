$(document).ready(function (){
	
	/* 등록시 알럿창 띄우기 스크립트 */
let message = [['${message}']];

  if(message!= null &&message!== '' && message != '${message}') {
	console.log(message);
    alert(message);
  };

/* 게시글 리스트에서 해당 게시글에 마우스를 올릴 떄에 대한 스타일 처리 */
if (document.querySelectorAll("#listArea td")) {
    const $tds = document.querySelectorAll("#listArea td");
    for (let i = 0; i < $tds.length; i++) {

        $tds[i].onclick = function() {
            const no = this.parentNode.children[3].innerText;
            location.href = "/food/stock/detail?no=" + no;
            
            console.log(no)
        }
    }
};
    
/* form 태그 액션값 지정해주는 스크립트문  */
$("#search").click(function () {
	console.log("asdasdas")
	$("form").attr("action", "/food/stock");
 });
  
$("#insert").click(function () {
	console.log("asdawdawdas");
    $("form").attr("action", "/food/stock/insert").attr("method", "post");
 });


	})



 	
  