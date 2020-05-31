package com.std.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<BoardVO> boardList() {

		List<BoardVO> list = null;

		list = sqlsession.selectList("mapper.board.listBoard");

		return list;
	}

	@Override
	public void insertSelectKey(BoardVO vo) {

		sqlsession.insert("mapper.board.insertSelectKey", vo);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		int page;
		page = sqlsession.selectOne("mapper.board.getTotal");

		return page;
	}

	@Override
	public BoardVO read(Long bno) {

		return sqlsession.selectOne("mapper.board.read", bno);

	}

	@Override
	public int delete(Long bno) {
		return sqlsession.delete("mapper.board.delete", bno);

	}

	@Override
	public int update(BoardVO vo) {
		return sqlsession.update("mapper.board.update", vo);
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("mapper.board.getListWithPaging", cri);
	}
}
