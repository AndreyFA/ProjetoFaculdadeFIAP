package br.com.healthtrack.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Calendar;

/***
 * Classe que representa as atividades físicas realizadas pelo usuáro.
 * @author Andrey Frazatti Alves
 * @version 1.0
 */
public class AtividadeFisica extends Persistivel<AtividadeFisica> implements Serializable{
	
	private static final long serialVersionUID = -4659494853648595373L;

	/***
	 * Número de calorias perdidas no exercício.
	 */
	private int calorias;
	
	/***
	 * Data da atividade física.
	 */
	private Calendar data;
	
	/***
	 * Horário da atividade física.
	 */
	private Timestamp horario;
	
	/***
	 * Descrição da atividade física.
	 */
	private String descricao;
	
	/***
	 * Tipo da atividade física.
	 */
	private TipoAtividadeFisica tipo;
	
	/***
	 * Referência do usuário.
	 */
	private Usuario usuario;
	
	/***
	 * Construtor padrão JavaBeans.
	 */
	public AtividadeFisica() {
		super();
	}
	
	/***
	 * Cria uma nova instância de atividade física realizada.
	 * @param calorias Calorias perdidas no exercício.
	 * @param data Data da atividade física.
	 * @param horario Horário da atividade física.
	 * @param descricao Descrição da atividade física.
	 * @param tipo Tipo da atividade física realizada.
	 * @param usuario Referência do usuário.
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
	 * Retorna o número de calorias perdidas na atividade física.
	 * @return Número de calorias perdidas na atividade física.
	 */
	public int getCalorias() {
		return calorias;
	}
	
	/***
	 * Atribui o número de calorias perdidas na atividade física.
	 * @param calorias Número de calorias perdidas na atividade física.
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	/***
	 * Retorna a data da atividade física.
	 * @return Data da atividade física.
	 */
	public Calendar getData()  {		
		return data;
	}
	
	/***
	 * Atribui a data atividade física.
	 * @param data Data da atividade física.
	 * @throws InvalidParameterException Não é permitido uma data nula.
	 */
	public void setData(Calendar data) throws InvalidParameterException {
		
		if(data == null) {
			throw new InvalidParameterException("Informe uma data válida.");
		}
		
		this.data = data;
	}
	
	/***
	 * Retorna o horário da atividade física.
	 * @return Horário da atividade física.
	 */
	public Timestamp getHorario() {
		return horario;
	}
	
	/***
	 * Atribui o horário da atividade física.
	 * @param horario Horário da atividade física.
	 * @throws InvalidParameterException Não é permitido um horário nulo.
	 */
	public void setHorario(Timestamp horario) throws InvalidParameterException {
		
		if(horario == null) {
			throw new InvalidParameterException("Informe um horário válido.");
		}
		
		this.horario = horario;
	}
	
	/***
	 * Retorna a descrição da atividade física.
	 * @return Descrição da atividade física.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/***
	 * Atribui a descrição da atividade física.
	 * @param descricao Descrição da atividade física.
	 * @throws InvalidParameterException Não é permitido uma descrição nula ou vazia.
	 */
	public void setDescricao(String descricao) throws InvalidParameterException {
		
		if(descricao == null || descricao == "") {
			throw new InvalidParameterException("Informe uma descrição válida.");
		}
		
		this.descricao = descricao;
	}
	
	/***
	 * Retorna o tipo da atividade física.
	 * @return Tipo da atividade física.
	 */
	public TipoAtividadeFisica getTipo() {
		return tipo;
	}
	
	/***
	 * Atribui o tipo da atividade física.
	 * @param tipo Tipo da atividade física.
	 * @throws InvalidParameterException Não é permitido um tipo nulo.
	 */
	public void setTipo(TipoAtividadeFisica tipo) throws InvalidParameterException {
		
		if(tipo == null) {
			throw new InvalidParameterException("Informe um tipo válido.");
		}
		
		this.tipo = tipo;
	}
	
	/***
	 * Retorna o usuário associado à atividade física.
	 * @return Usuário associado à atividade física.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/***
	 * Atribui o usuário à atividade física.
	 * @param usuario Usuário associado à atividade física.
	 * @throws InvalidParameterException Não é permitido um usuário nulo.
	 */
	public void setUsuario(Usuario usuario) throws InvalidParameterException {
		
		if(usuario == null) {
			throw new InvalidParameterException("Informe um usuário válido.");
		}
		
		this.usuario = usuario;
	}
}
