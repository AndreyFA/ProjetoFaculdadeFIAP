package br.com.healthtrack.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.model.*;

@WebServlet("/peso")
public class PesoServlet extends HttpServlet {

	private static final long serialVersionUID = -1035580250271846967L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String peso = req.getParameter("pesoInclusao");
		String data = req.getParameter("dataInclusao");

		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Peso> pesos = new ArrayList<>();
		Usuario usuario = new Usuario(
				"Andrey Frazatti Alves", 
				LocalDate.now(), 
				175F, 
				"M", 
				"email@email.com.br",
				"Senha@123");
		
		for (int i = 0; i < 10; i++) {
			pesos.add(new Peso(65.4F, LocalDate.now(), usuario));
		}

		req.setAttribute("pesos", pesos);
		req.getRequestDispatcher("peso.jsp").forward(req, resp);
	}
}
