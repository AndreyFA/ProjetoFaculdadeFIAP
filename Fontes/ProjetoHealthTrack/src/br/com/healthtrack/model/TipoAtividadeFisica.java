package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

/***
 * Classe que representa um tipo de atividade física.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class TipoAtividadeFisica extends Persistivel<TipoAtividadeFisica> implements Serializable {

	private static final long serialVersionUID = 6837406436730395115L;
	
	/***
	 * Nome do tipo de atividade física.
	 */
	private String nome;
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public TipoAtividadeFisica() {
		super();
	}
	
	/***
	 * Cria uma instância de tipo de atividade física.
	 * @param nome Nome do tipo de atividade física.
	 */
	public TipoAtividadeFisica(String nome) {
		setNome(nome);
	}
	
	/***
	 * Retorna o nome do tipo de atividade física.
	 * @return Nome do tipo de atividade física.
	 */
	public String getNome() {
		return nome;
	}
	
	/***
	 * Atribui o nome do tipo de atividade física. 
	 * @param nome Nome do tipo de atividade física.
	 * @throws InvalidParameterException Não é permitido um nome nulo ou vazio.
	 */
	public void setNome(String nome) throws InvalidParameterException {
		
		if(nome == null || nome == "") {
			throw new InvalidParameterException("Informe um nome válido.");
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
