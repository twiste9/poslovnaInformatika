$(document).ready(function() {
	defaultElements();
});


function defaultElements(){
	var title = "Transfer";
	document.title = title;
	$('#header').html(title);
}

function transfer(){
	var data = new Object();
    data.nalogodavac = $("#nalogodavac").val();
    data.svrhaPlacanja = $("#svrha").val();
    data.primalac = $("#primalac").val();
    data.sifraPlacanja = parseInt($("#sifraPl").val());
    data.valutaSifra = $("#valuta").val();
    data.iznos = parseFloat($("#iznos").val());
    data.racunNalogodavca = $("#racunNal").val();
    data.modelNalogodavca = parseInt($("#modelNal").val());
    data.pozivNaBrojNalogodavca = $("#pozivNaBrNal").val();
    data.racunPrimaoca = $("#racunPrim").val();
    data.modelPrimaoca = parseInt($("#modelPrim").val());
    data.pozivNaBrojPrimaoca = $("#pozivNaBrPrim").val();
    if(document.getElementById('hitno').checked) {
    	  data.hitno = true;
    }
    else{
    	data.hitno = false;
	}
    
	console.log(data);
    $.ajax({
    	url: "../MBT/transfer",
		data: JSON.stringify(data),
		type: "POST",
		contentType: "application/json",
		dataType: "json",
        success: function (data) {
        	window.location.href = "../MBT.html";	
        },
		error: function(xhr, ajaxOptions, thrownError){
			if(xhr.status == 200){
				clear();
				$('#preuzmi').css("visibility", "visible");
				$("#error").css("visibility", "hidden");
					
			}
			else{
				$("#error").html(xhr.responseText);
				$("#error").css("visibility", "visible");
			}
		}

        });
} 

function clear(){
	$("#nalogodavac").val("");
	$("#svrha").val("");
	$("#primalac").val("");
	($("#sifraPl").val(""));
	$("#valuta").val("");
	($("#iznos").val(""));
	  $("#racunNal").val("");
	 ($("#modelNal").val(""));
	 $("#pozivNaBrNal").val("");
	 $("#racunPrim").val("");
	 ($("#modelPrim").val(""));
	 $("#pozivNaBrPrim").val("");
	 $('#hitno').prop('checked', false);
}