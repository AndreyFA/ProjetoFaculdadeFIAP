package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.Usuario;

@WebServlet("/peso")
public class PesoServlet extends BaseController {

	private static final long serialVersionUID = 1L;
	
	private PesoDAO pesoDao;

	@Override
	public void init() throws ServletException {
		this.pesoDao = DAOFactory.getPesoDAO();
	}	

	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		Peso peso = this.pesoDao.obterPorId(codigo);
		
		req.setAttribute("peso", peso);
		req.getRequestDispatcher("pesoFormEdicao.jsp").forward(req, resp);
	}
	
	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("pesoFormCadastro.jsp").forward(req, resp);
	}
	
	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario, String mensagem) throws ServletException, IOException {
		List<Peso> pesos = this.pesoDao.obterTodos(usuario);

		req.setAttribute("pesos", pesos);
		
		if(super.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.getRequestDispatcher("peso.jsp").forward(req, resp);
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			float peso = Float.parseFloat(req.getParameter("peso"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));

			this.pesoDao.cadastrar(new Peso(peso, data, usuario));			
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			float peso = Float.parseFloat(req.getParameter("peso"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));

			Peso registroPeso = this.pesoDao.obterPorId(codigo);
			registroPeso.setData(data);
			registroPeso.setPeso(peso);

			this.pesoDao.atualizar(registroPeso);
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}	
		
		listar(req, resp, usuario, mensagem);
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			this.pesoDao.deletar(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}
}
