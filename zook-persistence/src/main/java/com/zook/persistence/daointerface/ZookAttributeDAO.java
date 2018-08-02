/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */package com.zook.persistence.daointerface;
import com.zook.persistence.dataobject.ZookAttributeDO;
import org.springframework.dao.DataAccessException;


import java.util.*;


/**
 * table:ZOOK_ATTRIBUTE
 * @author eli
 * */
public interface ZookAttributeDAO {


	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookAttribute      where         id = ?          and is_valid =    '1'</pre>
	 */
	public ZookAttributeDO findById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookAttribute      where         resource_id = ?             and is_valid = '1'</pre>
	 */
	public List<ZookAttributeDO> findByResourceId(Long resourceId) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookAttribute      where         attribute_value =    ?          and is_valid = '1'</pre>
	 */
	public List<ZookAttributeDO> findByValue(String attributeValue) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookAttribute      where         is_valid = '1'</pre>
	 */
	public List<ZookAttributeDO> findAll() throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *         from         FlightDrmAttribute         where         is_valid = '1'             and resource_id =    ?                   and       attribute_name like      concat('%', ?,'%' )                    and       attribute_path like      concat('%', ?,'%' )                    and       attribute_value like      concat('%', ?,'%' )</pre> 
	 */
//	public PageList<ZookAttributeDO> AttributePage(AttributePageQuery param) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookAttribute      set         is_valid = '0',update_time =    CURRENT_TIMESTAMP      where         id = ?          and is_valid = '1'</pre>
	 */
	public int deleteById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookAttribute      set         is_valid = '0',update_time =    CURRENT_TIMESTAMP      where         resource_id = ?          and is_valid = '1'</pre>
	 */
	public int deleteByResourceId(Long resourceId) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookAttribute      set         attribute_value =    ?,attribute_path = ?,attribute_name =    ?,remark = ?    ,update_time = CURRENT_TIMESTAMP         where         id = ?          and is_valid = '1'</pre>
	 */
	public int update(ZookAttributeDO drmAttribute) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>insert      into         ZookAttribute         (    resource_id,    attribute_name,    attribute_path,    attribute_value,    remark,    is_valid,    create_time,    update_time,    operator    )         values         (?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?)</pre>
	 */
	public long insert(ZookAttributeDO drmAttribute) throws DataAccessException;

}



