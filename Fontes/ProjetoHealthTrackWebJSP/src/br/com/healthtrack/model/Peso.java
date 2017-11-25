package br.com.healthtrack.model;

import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa o peso do usu�rio.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class Peso extends Persistivel<Peso>  {

	private static final long serialVersionUID = 213705830683833540L;
	
	/***
	 * Peso do usu�rio.
	 */
	private float peso;
	
	/***
	 * Data da pesagem.
	 */
	private LocalDate data;
	
	/***
	 * Refer�ncia do usu�rio.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public Peso() {
		super();
	}
	
	/***
	 * Cria uma nova inst�ncia de peso do usu�rio.
	 * @param peso Peso do usu�rio.
	 * @param data Data da pesagem.
	 * @param usuario Refer�ncia do usu�rio.
	 */
	public Peso(float peso, LocalDate data, Usuario usuario) {
		setPeso(peso);
		setData(data);
		setUsuario(usuario);
	}

	/***
	 * Retorna o peso do usu�rio.
	 * @return Peso do usu�rio.
	 */
	public float getPeso() {
		return peso;
	}
	
	/***
	 * Atribui o peso ao usu�rio.
	 * @param peso Peso do usu�rio.
	 * @throws InvalidParameterException N�o � permitido um peso zerado.
	 */
	public void setPeso(float peso) throws InvalidParameterException {
		
		if(peso == 0) {
			throw new InvalidParameterException("Informe um peso v�lido.");
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
	 * Atribui data � pesagem.
	 * @param data Data da pesagem.
	 * @throws InvalidParameterException N�o � permitido uma data nula.
	 */
	public void setData(LocalDate data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data v�lida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna o usu�rio associado ao peso.
	 * @return Usu�rio associado ao peso.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usu�rio ao peso.
	 * @param usuario Usu�rio associado ao peso.
	 * @throws InvalidParameterException N�o � permitido um usu�rio nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usu�rio v�lido.");
		}
		
		this.usuario = usuario;
	}
}
