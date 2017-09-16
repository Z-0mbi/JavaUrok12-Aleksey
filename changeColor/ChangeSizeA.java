package changeColor;
/*Разработать программу, которая дает возможность у компонента Jlabel 
 * менять шрифт в соответствии с выбранным JRadioButton. 
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.xml.bind.Marshaller.Listener;

public class ChangeSizeA extends JFrame{
	JLabel label;
	JRadioButton rb1;
	JRadioButton rb2;
	JRadioButton rb3;
	
	public ChangeSizeA () {
		setTitle("Изменяем размер");
		setBackground(Color.BLUE);
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		label = new JLabel("A");
		rb1 = new JRadioButton("Маленький");
		rb2 = new JRadioButton("Средний");
		rb3 = new JRadioButton("Большой");
		ButtonGroup g = new ButtonGroup();
		g.add(rb1);
		g.add(rb2);
		g.add(rb3);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		c.add(label);
		c.add(rb1);
		c.add(rb2);
		c.add(rb3);
		c.add(label);
		
		Listener lis = new Listener();
		rb1.addItemListener(lis);
		rb2.addItemListener(lis);
		rb3.addItemListener(lis);
	}
	
	class Listener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(rb1.isSelected()){
				label.setFont(new Font("defolt", Font.PLAIN, 9));				
			}
			else if(rb2.isSelected()){
				label.setFont(new Font("defolt", Font.PLAIN, 18));
			}
			else{
				label.setFont(new Font("defolt", Font.PLAIN, 27));
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		new ChangeSizeA();

	}

}
