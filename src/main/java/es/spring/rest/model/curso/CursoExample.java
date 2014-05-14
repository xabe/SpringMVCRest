package es.spring.rest.model.curso;

import java.util.ArrayList;
import java.util.List;

import es.spring.rest.model.CriteriaBase;
import es.spring.rest.model.ExampleBase;

public class CursoExample extends ExampleBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	protected String orderByClause;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	protected boolean distinct;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public CursoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	@SuppressWarnings(value = "unchecked")
	public void setOredCriteria(List<? extends CriteriaBase> list) {
		this.oredCriteria = (List<Criteria>) list;
	}

	@Override
	public List<? extends CriteriaBase> cloneList() {
		List<Criteria> clone = new ArrayList<Criteria>(oredCriteria.size());
		for (Criteria item : oredCriteria) {
			clone.add((Criteria) item.clone());
		}
		return clone;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		
		public Criteria andHorasIsNull() {
			addCriterion("horas is null");
			return (Criteria) this;
		}

		public Criteria andHorasIsNotNull() {
			addCriterion("horas is not null");
			return (Criteria) this;
		}

		public Criteria andHorasEqualTo(Integer value) {
			addCriterion("horas =", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasNotEqualTo(Integer value) {
			addCriterion("horas <>", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasGreaterThan(Integer value) {
			addCriterion("horas >", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasGreaterThanOrEqualTo(Integer value) {
			addCriterion("horas >=", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasLessThan(Integer value) {
			addCriterion("horas <", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasLessThanOrEqualTo(Integer value) {
			addCriterion("horas <=", value, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasIn(List<Integer> values) {
			addCriterion("horas in", values, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasNotIn(List<Integer> values) {
			addCriterion("horas not in", values, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasBetween(Integer value1, Integer value2) {
			addCriterion("horas between", value1, value2, "horas");
			return (Criteria) this;
		}

		public Criteria andHorasNotBetween(Integer value1, Integer value2) {
			addCriterion("horas not between", value1, value2, "horas");
			return (Criteria) this;
		}
		
		public Criteria andProfesorIsNull() {
			addCriterion("profesor is null");
			return (Criteria) this;
		}

		public Criteria andProfesorIsNotNull() {
			addCriterion("profesor is not null");
			return (Criteria) this;
		}

		public Criteria andProfesorEqualTo(Integer value) {
			addCriterion("profesor =", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorNotEqualTo(Integer value) {
			addCriterion("profesor <>", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorGreaterThan(Integer value) {
			addCriterion("profesor >", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorGreaterThanOrEqualTo(Integer value) {
			addCriterion("profesor >=", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorLessThan(Integer value) {
			addCriterion("profesor <", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorLessThanOrEqualTo(Integer value) {
			addCriterion("profesor <=", value, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorIn(List<Integer> values) {
			addCriterion("profesor in", values, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorNotIn(List<Integer> values) {
			addCriterion("profesor not in", values, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorBetween(Integer value1, Integer value2) {
			addCriterion("profesor between", value1, value2, "profesor");
			return (Criteria) this;
		}

		public Criteria andProfesorNotBetween(Integer value1, Integer value2) {
			addCriterion("profesor not between", value1, value2, "profesor");
			return (Criteria) this;
		}
		
		public Criteria andActivoIsNull() {
			addCriterion("activo is null");
			return (Criteria) this;
		}

		public Criteria andActivoIsNotNull() {
			addCriterion("activo is not null");
			return (Criteria) this;
		}

		public Criteria andActivoEqualTo(Boolean value) {
			addCriterion("activo =", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoNotEqualTo(Boolean value) {
			addCriterion("activo <>", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoGreaterThan(Boolean value) {
			addCriterion("activo >", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoGreaterThanOrEqualTo(Boolean value) {
			addCriterion("activo >=", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoLessThan(Boolean value) {
			addCriterion("activo <", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoLessThanOrEqualTo(Boolean value) {
			addCriterion("activo <=", value, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoIn(List<Boolean> values) {
			addCriterion("activo in", values, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoNotIn(List<Boolean> values) {
			addCriterion("activo not in", values, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoBetween(Boolean value1, Boolean value2) {
			addCriterion("activo between", value1, value2, "activo");
			return (Criteria) this;
		}

		public Criteria andActivoNotBetween(Boolean value1, Boolean value2) {
			addCriterion("activo not between", value1, value2, "activo");
			return (Criteria) this;
		}

		public Criteria andTituloIsNull() {
			addCriterion("titulo is null");
			return (Criteria) this;
		}

		public Criteria andTituloIsNotNull() {
			addCriterion("titulo is not null");
			return (Criteria) this;
		}

		public Criteria andTituloEqualTo(String value) {
			addCriterion("titulo =", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloNotEqualTo(String value) {
			addCriterion("titulo <>", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloGreaterThan(String value) {
			addCriterion("titulo >", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloGreaterThanOrEqualTo(String value) {
			addCriterion("titulo >=", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloLessThan(String value) {
			addCriterion("titulo <", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloLessThanOrEqualTo(String value) {
			addCriterion("titulo <=", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloLike(String value) {
			addCriterion("titulo like", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloNotLike(String value) {
			addCriterion("titulo not like", value, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloIn(List<String> values) {
			addCriterion("titulo in", values, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloNotIn(List<String> values) {
			addCriterion("titulo not in", values, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloBetween(String value1, String value2) {
			addCriterion("titulo between", value1, value2, "titulo");
			return (Criteria) this;
		}

		public Criteria andTituloNotBetween(String value1, String value2) {
			addCriterion("titulo not between", value1, value2, "titulo");
			return (Criteria) this;
		}
		
		public Criteria andNivelIsNull() {
			addCriterion("nivel is null");
			return (Criteria) this;
		}

		public Criteria andNivelIsNotNull() {
			addCriterion("nivel is not null");
			return (Criteria) this;
		}

		public Criteria andNivelEqualTo(String value) {
			addCriterion("nivel =", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelNotEqualTo(String value) {
			addCriterion("nivel <>", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelGreaterThan(String value) {
			addCriterion("nivel >", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelGreaterThanOrEqualTo(String value) {
			addCriterion("nivel >=", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelLessThan(String value) {
			addCriterion("nivel <", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelLessThanOrEqualTo(String value) {
			addCriterion("nivel <=", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelLike(String value) {
			addCriterion("nivel like", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelNotLike(String value) {
			addCriterion("nivel not like", value, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelIn(List<String> values) {
			addCriterion("nivel in", values, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelNotIn(List<String> values) {
			addCriterion("nivel not in", values, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelBetween(String value1, String value2) {
			addCriterion("nivel between", value1, value2, "nivel");
			return (Criteria) this;
		}

		public Criteria andNivelNotBetween(String value1, String value2) {
			addCriterion("nivel not between", value1, value2, "nivel");
			return (Criteria) this;
		}
		
		public Criteria andDocumentoIsNull() {
			addCriterion("documento is null");
			return (Criteria) this;
		}

		public Criteria andDocumentoIsNotNull() {
			addCriterion("documento is not null");
			return (Criteria) this;
		}

		public Criteria andDocumentoEqualTo(String value) {
			addCriterion("documento =", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoNotEqualTo(String value) {
			addCriterion("documento <>", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoGreaterThan(String value) {
			addCriterion("documento >", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoGreaterThanOrEqualTo(String value) {
			addCriterion("documento >=", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoLessThan(String value) {
			addCriterion("documento <", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoLessThanOrEqualTo(String value) {
			addCriterion("documento <=", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoLike(String value) {
			addCriterion("documento like", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoNotLike(String value) {
			addCriterion("documento not like", value, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoIn(List<String> values) {
			addCriterion("documento in", values, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoNotIn(List<String> values) {
			addCriterion("documento not in", values, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoBetween(String value1, String value2) {
			addCriterion("documento between", value1, value2, "documento");
			return (Criteria) this;
		}

		public Criteria andDocumentoNotBetween(String value1, String value2) {
			addCriterion("documento not between", value1, value2, "documento");
			return (Criteria) this;
		}

		// Se clona la lista de criterion

		public void setCriteria(List<Criterion> list) {
			this.criteria = list;
		}

		public List<Criterion> cloneList() {
			List<Criterion> clone = new ArrayList<Criterion>(criteria.size());
			for (Criterion item : criteria) {
				clone.add((Criterion) item.clone());
			}
			return clone;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated do_not_delete_during_merge Tue Oct 08 08:20:18 CEST 2013
	 */
	public static class Criteria extends GeneratedCriteria implements
			CriteriaBase {

		public Object clone() {
			GeneratedCriteria obj = null;
			try {
				obj = (GeneratedCriteria) super.clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(" no se puede duplicar criteria");
			}
			obj.setCriteria(obj.cloneList());
			return obj;
		}

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table t_prueba
	 * 
	 * @mbggenerated Tue Oct 08 08:20:18 CEST 2013
	 */
	public static class Criterion implements Cloneable {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}

		public Object clone() {
			Criterion obj = null;
			try {
				obj = (Criterion) super.clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(" no se puede duplicar criterion");
			}
			return obj;
		}
	}
}
