package kr.or.ddit.board.model;

public class BoardVO {
   private int board_no;
   private String title;
   private String content;
   
   public BoardVO() {

   }
   public BoardVO(int board_no, String title, String content) {
      this.board_no = board_no;
      this.title = title;
      this.content = content;
   }
   
   public int getBoard_no() {
      return board_no;
   }
   public void setBoard_no(int board_no) {
      this.board_no = board_no;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   
   @Override
   public String toString() {
      return "BoardVO [board_no=" + board_no + ", title=" + title + ", content=" + content + "]";
   }
}