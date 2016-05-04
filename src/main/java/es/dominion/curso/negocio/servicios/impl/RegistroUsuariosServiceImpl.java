package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.RegistroUsuarios;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.RegistroUsuariosRepository;
import es.dominion.curso.negocio.servicios.IRegistroUsuariosService;

@Service
@Transactional
public class RegistroUsuariosServiceImpl extends BaseServiceImpl<RegistroUsuarios, Long> implements IRegistroUsuariosService {

	@Autowired
	private RegistroUsuariosRepository registroUsuariosRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<RegistroUsuarios, Long> repository) {
		super.setBaseRepository(registroUsuariosRepository);
	}

}
