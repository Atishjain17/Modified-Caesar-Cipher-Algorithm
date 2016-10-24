package ceasertranspo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;



public class ceasertranspofull {


	private static final int MIN = 0, MAX = 127;
	private static HashMap<Character, Character> map;
	private static HashMap<Character, Character> inverseMap;
    private static int key=0;
	private static int key1 []=new int [5];
    private static int q=0;
    private static int mvisit []=new int [MAX];
    public static int rand;
    public static String input;
    
    public static char a[][]=new char[5][5];
    public static char b[][]=new char[5][5];
    public static char c[][]=new char[5][5];
    public static char d[][]=new char[5][5];
    public static char ip[]=new char[25];
    public static int j,k,l;
    
	public static String cipher1 = "";
	public static String cipher2 = "";
	public static String decipher1 = "";
	public static String decipher2 = "";
	
	
	public static void main(String[] args) throws IOException {
		
	for(int i=0;i<32;i++)
	mvisit[i]=1;
	for(int i=32;i<MAX;i++)
	mvisit[i]=0;
    
    initializekeyandip();
	loadMaps();
		
//encrypt ceaser		
		String encryptedString = encrypt(input);
		System.out.println("Initial Encrypted String:");
		System.out.println(encryptedString);
		System.out.println();            //encryptceaser finish
//transpose encrypt and decrypt
         transposeencrypt(encryptedString);
         transposedecrypt();
//decipher	ceaser	
		String decryptedString = decrypt(decipher2);
		System.out.println("Final Decrypted Message:");
		System.out.println(decryptedString);
		 System.out.println();			//decryptceaserfinish
		
	}
	
	public static void loadMaps() {
		map = new HashMap<Character, Character>();
		inverseMap = new HashMap<Character, Character>();
		
		for(int i = 0; i < 32; i++) {
			map.put((char) i, (char) i);
		}
		for(int i = 32; i < MAX; i++) {
			int qw=getNextRandom();
			map.put((char) i, (char) qw);
			char a=(char)i;
			char qwe=(char)qw;
			System.out.println(qw+" : "+a +" : "+ qwe);
		}
		for(int i = MAX; i < 255; i++) {
			map.put((char) i, (char) i);
		}
		System.out.println("the end");
		if(map != null && inverseMap != null) {
			Set<Entry<Character, Character>> set = map.entrySet();
			for(Entry<Character, Character> entry : set) {
				inverseMap.put(entry.getValue(), entry.getKey());
			}
		}
	}

	private static int getNextRandom() {
		
		rand=q % MAX;
		q=rand+3*key;
		if(rand<0)
			rand=rand*-1;
		
		if(mvisit[rand]==0)
			mvisit[rand]=1;
		else{
			while(mvisit[rand]!=0)
				rand=(rand+1)%MAX;
			mvisit[rand]=1;
		}

			return rand; 
	}
//ceaser	
	public static String encrypt(String input) {
		StringBuffer sb = new StringBuffer();
		//input = input.toUpperCase();
		
		char x = ' ';
		for(int i = 0; i < input.length(); i++) {
			x = input.charAt(i);
			sb.append(map.get(x));
		}
		
		return sb.toString();
	}
//ceaser	
	public static String decrypt(String input) {
		StringBuffer sb = new StringBuffer();
		
		char x = ' ';
		for(int i = 0; i < input.length(); i++) {
			x = input.charAt(i);
			sb.append(inverseMap.get(x));
		}
		
		return sb.toString();
	}
	public static void initializekeyandip() throws IOException
{   
	BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Input String :");
	input = bb.readLine();
	//input+=(char) 13;  
	//input+=bb.readLine();  for more than one lines.
	System.out.println("Enter password of length 5 : ");
	String key2 = bb.readLine();
	System.out.print("Password:");
	for(int i = 0 ; i < 5 ; i ++)
		key1[i] = (int)key2.charAt(i);
	for(int i=0;i<5;i++)
	{
		key=key*10+key1[i];
	}
	System.out.println(key);
	
	for(int i=0;i<5;i++)
		key1[i]=(key1[i]%5)+1;
	
	int kvisit []=new int [6];
	for(int i=0;i<6;i++)
		kvisit[i]=0;
	  for(int i=0;i<5;i++)
	  {
		  int rv=key1[i];
		  int kv1=1;
		  if(kvisit[rv]==0)
			  kvisit[rv]=1;
		  else{
			  while(kvisit[kv1]!=0 && kv1<6)
				  kv1++;
			  key1[i]=kv1;
			  kvisit[kv1]=1;
		  }
	  }
	   for(int i=0;i<5;i++)
	  System.out.print(key1[i]);
	  System.out.println();
}

