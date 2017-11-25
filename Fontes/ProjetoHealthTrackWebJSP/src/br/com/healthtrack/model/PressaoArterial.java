package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa a pressão arterial do usuário.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class PressaoArterial extends Persistivel<PressaoArterial> implements Serializable{

	private static final long serialVersionUID = 5033876516142185214L;
	
	/***
	 * Pressão sistólica do usuário.
	 */
	private int pressaoSistolica;
	
	/***
	 * Pressão diastólica do usuário.
	 */
	private int pressaoDiastolica;
	
	/***
	 * Data da medição.
	 */
	private LocalDate data;
	
	/***
	 * Situação da pressão do usuário.
	 */
	private String situacao;
	
	/***
	 * Referência do usuário.
	 */
	private Usuario usuario;
	
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public PressaoArterial() {
		super();
	}
	
	/***
	 * Cria uma nova instância de pressão arterial do usuário.	
	 * @param pressaoSistolica Pressão sistólica do usuário.
	 * @param pressaoDiastolica Pressão diastólica do usuário.
	 * @param data Data da medição.
	 * @param usuario Referência do usuário.
	 */
	public PressaoArterial(int pressaoSistolica, int pressaoDiastolica, LocalDate data, Usuario usuario) {
		setPressaoSistolica(pressaoSistolica);
		setPressaoDiastolica(pressaoDiastolica);
		setData(data);
		setUsuario(usuario);
		setSituacao();
	}
	
	/***
	 * Retorna a pressão sistólica do usuáro.
	 * @return Pressão sistólica d usuário.
	 */
	public int getPressaoSistolica() {
		return pressaoSistolica;
	}
	
	/***
	 * Atribui a pressão sistólica do usuário.
	 * @param pressaoSistolica Pressão sistólica do usuário.
	 */
	public void setPressaoSistolica(int pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}
	
	/***
	 * Retorna a pressão diastólica do usuário.
	 * @return Pressão diastólica do usuário.
	 */
	public int getPressaoDiastolica() {
		return pressaoDiastolica;
	}
	
	/***
	 * Atribui a pressão diastólica do usuário.
	 * @param pressaoDiastolica Pressão diastólica do usuário.
	 */
	public void setPressaoDiastolica(int pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}
	
	/***
	 * Retorna a data da medição.
	 * @return Data da medição.
	 */
	public LocalDate getData() {
		return data;
	}
	
	/***
	 * Atribui a data da medição.
	 * @param data Data da medição.
	 * @throws InvalidParameterException Não é permitida uma data nula.
	 */
	public void setData(LocalDate data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data válida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna a situação da pressão do usuário.
	 * @return Situação da pressão do usuário.
	 */
	public String getSituacao() {
		return situacao;
	}
	
	/***
	 * Atribui a situação da pressão do usuário.
	 * Elevada: pressão sistólica maior que 140.
	 * Normal: 120/80 até 140/90.
	 * Abaixo do normal: pressão sistólica menor que 120.
	 */
	public void setSituacao() {
				
		if ((pressaoSistolica >= 120 || pressaoSistolica <= 140)
				&& (pressaoDiastolica >= 80 || pressaoDiastolica <= 90)) {
			this.situacao = "Normal";
		} 
		else if (pressaoSistolica < 120){
			this.situacao = "Abaixo do normal";
		} 
		else {
			this.situacao = "Elevada";
		}
	}
	
	/***
	 * Retorna o usuário associado à pressão arterial.
	 * @return Usuário associada à pressão arterial.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usuário à pressão arterial.
	 * @param usuario Usuário associado à pressão arterial.
	 * @throws InvalidParameterException Não é permitido um usuário nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usuário válido.");
		}
		
		this.usuario = usuario;
	}
}
