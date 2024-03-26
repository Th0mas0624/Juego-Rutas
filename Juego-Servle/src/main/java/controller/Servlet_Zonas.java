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

import Model.Juego;
import Model.Builder.Carta;
import Model.Factory.Zona;

/**
 * Servlet implementation class Servlet_Zonas
 */

@WebServlet("/zonas")
public class Servlet_Zonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Juego j;
	List<String> zonasEquipo;
    public Servlet_Zonas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		zonasEquipo = new ArrayList<>();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Desde cartas "+this.getServletContext().getAttribute("juego"));
		if(this.getServletContext().getAttribute("juego") != null) {
			j = (Juego) this.getServletContext().getAttribute("juego");
			PrintWriter out=response.getWriter();
			
			
			//j.jugarRonda();
			
			// Esta es una solucion temporal que funciona solo cuando hay dos jugadores o dos equipos
			for (Zona zona: j.getEquipos().get(0).getZonas()){
				if (zona.getZona().size() > 0) {
					String carta = zona.getZona().get(zona.getZona().size() -1).getClass().getName()+zona.getZona().get(zona.getZona().size() -1).getfuncion();
					zonasEquipo.add(carta);
				}else {
					zonasEquipo.add("null");				}
			}
			for (Zona zona: j.getEquipos().get(1).getZonas()){
				if (zona.getZona().size() > 0) {
					String carta = zona.getZona().get(zona.getZona().size() -1).getClass().getName()+zona.getZona().get(zona.getZona().size() -1).getfuncion();
					zonasEquipo.add(carta);
				}else {
					zonasEquipo.add("null");				}
			}
			
			String json = new Gson().toJson(zonasEquipo); // Convierte la lista a JSON usando Gson
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(json);
			out.print(json);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
