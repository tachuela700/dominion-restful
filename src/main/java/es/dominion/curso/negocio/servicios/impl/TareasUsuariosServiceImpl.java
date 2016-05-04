package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.TareasUsuarios;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.TareasUsuariosRepository;
import es.dominion.curso.negocio.servicios.ITareasUsuariosService;

@Service
@Transactional
public class TareasUsuariosServiceImpl extends BaseServiceImpl<TareasUsuarios, Long> implements ITareasUsuariosService {

	@Autowired
	private TareasUsuariosRepository paisRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<TareasUsuarios, Long> repository) {
		super.setBaseRepository(paisRepository);
	}

}
