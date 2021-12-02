import java.util.Scanner;

public class TicTacToe {
	public  static void main(String[] args) {
		int [] board= {1,2,3,4,5,6,7,8,9};
		Scanner sc = new Scanner(System.in);
		int play = 3;
	do {
		System.out.println("Enter 1 to play with 2 people, 2 to play vs the CPU, and 0 to quit");
		play= sc.nextInt();
		switch(play) {
			case 0: 
				System.out.println("bye"); 
				System.exit(0);
				break;
			case 1: System.out.println("CPU"); break;
			case 2: System.out.println("Player 2"); break;
			default:
				System.out.println("Invalid input, please try again"); 
		}
		} while(play < 0 || play > 2);
		
		//create board here and print 
		
		int [] arr= {0,0,0,0,0,0,0,0,0};

		
public static void twoPlayer(Scanner sc, int[] board){
		int turn = 0;
		int choice = 0;
		do {
			try {
				int p1Error=0;
				int p2Error=0;
				if (turn%2==0){ //X
					System.out.print("Player 1 turn:");
					choice = sc.nextInt();
					if(!isValid(choice, board, 1));
						throw new InvalidTurnException();
					printBoard(board);
					checkBoard(board);
				}
			}
			catch (InvalidTurnException e){
				System.out.println("Invalid entry for turn");
			}
			try {
				System.out.print("Player 2 turn:");
				choice = sc.nextInt();
				isValid(choice, board, 2);
				printBoard(board);
				checkBoard(board);
			}
			catch (InvalidTurnException e){
				System.out.println( "Invalid entry for turn");
			}
			turn+=1;
		} while (turn<10);
		if (turn==10){
			System.out.println("Game over: It's a tie");
		}
		}

		
}
		public static void isValid(int choice, int[] board, int player) {
		//check its a valid number
		char mark = 'O';
		if(player == 1) 
			mark = 'X';
		if (choice<0||choice>9){
			throw new InvalidTurnException();
		}
		else if (choice==0){
			System.out.println("Player " + player + " forfiets");
			System.exit(0);
		}
		//make sure it has not been used before 
		for (int i=0; i<9; i++){
			if (board[choice-1]=='X' || board[choice-1] == 'O')
				throw new InvalidTurnException();
			else
				board[choice-1] = mark;
			//x if odd o if even
		}
	}




