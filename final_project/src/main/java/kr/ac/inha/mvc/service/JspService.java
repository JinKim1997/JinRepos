package kr.ac.inha.mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.ac.inha.mvc.dto.SampleDto;
import kr.ac.inha.mvc.mapper.JspMapper;

@Component
public class JspService {
	int count = 0;
	@Autowired
	JspMapper mapper;
	public String count() {
		return count++ + "";
	}
	public List<SampleDto> boardList() throws Exception{
		return mapper.boardList();
	}
	public int regitSubject(SampleDto dto) throws Exception {
		return mapper.regitSubject(dto);
		
	}
	public HashMap<String, String> boardDetail(String id) throws Exception{
		return mapper.boardDetail(id);
	}
	//modifySubject
	public int modifySubject(HashMap<String, String> hashmap) throws Exception {
		return mapper.modifySubject(hashmap);
		
	}
	public int delete(String id) throws Exception{
		return mapper.delete(id);
	}
}
