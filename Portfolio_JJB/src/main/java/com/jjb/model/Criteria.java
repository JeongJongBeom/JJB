package com.jjb.model;

public class Criteria {
	//��������ȣ
	private int pageNum;
	//�� �������� ������ ó�� ����(10��)
	private int amount;
	
	private String keyword;
	//ó������ �ƴ��� �ľ��ϱ� ����
	private boolean check;
	//� �޴��� � ī�װ����� �����ϱ� ����
	private String page;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if(keyword.equals("")) {
			keyword=null;
		}
		this.keyword = keyword;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", check=" + check
				+ ", page=" + page + "]";
	}	
	
}
