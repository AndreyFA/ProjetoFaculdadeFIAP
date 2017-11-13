package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = -589795848228775244L;
	private UsuarioDAO usuarioDao;

	@Override
	public void init() throws ServletException {
		this.usuarioDao = DAOFactory.getUsuarioDAO();
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

			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} else {
			req.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
	}

}
