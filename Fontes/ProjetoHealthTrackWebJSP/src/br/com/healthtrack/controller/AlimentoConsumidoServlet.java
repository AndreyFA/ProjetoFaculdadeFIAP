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
import br.com.healthtrack.dao.interfaces.AlimentoConsumidoDAO;
import br.com.healthtrack.dao.interfaces.TipoRefeicaoDAO;
import br.com.healthtrack.model.AlimentoConsumido;
import br.com.healthtrack.model.TipoRefeicao;
import br.com.healthtrack.model.Usuario;

@WebServlet("/alimentoConsumido")
public class AlimentoConsumidoServlet extends BaseController {

	private static final long serialVersionUID = -7777517156215164706L;
	private AlimentoConsumidoDAO alimentoConsumidoDao;
	private TipoRefeicaoDAO tipoRefeicaoDao;

	@Override
	public void init() throws ServletException {
		this.alimentoConsumidoDao = DAOFactory.getAlimentoConsumidoDAO();
		this.tipoRefeicaoDao = DAOFactory.getTipoRefeicaoDAO();
	}	
	
	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		AlimentoConsumido alimentoConsumido = this.alimentoConsumidoDao.obterPorId(codigo);
		
		carregarTiposDeRefeicoes(req);
		
		req.setAttribute("alimentoConsumido", alimentoConsumido);
		req.getRequestDispatcher("alimentoConsumidoFormEdicao.jsp").forward(req, resp);
	}
	
	private void carregarTiposDeRefeicoes(HttpServletRequest req) {
		List<TipoRefeicao> tipoRefeicoes = this.tipoRefeicaoDao.obterTodos(null);		
		req.setAttribute("tipoRefeicoes", tipoRefeicoes);
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		carregarTiposDeRefeicoes(req);
		req.getRequestDispatcher("alimentoConsumidoFormCadastro.jsp").forward(req, resp);
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario, String mensagem) throws ServletException, IOException {
		List<AlimentoConsumido> alimentosConsumidos = alimentoConsumidoDao.obterTodos(usuario);

		req.setAttribute("alimentosConsumidos", alimentosConsumidos);
		
		if(super.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.getRequestDispatcher("alimentoConsumido.jsp").forward(req, resp);
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			int calorias = Integer.parseInt(req.getParameter("calorias"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));
			
			String descricao = req.getParameter("descricao");
			
			TipoRefeicao tipo = new TipoRefeicao();
			tipo.setCodigo(Integer.parseInt(req.getParameter("tipoRefeicao")));
			
			this.alimentoConsumidoDao.cadastrar(new AlimentoConsumido(calorias, data, descricao, tipo, usuario));
			
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
			int calorias = Integer.parseInt(req.getParameter("calorias"));			
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));
			
			
			String descricao = req.getParameter("descricao");
			
			TipoRefeicao tipo = new TipoRefeicao();
			tipo.setCodigo(Integer.parseInt(req.getParameter("tipoRefeicao")));
			
			AlimentoConsumido alimento = this.alimentoConsumidoDao.obterPorId(codigo);
			alimento.setCalorias(calorias);
			alimento.setDescricao(descricao);
			alimento.setData(data);
			alimento.setTipo(tipo);	
			
			this.alimentoConsumidoDao.atualizar(alimento);	
			
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
			this.alimentoConsumidoDao.deletar(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}
}
