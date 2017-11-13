package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
/***
 * Classe que representa os alimentos consumidos pelo usu�rio.
 * @author Andrey Frazatti Alves
 * @version 1.0
 * 
 */
public class AlimentoConsumido extends Persistivel<AlimentoConsumido> implements Serializable {

	private static final long serialVersionUID = 7939814281711748587L;
	
	private int codigo;

	/***
	 * N�mero de calorias contidas no alimento.
	 */
	private int calorias;
	
	/***
	 * Hor�rio da refei��o.
	 */
	private LocalDateTime dataHorario;
	
	/***
	 * Descri��o do alimento consumido.
	 */
	private String descricao;
	
	/***
	 * Tipo da refei��o.
	 */
	private TipoRefeicao tipo;
	
	/***
	 * Refer�ncia do usu�rio.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public AlimentoConsumido() {
		super();
	}
	
	/***
	 * Criar uma nova inst�ncia de alimento consumido.
	 * @param calorias N�mero de calorias contida no alimento.
	 * @param horario Hor�rio da refei��o.
	 * @param descricao do alimento consumido.
	 * @param tipo Tipo da refei��o.
	 * @param usuario Refer�ncia do usu�rio.
	 */
	public AlimentoConsumido(int calorias, LocalDateTime horario, String descricao, TipoRefeicao tipo, Usuario usuario) {
		setCalorias(calorias);
		setHorario(horario);
		setDescricao(descricao);
		setTipo(tipo);
		setUsuario(usuario);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/***
	 * Retorna o n�mero de calorias do alimento.
	 * @return N�mero de calorias do alimento.
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/***
	 * Atribui o n�mero de calorias do alimento.
	 * @param calorias N�mero de calorias contida no alimento.
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	/***
	 * Retorna o hor�rio da refei��o.	
	 * @return hor�rio da refei��o.
	 */
	public LocalDateTime getHorario() {
		return dataHorario;
	}
	
	/***
	 * Atribui o hor�rio da refei��o.
	 * @param horario Hor�rio da refei��o.
	 * @throws InvalidParameterException N�o � permitido uma data nula.
	 */
	public void setHorario(LocalDateTime horario) throws InvalidParameterException {
		
		if(horario == null) {
			throw new InvalidParameterException("Informe uma data v�lida.");
		}
		
		this.dataHorario = horario;
	}
	
	/***
	 * Retorna a descri��o do alimento consumido.
	 * @return descri��o do alimento consumido.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/***
	 * Atribui a descri��o do alimento consumido.
	 * @param descricao Descri��o do alimento consumido.
	 * @throws InvalidParameterException N�o � permitido uma descri��o nula ou vazia.
	 */
	public void setDescricao(String descricao) throws InvalidParameterException {
		
		if(descricao == null || descricao == "") {
			throw new InvalidParameterException("Informe uma descri��o v�lida.");
		}
		
		this.descricao = descricao;
	}
	
	/***
	 * Retorna o tipo da refei��o.
	 * @return tipo da refei��o.
	 */
	public TipoRefeicao getTipo() {
		return tipo;
	}
	
	/***
	 * Atribui o tipo da refei��o.
	 * @param tipo Tipo da refei��o.
	 * @throws InvalidParameterException N�o � permitido um tipo nulo.
	 */
	public void setTipo(TipoRefeicao tipo) throws InvalidParameterException {
		
		if(tipo == null) {
			throw new InvalidParameterException("Informe um tipo v�lido.");
		}
		
		this.tipo = tipo;
	}
	
	/***
	 * Retorna o usu�rio associado ao alimento consumido.
	 * @return Usu�rio associado ao alimento consumido.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usu�rio a alimento consumido.
	 * @param usuario Usu�rio associado ao alimento consumido.
	 * @throws InvalidParameterException N�o � permitido um usu�rio nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usu�rio v�lido.");
		}
		
		this.usuario = usuario;
	}
	
	@Override
	public AlimentoConsumido cadastrar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public AlimentoConsumido alterar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public boolean deletar(int codigo) {
		// TODO Implementar regra com o banco de dados.
		return false;
	}
	
	@Override
	public AlimentoConsumido buscarPorCodigo(int codigo) {
		// TODO Implementar regra com o banco de dados.
		this.setCodigo(codigo);
		return this;
	}
}
