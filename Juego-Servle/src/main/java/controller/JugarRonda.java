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
    public JugarRonda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.getServletContext().getAttribute("juego") != null) {
			j = (Juego) this.getServletContext().getAttribute("juego");
			PrintWriter out=response.getWriter();
			String pa=request.getParameter("carta");
			System.out.println("Boton undido: "+pa);
			j.jugarRonda();
			System.out.println("Jugador Actual: "+j.jugadorActual);
			j.jugadorActual.jugada(j.getEquipos(), pa);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
