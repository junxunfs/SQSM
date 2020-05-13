package com.sqsm.util;

import java.util.List;

/** ��ҳ�Ĺ�����*/
public class PageUtil {
	/**Ҫ���ҳ������Դ*/
	private List list;
	/**ÿҳ��ʾ��������*/
	private Integer count ;
	/**��ʾ��ҳ��*/
	private Integer pageNum;
	/**��Ӧҳ�����ݵĿ�ʼ����(����)*/
	private Integer fromIndex;
	/**��Ӧҳ�����ݵĽ�������(������)*/
	private Integer toIndex;
	/**��ҳ��*/
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
		/**��������һҳ*/
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
