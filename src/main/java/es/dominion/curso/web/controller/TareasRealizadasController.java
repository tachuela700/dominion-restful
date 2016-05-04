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

import es.dominion.curso.negocio.entidades.TareasRealizadas;
import es.dominion.curso.negocio.entidades.TareasUsuarios;
import es.dominion.curso.negocio.repositorios.specifications.TareasRealizadasSpecification;
import es.dominion.curso.negocio.servicios.ITareasRealizadasService;
import es.dominion.curso.negocio.servicios.ITareasUsuariosService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.TareasRealizadasDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.TAREA_REALIZADA_REST_URL)
public class TareasRealizadasController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(TareasRealizadasController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private ITareasRealizadasService service;
	
	@Autowired
	private ITareasUsuariosService tUsuariosService;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TareasRealizadasDto>> getAll() throws APPException {
        logger.debug("Inicio TareasRealizadasRestController#getAll");
        List<TareasRealizadasDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<TareasRealizadas> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin TareasRealizadasRestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<TareasRealizadasDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, TareasRealizadasDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la informaci√≥n de la bd
			throw new APPException("FTWERRTAREASREALIZADASGETALL", e);  
        }
        logger.debug("Fin TareasRealizadasRestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<TareasRealizadasDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TareasRealizadasDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, TareasRealizadasDto dto) throws APPException {
		logger.debug("Inicio TareasRealizadasRestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<TareasRealizadasDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<TareasRealizadas> listado = service.findAll(TareasRealizadasSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin TareasRealizadasRestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<TareasRealizadasDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, TareasRealizadasDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRTAREASREALIZADASGETPAGINATED", e);  
		}
		logger.debug("Fin TareasRealizadasRestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<TareasRealizadasDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasRealizadasDto> get(@PathVariable("id") Long id) throws APPException {
		logger.debug("Inicio TareasRealizadasRestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		TareasRealizadasDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		TareasRealizadas entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasRealizadasRestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASREALIZADASGETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, TareasRealizadasDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin TareasRealizadasRestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<TareasRealizadasDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasRealizadasDto> create(@Valid @RequestBody TareasRealizadasDto dto) throws APPException {
		logger.debug("Inicio TareasRealizadasRestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasRealizadasDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		TareasRealizadasDto dtoBusqueda = new TareasRealizadasDto();
		dtoBusqueda.setCodigoTarearealizada(dto.getCodigoTarearealizada());
		if (service.exist(TareasRealizadasSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin TareasRealizadasRestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRTAREASREALIZADASDUPLICATE");
		}
		
		TareasUsuarios tUsuarios = tUsuariosService.findById(dto.getTareasUsuariosDto().getCodigoTareausuario());
		if (tUsuarios == null) {
			logger.debug("Fin TareasRealizadasRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASREALIZADASTAREASUSUARIOSCREATENOTFOUND", dto.toString(), dto.getTareasUsuariosDto().getCodigoTareausuario());
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			TareasRealizadas entidad = service.create(mapper.map(dto, TareasRealizadas.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasRealizadasDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRTAREASREALIZADASCREATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasRealizadasRestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<TareasRealizadasDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasRealizadasDto> update(@PathVariable("id") Long id, @Valid @RequestBody TareasRealizadasDto dto)
			throws APPException {
		logger.debug("Inicio TareasRealizadasRestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		TareasRealizadasDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		TareasRealizadas entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin TareasRealizadasRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASREALIZADASUPDATENOTFOUND", dto.toString(), id);
		}
		
		TareasUsuarios tUsuarios = tUsuariosService.findById(dto.getTareasUsuariosDto().getCodigoTareausuario());
		if (tUsuarios == null) {
			logger.debug("Fin TareasRealizadasRestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASREALIZADASTAREASUSUARIOSUPDATENOTFOUND", dto.toString(), dto.getTareasUsuariosDto().getCodigoTareausuario());
		}

		try {
			// Se actualiza la informaci√≥n de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setTareasUsuarios(tUsuarios);
			entidad.setUsuario(dto.getUsuario());
			entidad.setFechaRealizacion(dto.getFechaRealizacion());
			entidad.setDatosAÒadidos(dto.getDatosAÒadidos());
			entidad.setDatosModificados(dto.getDatosModificados());
			entidad.setDatosEliminados(dto.getDatosEliminados());
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, TareasRealizadasDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRTAREASREALIZADASUPDATE", e, dto.toString());
		}
		
		logger.debug("Fin TareasRealizadasRestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<TareasRealizadasDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TareasRealizadasDto> delete(@RequestBody TareasRealizadasDto dto) throws APPException {
		logger.debug("Inicio TareasRealizadasRestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		TareasRealizadas entidad = service.findById(dto.getCodigoTarearealizada());
		if (entidad == null) {
			logger.debug("Fin TareasRealizadasRestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRTAREASREALIZADASDELETENOTFOUND", dto.toString(), dto.getCodigoTarearealizada());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRTAREASREALIZADASDELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<TareasRealizadasDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
