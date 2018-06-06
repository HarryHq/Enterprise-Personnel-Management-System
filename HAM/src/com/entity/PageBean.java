package com.entity;

import java.util.List;
/**
 * 分页
 * @author yyk46
 *
 * @param <T>
 */
public class PageBean<T> {
	private int currentPage; //当前页
//	private int totalPages;  //总页数
	private int totalRows; //总记录数
	private int pageSize;  //每页记录数
	private List<T> beanList; //当前面的记录
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPages() {
		//根据总记录数和每页记录数来计算总页数
		int totalPages = totalRows/pageSize;
		return totalRows%pageSize==0 ? totalPages :totalPages+1;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalRows=" + totalRows + ", pageSize=" + pageSize
				+ ", beanList=" + beanList + "]";
	}
	
	
	
	

}
