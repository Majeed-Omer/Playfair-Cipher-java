package mom;
import java.util.Scanner;   
   
public class playfair   
{   
	 
	 public static final char key[][] = {   {'l', 'g', 'd', 'b', 'a'},
			                                {'q', 'm', 'h', 'e', 'c'},
			                                {'u', 'r', 'n', 'i', 'f'},
			                                {'x', 'v', 's', 'o', 'k'},
			                                {'z', 'y', 'w', 't', 'p'}};
	 
	 public static String arrangeString(String input) {
		 for(int i=0; i<input.length()-1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				 StringBuffer str = new StringBuffer(input);
				 str.insert(i+1, 'x');
				 input = str.toString();
			 }
		 }
		 if(input.length() % 2 != 0)
			  input += "x";
		 return input;
	 }
	 
    public static String encryptData(String inputStr)   
    {     
    	String encryptStr = "";
    	
    	int sr1 = 0;
    	int sr2 = 0;
    	int sc1 = 0;
    	int sc2 = 0;
    	
    	for(int i=0; i<inputStr.length(); i+=2) {
    		for (int r = 0; r < key.length; r++) { 
    	         for (int c = 0; c < key[r].length; c++) { 
    	            if(key[r][c] == inputStr.charAt(i)) {
    	            	sr1 = r;
    	            	sc1 = c;
    	            }else if(key[r][c] == inputStr.charAt(i+1)){
    	            	sr2 = r;
    	            	sc2 = c;
    	            }
    	         }
    	      }
    		if(sr1==sr2) {
    			sc1+=1;
    			sc2+=1;
    			if(sc1==5) 
    				sc1=0;
    			else if(sc2==5)
    				sc2=0;
    		} else if(sc1==sc2) {
    			sr1+=1;
    			sr2+=1;
    			if(sr1==5)
    				sr1=0;
    			else if(sr2==5)
    				sr2=0;
    		} else {
    			int xc = 0;
    			xc = sc1;
    			sc1=sc2;
    			sc2=xc;
    		}
    		encryptStr += key[sr1][sc1];
    		encryptStr += key[sr2][sc2];
    	}
          
        return encryptStr;   
    }   
      
    public static String decryptData(String inputStr)   
    {   
          
     String decryptStr = "";
    	
    	int sr1 = 0;
    	int sr2 = 0;
    	int sc1 = 0;
    	int sc2 = 0;
    	
    	for(int i=0; i<inputStr.length(); i+=2) {
    		for (int r = 0; r < key.length; r++) { 
    	         for (int c = 0; c < key[r].length; c++) { 
    	            if(key[r][c] == inputStr.charAt(i)) {
    	            	sr1 = r;
    	            	sc1 = c;
    	            }else if(key[r][c] == inputStr.charAt(i+1)){
    	            	sr2 = r;
    	            	sc2 = c;
    	            }
    	         }
    	      }
    		if(sr1==sr2) {
    			sc1-=1;
    			sc2-=1;
    			if(sc1==-1) 
    				sc1=4;
    			else if(sc2==-1)
    				sc2=4;
    		} else if(sc1==sc2) {
    			sr1-=1;
    			sr2-=1;
    			if(sr1==-1)
    				sr1=4;
    			else if(sr2==-1)
    				sr2=4;
    		} else {
    			int xc = 0;
    			xc = sc1;
    			sc1=sc2;
    			sc2=xc;
    		}
    		decryptStr += key[sr1][sc1];
    		decryptStr += key[sr2][sc2];
    	}
          
        return decryptStr;  
    }   
      
    public static void main(String[] args)   
    {   
        Scanner sc = new Scanner(System.in); 
                  
        System.out.println("Enter a string: ");   
        String inputStr = sc.nextLine().toLowerCase();
        inputStr = arrangeString(inputStr);
        System.out.println("Encrypted Data ===> "+encryptData(inputStr)); 
        System.out.println("Decrypted Data ===> "+decryptData(encryptData(inputStr)));   
          
        sc.close();   
    }   
} 