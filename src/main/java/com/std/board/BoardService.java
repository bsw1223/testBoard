package com.std.board;

import java.util.List;

public interface BoardService {

	public List<BoardVO> listBoard();

	public void register(BoardVO boardvo);

	public int getTotal();

	public BoardVO read(Long bno);

	public boolean delete(Long bno);

	public boolean update(BoardVO boardvo);

	public List<BoardVO> getList(Criteria cri);

}
