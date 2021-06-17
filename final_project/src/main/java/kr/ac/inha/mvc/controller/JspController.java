package kr.ac.inha.mvc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.mvc.dto.SampleDto;
import kr.ac.inha.mvc.service.JspService;

@Controller
public class JspController {
	@Autowired
	JspService jspService ;
	
	
	private static final Logger log = LoggerFactory.getLogger(JspController.class);

	
	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
	@RequestMapping("/hello.do")
	public String helloDo() {
		return "hello";
	}
	@RequestMapping("/gugudan")
	public ModelAndView gugudan(Integer num) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gugudan");
		try {
			String result ="구구단 : ";
			for (int i = 1; i <= 9; i++) {
				result = result + num + "*"+ i + "=" + (num * i) + " ";
			}
			mv.addObject("gugu", result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mv.addObject("title", "구구단");
		return mv;
	}
	@RequestMapping("/sum")
	public ModelAndView sum() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gugudan");
		int sum = 5050;
		mv.addObject("gugu", sum);
		mv.addObject("title", "1부터 100까지의합");
		return mv;
	}
	@RequestMapping("/board.do")
	public ModelAndView board(HttpServletRequest request, @RequestParam(value="title",required=false,defaultValue="과목정보")String subNm) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title",subNm);
		mv.setViewName("board");
		mv.addObject("count", jspService.count());
		List<SampleDto> boardList = jspService.boardList();
		mv.addObject("boardList", boardList);
		HttpSession  session = request.getSession();
		try {
			String subTit = session.getAttribute("subTit").toString();
			mv.addObject("subTit", subTit);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mv;
	}
	
	// /regSubject.do
	@RequestMapping("/regSubject.do")
	public ModelAndView regSubject() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardDetail");
		mv.addObject("title", "과목등록");
		return mv;
	}
	// /regitSubject.do
	@RequestMapping("/regitSubject.do")
	public ModelAndView regitSubject(HttpServletRequest request, SampleDto dto ) throws Exception {
		System.out.println(dto);
		try {
			jspService.regitSubject(dto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return board(request, "");
	}
	@RequestMapping("/boardDetail.do")
	public ModelAndView boardDetail(HttpServletRequest request ,String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardDetail");
		HashMap<String, String> detail = jspService.boardDetail(id);
		
		log.debug("logger!!" + detail.toString());
		HttpSession session = request.getSession();
		session.setAttribute("subTit", detail.get("SUBJECT"));
		mv.addObject("detail", detail);
		mv.addObject("title", "과목 상세");
		return mv;				
	}
	@RequestMapping("/modifySubject.do")
	public ModelAndView modifySubject(HttpServletRequest request,String id, String subject, String grade,
			String useYn, String description, String regUser) throws Exception {
		System.out.println(id + subject + grade);
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("id", id);
		hashmap.put("subject", subject);
		hashmap.put("grade", grade);
		hashmap.put("useYn", useYn);
		hashmap.put("description", description);
		hashmap.put("regUser", regUser);
		try {
			jspService.modifySubject(hashmap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return boardDetail(request, id);
	}
	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest request, String id) throws Exception {
		jspService.delete(id);
		return board(request, "");
	}
	
}
