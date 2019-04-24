import java.awt.*;
import java.awt.event.*;

public class GUICalculator implements ActionListener {
	
	TextField screen;
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bminus, btimes, bdivide, bequals, bclear;
	float currentValue;
	Button currentOperation;
	Frame err;
	
	public GUICalculator() {
		Frame f = new Frame("Calculator");
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Panel p1 = new Panel(), p2 = new Panel();
		p2.setLayout(new GridLayout(4,4));
		
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
		
		p1.add(screen);
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
		p2.add(bequals);
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
		if(btn == b0) {
			screen.setText(screen.getText()+"0");
		}
		if(btn == b1) {
			screen.setText(screen.getText()+"1");
		}
		if(btn == b2) {
			screen.setText(screen.getText()+"2");
		}
		if(btn == b3) {
			screen.setText(screen.getText()+"3");
		}
		if(btn == b4) {
			screen.setText(screen.getText()+"4");
		}
		if(btn == b5) {
			screen.setText(screen.getText()+"5");
		}
		if(btn == b6) {
			screen.setText(screen.getText()+"6");
		}
		if(btn == b7) {
			screen.setText(screen.getText()+"7");
		}
		if(btn == b8) {
			screen.setText(screen.getText()+"8");
		}
		if(btn == b9) {
			screen.setText(screen.getText()+"9");
		}
		if(btn == bplus) {
			mathematics();
			currentOperation=bplus;
			screen.setText("");
		}
		if(btn == bminus) {
			mathematics();
			currentOperation=bminus;
			screen.setText("");
		}
		if(btn == btimes) {
			mathematics();
			currentOperation=btimes;
			screen.setText("");
		}
		if(btn == bdivide) {
			mathematics();
			currentOperation=bdivide;
			screen.setText("");
		}
		if(btn == bequals) {
			mathematics();
			currentOperation=null;
			screen.setText(Float.toString(currentValue));
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
					currentValue+=Float.parseFloat(screen.getText());
				else if(currentOperation==bminus)
					currentValue-=Float.parseFloat(screen.getText());
				else if(currentOperation==btimes)
					currentValue*=Float.parseFloat(screen.getText());
				else if(currentOperation==bdivide)
					currentValue/=Float.parseFloat(screen.getText());
				else
					currentValue=Float.parseFloat(screen.getText());
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
				err.setVisible(true);
			}
			else {
				err.setVisible(true);
			}
		}
	}
}
