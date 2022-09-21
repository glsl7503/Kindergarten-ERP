var socket = io()
// 소켓에 접속 되었을 때 실행
socket.on('connect', function() {
  function getParameterByName(name) { // 입력받은 이름값 get방식으로 가져오기
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), //주소에서 이름과 한줄소개 빼오기
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
  }
  var user = getParameterByName('user'); // 유저 이름과
  var intro = getParameterByName('intro'); // 한줄소개 저장

  var text = "사용자 : " + user + "님";
  var in_text ="한줄소개 : " + intro;
  document.getElementById('h_name').innerHTML = text;
  document.getElementById('h_introduce').innerHTML = in_text;
  
  // 서버에 새로운 유저가 왔다고 알려주기
  socket.emit('newUser', user) //new user를 전송
})

// 서버로부터 데이터 받아오기
socket.on('update', function(data) {
  var chat = document.getElementById('chat')

  var message = document.createElement('div')
  var node = document.createTextNode(`${data.message}`)
  var className = ''

  // 타입에 따라 적용할 클래스를 다르게 지정
  switch(data.type) {
    case 'message':
      className = 'other'
      break

    case 'connect':
      className = 'connect'
      break

    case 'disconnect':
      className = 'disconnect'
      break
  }

  message.classList.add(className)
  message.appendChild(node)
  chat.appendChild(message)
})

/* 메시지 전송 함수 */
function send() {
  if(event.keyCode == 13){ //엔터키 눌렀을 때
  // 입력되어있는 데이터 가져오기
  var message = document.getElementById('test').value
  
  // 가져왔으니 데이터 빈칸으로 변경
  document.getElementById('test').value = ''

  // 내가 전송할 메시지 클라이언트에게 표시
  var chat = document.getElementById('chat')
  var msg = document.createElement('div')
  var node = document.createTextNode(message)
  msg.classList.add('me')
  msg.appendChild(node)
  chat.appendChild(msg)
  chat.scrollTop = chat.scrollHeight

  // 서버로 message 이벤트 전달 + 데이터와 함께
  socket.emit('message', {type: 'message', message: message})
  }
}
