package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.Roles;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.RolesRepository;
import es.dominion.curso.negocio.servicios.IRolesService;

@Service
@Transactional
public class RolesServiceImpl extends BaseServiceImpl<Roles, Byte> implements IRolesService {

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<Roles, Byte> repository) {
		super.setBaseRepository(rolesRepository);
	}

}
