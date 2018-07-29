package esc;

public class PageTool {
	private long total; // �ܵļ�¼��
	private int pageSize; // ÿҳ�ļ�¼��
	private int currentPage; // ��ǰҳ
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

	// ��ȡ�ܵ�ҳ��
	public int getPageTotal() {

		if (this.total % this.pageSize == 0) {
			return (int)this.total / this.pageSize;
		} else {
			return (int)this.total / this.pageSize + 1;
		}

	}

	// ��ȡ���һҳҳ��
	public int getLastPage() {

		return getPageTotal();
	}

	// �Ƿ�����һҳ
	public boolean getHasPrev() {

		if (this.currentPage == 1)
			return false;
		else
			return true;
	}

	// �Ƿ�����һҳ
	public boolean getHasNext() {

		if (this.currentPage == this.getPageTotal())
			return false;
		else
			return true;

	}

	// ��һҳ
	public int getPrev() {

		if (this.getHasPrev())
			return this.currentPage - 1;
		else
			return this.currentPage;
	}
	
	//��һҳ
	public int getNext(){
		
		if (this.getHasNext())
			return this.currentPage + 1;
		else
			return this.currentPage;	
		
	}
	  
	//��ȡ��һҳ������������url
	public String getPrevUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=" + this.getPrev();
		else
			return this.param + "&" + "p=" + this.getPrev();

	}



	//��ȡ��һҳ������������url
	public String getNextUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=" + this.getNext();
		else
			return this.param + "&" + "p=" + this.getNext();

	}

	
	
	//��ȡ��һҳ������������url
	public String getFirstUrl() {
		if (this.param == null || this.param.length() == 0)
			
			return "p=1";
		else
			return this.param + "&" + "p=1";

	}

	
	
	//��ȡ���һҳ������������url
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
