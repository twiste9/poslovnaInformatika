$(document).ready(function() {
	defaultElements();
});


function defaultElements(){
	var title = "Login";
	document.title = title;
	$('#header').html(title);
}

function login(){
	var data = new Object();
    data.email = $("#usernameOrEmail").val();
    data.password = $("#password").val();
    
    console.log(data);
    $.ajax({
    	url: "../log/login",
		data: JSON.stringify(data),
		type: "POST",
		contentType: "application/json",
		dataType: "json",
        success: function (data) {
        	window.location.href = "../MBT.html";	
        },
		error: function(xhr, ajaxOptions, thrownError){
			if(xhr.status == 200){
				window.location.href = "../MBT.html";	
			}
			else{
				$("#error").css("visibility", "visible");
			}
		}

        });
} 