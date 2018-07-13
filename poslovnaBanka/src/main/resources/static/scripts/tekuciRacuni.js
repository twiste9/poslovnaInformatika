function generisiPDF(){
	var nazivBanke = $("#nazivBanke").val();
	
	$.ajax({
		url: "../racuni/preuzmiPDF?nazivBanke=" +nazivBanke,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function(data) {
			alert("Dokument uspesno preuzet");
			//$('#preuzmi').css("visibility", "visible");
		}
	});
}