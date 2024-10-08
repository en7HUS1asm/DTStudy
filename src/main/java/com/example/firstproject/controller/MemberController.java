package com.example.firstproject.controller;


import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signupPage() {return "/members/new";}

    @PostMapping("/join")
    public String join(MemberForm memberform) {
        System.out.println(memberform.toString());
        Member member = memberform.toEntity();
        System.out.println(member.toString());
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "/members/new";}
}
