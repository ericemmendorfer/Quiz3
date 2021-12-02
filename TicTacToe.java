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

		
public static void twoPlayer(){
int turn =0;
do {
	int p1Error=0;
	int p2Error=0;

	if (turn%2==0){ //X
		try{
		System.out.println("Player 1 enter the space number to choose:");
		int box=sc.nextInt();
		//check its a valid number
		if (box<0||box>9){
		throw new InvalidTurnException();
		}
		else if (box==0){
			System.out.println("Player 1 forfiets");
		}
		//make sure it has not been used before 
		for (int i=0; i<9; i++){
			if (arr[i]==box){
throw new InvalidTurnException();
			}
			else {
			arr[turn]=box;

			//x if odd o if even
			board[box0-1]='X';
			printBoard();
			checkBoard();
		}
	}
}
catch (InvalidTurnException e){
		System.out.println( "Invalid entry for turn");
	}
		
}
else{//O
	try{
		System.out.println("Player 2 enter the space number to choose:");
		int box=sc.nextInt();
		//check its a valid number
		if (box<0||box>9){
		throw new InvalidTurnException();
		}
		else if (box==0){
			System.out.println("Player 2 forfiets");
		}
		//make sure it has not been used before 
		for (int i=0; i<9; i++){
			if (arr[i]==box){
throw new InvalidTurnException();
			}
			else {
			arr[turn]=box;

			//x if odd o if even
			board[box-1]='O';
			printBoard();
			checkBoard();
		}
	}
}
catch (InvalidTurnException e){
		System.out.println( "Invalid entry for turn");
	}
	
}
turn+=1;
} while (turn<10);
if (turn==10){
	System.out.println("Game over: It's a tie");
}
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
}
