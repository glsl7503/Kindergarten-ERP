$(document).ready(function(){
		
	select();
	
});

function select(){
	
	$.ajax({
		url: "/lessons/timetable/calendar/select",
		type: "POST",
		success: function(data){
			
			console.table(data);
			
			if(Object.keys(data).length !== 0) {
				calendar_draw(data);
			} else {
				console,log("오류 발생!!");
			}
			
		},
		error: function(error){
		
			console.log(error);
			
		}
	});
	
}

function calendar_draw(data){
	
	var jsonArray = new Array();
	
	for(var i = 0; i < Object.keys(data).length; i++){
		console.log(data[i].classKindDTO.className);
		console.log(data[i].resDate);
		let json = new Object();
		
		json.url = "timetable?param="+data[i].lpIdx;
		json.title = data[i].classKindDTO.className + "(" +data[i].age + "세)";
        json.start = data[i].resDate;
        json.method = "GET";
		
		jsonArray.push(json);
	}
	
	console.log(jsonArray);
	
	$(function () {
        // calendar element 취득     
        var calendarEl = $('#timetablecalendar')[0];
        // full-calendar 생성하기   
        var calendar = new FullCalendar.Calendar(calendarEl, {
            height: '1000px', // calendar 높이 설정     
            expandRows: true, // 화면에 맞게 높이 재설정   
            //slotMinTime: '08:00', // Day 캘린더에서 시작 시간   
            //slotMaxTime: '20:00', // Day 캘린더에서 종료 시간  
            // 해더에 표시할 툴바    
            headerToolbar: {
                left: 'prevYear,prev,next,nextYear',
                center: 'title',
                // right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                right: 'today'
            },
            initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)       
            initialDate: new Date(), // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)     
            navLinks: false, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크     
            editable: false, // 수정 가능?    
            selectable: true, // 달력 일자 드래그 설정가능     
            nowIndicator: true, // 현재 시간 마크     
            dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)   
            locale: 'ko', // 한국어 설정     
            /*eventAdd: function (obj) { // 이벤트가 추가되면 발생하는 이벤트       
                console.log(obj);
            },
            eventChange: function (obj) { // 이벤트가 수정되면 발생하는 이벤트     
                console.log(obj);
            },
            eventRemove: function (obj) { // 이벤트가 삭제되면 발생하는 이벤트   
                console.log(obj);
            },*/
            //select: function (info) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
           	//	console.log(info)
           	//},	
            eventSources: jsonArray,
            // 이벤트   
            
            //eventClick: function(arg){
			//	console.log(arg);
				//let calendarData = event.el.fcSeg.eventRange.def;
                 //let calendarData2 = event.el.fcSeg.eventRange.range;
                // let id = calendarData.publicId; //pk 비교를 위한 id값 추출
                // console.log(calendarData.extendedProps.content);
               //  console.log(calendarData2.start);
			//},
            
            events: jsonArray
            
        });      // 캘린더 랜더링     
        calendar.render();
    });

}


/*	
	var title = prompt('Event Title:');
                if (title) {
                    calendar.addEvent({
                        title: title,
                        start: arg.start,
                        end: arg.end,
                        allDay: arg.allDay
                    })
    } calendar.unselect()
               
    {
        groupId: 999,
        title: 'Repeating Event',
        start: '2021-07-09T16:00:00'
         end: '2021-07-13'
    },
*/