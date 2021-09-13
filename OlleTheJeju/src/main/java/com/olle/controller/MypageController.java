package com.olle.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.olle.biz.mypage.MypageBiz;
import com.olle.biz.mypage.MypageBizImple;
import com.olle.dto.member.MemberDto;

@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MypageBiz biz;
	
	//회원정보 조회
	@RequestMapping(value = "mypage_main.do", method = RequestMethod.GET)
	public String mypage_main(HttpSession session, Model model, String user_id) {
		logger.info("mypage_main");
		user_id = "LSJTEST";
		model.addAttribute("dto", biz.mypageInfo(user_id));
		return "page_mypage/mypage";
	}
	
	//회원정보 수정(수정전 내용인데 사용할지도 모르니 남겨놓음)
	/*@RequestMapping(value="userUpdate.do", method=RequestMethod.GET)
	public String userUpdate(HttpSession session, Model model, MemberDto userUpdate) {
		logger.info("userUpdate");
		
		int res = biz.userUpdate(userUpdate);
		
		if(res>0) {
			return "redirect:mypage_plan.do";
		}else {
			return "redirect:mypage_main.do?user_id="+userUpdate.getUser_id();
		}
	}*/
	@RequestMapping(value="newPw.do", method=RequestMethod.POST)
	@ResponseBody
	public int newPw(String user_pw, String new_pw) {
		int res = 0;
		
		res = biz.newPw(user_pw, new_pw);
		
		return res;
	}
	
	/* //회원정보 수정 및 삭제 비밀번호 체크
	@RequestMapping(value="info_update.do", method=RequestMethod.GET)
	public String mypage_updateChk(@ModelAttribute MemberDto dto, Model model) {
		boolean result = biz.checkPw(dto.getUser_id(), dto.getUser_pw());
		
		if(result) {
			biz.mypageInfoUpdate(dto);
			//비밀번호 일치 하다면 수정 처리, 리턴으로 페이지 이동은 없는것으로
			return "";
		}else {
			MemberDto dto2 = biz.mypageInfo(dto.getUser_id());
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호 불일치");
			//비밀번호 불일치시 메시지창 띄우고 페이지 이동 없음	
			return "";
		}
	}*/
	
	//회원 강제 탈퇴
	
	//회원 자진 탈퇴 (삭제)
	@RequestMapping(value="deleteUser.do", method= {RequestMethod.GET, RequestMethod.POST})
	//@RequestParam : get or post 방식으로 전달된 변수값
	public String deleteUser(@RequestParam String user_id, @RequestParam String user_pw, Model model) {
		logger.info("deleteUser");
		System.out.println("삭제");
		//비밀번호 체크
		boolean result = biz.checkPw(user_id, user_pw);
		
		//비밀번호가 맞으면 리턴
		if(result) {
			biz.deleteUser(user_id);
			return "home.do";
		}else { //비밀번호가 틀릴경우 메시지 출력
			model.addAttribute("message", "비밀번호 불일치");
			model.addAttribute("dto", biz.mypageInfo(user_id));
			return "mypage_main.do?user_id="+user_id;
		}
		
	}
	
	//내가쓴 게시글 조회
	@RequestMapping(value = "mypage_plan.do", method = RequestMethod.GET)
	public String mypage_plan() {
		return "page_mypage/mypage_plan";
	}
	
	//내가 찜한 게시글 조회
	
	//문의하기 (채팅 기능)
	@RequestMapping(value = "mypage_inquire.do", method = RequestMethod.GET)
	public String mypage_inquire() {
		return "page_mypage/mypage_inquire";
	}
	
	//신고 확인 기능
	@RequestMapping(value = "mypage_warn.do", method = RequestMethod.GET)
	public String mypage_warn() {
		return "page_mypage/mypage_warn";
	}
}
