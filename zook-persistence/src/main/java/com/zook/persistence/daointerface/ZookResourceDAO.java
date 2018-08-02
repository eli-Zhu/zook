/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */package com.zook.persistence.daointerface;
import com.zook.persistence.dataobject.ZookResourceDO;
import org.springframework.dao.DataAccessException;
import java.util.*;

/**
 * table:ZOOK_RESOURCE
 * @author eli
 * */
public interface ZookResourceDAO {


	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookResource      where         id = ?          and is_valid = '1'</pre>
	 */
	public ZookResourceDO findById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookResource      where         domain_id = ?          and is_valid =    '1'</pre>
	 */
	public List<ZookResourceDO> findByDomainId(Long domainId) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookResource      where         resource_path = ?          and    is_valid = '1'</pre>
	 */
	public List<ZookResourceDO> findByPath(String resourcePath) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookResource      where         is_valid = '1'</pre>
	 */
	public List<ZookResourceDO> findAll() throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *         from         ZookResource         where         domain_id = ?             and is_valid = '1'                   and       resource_name like concat('%', ?,'%' )                    and       resource_path like concat('%', ?,'%' )</pre>
	 */
//	public PageList<ZookResourceDO> resourcePage(ResourcePageQuery param) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookResource      set         is_valid = '0',update_time = CURRENT_TIMESTAMP         where         id = ?          and is_valid = '1'</pre>
	 */
	public int deleteById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookResource      set         is_valid = '0',update_time = CURRENT_TIMESTAMP         where         domain_id = ?          and is_valid = '1'</pre>
	 */
	public int deleteByDomainId(Long domainId) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookResource      set         resource_value =?,resource_name    =?,resource_path = ?,remark    =?,update_time = CURRENT_TIMESTAMP         where         is_valid = '1'          and id = ?</pre>
	 */
	public int update(ZookResourceDO drmResource) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>insert      into         ZookResource         (    domain_id,    resource_name,    resource_path,    resource_value,    remark,    is_valid,    create_time,    update_time,    operator    )         values         (?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?)</pre>
	 */
	public long insert(ZookResourceDO drmResource) throws DataAccessException;

}



