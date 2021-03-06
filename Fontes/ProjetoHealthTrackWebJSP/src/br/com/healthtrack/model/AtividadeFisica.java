package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Calendar;

/***
 * Classe que representa as atividades f�sicas realizadas pelo usu�ro.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class AtividadeFisica extends Persistivel<AtividadeFisica> implements Serializable{
	
	private static final long serialVersionUID = -4659494853648595373L;

	/***
	 * N�mero de calorias perdidas no exerc�cio.
	 */
	private int calorias;
	
	/***
	 * Data da atividade f�sica.
	 */
	private Calendar data;
	
	/***
	 * Hor�rio da atividade f�sica.
	 */
	private Timestamp horario;
	
	/***
	 * Descri��o da atividade f�sica.
	 */
	private String descricao;
	
	/***
	 * Tipo da atividade f�sica.
	 */
	private TipoAtividadeFisica tipo;
	
	/***
	 * Refer�ncia do usu�rio.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padr�o JavaBeans.
	 */
	public AtividadeFisica() {
		super();
	}
	
	/***
	 * Cria uma nova inst�ncia de atividade f�sica realizada.
	 * @param calorias Calorias perdidas no exerc�cio.
	 * @param data Data da atividade f�sica.
	 * @param horario Hor�rio da atividade f�sica.
	 * @param descricao Descri��o da atividade f�sica.
	 * @param tipo Tipo da atividade f�sica realizada.
	 * @param usuario Refer�ncia do usu�rio.
	 */
	public AtividadeFisica(int calorias, Calendar data, Timestamp horario, String descricao, TipoAtividadeFisica tipo, Usuario usuario) {
		setCalorias(calorias);
		setData(data);
		setHorario(horario);
		setDescricao(descricao);
		setTipo(tipo);
		setUsuario(usuario);
	}

	/***
	 * Retorna o n�mero de calorias perdidas na atividade f�sica.
	 * @return N�mero de calorias perdidas na atividade f�sica.
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/***
	 * Atribui o n�mero de calorias perdidas na atividade f�sica.
	 * @param calorias N�mero de calorias perdidas na atividade f�sica.
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	/***
	 * Retorna a data da atividade f�sica.
	 * @return Data da atividade f�sica.
	 */
	public Calendar getData()  {		
		return data;
	}
	
	/***
	 * Atribui a data atividade f�sica.
	 * @param data Data da atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido uma data nula.
	 */
	public void setData(Calendar data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data v�lida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna o hor�rio da atividade f�sica.
	 * @return Hor�rio da atividade f�sica.
	 */
	public Timestamp getHorario() {
		return horario;
	}
	
	/***
	 * Atribui o hor�rio da atividade f�sica.
	 * @param horario Hor�rio da atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido um hor�rio nulo.
	 */
	public void setHorario(Timestamp horario) throws InvalidParameterException {
		
		if(horario == null) {
			throw new InvalidParameterException("Informe um hor�rio v�lido.");
		}
		
		this.horario = horario;
	}
	
	/***
	 * Retorna a descri��o da atividade f�sica.
	 * @return Descri��o da atividade f�sica.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/***
	 * Atribui a descri��o da atividade f�sica.
	 * @param descricao Descri��o da atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido uma descri��o nula ou vazia.
	 */
	public void setDescricao(String descricao) throws InvalidParameterException {
		
		if(descricao == null || descricao == "") {
			throw new InvalidParameterException("Informe uma descri��o v�lida.");
		}
		
		this.descricao = descricao;
	}
	
	/***
	 * Retorna o tipo da atividade f�sica.
	 * @return Tipo da atividade f�sica.
	 */
	public TipoAtividadeFisica getTipo() {
		return tipo;
	}
	
	/***
	 * Atribui o tipo da atividade f�sica.
	 * @param tipo Tipo da atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido um tipo nulo.
	 */
	public void setTipo(TipoAtividadeFisica tipo) throws InvalidParameterException {
		
		if(tipo == null) {
			throw new InvalidParameterException("Informe um tipo v�lido.");
		}
		
		this.tipo = tipo;
	}
	
	/***
	 * Retorna o usu�rio associado � atividade f�sica.
	 * @return Usu�rio associado � atividade f�sica.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usu�rio � atividade f�sica.
	 * @param usuario Usu�rio associado � atividade f�sica.
	 * @throws InvalidParameterException N�o � permitido um usu�rio nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usu�rio v�lido.");
		}
		
		this.usuario = usuario;
	}
}
