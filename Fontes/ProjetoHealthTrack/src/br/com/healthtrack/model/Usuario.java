package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa um usu�rio no sistema.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class Usuario extends Persistivel<Usuario> implements Serializable {

	private static final long serialVersionUID = 7530693817118399678L;
	
	/***
	 * Nome completo do usu�rio.
	 */
	private String nomeCompleto;
	
	/***
	 * Data de nascimento do usu�rio.
	 */
	private LocalDate dataNascimento;
	
	/***
	 * Altura do usu�rio (em metros).
	 */
	private float altura;
	
	/***
	 * G�nero sexual do usu�rio. M ou F.
	 */
	private String genero;
	
	/***
	 * E-mail de contato do usu�rio.
	 */
	private String email;
	
	/***
	 * Senha de acesso do usu�rio.
	 * Regra: Deve ter no m�nimo 6 (seis) caracteres, combinando letras e n�meros.
	 */
	private String senha;
	
	/***
	 * Construtor padr�o JavaBeans. 
	 */
	public Usuario() {
		super();
	}
	
	/***
	 * Cria uma inst�ncia de usu�rio.
	 * @param nomeCompleto Nome completo do usu�rio.
	 * @param dataNascimento Data de nascimento do usu�rio.
	 * @param altura Altura (em metros) do usu�rio.
	 * @param genero G�nero do usu�rio.
	 * @param email E-mail de contato do usu�rio.
	 * @param senha Senha de acesso do usu�rio.
	 */
	public Usuario(String nomeCompleto, LocalDate dataNascimento, float altura, String genero, String email, String senha) {
		setNomeCompleto(nomeCompleto);
		setDataNascimento(dataNascimento);
		setAltura(altura);
		setGenero(genero);
		setEmail(email);
		setSenha(senha);
	}
	
	/***
	 * Retorna o nome completo do usu�rio.
	 * @return Nome completo do usu�rio.
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	/***
	 * Atribui o nome completo do usu�rio.
	 * @param nomeCompleto Nome completo do usu�rio.
	 * @throws InvalidParameterException N�o � permitido um nome nulo ou vazio.
	 */
	public void setNomeCompleto(String nomeCompleto) throws InvalidParameterException {
		
		if(nomeCompleto == null || nomeCompleto == "") {
			throw new InvalidParameterException("Informe um nome v�lido.");
		}
			
		this.nomeCompleto = nomeCompleto;
	}
	
	/***
	 * Retorna a data de nascimento do usu�rio.
	 * @return Data de nascimento do usu�rio.
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	/***
	 * Atribui a data de nascimento do usu�rio.
	 * @param dataNascimento Data de nascimento do usu�rio.
	 * @throws InvalidParameterException N�o � permitida uma data de nascimento nula.
	 */
	public void setDataNascimento(LocalDate dataNascimento) throws InvalidParameterException {
		
		if(dataNascimento == null) {
			throw new InvalidParameterException("Informe uma data de nascimento v�lida.");
		}
		
		this.dataNascimento = dataNascimento;
	}
	
	/***
	 * Retorna a altura (em metros) do usu�rio.
	 * @return Altura (em metros) do usu�rio.
	 */
	public float getAltura() {
		return altura;
	}
	
	/***
	 * Atribui a altura (em metros) do usu�rio.
	 * @param altura Altura (em metros) do usu�rio.
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	/***
	 * Retorna o g�nero sexual do usu�rio.
	 * @return G�nero sexual do usu�rio.
	 */
	public String getGenero() {
		return genero;
	}
	
	/***
	 * Atribui o g�nero sexual do usu�rio.
	 * @param genero G�nero sexual do usu�rio.
	 * @throws InvalidParameterException N�o � permitido um g�nero diferente de M ou F.
	 */
	public void setGenero(String genero) throws InvalidParameterException {
		
		if(genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("F")) {
			this.genero = genero;			
		} else {
			throw new InvalidParameterException("Informe um g�nero v�lido.");
		}	
	}
	
	/***
	 * Retorna o e-mail de contato do usu�rio.
	 * @return E-mail de contato do usu�rio.
	 */
	public String getEmail() {
		return email;
	}
	
	/***
	 * Atribui o e-mail de contato do usu�rio.
	 * @param email E-mail de contato do usu�rio.
	 * @throws InvalidParameterException O e-mail � um campo obrigat�rio.
	 */
	public void setEmail(String email) throws InvalidParameterException {
		
		/*
		 * TODO: Validar o e-mail com uma express�o regular.
		 */
		
		if(email == null || email == "") {
			throw new InvalidParameterException("Informe um e-mail v�lido.");
		}
		
		this.email = email;
	}
	
	/***
	 * Retorna a senha de acesso do usu�rio.
	 * @return Senha de acesso do usu�rio.
	 */
	public String getSenha() {
		return senha;
	}
	
	/***
	 * Atribui a senha de acesso do usu�rio.
	 * Regra: Deve ter no m�nimo 6 (seis) caracteres, combinando letras e n�meros.
	 * @param senha Senha de acesso do usu�rio. 
	 * @throws InvalidParameterException Deve ter no m�nimo 6 (seis) caracteres, combinando letras e n�meros.
	 */
	public void setSenha(String senha) throws InvalidParameterException {
		
		/*
		 * TODO: Validar a senha com uma express�o regular.  
		 */
		
		if(senha == null || senha == "" || senha.length() < 6) {
			throw new InvalidParameterException("Informe uma senha v�lida.");
		}
		
		this.senha = senha;
	}
	
	public boolean alterarSenha(String novaSenha) throws InvalidParameterException {
		/*
		 * TODO: Validar a nova senha com uma express�o regular.
		 */
		
		setSenha(novaSenha);
		return this.senha == novaSenha;	
	}
	
	@Override
	public Usuario cadastrar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public Usuario alterar() {
		// TODO Implementar regra com o banco de dados.
		return null;
	}

	@Override
	public boolean deletar(int codigo) {
		// TODO Implementar regra com o banco de dados.
		return false;
	}
	
	@Override
	public Usuario buscarPorCodigo(int codigo) {
		// TODO Implementar regra com o banco de dados.
		this.setCodigo(codigo);
		return this;
	}
}
