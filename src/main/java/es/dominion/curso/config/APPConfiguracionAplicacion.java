package es.dominion.curso.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.dominion.curso.negocio.entidades.Pais;
import es.dominion.curso.negocio.entidades.RegistroUsuarios;
import es.dominion.curso.negocio.entidades.Roles;
import es.dominion.curso.negocio.entidades.Tareas;
import es.dominion.curso.negocio.entidades.TareasRealizadas;
import es.dominion.curso.negocio.entidades.TareasUsuarios;
import es.dominion.curso.negocio.entidades.Usuarios;
import es.dominion.curso.util.dtos.PaisDto;
import es.dominion.curso.util.dtos.RegistroUsuariosDto;
import es.dominion.curso.util.dtos.RolesDto;
import es.dominion.curso.util.dtos.TareasDto;
import es.dominion.curso.util.dtos.TareasRealizadasDto;
import es.dominion.curso.util.dtos.TareasUsuariosDto;
import es.dominion.curso.util.dtos.UsuariosDto;

@Configuration
@ComponentScan(basePackages = { "es.dominion.curso.util", "es.dominion.curso.negocio" })
public class APPConfiguracionAplicacion {

	@Bean
	public BeanMappingBuilder beanMappingBuilder() {
		BeanMappingBuilder builder = new BeanMappingBuilder() {
			protected void configure() {
				mapping(Pais.class, PaisDto.class);
				mapping(RegistroUsuarios.class, RegistroUsuariosDto.class);
				mapping(Roles.class, RolesDto.class);
				mapping(Tareas.class, TareasDto.class);
				mapping(TareasRealizadas.class, TareasRealizadasDto.class);
				mapping(TareasUsuarios.class, TareasUsuariosDto.class);
				mapping(Usuarios.class, UsuariosDto.class);
			}
		};

		return builder;
	}

	@Bean
	public Mapper mapper() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(beanMappingBuilder());

		return mapper;
	}
}
