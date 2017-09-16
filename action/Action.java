package action;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Action extends JFrame {
	JRadioButton rb1,rb2,rb3;
	JCheckBox cb1,cb2,cb3;
	JComboBox box;
	JLabel l;
	String styleName;
	int size = 12;
	int style;

	
	public Action() {

		setSize(300,300);
		setTitle("Свойства текста");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String s[] = {"Черный","Красный","Зеленый","Синий"};
		box = new JComboBox(s);
		l = new JLabel("Самый обычный текст");
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
		cb1 = new JCheckBox("Курсив");//
		cb2 = new JCheckBox("Жирный");//было cb1
		cb3 = new JCheckBox("Курсив+Жирный");//было cb1
		
		rb1 = new JRadioButton("15");
		rb2 = new JRadioButton("20");
		rb3 = new JRadioButton("25");
		
		ButtonGroup gr = new ButtonGroup();
		gr.add(rb1);gr.add(rb2);gr.add(rb3);
		
		c.add(l); 
		c.add(box);
		c.add(cb1);
		c.add(cb2);
		c.add(cb3);
		c.add(rb2);c.add(rb3);c.add(rb1);
		
		Listen lis = new Listen();
		box.addItemListener(lis);
		cb1.addItemListener(lis);
		cb2.addItemListener(lis);
		cb3.addItemListener(lis);
		rb1.addItemListener(lis);
		rb2.addItemListener(lis);
		rb3.addItemListener(lis);	
		setVisible(true);
	}
	
	class Listen implements Properties{
		int count=0, a=0, b=0, c=0;//count - счетчик нажатий. a,b,c - смотрим нажимали ли мы на пункт 
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getSource()==cb1){
				//style(cb1);				
				if(a == 0) {//ставим галочку
					count++;
					a++;
				}
				else {//снимаем галочку
					count--;
					a = 0;
				}
			}
			if(e.getSource()==cb2){
				//style(cb2);
				if(b == 0) {
					count+=2;
					b++;
				}
				else {
					count-=2;
					b = 0;
				}
			}			
			if(e.getSource()==cb3){
				//style(cb3);
				if(c == 0) {
					count+=3;
					c++;
				}
				else {
					count-=3;
					c = 0;
				}
			}			
			style2(count);
			
			if(e.getSource()==rb1){
				size(rb1);
			}
			if(e.getSource()==rb2){
				size(rb2);
			}
			if(e.getSource()==rb3){
				size(rb3);
			}
			if (e.getSource()==box) { 
				color(box);
			}
			
			
		}

		//Переделал style под счетчик
		@Override
		public void style2(int count) {
			if(count > 2) {
				l.setFont(new Font("italica",Font.ITALIC | Font.BOLD,size));
				style = 3;
			}
			else if(count == 2) {
				l.setFont(new Font("italica",Font.BOLD,size));
				style = Font.BOLD;
			}
			else if(count == 1) {
				l.setFont(new Font("italica",Font.ITALIC,size));
				style = Font.ITALIC;
			}
			else {
				l.setFont(new Font("italica",Font.PLAIN,size));
				style = Font.PLAIN;
			}			
		}

		@Override
		public void style(JCheckBox c) {			
			if(c.getText()=="Курсив"){
				if(c.isSelected()){
					l.setFont(new Font("italica",Font.ITALIC,size));
					style = Font.ITALIC;
				}
				else{
					l.setFont(new Font("italica",Font.PLAIN,size));
					style = Font.PLAIN;
				}
			}
			
			if(c.getText()=="Жирный"){
				if(c.isSelected()){
					l.setFont(new Font("italica",Font.BOLD,size));
					style = Font.BOLD;
				}
				else{
					l.setFont(new Font("italica",Font.PLAIN,size));
					style = Font.PLAIN;
				}				
			}
			
			if(c.getText()=="Курсив+Жирный"){
				if(c.isSelected()){
					l.setFont(new Font("italica",Font.ITALIC | Font.BOLD,size));
					style = 3;
				}
				else{
					l.setFont(new Font("italica",Font.PLAIN,size));
					style = Font.PLAIN;
				}
			}
			
			
			
			
		}

		@Override
		public void size(JRadioButton b) {
			if(b.getText().equals("15")){
				if(b.isSelected()){
					l.setFont(new Font(styleName,style,15));
					size=15;
				}
				//Лишнее тк метка только переопределяется, но не снимается
				//else{
				//	l.setFont(new Font(styleName,style,size));
				//}
			}
			
			if(b.getText().equals("20")){
				if(b.isSelected()){
					l.setFont(new Font(styleName,style,20));
					size=20;
				}
				//else{
				//	l.setFont(new Font(styleName,style,size));
				//}
			}
			
			if(b.getText().equals("25")){
				if(b.isSelected()){
					l.setFont(new Font(styleName,style,25));
					size=25;
				}
				//else{
				//	l.setFont(new Font(styleName,style,size));
				//}
			}			
		}

		@Override
		public void color(JComboBox box) {
			int index = box.getSelectedIndex();
			if(index==0){
				l.setForeground(Color.BLACK);
			}
			else if(index==1){
				l.setForeground(Color.RED);
			}
			else if(index==2){
				l.setForeground(Color.GREEN);
			}
			
			else if(index==3){
				l.setForeground(Color.BLUE);
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		new Action();
	}
}
