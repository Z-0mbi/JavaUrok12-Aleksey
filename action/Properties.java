package action;

import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public interface Properties extends ItemListener {
	public void style(JCheckBox c);
	public void size(JRadioButton b);
	public void color(JComboBox box);
	public void style2(int count);
}