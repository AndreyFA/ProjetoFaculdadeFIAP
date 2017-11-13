package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

public abstract class BaseController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected UsuarioDAO usuarioDao;
	
	public BaseController() {
		this.usuarioDao = DAOFactory.getUsuarioDAO();
	}
	
	protected Usuario obterUsuario(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int codigoUsuario = Integer.parseInt(session.getAttribute("codigoUsuario").toString());
		
		return this.usuarioDao.obterPorId(codigoUsuario);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = this.obterUsuario(req);
		
		switch (req.getParameter("opcao")) {
			case "editar": {
				abrirFormularioEdicao(req, resp);
				break;
			}
			case "cadastrar": {
				abrirFormularioCadastro(req, resp);
				break;
			}
			case "listar": {
				listar(req, resp, usuario);
				break;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = this.obterUsuario(req);

		switch (req.getParameter("opcao")) {
			case "cadastrar": {
				cadastrar(req, resp, usuario);
				break;
			}
			case "editar": {
				editar(req, resp, usuario);
				break;
			}
			case "excluir": {
				excluir(req, resp, usuario);
				break;
			}
		}
	}
	
	protected abstract void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected abstract void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException;
	
	protected abstract void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException;
	
	protected abstract void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException;
	
	protected abstract void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException;
}
