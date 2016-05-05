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

import es.dominion.curso.negocio.entidades.Pais;
import es.dominion.curso.negocio.repositorios.specifications.PaisSpecification;
import es.dominion.curso.negocio.servicios.IPaisService;
import es.dominion.curso.util.comunes.APPCollectionUtils;
import es.dominion.curso.util.comunes.APPMapperUtils;
import es.dominion.curso.util.constantes.ConstantesURL;
import es.dominion.curso.util.dtos.PaisDto;
import es.dominion.curso.util.excepciones.APPException;

@RestController
@RequestMapping(value = ConstantesURL.PAIS_REST_URL)
public class PaisRestController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PaisRestController.class);

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private IPaisService service;
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaisDto>> getAll() throws APPException {
        logger.debug("Inicio Prueba1RestController#getAll");
        List<PaisDto> resultado = null;
        try {
        	//Se recuperan todas las entidades del sistema
        	List<Pais> listado = service.findAll();
	    	if(listado==null || listado.isEmpty()){
                logger.debug("Fin Prueba1RestController#getAll - return 'NO_FOUND'");
                //Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<List<PaisDto>>(HttpStatus.NOT_FOUND);//se puede devolver tambien HttpStatus.NOT_CONTENT
            }
	    	
	    	logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintCollection(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, listado, PaisDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintCollection(resultado)+"]");
        } catch(Exception e) {
        	// Se lanza excepcion - error al recuperar la información de la bd
			throw new APPException("FTWERRPRUEBA1GETALL", e);  
        }
        logger.debug("Fin Prueba1RestController#getAll - return ["+resultado+"]");
        //Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<List<PaisDto>>(resultado, HttpStatus.OK);
    }
	
	@RequestMapping(value = {ConstantesURL.SEARCH_URL/*, ConstantesURL.SEARCH_BASIC_URL*/}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PaisDto>> search(@RequestParam("searchBasic") String searchBasic, Pageable pageable, PaisDto dto) throws APPException {
		logger.debug("Inicio Prueba1RestController#search - Parametros de entrada: ");
		logger.debug("searchBasic: 	["+searchBasic+"]");
		logger.debug("Pageable: 	["+pageable+"]");
		logger.debug("Dto: 			["+dto+"]");
		
		Page<PaisDto> resultado = null;
		try {
			//Se recuperan las clientes del sistema de acuerdo a los criterios de busqueda establecidos por el usuario
			Page<Pais> listado = service.findAll(PaisSpecification.getSpecification(dto, searchBasic), pageable); 
			if(listado==null || listado.getContent()==null || listado.getContent().isEmpty()){
				logger.debug("Fin Prueba1RestController#search - return 'NO_FOUND'");
				//Se devuelve un mensaje http indicando que no se han recuperado registros de la bd
            	return new ResponseEntity<Page<PaisDto>>(HttpStatus.NOT_FOUND);
	        }
	    	
			logger.debug("mapeando el objeto: ["+APPCollectionUtils.debugPrintPage(listado)+"]");
            //Se mapea al objeto de salida
        	resultado = APPMapperUtils.map(mapper, pageable, listado, PaisDto.class);
	    	logger.debug("objeto mapeado: ["+APPCollectionUtils.debugPrintPage(resultado)+"]");
		} catch(Exception e) {
			throw new APPException("FTWERRPRUEBA1GETPAGINATED", e);  
		}
		logger.debug("Fin Prueba1RestController#search - return ["+resultado+"]");
		//Se devuelve el listado de registros que se han recuperado de la bd
    	return new ResponseEntity<Page<PaisDto>>(resultado, HttpStatus.OK);
	}
    
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaisDto> get(@PathVariable("id") Long id) throws APPException {
		logger.debug("Inicio Prueba1RestController#get - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		PaisDto resultado = null;
		
		// Se recupera la entidad del sistema, sino existe se lanza excepcion
		Pais entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin Prueba1RestController#get - return 'NOT_FOUND'");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRPRUEBA1GETIDNOTFOUND", id);
		}

		logger.debug("mapeando el objeto: ["+entidad+"]");
        //Se mapea al objeto de salida
    	resultado = mapper.map(entidad, PaisDto.class);
    	logger.debug("objeto mapeado: ["+resultado+"]");
    			
		logger.debug("Fin Prueba1RestController#get - return [" + resultado + "]");
		//Se devuelve el registro que se ha recuperado de la bd
    	return new ResponseEntity<PaisDto>(resultado, HttpStatus.OK);
	}
	   
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaisDto> create(@Valid @RequestBody PaisDto dto) throws APPException {
		logger.debug("Inicio Prueba1RestController#create - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");
		PaisDto resultado = null;

		// Se comprueba que no exista otra entidad igual en el sistema, si existe se lanza excepcion
		PaisDto dtoBusqueda = new PaisDto();
		dtoBusqueda.setCodigoPais(dto.getCodigoPais());
		if (service.exist(PaisSpecification.getSpecification(dtoBusqueda, null))) {
			logger.debug("Fin Prueba1RestController#create - registro duplicado");
			// Se lanza excepcion - registro duplicado
			throw new APPException("FTWERRPRUEBA1DUPLICATE");
		}

		try {
			// Se registra en el sistema la nueva entidad con los datos introducidos por el usuario
			Pais entidad = service.create(mapper.map(dto, Pais.class));
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, PaisDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al registrar la nueva entidad
			throw new APPException("FTWERRPRUEBA1CREATE", e, dto.toString());
		}
		
		logger.debug("Fin Prueba1RestController#create - return [" + resultado + "]");
		//Se devuelve la nueva entidad registrada en la bd
    	return new ResponseEntity<PaisDto>(resultado, HttpStatus.CREATED);
	}
	   
	@RequestMapping(value = ConstantesURL.ID_PARAMETER, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaisDto> update(@PathVariable("id") Long id, @Valid @RequestBody PaisDto dto)
			throws APPException {
		logger.debug("Inicio Prueba1RestController#update - Parametros de entrada: ");
		logger.debug("Id: [" + id + "]");
		logger.debug(dto!=null ? dto.toString() : "");
		PaisDto resultado = null;
		
		// Se recupera la cliente del sistema, sino existe se lanza excepcion
		Pais entidad = service.findById(id);
		if (entidad == null) {
			logger.debug("Fin Prueba1RestController#update - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRPRUEBA1UPDATENOTFOUND", dto.toString(), id);
		}

		try {
			// Se actualiza la información de la entidad del sistema con los datos que ha introducido el usuario
			entidad.setPaisIso2(dto.getPaisIso2());
			entidad.setPaisIso3(dto.getPaisIso3());
			entidad.setPaisNombre(dto.getPaisNombre());
			entidad.setPaisIsonum(dto.getPaisIsonum());

			//Se actualiza el registro en el sistema
			service.update(entidad);
			
			logger.debug("mapeando el objeto: ["+entidad+"]");
            //Se mapea al objeto de salida
	    	resultado = mapper.map(entidad, PaisDto.class);
	    	logger.debug("objeto mapeado: ["+resultado+"]");
		} catch (Exception e) {
			// Se lanza excepcion - error al modificar la entidad
			throw new APPException("FTWERRPRUEBA1UPDATE", e, dto.toString());
		}
		
		logger.debug("Fin Prueba1RestController#update - return [" + resultado + "]");
		//Se devuelve la entidad que se ha actualizado en la bd
    	return new ResponseEntity<PaisDto>(resultado, HttpStatus.OK);
	}
	  
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaisDto> delete(@RequestBody PaisDto dto) throws APPException {
		logger.debug("Inicio Prueba1RestController#delete - Parametros de entrada: ");
		logger.debug(dto!=null ? dto.toString() : "");

		// Se recupera la entidad del sistema, sino existe se lanza una excepcion
		Pais entidad = service.findById(dto.getCodigoPais());
		if (entidad == null) {
			logger.debug("Fin Prueba1RestController#delete - entidad no encontrada");
			// Se lanza excepcion - entidad no encontrada
			throw new APPException("FTWERRPRUEBA1DELETENOTFOUND", dto.toString(), dto.getCodigoPais());
		}

		try {
			// Se elimina la entidad del sistema
			service.delete(entidad);
		} catch (Exception e) {
			throw new APPException("FTWERRPRUEBA1DELETE", e, dto.toString());
		}
		logger.debug("Fin delete.");
		//Se devuelve 'NO_CONTENT' ya que no se puede devolver una entidad que no existe en la bd
    	return new ResponseEntity<PaisDto>(HttpStatus.NO_CONTENT);
	}
	
	
}
