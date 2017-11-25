package br.com.healthtrack.model;

import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa o peso do usuário.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class Peso extends Persistivel<Peso>  {

	private static final long serialVersionUID = 213705830683833540L;
	
	/***
	 * Peso do usuário.
	 */
	private float peso;
	
	/***
	 * Data da pesagem.
	 */
	private LocalDate data;
	
	/***
	 * Referência do usuário.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public Peso() {
		super();
	}
	
	/***
	 * Cria uma nova instância de peso do usuário.
	 * @param peso Peso do usuário.
	 * @param data Data da pesagem.
	 * @param usuario Referência do usuário.
	 */
	public Peso(float peso, LocalDate data, Usuario usuario) {
		setPeso(peso);
		setData(data);
		setUsuario(usuario);
	}

	/***
	 * Retorna o peso do usuário.
	 * @return Peso do usuário.
	 */
	public float getPeso() {
		return peso;
	}
	
	/***
	 * Atribui o peso ao usuário.
	 * @param peso Peso do usuário.
	 * @throws InvalidParameterException Não é permitido um peso zerado.
	 */
	public void setPeso(float peso) throws InvalidParameterException {
		
		if(peso == 0) {
			throw new InvalidParameterException("Informe um peso válido.");
		}
		
		this.peso = peso;
	}
	
	/***
	 * Retorna a data da pesagem.
	 * @return Data da pesagem.
	 */
	public LocalDate getData() {
		return data;
	}
	
	/***
	 * Atribui data à pesagem.
	 * @param data Data da pesagem.
	 * @throws InvalidParameterException Não é permitido uma data nula.
	 */
	public void setData(LocalDate data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data válida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna o usuário associado ao peso.
	 * @return Usuário associado ao peso.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usuário ao peso.
	 * @param usuario Usuário associado ao peso.
	 * @throws InvalidParameterException Não é permitido um usuário nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usuário válido.");
		}
		
		this.usuario = usuario;
	}
}
