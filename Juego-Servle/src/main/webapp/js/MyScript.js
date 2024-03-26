let diccionarioImagenes = {
	"Model.Builder.AtaqueGasolina":"falta de combustible","Model.Builder.AtaqueVelocidad": "velocidad maxima",
	"Model.Builder.AtaquePinchazo":"pinchadura","Model.Builder.AtaqueAccidente":"choque","Model.Builder.AtaqueSiga":"stop",
    "Model.Builder.DefensaGasolina":"combustible","Model.Builder.DefensaVelocidad":"fin velocidad maxima","Model.Builder.DefensaPinchazo":"rueda de auxilio",
    "Model.Builder.DefensaAccidente":"taller","Model.Builder.DefensaSiga":"siga","Model.Builder.SeguridadGasolina":"combustible extra",
    "Model.Builder.SeguridadPinchazo":"a prueba de pinchasos","Model.Builder.SeguridadAccidente":"as del volante","Model.Builder.SeguridadSiga":"prioridad de paso",
    "Model.Builder.Distancia200":"200","Model.Builder.Distancia100":"100","Model.Builder.Distancia75":"75","Model.Builder.Distancia50":"50","Model.Builder.Distancia25":"25"
    };

/*
    private String[] rutas = {"falta de combustible","velocidad maxima","pinchadura","choque","stop",
    "combustible","fin velocidad maxima","rueda de auxilio","taller","siga",
    "combustible extra","a prueba de pinchasos","as del volante","prioridad de paso",
    "200","100","75","50","25"};
 */

function iniciarJuego(numJugadores, modoJuego){
	
	/*let numJugadores=$("#numJugadores").val();
	let modoJuego=$("#modoJuego").val();*/
	let mydata={
		numJugadores:numJugadores,
		modoJuego:modoJuego
	};
	$.ajax({
        url: 'iniciar',
        type: 'GET',
        data: mydata,
        success: function(r) {
            paintAns("Inicio Juego"); // Convierte la respuesta a string si es necesario
            cartas();
        }
    });
}
function cartas(){    
    $.ajax({
        url: 'cartas',
        type: 'GET',
        success: function(r) {
                try {
                     
                    pintarLasCartas(r); // Si el parseo es exitoso, pasa los datos a pintarLasCartas
                } catch (e) {
                    console.error("Error parseando la respuesta JSON: ", e);
                    // Aquí puedes manejar el error, por ejemplo, mostrando un mensaje al usuario
                }
        }
    });
}

 
function pintarLasCartas(cartas) {
    cartas.forEach((carta, index) => {
        // Obtener el botón correspondiente (Carta1, Carta2, ..., Carta12)
        let boton = document.getElementById(`Carta${index + 1}`);
        //console.log(boton)
        // Traducir el identificador de la carta a una ruta de imagen usando diccionarioImagenes
        let rutaImagen = "Pictures/"+diccionarioImagenes[carta]+".png";
        //console.log(rutaImagen)
        // Establecer la imagen en el botón
        boton.style.backgroundImage = `url(${rutaImagen})`;
        boton.style.backgroundSize = 'cover'; // Asegura que la imagen cubra todo el botón
        boton.setAttribute("data-nombre",Object.keys(diccionarioImagenes).find(llave => diccionarioImagenes[llave] === diccionarioImagenes[carta]));
        //console.log(boton.getAttribute("data-nombre"));
    	//boton.style.transform = "rotate(90deg)";
        
    });
}
 
function jugarRonda(boton){
	let carta = boton.getAttribute("data-nombre");
	console.log(boton);
	console.log(carta);
	console.log(boton.getAttribute("data-nombre"));
	let mydata={
		carta:carta,
	};
	$.ajax({
        url: 'jugar',
        type: 'GET',
        data: mydata,
        success: function(r) {
            paintAns("Inicio Juego"); // Convierte la respuesta a string si es necesario
            cartas();
        }
    });
    
    //cartas();
}

 
function iniciar2Jugadores(){
	
	console.log("Si se llama");
	document.getElementById("botones").style.display = "none";
	document.getElementById("table").style.display = "flex";
	document.getElementById("bod").style.backgroundImage = "none";
	//window.location.href = 'Tablero.html'; // Redirecciona a dosJugadores.html
	iniciarJuego(2,"Individual");
	//cartas();
}

function iniciar2Equipos(){
	
	console.log("Si se llama");
	document.getElementById("botones").style.display = "none";
	document.getElementById("tablero").style.display = "flex";
	document.getElementById("bod").style.backgroundImage = "none";
	iniciarJuego(4,"Equipos");
	//window.location.href = 'Tablero.html'; // Redirecciona a dosJugadores.html
	//cartas();
}
function reglasJuego(){
	var contenedor = document.getElementById("contenedorImagen");
    var imagen = document.getElementById("imagenReglas");
    // Especifica la ruta de tu imagen
    imagen.src = 'Pictures/200.png'; // Asegúrate de reemplazar esto con la URL real de tu imagen
    // Hace el contenedor visible
    contenedor.style.display = "flex";
}

function cerrarImagen() {
    var contenedor = document.getElementById("contenedorImagen");
    // Oculta el contenedor, lo que también oculta la imagen y el botón de cerrar
    contenedor.style.display = "none";
}


function paintAns(ans) {
    $("#resultado").html("<h2>El resultado es: " + ans + "</h2>");
}


