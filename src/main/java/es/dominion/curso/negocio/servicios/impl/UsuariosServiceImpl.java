package es.dominion.curso.negocio.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dominion.curso.negocio.entidades.Usuarios;
import es.dominion.curso.negocio.repositorios.BaseRepository;
import es.dominion.curso.negocio.repositorios.UsuariosRepository;
import es.dominion.curso.negocio.servicios.IUsuariosService;

@Service
@Transactional
public class UsuariosServiceImpl extends BaseServiceImpl<Usuarios, String> implements IUsuariosService {

	@Autowired
	private UsuariosRepository paisRepository;
	
	@Override
	@Autowired
	public void setBaseRepository(BaseRepository<Usuarios, String> repository) {
		super.setBaseRepository(paisRepository);
	}

}
