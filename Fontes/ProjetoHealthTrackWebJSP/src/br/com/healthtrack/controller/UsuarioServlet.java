package br.com.healthtrack.controller;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	
	@Override
	public void init() throws ServletException {
		this.usuarioDao = DAOFactory.getUsuarioDAO();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getParameter("opcao")) {
			
			case "novoUsuario": 
				cadastrar(req,resp);
				break;
				
			case "recuperarSenha":
				recuperarSenha(req, resp);
				break;
		}		
	}
	
	private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email = req.getParameter("email");
			
			if(this.usuarioDao.emailJaCadastrado(email))
				throw new InvalidParameterException("E-mail já cadastrado.");
			
			String senha = req.getParameter("senha");
			String confirmacaoSenha = req.getParameter("confirmacaoSenha");			
			
			if(!senha.equals(confirmacaoSenha))
				throw new InvalidParameterException("A confirmação da senha não confere.");
			
			String nome = req.getParameter("nome");
			int altura = Integer.parseInt(req.getParameter("altura"));
			String genero = req.getParameter("genero");
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");			
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(req.getParameter("dataNascimento")));	
			
			this.usuarioDao.cadastrar(new Usuario(nome, dataNascimento, altura, genero, email, senha));
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", e.getMessage());
		}		
	}
	
	private void recuperarSenha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			
			if(!this.usuarioDao.emailJaCadastrado(email))
				throw new InvalidParameterException("E-mail inválido ou não cadastrado.");
			
			String senha = this.usuarioDao.obterSenhaPorEmail(email);
			
			req.setAttribute("senha", senha);
			req.getRequestDispatcher("exibirSenhaRecuperada.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", e.getMessage());
		}
	}
}
