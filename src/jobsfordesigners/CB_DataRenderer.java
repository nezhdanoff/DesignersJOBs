
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
//import javax.swing.*;
//import java.awt.*;

/**
 *
 * @author Nezhdanoff
 */

class CB_DataRenderer extends JLabel implements ListCellRenderer
{
    private final String _title;

    public CB_DataRenderer(String title) {   // Конструктор
        _title = title;
        setOpaque(true);   // не знаю, зачем это надо, взял из примера :)
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) // если элемент выделен - выставляем ему одни цвета, если нет - другие
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if (index == -1 && value == null) setText(_title);
        else setText(value.toString());   // ЗАДАЕМ ТЕКСТ ЭЛЕМЕНТА!!

        return this;
    }
}