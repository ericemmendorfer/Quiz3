import java.util.Scanner;

public class TicTacToe {
	public static int turn = 0;
	public static int p1Errors = 0;
	public static int p2Errors = 0;
	public static int p1Assist = 0;
	public static int p2Assist = 0;


	public static void main(String[] args) {
		char [] board= {'1', '2', '3', '4', '5', '6','7','8','9'};
		turn = 0;
		Scanner sc = new Scanner(System.in);
		int play = 3;
		do {
			System.out.println("Enter 1 to play with 2 people, 2 to play vs the CPU, and 0 to quit");
			play= sc.nextInt();
			switch(play) {
				case 0: 
					System.out.println("Goodbye!"); 
					System.exit(0);
					break;
				case 1: twoPlayer(sc, board, false, 0, false); break;
				case 2: twoPlayer(sc, board, false, 0, true); break;
				default:
					System.out.println("Invalid input, please try again"); 
			}
		} while(play < 0 || play > 2);
		sc.close();
	}
	//Prints board
	public static void printBoard(char[] board) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(i % 2 == 0) {
				System.out.printf("%3c%2c%2c%2c%2c", board[count], '|', board[count+1], '|', board[count+2]);
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
	//Central method for game
	public static void twoPlayer(Scanner sc, char[] board, boolean p2First, int errorCounter, boolean isCPU){
		int choice = 0;
		boolean isComputer = false;
		String player2 = "Player 2";
		if(isCPU) {
			isComputer = true;
			player2 = "CPU";
		}
		while(turn < 9) {
			//Checks if player 2 goes first or not
			if(!p2First) {
				try {
					//Checks if the player made too many errors
					if(p1Errors >= 5 && errorCounter >= 3) {
						System.out.println("Player 1 forfeits the game due to reaching maximum incorrect entries!");
						System.exit(0);
					}
					if (turn%2==0){ //Player's 1 Turn
						System.out.print("Player 1 turn(enter 000 for computer assist:");
						String help=sc.nextLine();
						if (help=="000"){
							if (p1Assist<2){
						choice=bestMove(board);
							p1Assist++;
							}
							else if(p1Assist==2){
								System.out.println("Player 1 has reached max CPU assist please try again.");
						}
						else{
						choice = Integer.parseInt(help);
						}
						if(choice == 0) {
							System.out.println("Player 1 forfeits by entering 0!");
							System.exit(0);
						}
						if(!isValid(choice, board, 1))
							throw new InvalidTurnException();
					}
				}
			}
				catch (InvalidTurnException e){
					System.out.println("Invalid entry for turn, please try again.");
					p1Errors++;
					twoPlayer(sc, board, false, errorCounter + 1, isComputer);
				}
				finally {
					errorCounter = 0;
					if(!isComputer)
						printBoard(board);
					if(checkBoard(board)) {
						System.out.println("Player 1 wins!");
						System.exit(0);
					}
					turn++;
					//Ends game in a tie
					if(turn == 9)
						break;
				}
			}
			p2First = false;
			try {
				System.out.println();
				//Checks if too many errors for Player 2
				if(p2Errors >= 5 && errorCounter >= 3) {
					System.out.println("Player 2 forfeits the game due to reaching maximum incorrect entries!");
					System.exit(0);
				}
				//Checks if it is a CPU Game
				if(isComputer)
					choice = bestMove(board);
				else {
					System.out.print("Player 2 turn(enter 000 for computer assist:");
					String help=sc.nextLine();
						if (help=="000"){
							if (p2Assist<2){
						choice=bestMove(board);
							p2Assist++;
							}
							else if(p2Assist==2){
								System.out.println("Player 2 has reached max CPU assist please try again.");
						}
					}
						else{
						choice = Integer.parseInt(help);
						}
				}
				if(choice == 0) {
					System.out.println("Player 2 forfeits by entering 0!");
					System.exit(0);
				}
				if(!isValid(choice, board, 2))
					throw new InvalidTurnException();
			}
			catch (InvalidTurnException e){
				System.out.println("Invalid entry for turn, please try again.");
				p2Errors++;
				twoPlayer(sc, board, true, errorCounter+1, isComputer);
			}
			finally {
				errorCounter = 0;
				printBoard(board);
				if(checkBoard(board)) {
					System.out.println(player2 + " wins!");
					System.exit(0);
				}
				turn++;
			}
		}
		System.out.println("Game over: It's a tie");
	}
	//Checks if there is a winning match
	public static boolean checkBoard(char[] board){	
		boolean won = false;
		if (board[0]==board[1] && board[0]==board[2])
			won = true;
		else if ( board[3]==board[4] && board[4]==board[5])
			won = true;
		else if ( board[6]==board[7] && board[6]==board[8])
			won = true;
		else if ( board[0]==board[3] && board[0]==board[6])
			won = true;
		else if ( board[1]==board[4] && board[1]==board[7])
			won = true;
		else if ( board[2]==board[5] && board[2]==board[8])
			won = true;
		else if ( board[0]==board[4] && board[0]==board[8])
			won = true;
		else if ( board[2]==board[4] && board[2]==board[6])
			won = true;
		return won;
		
	}
	//Checks if the input is valid
	public static boolean isValid(int choice, char[] board, int player) {
		//check its a valid number
		char mark = 'O';
		if(player == 1) 
			mark = 'X';
		if (choice<0||choice>9){
			return false;
		}
		else if (choice==0){
			System.out.println("Player " + player + " forfiets");
			System.exit(0);
		}
		//make sure it has not been used before 
		if (board[choice-1]=='X' || board[choice-1] == 'O')
			return false;
		else {
			board[choice-1] = mark;
			return true;
		}
	}
	//CPU Logic for best move
	public static int bestMove(char[]board) {
		//top row
			if (board[0]==board[1]&&board[1]=='O'&& board[2]=='3'){
			return 3;
			}
			else if (board[0]==board[2]&&board[2]=='O'&& board[1]=='2'){
			return 2;
			}
			else if (board[1]==board[2]&&board[2]=='O'&& board[0]=='1'){
			return 0;
			}
		//second row
		else if (board[3]==board[4]&&board[4]=='O'&& board[5]=='6'){
			return 6;
			}
			else if (board[4]==board[5]&&board[5]=='O'&& board[3]=='4'){
			return 4;
			}
			else if (board[3]==board[5]&&board[5]=='O'&& board[4]=='5'){
			return 5;
			}
			//third row
			else if (board[6]==board[7]&&board[7]=='O'&& board[8]=='9'){
			return 9;
			}
			else if (board[7]==board[8]&&board[8]=='O'&& board[6]=='7'){
			return 7;
			}
			else if (board[6]==board[8]&&board[8]=='O'&& board[7]=='8'){
			return 8;
			}
			//first column
			else if (board[3]==board[0]&&board[3]=='O'&& board[6]=='7'){
			return 7;
			}
			else if (board[3]==board[6]&&board[6]=='O'&&board[0]=='1'){
			return 1;
			}
			else if (board[0]==board[6]&&board[6]=='O'&& board[3]=='4'){
			return 4;
			}
			//second column
			else if (board[1]==board[4]&&board[4]=='O'&& board[7]=='8'){
			return 8;
			}
			else if (board[1]==board[7]&&board[7]=='O'&& board[4]=='5'){
			return 5;
			}
			else if (board[4]==board[7]&&board[7]=='O'&& board[1]=='2'){
			return 2;
			}
			//third column
			else if (board[2]==board[5]&&board[5]=='O'&& board[8]=='9'){
			return 9;
			}
			else if (board[5]==board[8]&&board[8]=='O'&& board[2]=='3'){
			return 3;
			}
			else if (board[2]==board[8]&&board[8]=='O'&& board[5]=='6'){
			return 6;
			}
			//diaganol 1
			else if (board[0]==board[4]&&board[4]=='O'&& board[8]=='9'){
			return 9;
			}
			else if (board[4]==board[8]&&board[8]=='O'&&board[0]=='1'){
			return 1;
			}
			else if (board[0]==board[8]&&board[8]=='O'&& board[4]=='5'){
			return 5;
			}
				//diaganol 2

			else if (board[2]==board[4]&&board[4]=='O'&& board[6]=='7'){
			return 7;
			}
			else if (board[4]==board[6]&&board[6]=='O'&& board[2]=='3'){
			return 3;
			}
			else if (board[2]==board[6]&&board[6]=='O'&& board[4]=='5'){
			return 5;
			}

		//top row
			else if (board[0]==board[1]&&board[1]=='X'&& board[2]=='3'){
			return 3;
			}
			else if (board[0]==board[2]&&board[2]=='X'&& board[1]=='2'){
			return 2;
			}
			else if (board[1]==board[2]&&board[2]=='X'&& board[0]=='1'){
			return 1;
			}
		//second row
		else if (board[3]==board[4]&&board[4]=='X'&& board[5]=='6'){
			return 6;
			}
			else if (board[4]==board[5]&&board[5]=='X'&& board[3]=='4'){
			return 4;
			}
			else if (board[3]==board[5]&&board[5]=='X'&& board[4]=='5'){
			return 5;
			}
			//third row
			else if (board[6]==board[7]&&board[7]=='X'&& board[8]=='9'){
			return 9;
			}
			else if (board[7]==board[8]&&board[7]=='X'&& board[6]=='7'){
			return 7;
			}
			else if (board[6]==board[8]&&board[8]=='X'&& board[7]=='8'){
			return 8;
			}
			//first column
			else if (board[3]==board[0]&&board[0]=='X'&& board[6]=='7'){
			return 7;
			}
			else if (board[3]==board[6]&&board[3]=='X'&&board[0]=='1'){
			return 1;
			}
			else if (board[0]==board[6]&&board[0]=='X'&& board[3]=='4'){
			return 4;
			}
			//second column
			else if (board[1]==board[4]&&board[4]=='X'&& board[7]=='8'){
			return 8;
			}
			else if (board[1]==board[7]&&board[7]=='X'&& board[4]=='5'){
			return 5;
			}
			else if (board[4]==board[7]&&board[7]=='X'&& board[1]=='2'){
			return 2;
			}
			//third column
			else if (board[2]==board[5]&&board[5]=='X'&& board[8]=='9'){
			return 9;
			}
			else if (board[5]==board[8]&&board[8]=='X'&& board[2]=='3'){
			return 3;
			}
			else if (board[2]==board[8]&&board[8]=='X'&& board[5]=='6'){
			return 6;
			}
			//diaganol 1
			else if (board[0]==board[4]&&board[4]=='X'&& board[8]=='9'){
			return 9;
			}
			else if (board[4]==board[8]&&board[8]=='X'&&board[0]=='1'){
			return 1;
			}
			else if (board[0]==board[8]&&board[8]=='X'&& board[4]=='5'){
			return 5;
			}
				//diagonol 2

			else if (board[2]==board[4]&& board[4]=='X'&& board[6]=='7'){
			return 7;
			}
			else if (board[4]==board[6]&& board[4]=='X'&& board[2]=='3'){
			return 3;
			}
			else if (board[2]==board[6]&& board[2]=='X'&& board[4]=='5'){
			return 5;
			}
			else{
				for (int j=0; j<9;){
					if (board[j]=='X'||board[j]=='O')
						j++;
					else
						return j+1;
				}
			}
			return 0;
	}
}
