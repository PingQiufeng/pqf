package esc;

public class PageTool {
	private long total; // 总的记录数
	private int pageSize; // 每页的记录数
	private int currentPage; // 当前页
	private String param="";  

	
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public PageTool(long total, int pageSize, int currentPage) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	// 获取总的页数
	public int getPageTotal() {

		if (this.total % this.pageSize == 0) {
			return (int)this.total / this.pageSize;
		} else {
			return (int)this.total / this.pageSize + 1;
		}

	}

	// 获取最后一页页码
	public int getLastPage() {

		return getPageTotal();
	}

	// 是否有上一页
	public boolean getHasPrev() {

		if (this.currentPage == 1)
			return false;
		else
			return true;
	}

	// 是否有下一页
	public boolean getHasNext() {

		if (this.currentPage == this.getPageTotal())
			return false;
		else
			return true;

	}

	// 上一页
	public int getPrev() {

		if (this.getHasPrev())
			return this.currentPage - 1;
		else
			return this.currentPage;
	}
	
	//下一页
	public int getNext(){
		
		if (this.getHasNext())
			return this.currentPage + 1;
		else
			return this.currentPage;	
		
	}
	  
	//获取上一页的整个参数的url
	public String getPrevUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=" + this.getPrev();
		else
			return this.param + "&" + "p=" + this.getPrev();

	}



	//获取下一页的整个参数的url
	public String getNextUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=" + this.getNext();
		else
			return this.param + "&" + "p=" + this.getNext();

	}

	
	
	//获取第一页的整个参数的url
	public String getFirstUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=1";
		else
			return this.param + "&" + "p=1";

	}

	
	
	//获取最后一页的整个参数的url
	public String getLastUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p="+this.getLastPage();
		else
			return this.param + "&" + "p="+this.getLastPage();

	}

	

	public long getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
