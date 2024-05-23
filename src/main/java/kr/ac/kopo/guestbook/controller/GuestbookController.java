package kr.ac.kopo.guestbook.controller;

import kr.ac.kopo.guestbook.dto.PageRequestDTO;
import kr.ac.kopo.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {
    private final GuestbookService service;
    @GetMapping({"/"})
    public String index(){
        return "/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        //list.html(View 계층)에 방명록 목록과 화면에 보여질 때 필요한 페이지번호들 등의 정보 저장
        model.addAttribute("result", service.getList(pageRequestDTO));
    }
}

