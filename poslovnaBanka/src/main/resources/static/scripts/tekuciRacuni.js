function generisiPDF(){
	var nazivBanke = $("#nazivBanke").val();
	
	$.ajax({
		url: "../racuni/preuzmiPDF?nazivBanke=" +nazivBanke,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function() {
			alert("Dokument uspesno preuzet");
			//$('#preuzmi').css("visibility", "visible");
		}
	});
}

function ukini(){
	var ukiniTR = $("#brTekuceg").val();
	var prenesiTR = $("#prenos").val();
	
	var ukidanje = new Object();
	ukidanje.ukini = ukiniTR;
	ukidanje.prenesi = prenesiTR;
	
	$.ajax({
    	url: "../racuni/ukini",
		data: JSON.stringify(ukidanje),
		type: "POST",
		contentType: "application/json",
		dataType: "json",
        success: function () {
        	alert("Racun ukinut");
        }
	}); 
}