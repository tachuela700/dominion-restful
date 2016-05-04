package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.Tareas;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.TareasRepository;
import es.dominion.curso.negocio.servicios.ITareasService;

@Service
@Transactional
public class TareasServiceImpl extends BaseServiceImpl<Tareas, Byte> implements ITareasService {

	@Autowired
	private TareasRepository tareasRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<Tareas, Byte> repository) {
		super.setBaseRepository(tareasRepository);
	}

}
