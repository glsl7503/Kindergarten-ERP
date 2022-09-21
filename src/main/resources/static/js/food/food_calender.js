 
  
  		$(document).ready(function(){
  		  
  			$("#foodModal").on("click", function(e){

				const t = e.target;
				
				if(t.classList.contains("modal")){
					
				$("#foodModal").removeClass("show");
				
				}
				
			});
			
			$("#insertModal").on("click", function(e){

				const t = e.target;
				
				if(t.classList.contains("modal")){
					
				$("#insertModal").removeClass("show");
				
				}
				
			});
  		
  			$.ajax({

  		      url: "/food/list",
  		      // type get 기본이 get방식이라 생략 가능. 
  		      // data findAllCal 쿼리문에서 가져온 값 ==> 이 때 쿼리문의 value값이 fullcalender에서 요구하는 값과 같아야함 <db에서 가져올거라 date생략가능>
  		      
  		      success:function(data) {
  		      	
  		      	console.table(data);
  		          let eventList = [];
  		          let even = {};
  		        
  		        
  		          for(let idx in data){
  		          	
  		          	even = {
  		                  "id": data[idx].id,
  		                  "title": data[idx].title,
  		                  "start": data[idx].start.substring(0, 10),
  		               	  "content": {
  		               		  id: data[idx].id,
  		               		  category: data[idx].foodCategoryIdx,
  		               		  empNo: data[idx].empNo
  		               	  		
  		               	  } 
  		          		    	   	
  		              }
  		              
  		              eventList.push(even);
  		              
  		          }
  		          
  		          let calendarEl = $('#calendar1')[0];
  		          $(function () {
  		              // calendar element 취득     
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
  		                  nowIndicator: false, // 현재 시간 마크     
  		                  dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)   
  		                  locale: 'ko', // 한국어 설정     
  		                  eventAdd: function (obj) { // 이벤트가 추가되면 발생하는 이벤트       
  		                      console.log(obj);
  		                	  
  		                	  
  		                  },
  		                  
  		                  events: eventList,
  		                  
  		                  /*eventChange: function (obj) { // 이벤트가 수정되면 발생하는 이벤트     
  		                      console.log(obj);
  		                  },
  		                  eventRemove: function (obj) { // 이벤트가 삭제되면 발생하는 이벤트   
  		                      console.log(obj);
  		                  },*/
  		                   select: function (arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.  
  		                      console.log(arg);

  		                	   $("#start").val(arg.startStr);
								
  		                      console.log(start);
  		                	  
  		                	  $('#insertModal').addClass( 'show' );
  		                  }, 
  		                eventClick: function(arg) {
  		                	
  		                      console.log(arg);
  		                	
  		                	let title = arg.el.fcSeg.eventRange.def;
  		                    let start = arg.el.fcSeg.eventRange.range;
  		                    let menuIdx = title.publicId; //pk 비교를 위한 id값 추출
  		                    
  		                	
  		                    $('#title').val(title.title);
  		                    $('#calenderHidden').val(menuIdx);
	                	    $(".startDay").val(arg.start);
	                	 	console.log(start);
	                	    $('#foodModal').addClass( 'show' );
 		                	  
 		                	  
 		                	  
  		                	
  		                },
  		              });      // 캘린더 랜더링     
  		              calendar.render();
  		          });
  		      }
  		      });
  	
      
      
      
	  
	  $("#update").click(function () {
		if($("#category").val() == 0) {
			alert("카테고리 지정해주세요")			
			
			} else {
				
	        $("#fm").attr("action", "/food/calender/update").attr("method", "post").submit();

			}  
		});
	  
	 	$("#delete").click(function () {
			
	        $("#fm").attr("action", "/food/calender/delete").attr("method", "post").submit();
	 });
	 	$("#insert").click(function () {
		
		if($("#category").val() == 0) {
			alert("카테고리를 지정해주세요")			
			
			} else {
				
	        $("form").attr("action", "/food/calender/insert").attr("method", "post").submit();
			}  
	 });
  	});	
  	
  	$.ajax({
		url: "/food/calender/category",
		type: "POST",
		success: function(data) {
			
			
			if(Object.keys(data).length !== 0) {
				
				const $empNo1 = $("#empNo1");
				const $empNo2 = $("#empNo2");
				
				//let html2 = "<option value='1'>" + "회사명" + "</option>";
			
				let html2 = "";
				$empNo1.html("");
				$empNo2.html("");
				
				$empNo1.append(html2);
				$empNo2.append(html2);
				
				let empList = JSON.parse(data.empList);
				
				let html1 = "";
				
				for(let i in empList){
				
					
					html1 += "<option value=" + empList[i].empNo + ">" + empList[i].empName + "</option>"
				}
				
				$empNo1.append(html1);
				$empNo2.append(html1);
			}
			
		},
		error: function(erroe) {
			
			console.log(erroe);
		}
});
  	
 
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
