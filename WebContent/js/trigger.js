//it get the data of the json file from our local system
function trigger() {
	$.ajax({
		type : "GET",
		url : "person1.json",
		dataType : "json",
		success : function(data) {
			$("#get_data").append(JSON.stringify(data));
			sendToservlet(data);
		},
	});
}
// this method is to send data to our servlet
function sendToservlet(data) {
	$.ajax({
		type : "POST",
		url : "getmydata",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(data),
		success : function(messege) {
			alert("Successfully sent to servlet");
		},
	});
}
