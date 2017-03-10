package com.sirun.common.base;

public class BaseQuery{

	//排序
	private String sortname;
	//当前页
	private Integer currentIndex = 0;
	//当前页最后一个个数
	private Integer currentNum = 0;
	//每页的页数
	private Integer pageSize = 10;
	//排序类型
	private String sortorder;
	//车辆VIN
	private String vin;
	private Integer isVerify; //是否已确认	0:未结束 1:已结束
	
	private Integer isEnd; //是否已结束 0:未结束 1:已结束
	
	public BaseQuery() {
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	

	public int getCurrentNum() {
		return currentNum;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		if(this.pageSize != null && currentIndex != null){
			this.currentNum = currentIndex*this.pageSize;
		}
		this.currentIndex = currentIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(this.currentIndex != null && pageSize != null){
			this.currentNum = this.currentIndex*pageSize;
		}
		this.pageSize = pageSize;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Integer getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Integer isVerify) {
		this.isVerify = isVerify;
	}

	public Integer getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}

}