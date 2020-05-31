package com.std.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	

	@Override
	public List<BoardVO> listBoard() {
		List boardlist = null;
		boardlist = boardDAO.boardList();

		return boardlist;
	}

	@Override
	public void register(BoardVO vo) {
		boardDAO.insertSelectKey(vo);

	}

	@Override
	public int getTotal() {
		return boardDAO.getTotal();
	}

	@Override

	public BoardVO read(Long bno) {

		return boardDAO.read(bno);
	}

	@Override
	public boolean delete(Long bno) {

		return boardDAO.delete(bno) == 1;
	}

	@Override
	public boolean update(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.update(vo) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDAO.getListWithPaging(cri);

	}

}
