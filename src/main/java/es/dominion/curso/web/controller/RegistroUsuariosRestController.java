package es.dominion.curso.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.dominion.curso.negocio.entidades.RegistroUsuarios;
import es.dominion.curso.negocio.repositorios.specifications.RegistroUsuariosSpecification;
import es.dominion.curso.negocio.servicios.IRegistroUsuariosService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.RegistroUsuariosDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.REGISTRO_USUARIO_REST_URL)
public class RegistroUsuariosRestController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RegistroUsuariosRestController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private IRegistroUsuariosService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegistroUsuariosDto>> getAll() throws APPException {
        logger.debug("Inicio RegistroUsuariosRestController#getAll");
        List<RegistroUsuariosDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<RegistroUsuarios> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin RegistroUsuariosRestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<RegistroUsuariosDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, RegistroUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la información de la bd
			throw new APPException("FTWERRREGISTROUSUARIOSGETALL", e);  
        }
        logger.debug("Fin RegistroUsuariosRestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<RegistroUsuariosDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<RegistroUsuariosDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, RegistroUsuariosDto dto) throws APPException {
		logger.debug("Inicio RegistroUsuariosRestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<RegistroUsuariosDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<RegistroUsuarios> listado = service.findAll(RegistroUsuariosSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin RegistroUsuariosRestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<RegistroUsuariosDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, RegistroUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRREGISTROUSUARIOSGETPAGINATED", e);  
		}
		logger.debug("Fin RegistroUsuariosRestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<RegistroUsuariosDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroUsuariosDto> get(@PathVariable("id") Long id) throws APPException {
		logger.debug("Inicio RegistroUsuariosRestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		RegistroUsuariosDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		RegistroUsuarios entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin RegistroUsuariosRestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRREGISTROUSUARIOSGETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, RegistroUsuariosDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin RegistroUsuariosRestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<RegistroUsuariosDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroUsuariosDto> create(@Valid @RequestBody RegistroUsuariosDto dto) throws APPException {
		logger.debug("Inicio RegistroUsuariosRestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		RegistroUsuariosDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		RegistroUsuariosDto dtoBusqueda = new RegistroUsuariosDto();
		dtoBusqueda.setCodigoRegistro(dto.getCodigoRegistro());
		if (service.exist(RegistroUsuariosSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin RegistroUsuariosRestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRREGISTROUSUARIOSDUPLICATE");
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			RegistroUsuarios entidad = service.create(mapper.map(dto, RegistroUsuarios.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, RegistroUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRREGISTROUSUARIOSCREATE", e, dto.toString());
		}
		
		logger.debug("Fin RegistroUsuariosRestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<RegistroUsuariosDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroUsuariosDto> update(@PathVariable("id") Long id, @Valid @RequestBody RegistroUsuariosDto dto)
			throws APPException {
		logger.debug("Inicio RegistroUsuariosRestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		RegistroUsuariosDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		RegistroUsuarios entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin RegistroUsuariosRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRREGISTROUSUARIOSUPDATENOTFOUND", dto.toString(), id);
		}

		try {
			// Se actualiza la información de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setCodigoUsuario(dto.getCodigoUsuario());
			entidad.setDuracion(dto.getDuracion());
			entidad.setFechaEntrada(dto.getFechaEntrada());
			entidad.setFechaSalida(dto.getFechaSalida());
			entidad.setFicherosSubidos(dto.getFicherosSubidos());
			entidad.setInformacionSubida(dto.getInformacionSubida());

			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, RegistroUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRREGISTROUSUARIOSUPDATE", e, dto.toString());
		}
		
		logger.debug("Fin RegistroUsuariosRestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<RegistroUsuariosDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroUsuariosDto> delete(@RequestBody RegistroUsuariosDto dto) throws APPException {
		logger.debug("Inicio RegistroUsuariosRestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		RegistroUsuarios entidad = service.findById(dto.getCodigoRegistro());
		if (entidad == null) {
			logger.debug("Fin RegistroUsuariosRestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRREGISTROUSUARIOSDELETENOTFOUND", dto.toString(), dto.getCodigoRegistro());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRREGISTROUSUARIOSDELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<RegistroUsuariosDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
