console.log('chat.js')
//----비회원제, 익명 식별이름 생성
    //Math.random() : 0~1 사이의 난수
    //Math.random() *끝값(미만): 0~ 끝값 사이의 난수
    // (Math.random()*끝값)+ 시작값 : 시작값~끝값 사이의 난수
let randomNo=Math.floor(Math.random()*1001)+1
let nickName=`익명${randomNo} `
console.log(nickName)
// JS 클라이언트 웹소켓 # new WebSocket("ws://localhost:8080/ws매핑주소")
let clientSocket = new WebSocket("ws://localhost:8080/chat/conn")
console.log(clientSocket)

//[1] clientSocket 의 onclose,onerror, onmessage, onopen 정의 해야한다.
function 클라이언트소켓이서버와접속성공(){
    alert("서버와 접속 성공")

}
    //(1) WebSocket 객체내 onopen 속성은 서버소켓과 접속을 성공했을 때 발동되는 함수 정의해서 대입
    clientSocket.onopen = (e)=>{
    //클라이언트가 서버와 접속을 성공했을 때 알림 메세지
    let msg={
        'type': 'alarm',
        'message': `${nickName}님이 입장 했습니다.`
    }
    //보내기
    clientSocket.send(JSON.stringify(msg));
    }

    //(2) WebSocket 객체내 onmessage 속성은 서버소켓이 메세지를 보내왔을 때 발동되는 함수 정의해서 대입
    clientSocket.onmessage= (messageEvent)=>{
    console.log(messageEvent);
    console.log(messageEvent.data);
    //1. 받은 메세지를 출력할 HTML 호출
    let msgBox=document.querySelector('.msgBox');
        
    //
    msg= JSON.parse(messageEvent.data)
    //js객체타입(JSON형식)<----- 문자열타입(JSON 형식)
    //2. 받은 메세지의 내용물(.data 속성)을 HTML 에 ㄷ입
        //알람 메세지
    if(msg.type=='alarm'){
        msgBox.innerHTML+= `
        <div class="fromMsg">
         <div> ${msg.message}</div>
        </div>`
        return;
    }
    if(msg.from==nickName){
    msgBox.innerHTML+= `
    <div class="fromMsgBox">
     <div> ${msg.from}</div>
        <div>
            <span>${msg.date.split(' ')[4]}</span>
            <span>${msg.message}</span>
        </div>
    </div>
        `
    }
    else{
        msgBox.innerHTML+= `
        <div class="toMsgBox">
         <div> ${msg.from}</div>
            <div>
                <span>${msg.message}</span>
                <span>${msg.date.split(' ')[4]}</span>
              
            </div>
        </div>
            `
    }
    }




//[2]매세지 전송 이벤트
function onMsgsend(){
    //1. 입력된 값 가져오기
    let msgInput=document.querySelector('.msgInput')
    //- 메세지 내용들을 객체 형식으로 구성
    let msg={
        'type': 'msg',
        'message':msgInput.value,
        'from': nickName,
        'date':new Date().toLocaleString()
    }
    // 현재 클라이언트 소켓과 연결 유지된 서버소켓에게 메세지 전송
    clientSocket.send( JSON.stringify(msg) );
        //JSON.stringify(js객체): js객체타입(JSON형식)---> 문자열타입(JSON 형식)
        //-"3"(문자열타입 숫자형식) VS 3(정수타입 숫자형식)
        // {key:value}객체타입 JSON 형식 vs "{key:value}" : 문자열타입 JSON 형식

    msgInput.value="";

}
