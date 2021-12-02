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

		//while statements to check game is not over
while ( board[0][0]==board[0][1]==board[0][2]=false){
while ( board[1][0]==board[1][1]==board[1][2]=false){
while ( board[2][0]==board[2][1]==board[2][2]=false){
while ( board[0][0]==board[1][0]==board[2][0]=false){
while ( board[0][1]==board[1][1]==board[2][1]=false){
while ( board[0][2]==board[1][2]==board[2][2]=false){
while ( board[0][0]==board[1][1]==board[2][2]=false){
while ( board[0][2]==board[1][1]==board[2][0]=false){
	

		
}
}
}
}
}	
}		
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
}
