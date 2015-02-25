package com.gfs.erm.util;

import java.util.ArrayList;
import java.util.List;

import com.gfs.erm.web.common.WebConstants;

/**
 * @author semikas
 *
 */
 public class Pager<T> {

 /**
  * Query result list.
  */
 private List<T> resultList = new ArrayList<T>(); 
 
 /**
  * Requested page number.
  */
 private Integer page = 1;
 
 /**
  * Number of rows displayed in a single page.
  */
 private Integer rows = WebConstants.RECORDS_PER_PAGE;
 
 /**
  * Paging String.
  */
 private String pagingString;
 
 /**
  * Total number of pages.
  */
 private String ajaxPath;
 
 /**
  * Starting row.
  */
 private Integer start=0;
 
 /**
  * max number of rows.
  */
 private Integer end=WebConstants.RECORDS_PER_PAGE;
 /**
  * Order (Desc or Asc).
  */
 private String order;
 /**
  * Sorting column.
  */
 private String sort;
 
 /**
  * Total number of pages.
  */
 private String elementId;
 
 /**
  * Paging String.
  */
 private String searchString;

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
 * @return the pagingString
 */
public String getPagingString() {
	return pagingString;
}

/**
 * @param pagingString the pagingString to set
 */
public void setPagingString(String pagingString) {
	this.pagingString = pagingString;
}

/**
 * @return the ajaxPath
 */
public String getAjaxPath() {
	return ajaxPath;
}

/**
 * @param ajaxPath the ajaxPath to set
 */
public void setAjaxPath(String ajaxPath) {
	this.ajaxPath = ajaxPath;
}

/**
 * @return the elementId
 */
public String getElementId() {
	return elementId;
}

/**
 * @param elementId the elementId to set
 */
public void setElementId(String elementId) {
	this.elementId = elementId;
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

public String getSearchString() {
	return searchString;
}

public void setSearchString(String searchString) {
	this.searchString = searchString;
}
 
}