package br.com.healthtrack.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.AtividadeFisicaDAO;
import br.com.healthtrack.dao.interfaces.TipoAtividadeFisicaDAO;
import br.com.healthtrack.model.AtividadeFisica;
import br.com.healthtrack.model.TipoAtividadeFisica;
import br.com.healthtrack.model.Usuario;

@WebServlet("/atividadeFisica")
public class AtividadeFisicaServlet extends BaseController {

	private static final long serialVersionUID = -3119950102476292024L;
	
	private AtividadeFisicaDAO atividadeFisicaDao;
	private TipoAtividadeFisicaDAO tipoAtividadeFisicaDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atividadeFisicaDao = DAOFactory.getAtividadeFisicaDAO();
		this.tipoAtividadeFisicaDao = DAOFactory.getTipoAtividadeFisicaDAO();
	}
	
	
	private void carregarTipoDeAtividadesFisicas(HttpServletRequest req) {
		List<TipoAtividadeFisica> tipoAtividadesFisicas = this.tipoAtividadeFisicaDao.obterTodos(null);		
		req.setAttribute("tipoAtividadesFisicas", tipoAtividadesFisicas);
	}

	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		AtividadeFisica atividadeFisica = this.atividadeFisicaDao.obterPorId(codigo);
		
		carregarTipoDeAtividadesFisicas(req);
		
		req.setAttribute("atividadeFisica", atividadeFisica);
		req.getRequestDispatcher("atividadeFisicaFormEdicao.jsp").forward(req, resp);
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		carregarTipoDeAtividadesFisicas(req);
		
		req.getRequestDispatcher("atividadeFisicaFormCadastro.jsp").forward(req, resp);		
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario, String mensagem) throws ServletException, IOException {
		List<AtividadeFisica> atividadesFisicas = this.atividadeFisicaDao.obterTodos(usuario);
		
		req.setAttribute("atividadesFisicas", atividadesFisicas);
		
		if(super.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.getRequestDispatcher("atividadeFisica.jsp").forward(req, resp);
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			int calorias = Integer.parseInt(req.getParameter("calorias"));		
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));		
			
			format = new SimpleDateFormat("hh:mm");			
			Timestamp horario = new Timestamp(format.parse(req.getParameter("horario")).getTime());
			
			String descricao = req.getParameter("descricao");
			
			TipoAtividadeFisica tipo = new TipoAtividadeFisica();
			tipo.setCodigo(Integer.parseInt(req.getParameter("tipoAtividadeFisica")));
			
			this.atividadeFisicaDao.cadastrar(new AtividadeFisica(calorias, data, horario, descricao, tipo, usuario));		
			
		} catch(Exception e) {
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
			int calorias = Integer.parseInt(req.getParameter("calorias"));	
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));		
			
			format = new SimpleDateFormat("hh:mm");
			
			Timestamp horario = new Timestamp(format.parse(req.getParameter("horario")).getTime());
			String descricao = req.getParameter("descricao");
						
			TipoAtividadeFisica tipo = new TipoAtividadeFisica();
			tipo.setCodigo(Integer.parseInt(req.getParameter("tipoAtividadeFisica")));
			
			AtividadeFisica atividadeFisica = this.atividadeFisicaDao.obterPorId(codigo);
			atividadeFisica.setCalorias(calorias);
			atividadeFisica.setData(data);
			atividadeFisica.setHorario(horario);
			atividadeFisica.setDescricao(descricao);
			
			this.atividadeFisicaDao.atualizar(atividadeFisica);		
			
		} catch(Exception e) {
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
			this.atividadeFisicaDao.deletar(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}	
		
		listar(req, resp, usuario, mensagem);
	}
}
