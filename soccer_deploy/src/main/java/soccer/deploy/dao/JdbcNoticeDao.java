package soccer.deploy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import soccer.deploy.dto.Params;
import soccer.deploy.dto.noticeDTO;

/*
 * UserDao 구현체 (순수 JDBC API 활용)
 */
public class JdbcNoticeDao implements noticeDAO {
	
	private DataSource dataSource;
	
	public JdbcNoticeDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(noticeDTO NoticeDTO) throws RuntimeException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO notice(notice_index, notice_title, notice_content, notice_date, notice_count)")
		  .append(" VALUES (?, ?, ?, ?, ?)");

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, NoticeDTO.getNotice_index());
			pstmt.setString(2, NoticeDTO.getNotice_title());
			pstmt.setString(3, NoticeDTO.getNotice_content());
			pstmt.setString(4, NoticeDTO.getNotice_date());
			pstmt.setInt(5, NoticeDTO.getNotice_count());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<noticeDTO> findAll() throws RuntimeException {
		List<noticeDTO> list = new ArrayList<noticeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'yyyy-MM-DD') notice_date, notice_count")
		  .append(" FROM notice")
		  .append(" ORDER BY notice_date DESC");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeDTO NoticeDTO = makeNotice(rs);
				list.add(NoticeDTO);
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public noticeDTO findById(String id) throws RuntimeException {
		noticeDTO NoticeDTO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'yyyy-MM-DD HH24:MI:SS') notice_date, notice_count")
		  .append(" FROM notice")
		  .append(" WHERE id = ?");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				NoticeDTO = makeNotice(rs);
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NoticeDTO;
	}

	@Override
	public noticeDTO findByIdAndPasswd(String id, String passwd) throws RuntimeException {
		noticeDTO NoticeDTO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'yyyy-MM-DD HH24:MI:SS') notice_date, notice_count")
		  .append(" FROM notice")
		  .append(" WHERE id = ? AND passwd = ? ");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				NoticeDTO = makeNotice(rs);
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NoticeDTO;
	}
	
	private noticeDTO makeNotice(ResultSet rs) throws SQLException {
		noticeDTO NoticeDTO = new noticeDTO();
		NoticeDTO.setNotice_index(rs.getInt("notice_index"));
		NoticeDTO.setNotice_title(rs.getString("notice_title"));
		NoticeDTO.setNotice_content(rs.getString("notice_content"));
		NoticeDTO.setNotice_date(rs.getString("notice_date"));
		NoticeDTO.setNotice_count(rs.getInt("notice_count"));
		return NoticeDTO;
	}

	@Override
	public List<noticeDTO> findAllBySearchOption(String type, String value) {
		List<noticeDTO> list = new ArrayList<noticeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'yyyy-MM-DD HH24:MI:SS') notice_date, notice_count")
		  .append(" FROM notice");
		// type에 따라 WHERE 동적 추가
		switch (type) {
			case "id": sb.append(" WHERE id = ?"); break;
			case "name": sb.append(" WHERE name LIKE ?"); break;
		}
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			if(!type.equals("")) {
				pstmt.setString(1, value);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeDTO NoticeDTO = makeNotice(rs);
				list.add(NoticeDTO);
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int countBySearchOption(String type, String value) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'yyyy-MM-DD HH24:MI:SS') regdate, notice_count")
		  .append(" FROM notice");
		// type에 따라 WHERE 동적 추가
		switch (type) {
			case "id": sb.append(" WHERE id = ?"); break;
			case "name": sb.append(" WHERE name LIKE ?"); break;
		}
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			if(!type.equals("")) {
				pstmt.setString(1, value);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public List<noticeDTO> findAllBySearchOption(Params params) {
		List<noticeDTO> list = new ArrayList<noticeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT notice_index, notice_title, notice_content, notice_date, notice_count")
		  .append(" FROM ( SELECT CEIL(rownum / ?) request_page, notice_index, notice_title, notice_content, notice_date, notice_count")
		  .append("        FROM   ( SELECT notice_index, notice_title, notice_content, TO_CHAR(notice_date, 'YYYY-MM-DD DAY') notice_date, notice_count")
		  .append("                 FROM notice");
		
		// type에 따라 WHERE 동적 추가
		switch (params.getSearchType()) {
			case "id": sb.append(" WHERE id = ?"); break;
			case "name": sb.append(" WHERE name LIKE ?"); break;
		}
		sb.append("	                ORDER  BY regdate DESC))")
		  .append("	WHERE  request_page = ?");
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			
			if(params.getSearchType().equals("")) {
				pstmt.setInt(2, params.getRequestPage());
			}else {
				pstmt.setString(2, params.getSearchValue());
				pstmt.setInt(3, params.getRequestPage());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeDTO NoticeDTO = makeNotice(rs);
				list.add(NoticeDTO);
			}
		} catch (SQLException e) {
			// SQLException을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<noticeDTO> view_content(int notice_index) {
		// TODO Auto-generated method stub
		return null;
	}
}



