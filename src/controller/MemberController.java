package controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import member.Member;
import member.MemberRepository;

@Slf4j
@Controller
public class MemberController 
{
	private MemberRepository memberRepository;
	
	// 생성자
	public MemberController(MemberRepository memberRepository)
	{
		this.memberRepository = memberRepository;
	}
	
	@RequestMapping("/signUp")
	public String signUp()
	{
		return "/signup";
	}
	
	@RequestMapping("/signUp/create")
	public String create(Member member)
	{
		member.setJoinDate(LocalDate.now());
		this.memberRepository.save(member);
		return "/login";
	}
}