		public static void printBoard(int[] board) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(i % 2 == 0) {
				System.out.printf("%3d%2c%2d%2c%2d", board[count], '|', board[count+1], '|', board[count+2]);
				System.out.println();
				count += 3;
			}
			else {
				for(int j = 0; j < 12; j++) {
					if(j % 4 == 0 && j != 0) 
						System.out.print('+');
					else
						System.out.print('-');
				}
				System.out.println();
			}
		}
	}
	public static String checkBoard(int[] board){	
		if (board[0]==board[1] && board[0]==board[2])
			System.out.println("You win!");
		else if ( board[3]==board[4] && board[4]==board[5])
			System.out.println("You win!");
		else if ( board[6]==board[7] && board[6]==board[8])
			System.out.println("You win!");
		else if ( board[0]==board[3] && board[0]==board[6])
			System.out.println("You win!");
		else if ( board[1]==board[4] && board[1]==board[7])
			System.out.println("You win!");
		else if ( board[2]==board[5] && board[2]==board[8])
			System.out.println("You win!");
		else if ( board[0]==board[4] && board[0]==board[8])
			System.out.println("You win!");
		else if ( board[2]==board[4] && board[2]==board[6])
			System.out.println("You win!");
	}
}
public static int bestMove(int[board]){
//top row
	if (board[0]==board[1]=='O'&& board[2]==3){
	return 2;
	}
	else if (board[0]==board[2]=='O'&& board[1]==2){
	return 1;
	}
	else if (board[1]==board[2]=='O'&& board[0]==1){
	return 0;
	}
//second row
else if (board[3]==board[4]=='O'&& board[5]==6){
	return 5;
	}
	else if (board[4]==board[5]=='O'&& board[3]==4){
	return 3;
	}
	else if (board[3]==board[5]=='O'&& board[4]==5){
	return 4;
	}
	//third row
	else if (board[6]==board[7]=='O'&& board[8]==9){
	return 8;
	}
	else if (board[7]==board[8]=='O'&& board[6]==7){
	return 6;
	}
	else if (board[6]==board[8]=='O'&& board[7]==8){
	return 7;
	}
	//first column
	else if (board[3]==board[0]=='O'&& board[6]==7){
	return 6;
	}
	else if (board[3]==board[6]=='O'&&board[0]==1){
	return 0;
	}
	else if (board[0]==board[6]=='O'&& board[3]==4){
	return 3;
	}
	//second column
	else if (board[1]==board[4]=='O'&& board[7]==8){
	return 7;
	}
	else if (board[1]==board[7]=='O'&& board[4]==5)){
	return 4;
	}
	else if (board[4]==board[7]=='O'&& board[1]==2){
	return 1;
	}
	//third column
	else if (board[2]==board[5]=='O'&& board[8]==9){
	return 8;
	}
	else if (board[5]==board[8]=='O'&& board[2]==3){
	return 2;
	}
	else if (board[2]==board[8]=='O'&& board[5]==6){
	return 5;
	}
	//diaganol 1
	else if (board[0]==board[4]=='O'&& board[8]==9){
	return 8;
	}
	else if (board[4]==board[8]=='O'&&board[0]==1){
	return 0;
	}
	else if (board[0]==board[8]=='O'&& board[4]==5)){
	return 4;
	}
		//diaganol 2

	else if (board[2]==board[4]=='O'&& board[6]==7){
	return 6;
	}
	else if (board[4]==board[6]=='O'&& board[2]==3){
	return 2;
	}
	else if (board[2]==board[6]=='O'&& board[4]==5)){
	return 4;
	}

//top row
	else if (board[0]==board[1]=='X'&& board[2]==3){
	return 2;
	}
	else if (board[0]==board[2]=='X'&& board[1]==2){
	return 1;
	}
	else if (board[1]==board[2]=='X'&& board[0]==1){
	return 0;
	}
//second row
else if (board[3]==board[4]=='X'&& board[5]==6){
	return 5;
	}
	else if (board[4]==board[5]=='X'&& board[3]==4){
	return 3;
	}
	else if (board[3]==board[5]=='X'&& board[4]==5){
	return 4;
	}
	//third row
	else if (board[6]==board[7]=='X'&& board[8]==9){
	return 8;
	}
	else if (board[7]==board[8]=='X'&& board[6]==7){
	return 6;
	}
	else if (board[6]==board[8]=='X'&& board[7]==8){
	return 7;
	}
	//first column
	else if (board[3]==board[0]=='X'&& board[6]==7){
	return 6;
	}
	else if (board[3]==board[6]=='X'&&board[0]==1){
	return 0;
	}
	else if (board[0]==board[6]=='X'&& board[3]==4){
	return 3;
	}
	//second column
	else if (board[1]==board[4]=='X'&& board[7]==8){
	return 7;
	}
	else if (board[1]==board[7]=='X'&& board[4]==5)){
	return 4;
	}
	else if (board[4]==board[7]=='X'&& board[1]==2){
	return 1;
	}
	//third column
	else if (board[2]==board[5]=='X'&& board[8]==9){
	return 8;
	}
	else if (board[5]==board[8]=='X'&& board[2]==3){
	return 2;
	}
	else if (board[2]==board[8]=='X'&& board[5]==6){
	return 5;
	}
	//diaganol 1
	else if (board[0]==board[4]=='X'&& board[8]==9){
	return 8;
	}
	else if (board[4]==board[8]=='X'&&board[0]==1){
	return 0;
	}
	else if (board[0]==board[8]=='X'&& board[4]==5)){
	return 4;
	}
		//diaganol 2

	else if (board[2]==board[4]=='X'&& board[6]==7){
	return 6;
	}
	else if (board[4]==board[6]=='X'&& board[2]==3){
	return 2;
	}
	else if (board[2]==board[6]=='X'&& board[4]==5)){
	return 4;
	}
}
}
