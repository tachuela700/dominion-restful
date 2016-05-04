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

import es.dominion.curso.negocio.entidades.Roles;
import es.dominion.curso.negocio.repositorios.specifications.RolesSpecification;
import es.dominion.curso.negocio.servicios.IRolesService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.RolesDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.ROL_REST_URL)
public class RolesController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private IRolesService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolesDto>> getAll() throws APPException {
        logger.debug("Inicio RolesRestController#getAll");
        List<RolesDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<Roles> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin RolesRestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<RolesDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, RolesDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la información de la bd
			throw new APPException("FTWERRROLESGETALL", e);  
        }
        logger.debug("Fin RolesRestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<RolesDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<RolesDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, RolesDto dto) throws APPException {
		logger.debug("Inicio RolesRestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<RolesDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<Roles> listado = service.findAll(RolesSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin RolesRestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<RolesDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, RolesDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRROLESGETPAGINATED", e);  
		}
		logger.debug("Fin RolesRestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<RolesDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> get(@PathVariable("id") Byte id) throws APPException {
		logger.debug("Inicio RolesRestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		RolesDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		Roles entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin RolesRestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRROLESGETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, RolesDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin RolesRestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<RolesDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> create(@Valid @RequestBody RolesDto dto) throws APPException {
		logger.debug("Inicio RolesRestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		RolesDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		RolesDto dtoBusqueda = new RolesDto();
		dtoBusqueda.setCodigoRol(dto.getCodigoRol());
		if (service.exist(RolesSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin RolesRestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRROLESDUPLICATE");
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			Roles entidad = service.create(mapper.map(dto, Roles.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, RolesDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRROLESCREATE", e, dto.toString());
		}
		
		logger.debug("Fin RolesRestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<RolesDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> update(@PathVariable("id") Byte id, @Valid @RequestBody RolesDto dto)
			throws APPException {
		logger.debug("Inicio RolesRestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		RolesDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		Roles entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin RolesRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRROLESUPDATENOTFOUND", dto.toString(), id);
		}

		try {
			// Se actualiza la información de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setDescripcionRol(dto.getDescripcionRol());

			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, RolesDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRROLESUPDATE", e, dto.toString());
		}
		
		logger.debug("Fin RolesRestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<RolesDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> delete(@RequestBody RolesDto dto) throws APPException {
		logger.debug("Inicio RolesRestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		Roles entidad = service.findById(dto.getCodigoRol());
		if (entidad == null) {
			logger.debug("Fin RolesRestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRROLESDELETENOTFOUND", dto.toString(), dto.getCodigoRol());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRROLESDELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<RolesDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
