package com.gfs.erm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author atonu
 *
 */
 public class Page<T> {

 /**
  * Query result list.
  */
 private List<T> resultList = new ArrayList<T>(); 
 
 /**
  * Total number of records return from the query.
  */
 private Integer records;
 
 /**
  * Total number of records return from the query.
  */
 private Integer rows;
 
 /**
  * Total number of records return from the query.
  */
 private Integer page;
 
 /**
  * Starting row.
  */
 private Integer start;
 
 /**
  * max number of rows.
  */
 private Integer end;
 /**
  * Order (Desc or Asc).
  */
 private String order;
 /**
  * Sorting column.
  */
 private String sort;
 
 /**
  * Sorting column.
  */
 private Integer total;

 /**
  * @return the resultDtoList
  */
 public List<T> getResultList() {
      return resultList;
 }

 /**
  * @param resultDtoList the resultDtoList to set
  */
 public void setResultList(List<T> resultList) {
      this.resultList = resultList;
 }

 
 /**
  * @return the records
  */
 public Integer getRecords() {
      return records;
 }

 /**
  * @param records the records to set
  */
 public void setRecords(Integer records) {
      this.records = records;
 }

 
/**
 * @return the start
 */
public Integer getStart() {
	return start;
}

/**
 * @param start the start to set
 */
public void setStart(Integer start) {
	this.start = start;
}

/**
 * @return the end
 */
public Integer getEnd() {
	return end;
}

/**
 * @param end the end to set
 */
public void setEnd(Integer end) {
	this.end = end;
}

/**
 * @return the order
 */
public String getOrder() {
	return order;
}

/**
 * @param order the order to set
 */
public void setOrder(String order) {
	this.order = order;
}

/**
 * @return the sort
 */
public String getSort() {
	return sort;
}

/**
 * @param sort the sort to set
 */
public void setSort(String sort) {
	this.sort = sort;
}

/**
 * @return the rows
 */
public Integer getRows() {
	return rows;
}

/**
 * @param rows the rows to set
 */
public void setRows(Integer rows) {
	this.rows = rows;
}

/**
 * @return the page
 */
public Integer getPage() {
	return page;
}

/**
 * @param page the page to set
 */
public void setPage(Integer page) {
	this.page = page;
}

/**
 * @return the total
 */
public Integer getTotal() {
	return total;
}

/**
 * @param total the total to set
 */
public void setTotal(Integer total) {
	this.total = total;
}
 
}