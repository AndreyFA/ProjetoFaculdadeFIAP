package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

/***
 * Classe que representa um tipo de atividade f�sica.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class TipoAtividadeFisica extends Persistivel<TipoAtividadeFisica> implements Serializable {

	private static final long serialVersionUID = 6837406436730395115L;
	
	/***
	 * Nome do tipo de atividade f�sica.
	 */
	private String nome;
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public TipoAtividadeFisica() {
		super();
	}
	
	/***
	 * Cria uma inst�ncia de tipo de atividade f�sica.
	 * @param nome Nome do tipo de atividade f�sica.
	 */
	public TipoAtividadeFisica(String nome) {
		setNome(nome);
	}
	
	/***
	 * Retorna o nome do tipo de atividade f�sica.
	 * @return Nome do tipo de atividade f�sica.
	 */
	public String getNome() {
		return nome;
	}
	
	/***
	 * Atribui o nome do tipo de atividade f�sica. 
	 * @param nome Nome do tipo de atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido um nome nulo ou vazio.
	 */
	public void setNome(String nome) throws InvalidParameterException {
		
		if(nome == null || nome == "") {
			throw new InvalidParameterException("Informe um nome v�lido.");
		}
		
		this.nome = nome;
	}
	
	@Override
	public TipoAtividadeFisica cadastrar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public TipoAtividadeFisica alterar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public boolean deletar(int codigo) {
		// TODO Implementar regra com o banco de dados.
		return false;
	}
	
	@Override
	public TipoAtividadeFisica buscarPorCodigo(int codigo) {
		// TODO Implementar regra com o banco de dados.
		this.setCodigo(codigo);
		return this;
	}
}
