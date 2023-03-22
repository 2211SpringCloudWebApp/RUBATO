package com.rubato.board.store.imple;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rubato.board.domain.BoardComment;
import com.rubato.board.domain.PageInfo;
import com.rubato.board.store.BoardCommentStore;

@Repository
public class BoardCommentStoreImpl implements BoardCommentStore {
	@Autowired
	private SqlSession session;

	@Override
	public int insertComment(SqlSession session, BoardComment boardComment) {
		return session.insert("BoardCommentMapper.insertComment", boardComment);
	}

	@Override
	public int deleteComment(SqlSession session, int commentNo) {
		return session.delete("BoardCommentMapper.deleteComment", commentNo);
	}

	@Override
	public List<BoardComment> selectCommentList(SqlSession session, int boardNo) {
		List<BoardComment> bcList = session.selectList("BoardCommentMapper.selectCommentList", boardNo);
		return bcList;
	}

	@Override
	public List<BoardComment> searchListByComment(SqlSession session,PageInfo pi, String memberId) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<BoardComment> cList = session.selectList("BoardCommentMapper.searchListByComment", memberId, rowBounds);
		return cList;
	}

	@Override
	public int getBoardCommentListCount(SqlSession session, String memberId) {
		int result = session.selectOne("BoardCommentMapper.getBoardCommentListCount", memberId); 
		return result;
	}


}
