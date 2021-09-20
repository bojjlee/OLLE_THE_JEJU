package com.olle.dto.pagination;

import java.util.ArrayList;
import java.util.List;

import com.olle.dto.etc.ImgDto;
import com.olle.dto.jejusituation.JejuDto;
import com.olle.dto.jejusituation.MenuDto;

public class JejuPage {
	//총 아이템수
	int totalElements;
	//총 페이지 수
	int totalPages;
	//한 페이지당 아이템수
	int elementsPerPage;
	//시작 인덱스(페이지당)
	int startIdx;
	//끝인덱스
	int endIdx;
	//현재 페이지
	int curPage;
	//리스트 유닛
	int listBtnUnit;
	//이전 유닛으로 넘어갈 수 있는지 여부
	boolean prevUnit;
	boolean nextUnit;
	//페이지당 아이뎀 담기
	//가게정보
	List<JejuDto> jeju=new ArrayList<JejuDto>();
	//이미지
	List<ImgDto> img=new ArrayList<ImgDto>();
	//각 가게당 메뉴 리스트들을 담을 리스트
	List<ArrayList<MenuDto>> menuList=new ArrayList<ArrayList<MenuDto>>();
	public JejuPage() {
		super();
	}
	public JejuPage(int totalElements, int totalPages, int elementsPerPage, int startIdx, int endIdx, int curPage,
			int listBtnUnit, boolean prevUnit, boolean nextUnit, List<JejuDto> jeju, List<ImgDto> img,
			List<ArrayList<MenuDto>> menuList) {
		super();
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.elementsPerPage = elementsPerPage;
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.curPage = curPage;
		this.listBtnUnit = listBtnUnit;
		this.prevUnit = prevUnit;
		this.nextUnit = nextUnit;
		this.jeju = jeju;
		this.img = img;
		this.menuList = menuList;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getElementsPerPage() {
		return elementsPerPage;
	}
	public void setElementsPerPage(int elementsPerPage) {
		this.elementsPerPage = elementsPerPage;
	}
	public int getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	public int getEndIdx() {
		return endIdx;
	}
	public void setEndIdx(int endIdx) {
		this.endIdx = endIdx;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getListBtnUnit() {
		return listBtnUnit;
	}
	public void setListBtnUnit(int listBtnUnit) {
		this.listBtnUnit = listBtnUnit;
	}
	public boolean isPrevUnit() {
		return prevUnit;
	}
	public void setPrevUnit(boolean prevUnit) {
		this.prevUnit = prevUnit;
	}
	public boolean isNextUnit() {
		return nextUnit;
	}
	public void setNextUnit(boolean nextUnit) {
		this.nextUnit = nextUnit;
	}
	public List<JejuDto> getJeju() {
		return jeju;
	}
	public void setJeju(List<JejuDto> jeju) {
		this.jeju = jeju;
	}
	public List<ImgDto> getImg() {
		return img;
	}
	public void setImg(List<ImgDto> img) {
		this.img = img;
	}
	public List<ArrayList<MenuDto>> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<ArrayList<MenuDto>> menuList) {
		this.menuList = menuList;
	}
}