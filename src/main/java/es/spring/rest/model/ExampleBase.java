package es.spring.rest.model;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ExampleBase implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private static final Logger  LOGGER = LoggerFactory.getLogger(ExampleBase.class);
	private Integer limit;
	private Integer offset;
		
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
		
	public Integer getLimit() {
		return limit;
	}
	
	public Integer getOffset() {
		return offset;
	}
	
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public abstract void setOrderByClause(String orderByClause);
	 
	public abstract List< ? extends CriteriaBase> getOredCriteria();
	
	public abstract void setOredCriteria(List<? extends CriteriaBase> list);
	 
	public abstract CriteriaBase createCriteria();
	
	public abstract List< ? extends CriteriaBase> cloneList();
	
	public Object clone() {
		ExampleBase obj=null;
		try
		{
            obj=(ExampleBase)super.clone();
        }catch(CloneNotSupportedException ex){
        	LOGGER.error("No se puede duplicar el example: "+ex.getMessage());
        }
        obj.setOredCriteria(obj.cloneList());
        return obj;
	}
}
