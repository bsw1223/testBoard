package com.std.board;

import java.util.List;

public interface BoardDAO {

	public List<BoardVO> getListWithPaging(Criteria cri);

	public List<BoardVO> boardList();

	public void insertSelectKey(BoardVO vo);

	public int getTotal();

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO vo);


}
