import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Atish
 */
public class caesargui extends javax.swing.JFrame {

    //initialize real code
    
	private static final int MIN = 0, MAX = 127;
	private static HashMap<Character, Character> map;
	private static HashMap<Character, Character> inverseMap;
        private static int key=0;
	private static int key1 []=new int [5];
        private static int q;
        private static int mvisit []=new int [MAX];
        public static int rand;
        public static String input;
        public static String decryptinput;
        public static String pwd1;
        public static int ch=0;
    
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
	
    //--
    public caesargui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Encryptiontitle = new javax.swing.JLabel();
        Decryptiontitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        encryptedstring = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        decryptedtext = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputtext = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        encryptedtext = new javax.swing.JTextArea();
        Password1 = new javax.swing.JTextField();
        Password2 = new javax.swing.JTextField();
        Encrypt = new javax.swing.JButton();
        Decrypt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Title.setLabelFor(this);
        Title.setText("Modified Caesar Algorithm");

        Encryptiontitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Encryptiontitle.setText("Encryption:");

        Decryptiontitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Decryptiontitle.setText("Decryption:");

        jLabel3.setText("Plain Text:");

        encryptedstring.setEditable(false);
        encryptedstring.setColumns(20);
        encryptedstring.setRows(5);
        jScrollPane1.setViewportView(encryptedstring);

        jLabel4.setText("Encrypted Text:");

        decryptedtext.setEditable(false);
        decryptedtext.setColumns(20);
        decryptedtext.setRows(5);
        jScrollPane2.setViewportView(decryptedtext);

        jLabel5.setText("Password:");

        jLabel6.setText("Password:");

        jLabel7.setText("Encrypted String:");

        jLabel8.setText("Decrypted String:");

        inputtext.setColumns(20);
        inputtext.setRows(5);
        jScrollPane3.setViewportView(inputtext);

        encryptedtext.setColumns(20);
        encryptedtext.setRows(5);
        jScrollPane4.setViewportView(encryptedtext);

