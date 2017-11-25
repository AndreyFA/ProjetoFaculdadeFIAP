package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.Calendar;
/***
 * Classe que representa os alimentos consumidos pelo usuário.
 * @author Andrey Frazatti Alves
 * @version 1.0
 * 
 */
public class AlimentoConsumido extends Persistivel<AlimentoConsumido> implements Serializable {

	private static final long serialVersionUID = 7939814281711748587L;
	
	/***
	 * Número de calorias contidas no alimento.
	 */
	private int calorias;
	
	/***
	 * Horário da refeição.
	 */
	private Calendar data;
	
	/***
	 * Descrição do alimento consumido.
	 */
	private String descricao;
	
	/***
	 * Tipo da refeição.
	 */
	private TipoRefeicao tipo;
	
	/***
	 * Referência do usuário.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public AlimentoConsumido() {
		super();
	}
	
	/***
	 * Criar uma nova instância de alimento consumido.
	 * @param calorias Número de calorias contida no alimento.
	 * @param data Data da refeição.
	 * @param descricao do alimento consumido.
	 * @param tipo Tipo da refeição.
	 * @param usuario Referência do usuário.
	 */
	public AlimentoConsumido(int calorias, Calendar data, String descricao, TipoRefeicao tipo, Usuario usuario) {
		setCalorias(calorias);
		setData(data);
		setDescricao(descricao);
		setTipo(tipo);
		setUsuario(usuario);
	}

	/***
	 * Retorna o número de calorias do alimento.
	 * @return Número de calorias do alimento.
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/***
	 * Atribui o número de calorias do alimento.
	 * @param calorias Número de calorias contida no alimento.
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	/***
	 * Retorna a data da refeição.	
	 * @return data da refeição.
	 */
	public Calendar getData() {
		return data;
	}
	
	/***
	 * Atribui a data da refeição.
	 * @param data Data da refeição.
	 * @throws InvalidParameterException Não é permitido uma data nula.
	 */
	public void setData(Calendar data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data válida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna a descrição do alimento consumido.
	 * @return descrição do alimento consumido.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/***
	 * Atribui a descrição do alimento consumido.
	 * @param descricao Descrição do alimento consumido.
	 * @throws InvalidParameterException Não é permitido uma descrição nula ou vazia.
	 */
	public void setDescricao(String descricao) throws InvalidParameterException {
		
		if(descricao == null || descricao == "") {
			throw new InvalidParameterException("Informe uma descrição válida.");
		}
		
		this.descricao = descricao;
	}
	
	/***
	 * Retorna o tipo da refeição.
	 * @return tipo da refeição.
	 */
	public TipoRefeicao getTipo() {
		return tipo;
	}
	
	/***
	 * Atribui o tipo da refeição.
	 * @param tipo Tipo da refeição.
	 * @throws InvalidParameterException Não é permitido um tipo nulo.
	 */
	public void setTipo(TipoRefeicao tipo) throws InvalidParameterException {
		
		if(tipo == null) {
			throw new InvalidParameterException("Informe um tipo válido.");
		}
		
		this.tipo = tipo;
	}
	
	/***
	 * Retorna o usuário associado ao alimento consumido.
	 * @return Usuário associado ao alimento consumido.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usuário a alimento consumido.
	 * @param usuario Usuário associado ao alimento consumido.
	 * @throws InvalidParameterException Não é permitido um usuário nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usuário válido.");
		}
		
		this.usuario = usuario;
	}
}
