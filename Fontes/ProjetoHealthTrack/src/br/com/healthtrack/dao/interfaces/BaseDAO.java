package br.com.healthtrack.dao.interfaces;

import java.util.ArrayList;

public interface BaseDAO<T> {
	ArrayList<T> obterTodos();
	T obterPorId(int id);
	void cadastrar(T entidade);
	void atualizar(T entidade);
	void deletar(int id);
}
