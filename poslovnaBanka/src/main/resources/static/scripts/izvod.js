function generisi() {
	var brojRacuna = $("#broj_racuna").val();
	var datum = $("#datum").val();
	
	$.ajax({
		url: "../izvod/preuzmi?brojRacuna=" +brojRacuna + "&datum=" + datum,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function(data) {
			$('#preuzmi').css("visibility", "visible");
		}
	});
}

function generisiPDF(){
	var brojRacuna = $("#broj_racuna").val();
	var datum = $("#datum").val();
	
	$.ajax({
		url: "../izvod/preuzmiPDF?brojRacuna=" +brojRacuna + "&datum=" + datum,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function() {
			alert("Izvod uspesno preuzet");
			//$('#preuzmi').css("visibility", "visible");
		}
	});
}