package rfe.by.novik.checkbox;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("rawtypes")
public class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer
{
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean hasFocus)
	{
		setComponentOrientation(list.getComponentOrientation());

		setFont(list.getFont());
		setText(String.valueOf(value));
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setSelected(hasFocus);
		setEnabled(list.isEnabled());
		return this;
	}
}