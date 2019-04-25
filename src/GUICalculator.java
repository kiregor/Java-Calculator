import java.awt.*;
import java.awt.event.*;

public class GUICalculator implements ActionListener {
	
	TextField screen;
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bminus, btimes, bdivide, bequals, bclear, bdecimal;
	double currentValue;
	Button currentOperation;
	Frame f, err;
	
	public GUICalculator() {
		f = new Frame("Calculator");
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Panel p1 = new Panel(), p2 = new Panel(), p3 = new Panel();
		p2.setLayout(new GridLayout(4,4));
		p3.setLayout(new GridLayout(2,1));
		
		screen = new TextField(50);
		b0 = new Button("0");
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		bplus = new Button("+");
		bminus = new Button("-");
		btimes = new Button("x");
		bdivide = new Button("/");
		bequals = new Button("=");
		bclear = new Button("C");
		bdecimal = new Button(".");
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		btimes.addActionListener(this);
		bdivide.addActionListener(this);
		bequals.addActionListener(this);
		bclear.addActionListener(this);
		bdecimal.addActionListener(this);
		
		p1.add(screen);
		p3.add(bequals);
		p3.add(bdecimal);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(bplus);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(bminus);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(btimes);
		p2.add(b0);
		p2.add(p3);
		p2.add(bclear);
		p2.add(bdivide);
		
		f.add(p1, BorderLayout.NORTH);
		f.add(p2);
		
		f.setSize(400,400);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GUICalculator();
	}
	
	public void actionPerformed(ActionEvent x) {
		Button btn = (Button)x.getSource();
		if(btn == b0 || btn == b1 || btn == b2 || btn == b3 || btn == b4 || btn == b5 || btn == b6 || btn == b7 || btn == b8 || btn == b9 || btn == bdecimal) {
			screen.setText(screen.getText()+btn.getLabel());
		}
		if(btn == bplus || btn == bminus || btn == btimes || btn == bdivide) {
			mathematics();
			currentOperation=btn;
			screen.setText("");
		}
		if(btn == bequals) {
			mathematics();
			currentOperation=null;
			screen.setText(Double.toString(currentValue));
		}
		if(btn == bclear) {
			currentOperation=null;
			currentValue=0;
			screen.setText("");
		}
	}
	
	public void mathematics() {
		try {
			if(!screen.getText().contentEquals("")) {
				if(currentOperation==bplus)
					currentValue+=Double.parseDouble(screen.getText());
				else if(currentOperation==bminus)
					currentValue-=Double.parseDouble(screen.getText());
				else if(currentOperation==btimes)
					currentValue*=Double.parseDouble(screen.getText());
				else if(currentOperation==bdivide)
					currentValue/=Double.parseDouble(screen.getText());
				else
					currentValue=Double.parseDouble(screen.getText());
			}
		}
		catch(NumberFormatException e) {
			if(err == null) {
				err = new Frame("Input Error");
				
				err.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						err.setVisible(false);
					}
				});
				
				Panel p1=new Panel(), p2=new Panel();
				
				Label lerr = new Label("Please only enter numerical values into the calculator");
				err.add(lerr);
				err.add(p1, BorderLayout.WEST);
				err.add(p2, BorderLayout.EAST);
				err.setSize(330,80);
				err.setLocation(f.getLocation());
				err.setVisible(true);
			}
			else {
				err.setLocation(f.getLocation());
				err.setVisible(true);
			}
		}
	}
}