package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

/***
 * Classe que representa um tipo de refeição.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class TipoRefeicao extends Persistivel<TipoRefeicao> implements Serializable {
	
	private static final long serialVersionUID = -915843762150823503L;
	
	private int codigo;
	
	/***
	 * Nome do tipo de refeição.
	 */
	private String nome;
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public TipoRefeicao() {
		super();
	}
	
	/***
	 * Cria uma instância de tipo de refeição.
	 * @param nome Nome do tipo de refeição.
	 */
	public TipoRefeicao(String nome) {			
		setNome(nome);
	}
	
	/***
	 * Retorna o nome do tipo de refeição.
	 * @return Nome do tipo de refeição.
	 */
	public String getNome() {
		return nome;
	}
	
	/***
	 * Atribui o nome do tipo de refeição.
	 * @param nome Nome do tipo de refeição.
	 * @throws InvalidParameterException Não é permitido um nome nulo ou vazio.
	 */
	public void setNome(String nome) throws InvalidParameterException{
		
		if(nome == null || nome == "") {
			throw new InvalidParameterException("Informe um nome válido.");
		}
		
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public TipoRefeicao cadastrar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public TipoRefeicao alterar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public boolean deletar(int codigo) {
		// TODO Implementar regra com o banco de dados.
		return false;
	}
	
	@Override
	public TipoRefeicao buscarPorCodigo(int codigo) {
		// TODO Implementar regra com o banco de dados.
		this.setCodigo(codigo);
		return this;
	}
}