	public static void transposeencrypt(String encryptedString)
{   
	int len=encryptedString.length();
	int i=0,len1=0,w=1;
	while(w==1)
	{
    for(i=0;i<25 && len1<len;i++,len1++)
    {
        ip[i]=encryptedString.charAt(len1);     
    }

    if(len==len1)
    {   for(i=i;i<25;i++)
        ip[i]=' ';
    	w=0;
    }
	for(j=0,l=0;j<5;j++)
    {
        for(k=0;k<5;k++,l++)
        {
            a[j][k]=ip[l];
        }
    }
    for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          b[k][j]=a[k][l];  
        }
    }
    System.out.println("Tencrypt1 is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	{cipher1 += b[k][j];
        	System.out.print(b[k][j]+"  ");
        	}
        System.out.println();
    } 
    System.out.println(cipher1);
    System.out.println();
   for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
           c[j][k]=b[k][j];
    }
     for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          d[k][j]=c[k][l];  
        }
    }        
    System.out.println("Final Encrypted message is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	{cipher2 += d[k][j];
       	System.out.print(d[k][j]+"  ");
	}
System.out.println();
            
    } 
    System.out.println(cipher2);
    System.out.println();
	} 
	System.out.println("Tencrypt1 is :");
	System.out.println(cipher1);
    System.out.println();
    System.out.println("Final Encrypted message is :");
    System.out.println(cipher2);
    System.out.println();
}
	public static void transposedecrypt()
{
	 //System.out.println("Decryption :");
	int len=cipher2.length();
	int i=0,len1=0,w=1;
	while(w==1)
	{
    for(i=0;i<25 && len1<len;i++,len1++)
    {
        ip[i]=cipher2.charAt(len1);     
    }
    if(len==len1)
    {
    	 for(i=i;i<25;i++)
    	   ip[i]=' ';
    	w=0;
    }
	for(j=0,l=0;j<5;j++)
    {
        for(k=0;k<5;k++,l++)
        {
            d[j][k]=ip[l];
        }
    }
     for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          c[k][l]=d[j][k];  
        }
    }
     for(j=0;j<5;j++)
    {
     for(k=0;k<5;k++)
       b[j][k]=c[k][j];
    }
    System.out.println("Tdecrpt1 is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        {	decipher1 += b[k][j];
       	System.out.print(b[k][j]+"  ");
	}
System.out.println();
    }
    System.out.println(decipher1);
    System.out.println();
    for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          a[k][l]=b[k][j];  
        }
    }
    System.out.println("Initial decrypted is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	{decipher2 +=a[j][k];
           	System.out.print(b[k][j]+"  ");
        	}
        System.out.println();
        	
    }  
    System.out.println(decipher2);
    System.out.println();
    decipher2 = decipher2.replace("  ","");
	}
	 System.out.println("Decryption :");
	 System.out.println("Tdecrpt1 is :");
     System.out.println(decipher1);
     System.out.println();	
	 System.out.println("Initial decrypted is :");
     System.out.println(decipher2);
     System.out.println();
     //decipher2 = decipher2.replace("   ","");
}

}


