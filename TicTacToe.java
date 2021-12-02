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
			case 2: System.out.println("hi"); break;
			default:
				System.out.println("Invalid input, please try again"); 
		}
		} while(play < 0 || play > 2);
		
		//create board here and print 
		
		int [] arr= {0,0,0,0,0,0,0,0,0};

		//while statements to check game is not over

public static String checkBoard(){	
if ( board[0]==board[1]==board[2]){
	System.out.println("You win!");
}
else if ( board[3]==board[4]==board[5]){
	System.out.println("You win!");
}
else if ( board[6]==board[7]==board[8]){
	System.out.println("You win!");
}
else if ( board[0]==board[3]==board[6]){
	System.out.println("You win!");
}
else if ( board[1]==board[4]==board[7]){
	System.out.println("You win!");
}
else if ( board[2]==board[5]==board[8]){
	System.out.println("You win!");
}
else if ( board[0]==board[4]==board[8]){
	System.out.println("You win!");
}
else if ( board[2]==board[4]==board[6]){
	System.out.println("You win!");
}
}

		

	

		
}
}
