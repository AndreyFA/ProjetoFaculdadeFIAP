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
import javax.servlet.http.HttpSession;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	protected String mensagemSucesso = "Processo realizado com sucesso!";
	protected String mensagemErro = "Ocorrem falhas. Entre em contato com o suporte!";
	
	@Override
	public void init() throws ServletException {
		this.usuarioDao = DAOFactory.getUsuarioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getParameter("opcao")) {
		
			case "editar": 
				abrirFormularioEdicao(req,resp);
				break;

			case "sair": 
				encerrarSessaoDoUsuario(req, resp);
				break;
		}
	}
	
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("usuario", obterUsuario(req));
		req.getRequestDispatcher("usuario.jsp").forward(req, resp);
	}
	
	protected void encerrarSessaoDoUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("codigoUsuario");
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	protected Usuario obterUsuario(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int codigoUsuario = Integer.parseInt(session.getAttribute("codigoUsuario").toString());
		
		return this.usuarioDao.obterPorId(codigoUsuario);
	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getParameter("opcao")) {
			
			case "novoUsuario": 
				cadastrar(req,resp);
				break;
				
			case "editarUsuario": 
				editar(req,resp);
				break;
				
			case "alterarSenha": 
				alterarSenha(req, resp);
				break;
				
			case "recuperarSenha":
				recuperarSenha(req, resp);
				break;
		}		
	}
	
	private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mensagem = this.mensagemSucesso;
		Usuario usuario = this.obterUsuario(req);
		
		try {
			String email = req.getParameter("email");
			
			if(this.usuarioDao.emailJaCadastrado(email, usuario))
				throw new InvalidParameterException("E-mail já cadastrado.");
			
			String nome = req.getParameter("nome");
			int altura = Integer.parseInt(req.getParameter("altura"));
			String genero = req.getParameter("genero");
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");			
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(req.getParameter("dataNascimento")));			
			
			usuario.setNomeCompleto(nome);
			usuario.setAltura(altura);
			usuario.setEmail(email);
			usuario.setDataNascimento(dataNascimento);
			usuario.setGenero(genero);
			
			this.usuarioDao.atualizar(usuario);
			
		} catch(Exception e) {
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		
		if(this.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("usuario.jsp").forward(req, resp);
	}
	
	private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mensagem = this.mensagemSucesso;
		
		try {
			String email = req.getParameter("email");
			
			if(this.usuarioDao.emailJaCadastrado(email, null))
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
		
		if(this.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.setAttribute("", arg1);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	private void recuperarSenha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			
			if(!this.usuarioDao.emailJaCadastrado(email, null))
				throw new InvalidParameterException("E-mail inválido ou não cadastrado.");
			
			String senha = this.usuarioDao.obterSenhaPorEmail(email);
			
			req.setAttribute("senha", senha);
			req.getRequestDispatcher("exibirSenhaRecuperada.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", e.getMessage());
		}
	}

	private void alterarSenha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mensagem = this.mensagemSucesso;
		Usuario usuario = this.obterUsuario(req);
		
		try {
			
			String senha = req.getParameter("senha");
			String novaSenha = req.getParameter("novaSenha");
			String confirmacaoNovaSenha = req.getParameter("confirmacaoNovaSenha");
			
			usuario.verificarNovaSenha(senha, novaSenha, confirmacaoNovaSenha);
			usuario.setSenha(novaSenha);
			
			this.usuarioDao.atualizar(usuario);
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = e.getMessage();
		}
		
		if(this.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.setAttribute("usuario", usuario);		
		req.getRequestDispatcher("usuario.jsp").forward(req, resp);
	}
}
