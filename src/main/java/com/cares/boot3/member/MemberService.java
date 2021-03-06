package com.cares.boot3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cares.boot3.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;

	public int setUpdate(MemberVO memberVO)throws Exception{
		return memberMapper.setUpdate(memberVO);
	}

	public MemberVO getDetail(MemberVO memberVO)throws Exception{
		return memberMapper.getDetail(memberVO);
	}

	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}

	public int setDelete(MemberVO memberVO)throws Exception{
		MemberFilesVO memberFilesVO = memberMapper.getFileDetail(memberVO);

		int result = memberMapper.setDelete(memberVO);

		boolean fileResult = fileManager.fileDelete(memberFilesVO.getFileName(), "resources/upload/member/");


		return result;
	}

	public int setAdd(MemberVO memberVO, MultipartFile file)throws Exception{

		int result = memberMapper.setAdd(memberVO);

		if(!file.isEmpty()) {
			String fileName = fileManager.fileSave(file, "resources/upload/member/");

			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setId(memberVO.getId());
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(file.getOriginalFilename());

			result = memberMapper.setFileAdd(memberFilesVO);
		}
		return result;
	}
}