package com.cares.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.cares.boot3.util.Pager;

@SpringBootTest
//@Transactional
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	void test() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO = boardMapper.getDetail(boardVO);
		System.out.println(boardVO.toString()); // rombok을 통해 가능
		assertNotNull(boardVO);
	}
	
	@Test
	void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardVO> boardVOs = boardMapper.getList(pager);
		
		System.out.println(boardVOs);
		assertEquals(10, boardVOs.size());
	}
	
	//@Test
	void setAddTest() throws Exception {
		for(int i=0;i<100;i++) {
			
			if(i%10 == 0) {
				Thread.sleep(1000);
			}
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title" + i);
			boardVO.setWriter("writer" + i);
			boardVO.setContents("contents" + i);
			
			int result = boardMapper.setAdd(boardVO);
		}
		System.out.println("finish");
		//assertEquals(1, result);
		
	}

	//@Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		
		int result = boardMapper.setDelete(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void setFileAddTest() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileName("fileName");
		boardFilesVO.setOriName("oriName");
		boardFilesVO.setNum(3L);
		
		int result = boardMapper.setFileAdd(boardFilesVO);
		
		assertEquals(1, result);
	}
	
}
