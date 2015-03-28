package rfe.by.novik.checkbox;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import rfe.by.novik.gui.Gui;

@SuppressWarnings("rawtypes")
public class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer
{
	private static final long serialVersionUID = 6604709223091382270L;
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean hasFocus)
	{
		setComponentOrientation(list.getComponentOrientation());
		setFont(list.getFont());
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setText(String.valueOf(value));
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setSelected(isSelected);
		setEnabled(list.isEnabled());
		setEnabled(list.isDisplayable());
		return this;
		
	}

}