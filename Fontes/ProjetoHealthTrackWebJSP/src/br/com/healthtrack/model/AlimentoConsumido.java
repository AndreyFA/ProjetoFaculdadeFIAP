package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.Calendar;
/***
 * Classe que representa os alimentos consumidos pelo usu�rio.
 * @author Andrey Frazatti Alves
 * @version 1.0
 * 
 */
public class AlimentoConsumido extends Persistivel<AlimentoConsumido> implements Serializable {

	private static final long serialVersionUID = 7939814281711748587L;
	
	/***
	 * N�mero de calorias contidas no alimento.
	 */
	private int calorias;
	
	/***
	 * Hor�rio da refei��o.
	 */
	private Calendar data;
	
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
	 * @param data Data da refei��o.
	 * @param descricao do alimento consumido.
	 * @param tipo Tipo da refei��o.
	 * @param usuario Refer�ncia do usu�rio.
	 */
	public AlimentoConsumido(int calorias, Calendar data, String descricao, TipoRefeicao tipo, Usuario usuario) {
		setCalorias(calorias);
		setData(data);
		setDescricao(descricao);
		setTipo(tipo);
		setUsuario(usuario);
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
	 * Retorna a data da refei��o.	
	 * @return data da refei��o.
	 */
	public Calendar getData() {
		return data;
	}
	
	/***
	 * Atribui a data da refei��o.
	 * @param data Data da refei��o.
	 * @throws InvalidParameterException N�o � permitido uma data nula.
	 */
	public void setData(Calendar data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data v�lida.");
		}
		
		this.data = data;
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
}
