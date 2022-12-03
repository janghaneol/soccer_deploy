package soccer.deploy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.dto.pageDTO;
import soccer.deploy.dto.Params;
import soccer.deploy.dto.noticeDTO;

@Mapper
public interface noticeDAO {

	public void create(noticeDTO NoticeDTO) throws RuntimeException;

	public List<noticeDTO> findAll() throws RuntimeException;

	public noticeDTO findById(String id) throws RuntimeException;

	public noticeDTO findByIdAndPasswd(String id, String passwd) throws RuntimeException;

	// 검색옵션에 따른 회원목록 조회
	public List<noticeDTO> findAllBySearchOption(String type, String value);

	// 검색옵션에 따른 회원수 조회
	public int countBySearchOption(String type, String value);

	// 검색옵션, 페이지사이즈, 페이지카운트, 요청페이지 따른 회원목록 조회
	// public List<User> findAllBySearchOption(String type, String value, int
	// pageSize, int pageCount, int requestPage);

	// 검색옵션, 페이지사이즈, 페이지카운트, 요청페이지 따른 회원목록 조회
	public List<noticeDTO> findAllBySearchOption(Params params);


}
