package advanceJava;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.ArrayList;

//for operator
class Stack{
	
	int top=-1;
    ArrayList<Character> stk = new ArrayList<Character>();
	 
    void push(char ch)
	{
		stk.add(++top,ch);
	}
	
	char pop()
	{
		if(top < 0)
		{
			return 'a';
		}
		
		return stk.get(top--);
	}
	
	/*
	//debug function
	void printStack() {
		for(int i=0;i<=top;i++)
			System.out.print(" "+stk.get(i));
	}*/
	
}

//for solution
class NumberStack{
	int top=-1;
    ArrayList<Integer> stk = new ArrayList<>();
	 
    void push(int n)
	{
		stk.add(++top,n);
	}
	
	int pop()
	{
		return stk.get(top--);
	}
}


class PostFixQueue
{
	int putPointer=0, getPointer=0;
	
    ArrayList<String> stk = new ArrayList<>();
	void put(String ch)
	{
		stk.add(putPointer++,ch);
		
	}
	String get()
	{
		return stk.get(getPointer++);
		
	}
	
}

class CharToNum{
	//For converting Character array to string
	static String getStringFrom(ArrayList<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}
}


class Demo extends JFrame implements ActionListener{
	JLabel ad,eq;
	JTextField n1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,minus,div,mul,eql;
	
	Demo(){
		JFrame jFrame = new JFrame("Solve");
		
		n1= new JTextField(20);
		add(n1);
		
		b1 = new JButton("1");
		add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"1");
			}
		});
		
		b2 = new JButton("2");
		add(b2);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"2");
			}
		});
		
		b3 = new JButton("3");
		add(b3);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"3");
			}
		});
		
		b4 = new JButton("4");
		add(b4);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"4");
			}
		});
		
		b5 = new JButton("5");
		add(b5);
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"5");
			}
		});
		
		b6 = new JButton("6");
		add(b6);
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"6");
			}
		});
		
		b7 = new JButton("7");
		add(b7);
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"7");
			}
		});
		
		b8 = new JButton("8");
		add(b8);
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"8");
			}
		});
		
		b9 = new JButton("9");
		add(b9);
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"9");
			}
		});
		
		plus = new JButton("+");
		add(plus);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"+");
			}
		});
		
		minus = new JButton("-");
		add(minus);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"-");
			}
		});
		
		div = new JButton("/");
		add(div);
		div.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"/");
			}
		});
		
		mul = new JButton("*");
		add(mul);
		mul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String st = n1.getText();
				n1.setText(st+"*");
			}
		});
		
		eql = new JButton("=");
		add(eql);
		eql.addActionListener(this);
		
		setVisible(true);
		setSize(480,480);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
			if(n1.getText().isEmpty())
			{
				//do nothing
			}
			
			//create postfix expression, solve and display it - display to console
			else
			{
			char s[]=n1.getText().toCharArray();
			
		    boolean precedenceFlag=false;
		    
		    
		    PostFixQueue exp = new PostFixQueue();
		    Stack opr = new Stack();
		    
		    //for keeping track of current number
		    ArrayList<Character> number = new ArrayList<>();
		    
		    //creating postfix expression
		    for(int i=0; i<s.length;i++) {
		    	char ch=s[i];
		    	
		    	if(ch-'0'>=0 && ch-'0'<=9) {
		    		//character is a number
		    		number.add(ch);
		    		
		    	} else {
		    		//else it is an operator
		    		exp.put(CharToNum.getStringFrom(number));
		    		number.clear();
		    		
		    		if(!precedenceFlag) {
		    			//There is NOT an operator of higher precedence in operator stack
		    			//We can push operators in operator stack
		    			opr.push(ch);
		    			
		    			//Set precedenceFlag if current operator is '*' or '/'
		    			if(ch=='*' || ch=='/') {
		    				precedenceFlag=true;
		    			}
		    		} else {
		    			//There is an operator of higher precedence in operator stack
		    			//Pop all operators and put into PostFixQueue
		    			char o = opr.pop();
		    			while(o!='a') {
		    				exp.put(String.valueOf(o));
		    				o = opr.pop();
		    			}
		    			//Now we can push current operator
		    			opr.push(ch);
		    			precedenceFlag=false;
		    		}
		    	}
		    	
		    }
		    
		    //Put the last number being continued from character array into the stack
		    exp.put(CharToNum.getStringFrom(number));
    		number.clear();
		    
		    char o = opr.pop();
			while(o!='a') {
				exp.put(String.valueOf(o));
				o = opr.pop();
			}
		    exp.put("e");
		    
		    //Now we can calculate postfix expression
		    NumberStack solution = new NumberStack();
		    String ch=exp.get();
		    
		    while(!ch.equals("e")) {
		    	try{
		    		int n = Integer.valueOf(ch);
		    		solution.push(n);
		    	}
		    	catch(NumberFormatException e) {
		    		int operand1 = solution.pop();
		    		int operand2 = solution.pop();
		    		int ans=0;
		    		char op = ch.charAt(0);
		    		switch(op) {
		    		case '+': ans= operand2+operand1; break;
		    		case '-': ans= operand2-operand1; break;
		    		case '*': ans= operand2*operand1; break;
		    		case '/': ans= operand2/operand1; break;
		    		}
		    		solution.push(ans);
		    	}
		    	//get next operator or number from the Postfix queue
		    	ch=exp.get();
		    }
		    //pop and print solution
		    n1.setText(""+solution.pop());
	        }
			
			
    }
}

public class Calculator{
	static Demo obj;
	public static void main(String[] args){
		obj= new Demo();
		obj.show();
	}
}
