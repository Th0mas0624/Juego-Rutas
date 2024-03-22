package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Model.Equipo;
import Model.Juego;
import Model.Jugador;
import Model.Builder.Carta;

/**
 * Servlet implementation class Servlet_Cartas
 */

@WebServlet("/cartas")
public class Servlet_Cartas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Juego j;
	List<String> cartasJugadores = new ArrayList<>();
    public Servlet_Cartas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Desde cartas "+this.getServletContext().getAttribute("juego"));
		if(this.getServletContext().getAttribute("juego") != null) {
			j = (Juego) this.getServletContext().getAttribute("juego");
			PrintWriter out=response.getWriter();
			
			/* Las primeras 6 cartas pertenecen al jugador 1 y las otras 6 pertenecen al jugador 2
			 * Esta solucion es una aproximacion que solo funciona cuando hay 2 jugadores
			 * */
			for (Equipo equipo : j.getEquipos()) {
				for (Jugador jugador: equipo.getJugadores()) {
					for (Carta carta : jugador.getMano()) {
						cartasJugadores.add(carta.getClass().getName()+carta.getfuncion());
						System.out.println(carta.getClass().getName()+carta.getfuncion());
					}
				}
			}
			
			String json = new Gson().toJson(cartasJugadores); // Convierte la lista a JSON usando Gson
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(json);
			out.print(json);
			out.flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
