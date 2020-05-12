package com.sqsm.util;

import java.util.List;

/** 分页的工具类*/
public class PageUtil {
	/**要求分页的数据源*/
	private List list;
	/**每页显示的数据量*/
	private Integer count ;
	/**显示的页码*/
	private Integer pageNum;
	/**对应页码数据的开始索引(包含)*/
	private Integer fromIndex;
	/**对应页码数据的结束索引(不包含)*/
	private Integer toIndex;
	/**总页数*/
	private Integer pageCount;
	
	public PageUtil(List list, Integer count, Integer pageNum) {
		super();
		this.list = list;
		this.count = count;
		this.pageNum = pageNum;
		
		setPageCount();
		setFromIndex();
		setToIndex();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex() {
		if(pageNum==1){
			this.fromIndex=0;
		}else{
			this.fromIndex=(pageNum-1)*count;	
		}
	}

	public Integer getToIndex() {
		return toIndex;
	}

	public void setToIndex() {
		/**如果是最后一页*/
		if(pageNum==pageCount){
			this.toIndex=list.size();
		}else{
			this.toIndex=pageNum*count;
		}
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount() {
		if(count==null||count==0){
			count=10;
		}
		pageCount = (list.size()%count)==0?list.size()/count:list.size()/count+1;
	}

	
	
}
