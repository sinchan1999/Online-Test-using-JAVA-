package coreJava2;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            
            JOptionPane.showMessageDialog(this,"correct ans="+count+"/10");  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which of the following is a reserved keyword in Java?");  
            jb[0].setText("object");jb[1].setText("strictfp");jb[2].setText("main");jb[3].setText("system");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which of the following is not a Java features?");  
            jb[0].setText("Dynamic");jb[1].setText("Architecture Neutral");jb[2].setText("Use of pointers");jb[3].setText("Object-oriented");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: _____ is used to find and fix bugs in the Java programs.");  
            jb[0].setText("JVM");jb[1].setText("JRE");jb[2].setText("JDK");jb[3].setText("JDB");  
        }  
        if(current==3)  
        {  
            l.setText("Que4:  What is the return type of the hashCode() method in the Object class?");  
            jb[0].setText("Object");jb[1].setText("int");jb[2].setText("long");jb[3].setText("void");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following is a valid long literal?");  
            jb[0].setText("ABH8097");jb[1].setText("L990023");jb[2].setText("904423");jb[3].setText("0xnf029L");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: What does the expression float a = 35 / 0 return?");  
            jb[0].setText("0");jb[1].setText("Not a Number");jb[2].setText("Infinity");jb[3].setText("Run time exception");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: What is meant by the classes and objects that dependents on each other? ");  
            jb[0].setText("Tight Coupling");jb[1].setText("Cohesion");jb[2].setText("Loose Coupling");  
                        jb[3].setText("None of the above");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: How many threads can be executed at a time?");  
            jb[0].setText("Only one thread");jb[1].setText("Multiple threads");
            jb[2].setText("Only main (main() method) thread");
            jb[3].setText("Two threads");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: An interface with no fields or methods is known as a ______.");  
            jb[0].setText("Runnable Interface");jb[1].setText("Marker Interface");jb[2].setText("Abstract Interface");jb[3].setText("CharSequence Interface");  
        }  
        if(current==9)  
        {  
            l.setText("Que10:  Which of the following is an immediate subclass of the Panel class?");  
            jb[0].setText("Applet class");jb[1].setText("Window class");jb[2].setText("Frame class");  
                        jb[3].setText("Dialog class");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    
    // Checking the answers with index.
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        
        if(current==1)  
            return(jb[2].isSelected());  
        
        if(current==2)  
            return(jb[3].isSelected()); 
        
        if(current==3)  
            return(jb[1].isSelected());  
        
        if(current==4)  
            return(jb[3].isSelected());  
        
        if(current==5)  
            return(jb[2].isSelected()); 
        
        if(current==6)  
            return(jb[0].isSelected());
        
        if(current==7)  
            return(jb[1].isSelected());  
        
        if(current==8)  
            return(jb[1].isSelected()); 
        
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  