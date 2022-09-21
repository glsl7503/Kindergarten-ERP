   /* 등록시 알럿창 띄어주는 스크립트 문 */
   let message = '[[${message}]]';

  if(message!= null &&message!== '' && message !== 'null') {
    alert(message);
  } 
  
  /* 게시글 리스트에서 해당 게시글에 마우스를 올릴 떄에 대한 스타일 처리 */
    if (document.querySelectorAll("#listArea td")) {
        const $tds = document.querySelectorAll("#listArea td");
        for (let i = 0; i < $tds.length; i++) {

            $tds[i].onclick = function() {
                const no = this.parentNode.children[4].innerText;
                location.href = "/food/trader/detail?no=" + no;
                
                console.log(no)
            }
        }
    }

    /* form태그 액션값 지정해주는 스크립트 문 */
    $("#search").click(function () {
        $("form").attr("action", "/food/trader");
 	 });
  
 	$("#insert").click(function () {
        $("form").attr("action", "/food/trader/insert");
 	});

  