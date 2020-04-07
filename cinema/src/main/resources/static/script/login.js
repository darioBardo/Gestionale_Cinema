
$(document).ready(function(){

	$("#form-login").submit(function(event){
		event.preventDefault();
		login();

	});
});


function login(){

	var search = {}
    search["username"] = $("#username").val();
    search["password"] = $("#password").val();

    $("#btn-login").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/login",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "Accesso effettuato"
                
            $('#feedbackLog').html(json);
            
           /*
            window.location.replace("/index.html");
            setTimeout("pageRedirect()", 10000);
            */
            
            console.log("SUCCESS : ", data);
            $("#btn-login").prop("disabled", false);

        },
        error: function (e) {

            var json = 
                "Utente non valido"
            $('#feedbackLog').html(json);

            console.log("ERROR : ", e);
            $("#btn-login").prop("disabled", false);

        }
    });

}