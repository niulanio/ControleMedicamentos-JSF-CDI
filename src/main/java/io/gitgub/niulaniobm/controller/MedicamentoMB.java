package io.gitgub.niulaniobm.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import io.gitgub.niulaniobm.service.MedicamentoService;
import io.github.niulaniobm.model.Medicamento;
import io.github.niulaniobm.util.Message;
import io.github.niulaniobm.util.NegocionException;

@Named
@ViewScoped
public class MedicamentoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;

	@PostConstruct
	public void carregar() {
		medicamentos = service.todosOsMedicamentos();
	}

	public void adicionar() {
		try {

			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();
			Message.info("Salvo com sucesso");

		} catch (NegocionException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {

			service.remover(medicamento);
			carregar();
			Message.info(medicamento.getNome() + " foi removido");

		} catch (NegocionException e) {

			Message.erro(e.getMessage());
		}

	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}
