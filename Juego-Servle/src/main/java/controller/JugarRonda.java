package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Juego;

/**
 * Servlet implementation class JugarRonda
 */

@WebServlet("/jugar")
public class JugarRonda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Juego j;
	boolean auxiliar = false;
    public JugarRonda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		auxiliar = false;
		if(this.getServletContext().getAttribute("juego") != null) {
			j = (Juego) this.getServletContext().getAttribute("juego");
			PrintWriter out=response.getWriter();
			String carta=request.getParameter("carta");
			String accion = request.getParameter("accion");
			
			System.out.println("Boton undido: "+carta);
			System.out.println("Jugador Actual: "+j.jugadorActual);
			
			if (accion.equals("jugar")) {
				auxiliar = j.jugadorActual.jugada(j.getEquipos(), carta);	
			}else{
				auxiliar = j.jugadorActual.descartarCarta(j.getMazoJuego().getCartasDescartadas(), carta);
			}
			
			if(auxiliar) {
				j.jugadorActual.recogerCartaMazo(j.getMazoJuego().getCartasDisponibles());
				System.out.println("Carta recogida exitosamente");
			}
			
			out.print(auxiliar);
			out.flush();
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
