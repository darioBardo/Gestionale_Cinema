function fetchSala() {
	window.open("http://localhost:8080/listaSale", "_blank");
}

function createDropDown(){
  $('#lista-sale').empty();

  $('#lista-sale').append('<option selected="true" disabled>Scegli la sala</option>');
  $('#lista-sale').prop('selectedIndex', 0);

  const url = 'http://localhost:8080/listaSale';

  $.getJSON(url, function (data) {
    $.each(data, function (key, entry) {
      $('#lista-sale').append($('<option></option>').val(entry.id).html(entry.nomeSala));
    });
  });

}

function createRoomsTable(){
	  const url = 'http://localhost:8080/listaSale';

	  $.getJSON(url, function (data){

	    var room_data = '';

	    $.each(data, function(key, value) {
	      room_data += '<tr>';
	      room_data += '<td>' + value.id + '</td>';
	      room_data += '<td>' + value.nomeSala + '</td>';
	      room_data += '<td>' + value.numeroPosti + '</td>';
	      room_data += '</tr>';
	    });
	    $('#rooms-table').append(room_data);
	  });
	}



function hideTable(){
  var x = document.getElementById("rooms-table");
  if(x.style.display === "block"){
    x.style.display = "none";
    document.getElementById("table-toggler").innerHTML = "Show Me!";
  }else {
      x.style.display = "block";
      document.getElementById("table-toggler").innerHTML = "Hide Me!";
    }
}
