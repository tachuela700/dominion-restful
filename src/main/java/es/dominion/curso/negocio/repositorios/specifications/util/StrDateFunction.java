package es.dominion.curso.negocio.repositorios.specifications.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Selection;

import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
import org.hibernate.jpa.criteria.ParameterRegistry;
import org.hibernate.jpa.criteria.Renderable;
import org.hibernate.jpa.criteria.compile.RenderingContext;
import org.hibernate.jpa.criteria.expression.function.BasicFunctionExpression;
import org.hibernate.jpa.criteria.expression.function.FunctionExpression;

//plagiarized from org.hibernate.ejb.criteria.expression.function.CastFunction
public class StrDateFunction<Y extends Date> extends BasicFunctionExpression<String>
		implements FunctionExpression<String>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6283527751143724740L;

	public static final String FCT_NAME = "str";

	private final Selection<Y> selection;

	public StrDateFunction(CriteriaBuilder criteriaBuilder, Selection<Y> selection) {
		super((CriteriaBuilderImpl) criteriaBuilder, String.class, FCT_NAME);
		this.selection = selection;
	}

	@Override
	public void registerParameters(ParameterRegistry registry) {
		Helper.possibleParameter(selection, registry);
	}

	@Override
	// public String render(CriteriaQueryCompiler.RenderingContext
	// renderingContext) {
	public String render(RenderingContext renderingContext) {
		return FCT_NAME + '(' + ((Renderable) selection).render(renderingContext) + ')';
	}
}
