package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDate;

/***
 * Classe que representa a press�o arterial do usu�rio.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class PressaoArterial extends Persistivel<PressaoArterial> implements Serializable{

	private static final long serialVersionUID = 5033876516142185214L;
	
	/***
	 * Press�o sist�lica do usu�rio.
	 */
	private int pressaoSistolica;
	
	/***
	 * Press�o diast�lica do usu�rio.
	 */
	private int pressaoDiastolica;
	
	/***
	 * Data da medi��o.
	 */
	private LocalDate data;
	
	/***
	 * Situa��o da press�o do usu�rio.
	 */
	private String situacao;
	
	/***
	 * Refer�ncia do usu�rio.
	 */
	private Usuario usuario;
	
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public PressaoArterial() {
		super();
	}
	
	/***
	 * Cria uma nova inst�ncia de press�o arterial do usu�rio.	
	 * @param pressaoSistolica Press�o sist�lica do usu�rio.
	 * @param pressaoDiastolica Press�o diast�lica do usu�rio.
	 * @param data Data da medi��o.
	 * @param usuario Refer�ncia do usu�rio.
	 */
	public PressaoArterial(int pressaoSistolica, int pressaoDiastolica, LocalDate data, Usuario usuario) {
		setPressaoSistolica(pressaoSistolica);
		setPressaoDiastolica(pressaoDiastolica);
		setData(data);
		setUsuario(usuario);
		setSituacao();
	}
	
	/***
	 * Retorna a press�o sist�lica do usu�ro.
	 * @return Press�o sist�lica d usu�rio.
	 */
	public int getPressaoSistolica() {
		return pressaoSistolica;
	}
	
	/***
	 * Atribui a press�o sist�lica do usu�rio.
	 * @param pressaoSistolica Press�o sist�lica do usu�rio.
	 */
	public void setPressaoSistolica(int pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}
	
	/***
	 * Retorna a press�o diast�lica do usu�rio.
	 * @return Press�o diast�lica do usu�rio.
	 */
	public int getPressaoDiastolica() {
		return pressaoDiastolica;
	}
	
	/***
	 * Atribui a press�o diast�lica do usu�rio.
	 * @param pressaoDiastolica Press�o diast�lica do usu�rio.
	 */
	public void setPressaoDiastolica(int pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}
	
	/***
	 * Retorna a data da medi��o.
	 * @return Data da medi��o.
	 */
	public LocalDate getData() {
		return data;
	}
	
	/***
	 * Atribui a data da medi��o.
	 * @param data Data da medi��o.
	 * @throws InvalidParameterException N�o � permitida uma data nula.
	 */
	public void setData(LocalDate data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data v�lida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna a situa��o da press�o do usu�rio.
	 * @return Situa��o da press�o do usu�rio.
	 */
	public String getSituacao() {
		return situacao;
	}
	
	/***
	 * Atribui a situa��o da press�o do usu�rio.
	 * Elevada: press�o sist�lica maior que 140.
	 * Normal: 120/80 at� 140/90.
	 * Abaixo do normal: press�o sist�lica menor que 120.
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
	 * Retorna o usu�rio associado � press�o arterial.
	 * @return Usu�rio associada � press�o arterial.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usu�rio � press�o arterial.
	 * @param usuario Usu�rio associado � press�o arterial.
	 * @throws InvalidParameterException N�o � permitido um usu�rio nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usu�rio v�lido.");
		}
		
		this.usuario = usuario;
	}
}
