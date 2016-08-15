package ua.itak.designers.job;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**

 @author Nezhdanoff
 */
public class TableModel_NowWork implements TableModel {

        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

        private List<Object_NowWorkJob> beans;

        public TableModel_NowWork(List<Object_NowWorkJob> beans) {
            this.beans = beans;
        }

        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public int getColumnCount() {
            return 8;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return "Дизайнер";
            case 1:
                return "ТЗ №";
            case 2:
                return "Статус";
            case 3:
                return "С какого часа";
            case 4:
                return "Заказчик";
            case 5:
                return "ТМ";
            case 6:
                return "Видов";
            case 7:
                return "Менеджер";
            }
            return "";
        }

        public int getRowCount() {
            return beans.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Object_NowWorkJob bean = beans.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return bean.getJ_Designer();
            case 1:
                return bean.getJ_NumIdx();
            case 2:
                return bean.getJ_StageName();
            case 3:
                return bean.getJ_StartString();
            case 4:
                return bean.getJ_Customer();
            case 5:
                return bean.getJ_TM();
            case 6:
                return bean.getJ_NumOfKind();
            case 7:
                return bean.getJ_Manager();
            }
            return "";
        }

        public int getJobIdAT(int rowIndex) {
            Object_NowWorkJob bean = beans.get(rowIndex);
            return bean.getJ_ID();
        }

        public String getHTMLString(int rowIndex) {

            Object_NowWorkJob bean = beans.get(rowIndex);

            Timestamp timestamp_now = new Timestamp(System.currentTimeMillis()) ;
            Timestamp timestamp_old = bean.getJ_Start();
            float i = ((timestamp_now.getTime() - timestamp_old.getTime())/1000)+ bean.getJ_WorkingTime();
            float percents = (i / (bean.getJ_Average() * 3600)) * 100;

            String work_total = Seconds_TO_HMS.toString((int)i);

            String kinds = (bean.getJ_NumOfKind() > 0
                            ? ("<b>Количество видов : </b>"
                               + bean.getJ_NumOfKind() + "<br>"
                               + " <b>Виды :</b><br>"
                               + bean.getJ_Kinds().replaceAll(";", ";<br>"))
                            : "");

            String str = "<html>"
                    + "<b>ТЗ №</b> "
                    + bean.getJ_NumIdx() + " "
                    + "<b>Дизайнер :</b> "
                    + bean.getJ_Designer() + "<br>"
                    + " <b>Заказчик :</b> "
                    + bean.getJ_Customer() + "<br>"
                    + " <b>ТМ :</b> "
                    + bean.getJ_TM() + "<br>"
                    + kinds + "<br>"
                    + " <b>Текущее состояние :</b> "
                    + bean.getJ_StageName()
                    + " <b>начато :</b> "
                    + bean.getJ_StartString() + "<br>"
                    + " <b>Среднее нормативное время выполнения :</b> "
                    + bean.getJ_Average()+ ":00:00 <br>"
                    + " <b>Уже было отработано (часов:минут:секунд) :</b> "
                    + work_total + "<br>"
                    + "<b>Это составляет</b> "
                    + percents + "%"
                    + "</html>";

            return str;
        }


        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }

        public void setValueAt(Object value, int rowIndex, int columnIndex) {

        }




}
