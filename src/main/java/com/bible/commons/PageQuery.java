package com.bible.commons;

/**
 * 类名称：PageInfo<br> 
 * 类描述：分页信息基础类 <br>
 */
public class PageQuery  {
	private int pageNum=0; //当前页码数
	private int pageSize=10; //每次多少行
	private String  sortColumns; //排序列名
	
	public String getSortColumns() {
		return sortColumns;
	}
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}