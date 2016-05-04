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

import es.dominion.curso.negocio.entidades.Tareas;
import es.dominion.curso.negocio.repositorios.specifications.TareasSpecification;
import es.dominion.curso.negocio.servicios.ITareasService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.TareasDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.TAREA_REST_URL)
public class TareasController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(TareasController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private ITareasService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TareasDto>> getAll() throws APPException {
        logger.debug("Inicio TareasRestController#getAll");
        List<TareasDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<Tareas> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin TareasRestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<TareasDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, TareasDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la información de la bd
			throw new APPException("FTWERRTAREASGETALL", e);  
        }
        logger.debug("Fin TareasRestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<TareasDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TareasDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, TareasDto dto) throws APPException {
		logger.debug("Inicio TareasRestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<TareasDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<Tareas> listado = service.findAll(TareasSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin TareasRestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<TareasDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, TareasDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRTAREASGETPAGINATED", e);  
		}
		logger.debug("Fin TareasRestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<TareasDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasDto> get(@PathVariable("id") Byte id) throws APPException {
		logger.debug("Inicio TareasRestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		TareasDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		Tareas entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasRestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASGETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, TareasDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin TareasRestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<TareasDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasDto> create(@Valid @RequestBody TareasDto dto) throws APPException {
		logger.debug("Inicio TareasRestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		TareasDto dtoBusqueda = new TareasDto();
		dtoBusqueda.setCodigoTarea(dto.getCodigoTarea());
		if (service.exist(TareasSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin TareasRestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRTAREASDUPLICATE");
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			Tareas entidad = service.create(mapper.map(dto, Tareas.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRTAREASCREATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasRestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<TareasDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasDto> update(@PathVariable("id") Byte id, @Valid @RequestBody TareasDto dto)
			throws APPException {
		logger.debug("Inicio TareasRestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		Tareas entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASUPDATENOTFOUND", dto.toString(), id);
		}

		try {
			// Se actualiza la información de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setDescripcionTarea(dto.getDescripcionTarea());
			entidad.setVinculo(dto.getVinculo());

			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRTAREASUPDATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasRestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<TareasDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasDto> delete(@RequestBody TareasDto dto) throws APPException {
		logger.debug("Inicio TareasRestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		Tareas entidad = service.findById(dto.getCodigoTarea());
		if (entidad == null) {
			logger.debug("Fin TareasRestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASDELETENOTFOUND", dto.toString(), dto.getCodigoTarea());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRTAREASDELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<TareasDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
