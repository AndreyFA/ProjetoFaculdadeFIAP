package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa um usuário no sistema.
 * @author Andrey Frazatti Alves.
 * @version 1.0
 */
public class Usuario extends Persistivel<Usuario> implements Serializable {

	private static final long serialVersionUID = 7530693817118399678L;
	
	/***
	 * Nome completo do usuário.
	 */
	private String nomeCompleto;
	
	/***
	 * Data de nascimento do usuário.
	 */
	private LocalDate dataNascimento;
	
	/***
	 * Altura do usuário (em metros).
	 */
	private float altura;
	
	/***
	 * Gênero sexual do usuário. M ou F.
	 */
	private String genero;
	
	/***
	 * E-mail de contato do usuário.
	 */
	private String email;
	
	/***
	 * Senha de acesso do usuário.
	 * Regra: Deve ter no mínimo 6 (seis) caracteres, combinando letras e números.
	 */
	private String senha;
	
	/***
	 * Construtor padrão JavaBeans. 
	 */
	public Usuario() {
		super();
	}
	
	/***
	 * Cria uma instância de usuário.
	 * @param nomeCompleto Nome completo do usuário.
	 * @param dataNascimento Data de nascimento do usuário.
	 * @param altura Altura (em metros) do usuário.
	 * @param genero Gênero do usuário.
	 * @param email E-mail de contato do usuário.
	 * @param senha Senha de acesso do usuário.
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
	 * Retorna o nome completo do usuário.
	 * @return Nome completo do usuário.
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	/***
	 * Atribui o nome completo do usuário.
	 * @param nomeCompleto Nome completo do usuário.
	 * @throws InvalidParameterException Não é permitido um nome nulo ou vazio.
	 */
	public void setNomeCompleto(String nomeCompleto) throws InvalidParameterException {
		
		if(nomeCompleto == null || nomeCompleto == "") {
			throw new InvalidParameterException("Informe um nome válido.");
		}
			
		this.nomeCompleto = nomeCompleto;
	}
	
	/***
	 * Retorna a data de nascimento do usuário.
	 * @return Data de nascimento do usuário.
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	/***
	 * Atribui a data de nascimento do usuário.
	 * @param dataNascimento Data de nascimento do usuário.
	 * @throws InvalidParameterException Não é permitida uma data de nascimento nula.
	 */
	public void setDataNascimento(LocalDate dataNascimento) throws InvalidParameterException {
		
		if(dataNascimento == null) {
			throw new InvalidParameterException("Informe uma data de nascimento válida.");
		}
		
		this.dataNascimento = dataNascimento;
	}
	
	/***
	 * Retorna a altura (em metros) do usuário.
	 * @return Altura (em metros) do usuário.
	 */
	public float getAltura() {
		return altura;
	}
	
	/***
	 * Atribui a altura (em metros) do usuário.
	 * @param altura Altura (em metros) do usuário.
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	/***
	 * Retorna o gênero sexual do usuário.
	 * @return Gênero sexual do usuário.
	 */
	public String getGenero() {
		return genero;
	}
	
	/***
	 * Atribui o gênero sexual do usuário.
	 * @param genero Gênero sexual do usuário.
	 * @throws InvalidParameterException Não é permitido um gênero diferente de M ou F.
	 */
	public void setGenero(String genero) throws InvalidParameterException {
		
		if(genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("F")) {
			this.genero = genero;			
		} else {
			throw new InvalidParameterException("Informe um gênero válido.");
		}	
	}
	
	/***
	 * Retorna o e-mail de contato do usuário.
	 * @return E-mail de contato do usuário.
	 */
	public String getEmail() {
		return email;
	}
	
	/***
	 * Atribui o e-mail de contato do usuário.
	 * @param email E-mail de contato do usuário.
	 * @throws InvalidParameterException O e-mail é um campo obrigatório.
	 */
	public void setEmail(String email) throws InvalidParameterException {
		
		/*
		 * TODO: Validar o e-mail com uma expressão regular.
		 */
		
		if(email == null || email == "") {
			throw new InvalidParameterException("Informe um e-mail válido.");
		}
		
		this.email = email;
	}
	
	/***
	 * Retorna a senha de acesso do usuário.
	 * @return Senha de acesso do usuário.
	 */
	public String getSenha() {
		return senha;
	}
	
	/***
	 * Atribui a senha de acesso do usuário.
	 * Regra: Deve ter no mínimo 6 (seis) caracteres, combinando letras e números.
	 * @param senha Senha de acesso do usuário. 
	 * @throws InvalidParameterException Deve ter no mínimo 6 (seis) caracteres, combinando letras e números.
	 */
	public void setSenha(String senha) throws InvalidParameterException {
		
		/*
		 * TODO: Validar a senha com uma expressão regular.  
		 */
		
		if(senha == null || senha == "" || senha.length() < 6) {
			throw new InvalidParameterException("Informe uma senha válida.");
		}
		
		this.senha = senha;
	}
	
	public boolean alterarSenha(String novaSenha) throws InvalidParameterException {
		/*
		 * TODO: Validar a nova senha com uma expressão regular.
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