        Password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password1ActionPerformed(evt);
            }
        });

        Password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password2ActionPerformed(evt);
            }
        });

        Encrypt.setText("Encrypt");
        Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptActionPerformed(evt);
            }
        });

        Decrypt.setText("Decrypt");
        Decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptActionPerformed(evt);
            }
        });

        jLabel1.setText("* Password should be of length 5");

        jLabel2.setText("* Password should be of length 5");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(Encrypt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Decrypt)
                .addGap(149, 149, 149))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit)
                .addGap(463, 463, 463))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Encryptiontitle)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(349, 349, 349)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Decryptiontitle)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(Password2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Password1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(582, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(681, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Encryptiontitle)
                            .addComponent(Decryptiontitle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(235, 235, 235)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(Password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Encrypt)
                    .addComponent(Decrypt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password1ActionPerformed

    }//GEN-LAST:event_Password1ActionPerformed

    private void Password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Password2ActionPerformed

    private void EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptActionPerformed

         JPanel pnl = null;
         pwd1=Password1.getText();
        if(pwd1.length()!=5)
        {
                            JOptionPane.showMessageDialog(pnl, "Enter password of length 5","Error", JOptionPane.ERROR_MESSAGE);
        }
         else
        {    
            ch=1;
            cipher1 = "";
            cipher2 = "";
            encryptedstring.setText("");
            encryptedtext.setText("");
             try {
                 encryptinit();
             } catch (IOException ex) {
                 Logger.getLogger(caesargui.class.getName()).log(Level.SEVERE, null, ex);
             }
             String encryptedStr = encrypt(input);
             transposeencrypt(encryptedStr);
        }
    }//GEN-LAST:event_EncryptActionPerformed

    private void DecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptActionPerformed
         JPanel pnl = null;
         pwd1=Password2.getText();
        if(pwd1.length()!=5)
        {
                            JOptionPane.showMessageDialog(pnl, "Enter password of length 5","Error", JOptionPane.ERROR_MESSAGE);
        }
          else
        {   
            ch=2;
            decipher1 = "";
            decipher2 = "";
             decryptedtext.setText("");
             try {
                 decryptinit();
             } catch (IOException ex) {
                 Logger.getLogger(caesargui.class.getName()).log(Level.SEVERE, null, ex);
             }
             transposedecrypt();
             String decryptedString = decrypt(decipher2);
             decryptedtext.append(decryptedString);
        }
    }//GEN-LAST:event_DecryptActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
       System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(caesargui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(caesargui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(caesargui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(caesargui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new caesargui().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Decrypt;
    private javax.swing.JLabel Decryptiontitle;
    private javax.swing.JButton Encrypt;
    private javax.swing.JLabel Encryptiontitle;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField Password1;
    private javax.swing.JTextField Password2;
    private javax.swing.JLabel Title;
    private javax.swing.JTextArea decryptedtext;
    private javax.swing.JTextArea encryptedstring;
    private javax.swing.JTextArea encryptedtext;
    private javax.swing.JTextArea inputtext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    public  void encryptinit() throws IOException
    {
            initializekeyandip();
            loadMaps();
    }
    public  void decryptinit() throws IOException
    {
            initializekeyandip();
            loadMaps();
    }
    	public  void loadMaps() {
		map = new HashMap<Character, Character>();
		inverseMap = new HashMap<Character, Character>();
                q=0;
		        for(int i=0;i<32;i++)
                 mvisit[i]=1;
                 for(int i=32;i<MAX;i++)
                 mvisit[i]=0;
		for(int i = 0; i < 32; i++) {
			map.put((char) i, (char) i);
		}
		for(int i = 32; i < MAX; i++) {
			map.put((char) i, (char) getNextRandom());
		}
		for(int i = MAX; i < 255; i++) {
			map.put((char) i, (char) i);
		}
		
		if(map != null && inverseMap != null) {
			Set<Entry<Character, Character>> set = map.entrySet();
			for(Entry<Character, Character> entry : set) {
				inverseMap.put(entry.getValue(), entry.getKey());
			}
		}
	}

	private  int getNextRandom() {
		
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
	public  String encrypt(String input) {
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
	public  String decrypt(String input) {
		StringBuffer sb = new StringBuffer();
		
		char x = ' ';
		for(int i = 0; i < input.length(); i++) {
			x = input.charAt(i);
			sb.append(inverseMap.get(x));
		}
		
		return sb.toString();
	}
	public  void initializekeyandip() throws IOException
{       
    if(ch==1)
        input=inputtext.getText();
    else if (ch==2)
        decryptinput=encryptedtext.getText();
	key=0;
	for(int i = 0 ; i < 5 ; i ++)
		key1[i] = (int)pwd1.charAt(i);
	for(int i=0;i<5;i++)
	{
		key=key*10+key1[i];
	}
	//System.out.println(key);
	
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
	  // for(int i=0;i<5;i++)
	  //System.out.print(key1[i]);
	 // System.out.println();
               
}
public void transposeencrypt(String encryptedString)
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
            System.out.print(a[j][k]+" ");
        }
          System.out.println();
    }
    for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          b[k][j]=a[k][l];
          System.out.print(b[k][j]+" ");
        }
        System.out.println();
    }
    System.out.println("Tencrypt1 is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	cipher1 += b[k][j];         
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
    //System.out.println("Final Encrypted message is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	cipher2 += d[k][j]; 
            
    } 
    //System.out.println(cipher2);
    //System.out.println();
	} 
encryptedstring.append(cipher2);
encryptedtext.append(cipher2);
}
public  void transposedecrypt()
{
	 //System.out.println("Decryption :");
	int len=decryptinput.length();
	int i=0,len1=0,w=1;
	while(w==1)
	{
    for(i=0;i<25 && len1<len;i++,len1++)
    {
        ip[i]=decryptinput.charAt(len1);     
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
    //System.out.println("Tdecrpt1 is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	decipher1 += b[k][j];
    }
    //System.out.println(decipher1);
    //System.out.println();
    for(j=0,l=0;j<5;j++)
    {
        l=key1[j]-1;
        for(k=0;k<5;k++)
        {
          a[k][l]=b[k][j];  
        }
    }
    //System.out.println("Initial decrypted is :");
    for(j=0;j<5;j++)
    {
        for(k=0;k<5;k++)
        	decipher2 +=a[j][k];
    }  
    //System.out.println(decipher2);
   // System.out.println();
   // decipher2 = decipher2.replace(" ","");
        }
     decipher2 = decipher2.replace("   ","");
     
}

}
