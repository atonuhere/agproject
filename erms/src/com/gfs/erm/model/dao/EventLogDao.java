/**
 * 
 */
package com.gfs.erm.model.dao;

import java.util.List;


/**
 * @author Atonu
 *
 */
public interface EventLogDao {
	/**
	 * Retrieve the primary key
	 * @return
	 */
	public Long getId();

	/**
	 * Returns the list of fields that should be audited.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAuditableFields();

	/**
	 * Returns the field of the primary identifier (e.g. title).
	 * This field is used to uniquely identify the record.
	 * @return
	 */
	public String getPrimaryField();

	/**
	 * Returns customized audit log message. When empty, audit logging
	 * uses standard audit message.
	 * @return
	 */
	public String getAuditMessage();
}