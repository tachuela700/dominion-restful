package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.Pais;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.PaisRepository;
import es.dominion.curso.negocio.servicios.IPaisService;

@Service
@Transactional
public class PaisServiceImpl extends BaseServiceImpl<Pais, Long> implements IPaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<Pais, Long> repository) {
		super.setBaseRepository(paisRepository);
	}

}
