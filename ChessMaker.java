package assignment018;
import java.util.*;

public class ChessMaker {
	
	public static void main(String args []) {
		DispBoard obj = new DispBoard();
		obj.dispMenu();
		
	}
	
}

class PlaceChessCoin{
	String[] color = {"\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m"};
	String colorReset = "\u001B[0m";
	String[][] chessBoard = new String[8][8];
	static char[][] _whitePieces_ = {{'\u2656','\u2658','\u2657','\u2655','\u2654','\u2657','\u2658','\u2656'},{'\u2659','\u2659','\u2659','\u2659','\u2659','\u2659','\u2659','\u2659'}};
	static char[][] _blackPieces_ = {{'\u265C','\u265E','\u265D','\u265B','\u265A','\u265D','\u265E','\u265C'},{'\u265F','\u265F','\u265F','\u265F','\u265F','\u265F','\u265F','\u265F'}};
	public PlaceChessCoin() {
		createBoard(8);
	}
	public void placePieces(){
		createBoard(8);
		for(int i=0; i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i==0 || i==1) {
					chessBoard[i][j] = (" "+_blackPieces_[i][j]+" ");
				}else if(i==7 || i==6) {
					chessBoard[i][j] = (" "+_whitePieces_[7-i][j]+" ");
				}
			}
		}
	}
	public void placeKing(int x, int y, boolean pieceChoice) {
		System.out.println();
		createBoard(8);
		char piece = pieceChoice?_blackPieces_[0][4]:_whitePieces_[0][4];
		for(int i=0; i<8;i++) {
			for(int j=0; j<8;j++) {
				if((j>=y-1)&&(j<=y+1)) {
					if((i==x-1)||(i==x)||(i==x+1)) {
						chessBoard[i][j] = " x ";
					}
				}
			}
		}
		chessBoard[x][y]= " "+piece+" ";
	}
	public void placeRook(int x, int y, boolean pieceChoice) {
		System.out.println();
		createBoard(8);
		char piece = pieceChoice?_blackPieces_[0][0]:_whitePieces_[0][0];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				if(i==x || j==y) {
					chessBoard[i][j] =" x ";
				}
			}
		}
		chessBoard[x][y]= " "+piece+" ";
	}
	public void placeBishop(int x, int y, boolean pieceChoice) {
		System.out.println();
		createBoard(8);
		char piece = pieceChoice?_blackPieces_[0][2]:_whitePieces_[0][2];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				if((i-x==j-y)||(i+j==x+y)) {
					chessBoard[i][j] =" x ";
				}
			}
		}
		chessBoard[x][y]= " "+piece+" ";
	}
	public void placeQueen(int x, int y, boolean pieceChoice) {
		System.out.println();
		createBoard(8);
		char piece = pieceChoice?_blackPieces_[0][3]:_whitePieces_[0][3];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				if((i-x==j-y)||(i+j==x+y)|| i==x || j==y) {
					chessBoard[i][j] =" x ";
				}
			}
		}
		chessBoard[x][y]= " "+piece+" ";
	}
	public void placeKnight(int x, int y, boolean pieceChoice) {
		System.out.println();
		createBoard(8);
		char piece = pieceChoice?_blackPieces_[0][1]:_whitePieces_[0][1];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++){
				if(((i==x-2)||(i==x+2))&&((j==y+1)||(j==y-1))) {
					chessBoard[i][j]=" x ";
				}else if(((i==x-1)||(i==x+1))&&((j==y+2)||(j==y-2))){
					chessBoard[i][j]=" x ";
				}
			}
		}
		chessBoard[x][y]= " "+piece+" ";
	}
	public void placePawn(int x, int y,boolean piece) {
		System.out.println();
		createBoard(8);
		if(piece && (x>0 && x<7)) {
			if(x==6) {
				chessBoard[x-1][y]=" x ";
				chessBoard[x-2][y]=" x ";
			}else {
				chessBoard[x-1][y]=" x ";
			}
			chessBoard[x][y] = " "+_whitePieces_[1][0]+" ";
		}else if((x>0 && x<7)){
			if(x==1) {
				chessBoard[x+1][y]=" x ";
				chessBoard[x+2][y]=" x ";
			}else{
				chessBoard[x+1][y]=" x ";
			}
			chessBoard[x][y] = " "+_blackPieces_[1][0]+" ";
		}else {
			System.out.println("Invalid co-ordinates for "+(piece?"White":"Black")+" pawn");
		}
	}

	public void createBoard(int size){
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				chessBoard[i][j] ="   ";
			}
		}
	}
	public void printArr(String col1) {
		for(int i=0;i<8;i++) {
			for(int j=0; j<16;j++) {
				String color = ((i+j)%2==0)?col1:"\u001B[47m";
				if(j>7) {
					System.out.print("\u001B[30m"+color+chessBoard[i][j-8]+colorReset);
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

class DispBoard{

	String[] backgroundColor = {"\u001B[40m","\u001B[41m","\u001B[42m","\u001B[43m","\u001B[44m","\u001B[45m","\u001B[46m","\u001B[47m"};
	String color = backgroundColor[6];
	Scanner scan = new Scanner(System.in);
	PlaceChessCoin obj = new PlaceChessCoin();
	public void dispMenu() {
		boolean flag = false;
		obj.printArr(color);
		while(true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1. Custumise Board Color\n2. Place Pieces\n3. Place a Specific Pieces\n4. Exit");
			int option = inputGenerator(1,4,"Enter Your Option");
			System.out.println();
			switch(option){
				case 1:
					customBoardColor();
					obj.printArr(color);
					break;
				case 2:
					obj.placePieces();
					obj.printArr(color);
					break;
				case 3:
					flag = placeSpecificPiece();
					break;
				case 4:
					flag = true;
					break;
				default:
					System.out.println("Enter Valid Option..\n");
					break;
			}
			if(flag) {
				System.out.println("\nThank You for Playing............");
				break;
			}
		}
	}
	
	public int inputGenerator(int start, int end, String content) {
		System.out.print(content+": ");
		int input;
		while(true) {
			input  = scan.nextInt();
			if(input>=start && input<=end) {
				break;
			}
			System.out.print("Enter Valid Option : ");
		}
		return input;
	}
	public void customBoardColor() {
		obj.createBoard(8);
		System.out.println("Colors Available\n1.Black\n2.Red\n3.Green\n4.Yellow\n5.Blue\n6.Purple\n7.Cyan\n\nEnter the respective number for select the color...");
		int colorOption = inputGenerator(1,7,"Choice");
		System.out.println();
		color = backgroundColor[colorOption-1];
	}
	public boolean placeSpecificPiece() {
		System.out.println("1. Black Piece\n2. White Piece");
		int choice = inputGenerator(1,2,"Select Your Choice");
		boolean isWhiteBlack = choice==1?true:false;
		boolean flag = false;
		int x,y;
		while(true) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("\n1. King\n2. Queen\n3. Bishop\n4. Knight\n5. Rook\n6. Pawn\n7. Back To Main Menu\n8. Exit");
			int option = inputGenerator(1,8,"Select a Piece");
			switch(option) {
				case 1:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placeKing(x,y,isWhiteBlack);
					break;
				case 2:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placeQueen(x,y,isWhiteBlack);
					break;
				case 3:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placeBishop(x, y,isWhiteBlack);
					break;
				case 4:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placeKnight(x, y,isWhiteBlack);
					break;
				case 5:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placeRook(x, y,isWhiteBlack);
					break;
				case 6:
					x = inputGenerator(0,7,"Enter x Co-ordinate");
					y = inputGenerator(0,7,"Enter y Co-ordinate");
					obj.placePawn(x, y, isWhiteBlack);
					break;
				case 7:
					flag = true;
					break;
				case 8:
					flag = true;
					break;
				default:
					System.out.println("Invalid Choice");
			}
			if(flag) {
				flag = option==7?false:true;
				break;
			}
			obj.printArr(color);
			
		}
		return flag;
	}
}
