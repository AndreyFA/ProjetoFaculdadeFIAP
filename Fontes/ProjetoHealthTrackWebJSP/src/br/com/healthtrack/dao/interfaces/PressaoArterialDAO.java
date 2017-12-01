package br.com.healthtrack.dao.interfaces;

import br.com.healthtrack.model.PressaoArterial;
import br.com.healthtrack.model.Usuario;

public interface PressaoArterialDAO extends BaseDAO<PressaoArterial> {
	
	PressaoArterial obterUltimaPressaoArterialCadastrada(Usuario usuario);
	
}
