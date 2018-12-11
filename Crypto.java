/*
How to use :
1- The program will ask you to input a String to be Encrypted
2- The program will ask you if you want to Encrypt (you should first Encrypt)
3-You will get then the encypted matrix along with the cypher(key)
4-Then you will have the option to Decrypt with the inverse of the cypher matrix (option 2)
5- You will obtain the inverse cypher matrix along with the text you first Entered at the beginning of the program
6-you can choose (3) to test our Hash like encryption algorithm
7-the program will ask you to login to "your account" we already set the password before hand on line(212)

*/


import javax.swing.JOptionPane;

public class Crypto
{
	//************************************************************************************************
	//Puts a String in an array of the same size
	static void StringtoArray(char []arr,String phrase)
	{
		for(int i=0;i<phrase.length();i++)
		{
			arr[i]=phrase.charAt(i);
		}
	}

	//***********************************************************************************
	//Take a one Dimantional array and injects it into a two Dimantional one
	static void ArraytoMatrix(char[]arr,int[][]arrb)
	{
		int count=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<(arr.length)/3+1;j++)
			{
				if(count<arr.length)
				{
					switch(arr[count])
					{
						case 'A':arrb[i][j]=1 ;break;
						case 'B':arrb[i][j]=2;break;
						case 'C':arrb[i][j]=3;break;
						case 'D':arrb[i][j]=4;break;
						case 'E':arrb[i][j]=5;break;
						case 'F':arrb[i][j]=6;break;
						case 'G':arrb[i][j]=7;break;
						case 'H':arrb[i][j]=8;break;
						case 'I':arrb[i][j]=9;break;
						case 'J':arrb[i][j]=10;break;
						case 'K':arrb[i][j]=11;break;
						case 'L':arrb[i][j]=12;break;
						case 'M':arrb[i][j]=13;break;
						case 'N':arrb[i][j]=14;break;
						case 'O':arrb[i][j]=15;break;
						case 'P':arrb[i][j]=16;break;
						case 'Q':arrb[i][j]=17;break;
						case 'R':arrb[i][j]=18;break;
						case 'S':arrb[i][j]=19;break;
						case 'T':arrb[i][j]=20;break;
						case 'U':arrb[i][j]=21;break;
						case 'V':arrb[i][j]=22;break;
						case 'W':arrb[i][j]=23;break;
						case 'X':arrb[i][j]=24;break;
						case 'Y':arrb[i][j]=25;break;
						case 'Z':arrb[i][j]=26;break;
						case ' ':arrb[i][j]=27;break;
						case '0':arrb[i][j]=28;break;
						case '1':arrb[i][j]=29;break;
						case '2':arrb[i][j]=30;break;
						case '3':arrb[i][j]=31;break;
						case '4':arrb[i][j]=32;break;
						case '5':arrb[i][j]=33;break;
						case '6':arrb[i][j]=34;break;
						case '7':arrb[i][j]=35;break;
						case '8':arrb[i][j]=36;break;
						case '9':arrb[i][j]=37;break;
					}
					count++;
				}
				else
					arrb[i][j]=27;

			}
		}
	}
	//************************************************************************************************
	//Prints the two Dimantional Array as it is in numbers
	static void PrintMatrix(int [][]arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
	}

	//************************************************************************************************
	//Translates the numbers in the Matrix into Characters(Alphabet)
	static void ReadMatrix(int [][]arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				switch(arr[i][j])
				{
					case 1:System.out.print("A ");break;
					case 2:System.out.print("B ");break;
					case 3:System.out.print("C ");break;
					case 4:System.out.print("D ");break;
					case 5:System.out.print("E ");break;
					case 6:System.out.print("F ");break;
					case 7:System.out.print("G ");break;
					case 8:System.out.print("H ");break;
					case 9:System.out.print("I ");break;
					case 10:System.out.print("J ");break;
					case 11:System.out.print("K ");break;
					case 12:System.out.print("L ");break;
					case 13:System.out.print("M ");break;
					case 14:System.out.print("N ");break;
					case 15:System.out.print("O ");break;
					case 16:System.out.print("P ");break;
					case 17:System.out.print("Q ");break;
					case 18:System.out.print("R ");break;
					case 19:System.out.print("S ");break;
					case 20:System.out.print("T ");break;
					case 21:System.out.print("U ");break;
					case 22:System.out.print("V ");break;
					case 23:System.out.print("W ");break;
					case 24:System.out.print("X ");break;
					case 25:System.out.print("Y ");break;
					case 26:System.out.print("Z ");break;
					case 27:System.out.print("  ");break;
					case 28:System.out.print("0 ");break;
					case 29:System.out.print("1 ");break;
					case 30:System.out.print("2 ");break;
					case 31:System.out.print("3 ");break;
					case 32:System.out.print("4 ");break;
					case 33:System.out.print("5 ");break;
					case 34:System.out.print("6 ");break;
					case 35:System.out.print("7 ");break;
					case 36:System.out.print("8 ");break;
					case 37:System.out.print("9 ");break;
				}
			}
			System.out.println();
		}
	}

	//************************************************************************************************
	//This function is use to Multiply the Cypher/Inverse Cypher by the Matrix obtained from the user or by Encrypting
	static void DeAndEncrypte(int [][]orgarr,int [][]encr,int [][]cypher)
	{
		for(int a=0;a<encr.length;a++)
		{
			for(int b=0;b<encr[a].length;b++)
			{
		 		for(int i=0;i<orgarr.length;i++)
		 		{
					encr[a][b]+=(cypher[a][i]*orgarr[i][b]);
			 	}
		 	}
	 	}
	}

	//************************************************************************************************
	//************************************************************************************************

	public static void main(String[]args)
	{
		char []UserInput;
		int choice=0;
		String UserSentence;
		String Password;
		JOptionPane.showMessageDialog(null,"Your Encryption Algorithm is getting Ready \n                         ..................");
		UserSentence=JOptionPane.showInputDialog("Enter the Message to be ENCRYPTED :");
		UserSentence=UserSentence.toUpperCase();
		UserInput=new char[UserSentence.length()];
		StringtoArray(UserInput,UserSentence);
		int OrgMatrix[][]=new int[3][(UserSentence.length())/3+1];
		int [][]Encrypted =new int [3][(UserSentence.length())/3+1];
		int [][]Dencrypted =new int [3][(UserSentence.length())/3+1];
		int [][]Encrypted1;
		int [][]PassCodeM;
		ArraytoMatrix(UserInput,OrgMatrix);
		/*int OrgMatrix[][];
		int [][]Encrypted ;
		int [][]Dencrypted ;*/

		int Cypher[][]=
		{
			{-3,-3,-4},
			{0,1,1},
			{4,3,4}
		};
		int InvCypher[][]=
		{
			{1,0,1},
			{4,4,3},
			{-4,-3,-3}
		};
		int SingCypher[][]=
		{
			{1,5,2},
			{3,15,6},
			{2,1,-6}
		};
		//Password is : 123aust456
		int PassMatrix[][]=
		{
			{29,30,31,1},
			{21,19,20,32},
			{33,34,27,27}
		};
		choice=Integer.parseInt(JOptionPane.showInputDialog(" 1- Encrypte message(2 way)\n 2- Decrypte message(2 way)\n 3- Encrypte Password(one way) \n0- Exite"));
		while(choice!=0)
		{

			switch(choice)
			{
				case 1:

					System.out.println("This is the original matrix :\n\n");
					PrintMatrix(OrgMatrix);
					System.out.println();
					ReadMatrix(OrgMatrix);
					System.out.println("\n\nThis is the Cypher matrix :\n");
					PrintMatrix(Cypher);
					DeAndEncrypte(OrgMatrix,Encrypted,Cypher);
					System.out.println("\n\nThis is the Encrypted matrix :\n");
			 		PrintMatrix(Encrypted);
			 		System.out.println();
				break;
				case 2:
					System.out.println("\n\nThis is the Invere Cypher matrix :\n");
					PrintMatrix(InvCypher);
					DeAndEncrypte(Encrypted,Dencrypted,InvCypher);
					System.out.println("\n\nThis is the Dencrypted matrix :\n");
					PrintMatrix(Dencrypted);
					System.out.println();
					ReadMatrix(Dencrypted);
				break;
				case 3:
					boolean same=true;
					Password=JOptionPane.showInputDialog("Enter your Password to Login :");
					Password=Password.toUpperCase();
					char []UserPass=new char[Password.length()];
					StringtoArray(UserPass,Password);
					PassCodeM=new int[3][(Password.length())/3+1];
					Encrypted1 =new int [3][(Password.length())/3+1];
					Encrypted =new int [3][(Password.length())/3+1];
					ArraytoMatrix(UserPass,PassCodeM);
					DeAndEncrypte(PassCodeM,Encrypted1,SingCypher);
					DeAndEncrypte(PassMatrix,Encrypted,SingCypher);
					PrintMatrix(Encrypted1);
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<4;j++)
						{
							if(Encrypted1[i][j]!=Encrypted[i][j])
							{
								JOptionPane.showMessageDialog(null,"You Entered an Incorrect Password");
								same=false;
								break;
							}
						}
						if(!same)
							break;
					}
					if(same)
						JOptionPane.showMessageDialog(null,"You successfully loged in");
				break;
			}
			choice=Integer.parseInt(JOptionPane.showInputDialog(" 1- Encrypte message(2 way)\n 2- Decrypte message(2 way)\n 3- Encrypte Password(one way) \n0- Exite"));
		}
		JOptionPane.showMessageDialog(null,"Thank you for using our Encryption /Decryption Algorithm");
	}
}