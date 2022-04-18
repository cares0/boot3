package com.cares.boot3.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
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
		
		List<BoardVO> boardVOs = boardMapper.getList();
		
		assertNotEquals(0, boardVOs.size());
	}
	
	@Test
	void setAddTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("title");
		boardVO.setWriter("writer");
		boardVO.setContents("contents");
		
		int result = boardMapper.setUpdate(boardVO);
		
		assertEquals(1, result);
		
	}

	@Test
	void setDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		
		int result = boardMapper.setDelete(boardVO);
		
		assertEquals(1, result);
	}
}
