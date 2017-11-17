package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

/***
 * Classe que representa um tipo de refei��o.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class TipoRefeicao extends Persistivel<TipoRefeicao> implements Serializable {
	
	private static final long serialVersionUID = -915843762150823503L;
	
	private int codigo;
	
	/***
	 * Nome do tipo de refei��o.
	 */
	private String nome;
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public TipoRefeicao() {
		super();
	}
	
	/***
	 * Cria uma inst�ncia de tipo de refei��o.
	 * @param nome Nome do tipo de refei��o.
	 */
	public TipoRefeicao(String nome) {			
		setNome(nome);
	}
	
	/***
	 * Retorna o nome do tipo de refei��o.
	 * @return Nome do tipo de refei��o.
	 */
	public String getNome() {
		return nome;
	}
	
	/***
	 * Atribui o nome do tipo de refei��o.
	 * @param nome Nome do tipo de refei��o.
	 * @throws InvalidParameterException N�o � permitido um nome nulo ou vazio.
	 */
	public void setNome(String nome) throws InvalidParameterException{
		
		if(nome == null || nome == "") {
			throw new InvalidParameterException("Informe um nome v�lido.");
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
