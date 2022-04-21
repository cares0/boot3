package com.cares.boot3.util;

import lombok.Data;

@Data
public class Pager {

	// 한 페이지당 보여줄 데이터의 수
	private Integer perPage;
	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return this.perPage;
	}
	
	// 페이지 번호(파라미터의 값)
	private Integer pn;

	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return pn;
	}
	
	// DB 쿼리문에 들어갈 시작 인덱스
	private Integer startRow;
	
	public void makeRow() {
		this.startRow = (this.getPn()-1) * this.getPerPage();
	}
	
	// 검색기능(파라미터 값)
	private String search;
	private String kind;
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return this.search;
	}
	
	public String kind() {
		if(this.kind == null) {
			this.kind = "col1";
		}
		return this.kind;
	}
	
	private Long startNum;
	private Long lastNum;

	private boolean pre;
	private boolean next;

	public void makeNum(Long totalCount) {
		System.out.println(totalCount);
		Long totalPage = totalCount/this.getPerPage();

		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}

		Long perBlock=5L;

		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}

		Long curBlock = this.getPn()/perBlock;

		if(this.getPn()%perBlock !=0) {
			curBlock++;
		}

		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;


		if(curBlock>1) {
			this.pre=true;
		}

		if(totalBlock>curBlock) {
			this.next=true;
		}

		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}

		if(totalCount==0) {
			this.lastNum=0L;
		}


	}

}
