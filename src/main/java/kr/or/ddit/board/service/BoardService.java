package kr.or.ddit.board.service;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;

public class BoardService implements BoardServiceI{
   
   private BoardRepositoryI boardRepository;

   public BoardService() {
      
   }
   
   public BoardService(BoardRepositoryI boardRepository) {
      this.boardRepository = boardRepository;
   }
   
   public BoardRepositoryI getBoardRepository() {
      return boardRepository;
   }

   public void setBoardRepository(BoardRepositoryI boardRepository) {
      this.boardRepository = boardRepository;
   }

   @Override
   public BoardVO getBoard(int board_no) {
       return boardRepository.getBoard(board_no);
   }
}