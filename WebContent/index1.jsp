<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>

	
function initialize() {
	
	var filter = document.getElementById('trends').value;
	
	var i;
	var myCenter=new google.maps.LatLng(51.508742 ,-0.120850 );
  var mapProp = {
    center:myCenter,
    zoom:3,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

//   for(i=0;i<10;i++){
	  
// 	  var marker=new google.maps.Marker({
// 		  position:myLocation[i],
// 		  });

// 		marker.setMap(map);
  
//  }
  
	$.ajax({
		type: "GET",
		url: "NewServ",
		data: {trends:filter},
		dataType: "json",
		contentType : 'application/json; charset=utf-8',
		success: function(responseText){
			
			var Latitude = responseText["lat"]; 
			var Longitude = responseText["long"];
			var myLocation1 = [];
//			document.write(foo);
			for(i=0;i<Latitude.length;i++){
				myLocation1.push(new google.maps.LatLng(Latitude[i],Longitude[i]));
			}
			for(i=0;i<Latitude.length;i++){
			var marker=new google.maps.Marker({
		  	position:myLocation1[i],
		  	});

			marker.setMap(map);
			}
		
//			alert(responseText["long"]);
	},
		error: function(request, error, data){
			alert(error);
		}
	});
}
google.maps.event.addDomListener(window, 'load', initialize);


</script>
</head>
<body>
<div id="dropDown">
<select name = "selectTrends" id = "trends"  onChange="initialize()">
<option value = "today">Today</option>
<option value = "@justinbieber">@justinbieber</option>
<option value = "#TweetMyJobs">#TweetMyJobs</option>
<option value = "birthday">birthday</option>
<option value = "#job:">#job:</option>
</select>
</div>
<div id="googleMap" style="width:1300px;height:600px;"></div>

</body>
</html>