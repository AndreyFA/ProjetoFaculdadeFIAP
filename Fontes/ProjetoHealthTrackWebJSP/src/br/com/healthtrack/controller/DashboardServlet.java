package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.PressaoArterial;
import br.com.healthtrack.model.Usuario;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	private static final long serialVersionUID = 4349328432765605641L;
	private UsuarioDAO usuarioDao;
	private PesoDAO pesoDao;
	private PressaoArterialDAO pressaoArterialDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioDao = DAOFactory.getUsuarioDAO();
		this.pesoDao = DAOFactory.getPesoDAO();
		this.pressaoArterialDao = DAOFactory.getPressaoArterialDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = this.usuarioDao.autenticar(email, senha);

		if (usuario != null) {
			HttpSession session = req.getSession();			
			session.setAttribute("nomeUsuario", usuario.getNomeCompleto());
			session.setAttribute("codigoUsuario", usuario.getCodigo());
			
			req = this.popularDashboard(req, usuario);			
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = this.obterUsuario(req);
		req = this.popularDashboard(req, usuario);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
	
	private HttpServletRequest popularDashboard(HttpServletRequest req, Usuario usuario) throws ServletException, IOException {
		Peso ultimoPeso = this.pesoDao.obterUltimoPesoCadastrado(usuario);
		PressaoArterial ultimaPressaoArterial = this.pressaoArterialDao.obterUltimaPressaoArterialCadastrada(usuario);
		
		if (ultimoPeso != null) {
			req.setAttribute("peso", ultimoPeso.getPeso());
			req.setAttribute("dataUltimoPeso", ultimoPeso.getData());
			
			float imc = this.obterIMC(usuario.getAltura(), ultimoPeso.getPeso());	
			req.setAttribute("IMC", imc);
			req.setAttribute("situacaoIMC", this.obterSituacaoIMC(imc));
		}
		
		if (ultimaPressaoArterial != null) {
			req.setAttribute("pressaoSistolica", ultimaPressaoArterial.getPressaoSistolica());
			req.setAttribute("pressaoDiastolica", ultimaPressaoArterial.getPressaoDiastolica());
			req.setAttribute("dataUltimaPressao", ultimaPressaoArterial.getData());
		}

		req.setAttribute("idade", usuario.obterIdadeAtual());
		req.setAttribute("nomeUsuario", usuario.getNomeCompleto());
		
		return req;
	}
	
	private Usuario obterUsuario(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int codigoUsuario = Integer.parseInt(session.getAttribute("codigoUsuario").toString());
		
		return this.usuarioDao.obterPorId(codigoUsuario);
	}
	
	private float obterIMC(float altura, float peso) {
		altura = altura / 100.0F;
		
		return (peso / (altura * altura));
	}
	
	private String obterSituacaoIMC(float imc) {
		
		if (imc <= 18.5F) {
		 return "Abaixo do peso.";
		}
		
		if (imc > 18.5F && imc <= 24.9) {
			return "Peso ideal (parabéns).";
		}
		
		if (imc > 24.9F && imc <= 29.9F) {
			return "Levemente acima do peso.";
		}
		
		if (imc > 29.9F && imc <= 34.9F) {
			return "Obesidade grau 1.";
		}
		
		if (imc > 34.9F && imc <= 39.9F) {
			return "Obesidade grau 2 (severa).";
		}
		
		return "Obesidade grau 3 (mórbida).";
	}
}
