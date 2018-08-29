/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */package com.zook.persistence.daointerface;
import com.zook.persistence.dataobject.ZookDomainDO;
import com.zook.persistence.operation.DomainQueryDO;
import org.springframework.dao.DataAccessException;
import java.util.*;

/**
 * table:ZOOK_DOMAIN
 * @author eli
 * */
public interface ZookDomainDAO {


	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookDomain      where         id = ?          and is_valid = '1'</pre>
	 */
	ZookDomainDO findById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookDomain      where         domain_path = ?          and is_valid = '1'</pre>
	 */
	ZookDomainDO findByPath(String domainPath) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>select         *      from         ZookDomain      where         is_valid = '1'</pre>
	 */
	List<ZookDomainDO> findAll() throws DataAccessException;


	/**
	 * 
	 * sql:
	 * <pre>update         ZookDomain      set         is_valid = '0',update_time = CURRENT_TIMESTAMP       where         id = ?          and is_valid = '1'</pre>
	 */
	int deleteById(Long id) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookDomain      set         is_valid = '0',update_time = CURRENT_TIMESTAMP      where         domain_path = ?          and is_valid = '1'</pre>
	 */
	int deleteByPath(String domainPath) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>update         ZookDomain      set         domain_name =?,domain_value =?,domain_path = ?,remark =?,update_time = CURRENT_TIMESTAMP         where         id = ?          and is_valid = '1'</pre>
	 */
	int update(ZookDomainDO zookDomain) throws DataAccessException;

	/**
	 * 
	 * sql:
	 * <pre>insert      into         ZookDomain         (     domain_name,      domain_path,      domain_value,     remark,      is_valid,      create_time,     update_time,     operator     )          values         (?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?)</pre>
	 */
	long insert(ZookDomainDO zookDomain) throws DataAccessException;

	/**
	 *
	 * @param domainQuery
	 * @return
	 * @throws DataAccessException
     */
	int count(DomainQueryDO domainQuery) throws DataAccessException;

	/**
	 *
	 * @param domainQuery
	 * @return
	 * @throws DataAccessException
     */
	List<ZookDomainDO> queryByParam(DomainQueryDO domainQuery) throws DataAccessException;

}



