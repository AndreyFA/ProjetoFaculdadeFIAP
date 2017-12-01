package br.com.healthtrack.dao.interfaces;

import java.util.ArrayList;

import br.com.healthtrack.model.Usuario;

public interface BaseDAO<T> {
	ArrayList<T> obterTodos(Usuario usuario);
	T obterPorId(int id);
	void cadastrar(T entidade);
	void atualizar(T entidade);
	void deletar(int id);
}
