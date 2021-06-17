package kr.ac.inha.mvc.mapper;

import java.util.HashMap;
import java.util.List;

import kr.ac.inha.mvc.dto.SampleDto;

public interface JspMapper {

	public List<SampleDto> boardList() throws Exception;
	public int regitSubject(SampleDto dto) throws Exception;
	public HashMap<String, String> boardDetail(String id) throws Exception;
	public int modifySubject(HashMap<String, String> hashmap) throws Exception;
	public int delete(String id) throws Exception;
}
