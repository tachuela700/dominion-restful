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

import es.dominion.curso.negocio.entidades.TareasUsuarios;
import es.dominion.curso.negocio.repositorios.specifications.TareasUsuariosSpecification;
import es.dominion.curso.negocio.servicios.ITareasUsuariosService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.TareasUsuariosDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.TAREA_USUARIO_REST_URL)
public class TareasUsuariosController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(TareasUsuariosController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private ITareasUsuariosService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TareasUsuariosDto>> getAll() throws APPException {
        logger.debug("Inicio TareasUsuariosRestController#getAll");
        List<TareasUsuariosDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<TareasUsuarios> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin TareasUsuariosRestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<TareasUsuariosDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, TareasUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la información de la bd
			throw new APPException("FTWERRTAREASUSUARIOSGETALL", e);  
        }
        logger.debug("Fin TareasUsuariosRestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<TareasUsuariosDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TareasUsuariosDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, TareasUsuariosDto dto) throws APPException {
		logger.debug("Inicio TareasUsuariosRestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<TareasUsuariosDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<TareasUsuarios> listado = service.findAll(TareasUsuariosSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin TareasUsuariosRestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<TareasUsuariosDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, TareasUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRTAREASUSUARIOSGETPAGINATED", e);  
		}
		logger.debug("Fin TareasUsuariosRestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<TareasUsuariosDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasUsuariosDto> get(@PathVariable("id") Long id) throws APPException {
		logger.debug("Inicio TareasUsuariosRestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		TareasUsuariosDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		TareasUsuarios entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasUsuariosRestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASUSUARIOSGETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, TareasUsuariosDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin TareasUsuariosRestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<TareasUsuariosDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasUsuariosDto> create(@Valid @RequestBody TareasUsuariosDto dto) throws APPException {
		logger.debug("Inicio TareasUsuariosRestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasUsuariosDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		TareasUsuariosDto dtoBusqueda = new TareasUsuariosDto();
		dtoBusqueda.setCodigoTareausuario(dto.getCodigoTareausuario());
		if (service.exist(TareasUsuariosSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin TareasUsuariosRestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRTAREASUSUARIOSDUPLICATE");
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			TareasUsuarios entidad = service.create(mapper.map(dto, TareasUsuarios.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRTAREASUSUARIOSCREATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasUsuariosRestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<TareasUsuariosDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasUsuariosDto> update(@PathVariable("id") Long id, @Valid @RequestBody TareasUsuariosDto dto)
			throws APPException {
		logger.debug("Inicio TareasUsuariosRestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasUsuariosDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		TareasUsuarios entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasUsuariosRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASUSUARIOSUPDATENOTFOUND", dto.toString(), id);
		}

		try {
			// Se actualiza la información de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setDescripcionTareausuario(dto.getDescripcionTareausuario());
			entidad.setEstadoTarea(dto.getEstadoTarea());

			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasUsuariosDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRTAREASUSUARIOSUPDATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasUsuariosRestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<TareasUsuariosDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasUsuariosDto> delete(@RequestBody TareasUsuariosDto dto) throws APPException {
		logger.debug("Inicio TareasUsuariosRestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		TareasUsuarios entidad = service.findById(dto.getCodigoTareausuario());
		if (entidad == null) {
			logger.debug("Fin TareasUsuariosRestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASUSUARIOSDELETENOTFOUND", dto.toString(), dto.getCodigoTareausuario());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRTAREASUSUARIOSDELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<TareasUsuariosDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
