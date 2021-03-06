package com.cares.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cares.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public void list(Model model, Pager pager) throws Exception {
		System.out.println(pager.getSearch());
		List<BoardVO> boardVOs = boardService.getList(pager);
		
		model.addAttribute("boardVOs", boardVOs);
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(BoardVO boardVO, MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardService.setAdd(boardVO, files);
		System.out.println("Add Result : "+result);
		mv.setViewName("redirect:./list");
		return mv;

	}

	@GetMapping("add")
	public void setAdd()throws Exception{}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();

		int result = boardService.setDelete(boardVO);

		mv.setViewName("redirect:./list");
		return mv;

	}

	@PostMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO, ModelAndView mv)throws Exception{

		int result = boardService.setUpdate(boardVO);
		mv.setViewName("redirect:./list");

		return mv;
	}

	@GetMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.setViewName("board/update");
		mv.addObject("vo", boardVO);
		return mv;
	}

	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/detail");
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("vo", boardVO);
		return mv;
	}
	
}
