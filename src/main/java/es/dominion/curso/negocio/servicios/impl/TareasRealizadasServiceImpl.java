package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.TareasRealizadas;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.TareasRealizadasRepository;
import es.dominion.curso.negocio.servicios.ITareasRealizadasService;

@Service
@Transactional
public class TareasRealizadasServiceImpl extends BaseServiceImpl<TareasRealizadas, Long> implements ITareasRealizadasService {

	@Autowired
	private TareasRealizadasRepository tareasRealizadasRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<TareasRealizadas, Long> repository) {
		super.setBaseRepository(tareasRealizadasRepository);
	}

}
