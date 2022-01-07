package io.gitgub.niulaniobm.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import io.gitgub.niulaniobm.dao.DAO;
import io.github.niulaniobm.model.Medicamento;
import io.github.niulaniobm.util.NegocionException;

public class MedicamentoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Medicamento> dao;
	
	public void salvar(Medicamento m ) throws NegocionException{
		
		
		if(m.getNome().length() < 3) {
			throw new NegocionException("O nome do medicamento não pode ter menos que 3 caracteres");
		}
		
		
		dao.salvar(m);
	}
	
	
	public void remover(Medicamento m) throws NegocionException {
		dao.remover(Medicamento.class, m.getId());
	}
	
	
	public List<Medicamento> todosOsMedicamentos(){
		return dao.buscarTodos("select m from Medicamento m order by m.nome");
	}

}
