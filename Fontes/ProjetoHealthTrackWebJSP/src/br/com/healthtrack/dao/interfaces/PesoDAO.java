package br.com.healthtrack.dao.interfaces;

import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.Usuario;

public interface PesoDAO extends BaseDAO<Peso> {
	
	Peso obterUltimoPesoCadastrado(Usuario usuario);
	
}
