package com.olle.dao.mypage;


import java.util.List;

import com.olle.dto.mypage.MypageDto;

public interface MypageDao {

	String NAMESPACE="user.";
	
	//마이페이지 회원정보 조회
	public MypageDto mypageInfo(String user_id);
	
	//마이페이지 회원정보 수정
	public int mypageInfoUpdate(MypageDto userUpdate);
	
	//회원 강제 탈퇴
	public int mypageLeave(String user_id, String user_pw);
	
	//회원 자진 탈퇴
	public int mypageDelete(String user_id);
	
	//내가 작성한 게시글 조회
	public List<MypageDto> myWriteList(String user_nick, int pageNum);
	
	//내가 찜한 게시글 조회 
	public List<MypageDto> myDibList(String user_nick, int pageNum);
	
	//문의사항 (실시간 채팅)
	
	//신고확인
	
}
