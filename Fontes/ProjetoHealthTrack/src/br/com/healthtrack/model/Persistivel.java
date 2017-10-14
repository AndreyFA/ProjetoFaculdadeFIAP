package br.com.healthtrack.model;

import java.io.Serializable;

/***
 * Classe base para todas as outras Model.
 * @author Andrey Frazatti Alves
 * @version 1.0
 *
 */
public abstract class Persistivel<T> implements Serializable{

	private static final long serialVersionUID = 8806869988858470597L;
	
	/***
	 * C�digo gerado pelo banco de dados.
	 */
	protected int codigo;
	
	/***
	 * Informa se o registro est� ativo ou n�o para visualiza��o.
	 */
	protected boolean ativo;
	
	/***
	 * Retorna se o registro est� ativo ou n�o para visualiza��o.
	 * @return registro est� ativo ou n�o.
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/***
	 * Desabilita ou habilita a visualiza��o do registro.
	 * @param ativo Informa se o registro est� ativo ou n�o.
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/***
	 * Atribui o c�digodo do registro no banco de dados.
	 * @param c�digo do registro no banco de dados.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/***
	 * Retorna o c�digo do registro no banco de dados.
	 * @return c�digo do registro no banco de dados.
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public Persistivel() {
		
	}
	
	/***
	 * Cadastra a entidade no banco de dados.
	 * @return Entidade cadastrada com o codigo preenchido.
	 */
	public abstract T cadastrar();
	
	/***
	 * Altera a entidade no banco de dados.
	 * @return Entidade alterada.
	 */
	public abstract T alterar();
	
	/***
	 * Remove a entidade que possui o codigo informado.
	 * @param codigo Codigo da entidade no banco de dados.
	 * @return true para sucesso e false para falha.
	 */
	public abstract boolean deletar(int codigo);
	
	/***
	 * Retorna a entidade que possui o codigo informado.
	 * @param codigo Codigo da entidade no banco de dados.
	 * @return Entidade que possui o codigo informado.
	 */
	public abstract T buscarPorCodigo(int codigo);
}
