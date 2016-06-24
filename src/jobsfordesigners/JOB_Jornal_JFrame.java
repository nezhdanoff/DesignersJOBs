/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import static jobsfordesigners.JobsForDesigners.BASE;
import static jobsfordesigners.JobsForDesigners.PASSWORD;
import static jobsfordesigners.JobsForDesigners.SERVER;
import static jobsfordesigners.JobsForDesigners.USER;
import static jobsfordesigners.JobsForDesigners.User;

/**
 *
 * @author Nezhdanoff
 */
public class JOB_Jornal_JFrame extends javax.swing.JFrame {

     final static DefaultListModel KDO_Model = new DefaultListModel();
     final static DefaultListModel Customer_List_Model = new DefaultListModel();
     final static DefaultComboBoxModel Manager_CB_Model = new DefaultComboBoxModel();
    /**
     * Creates new form JOB_Jornal_JFrame
     */
    JOB_Jornal_JFrame() {

        initComponents();

        KDO_Model.clear();
        Customer_List_Model.clear();
        Manager_CB_Model.removeAllElements();

//        JL_KindList.setModel(KDO_Model);
        LB_FIO_Redactor.setText(User.getEmp_Surname() + " " + User.getEmp_Name());
 //       DefaultComboBoxModel Manager_CB_Model = new DefaultComboBoxModel();

        // подключаемся к базе и вытаскиваем из нее данные
        // Заполняем ComboBox Менеджеры
        String Query = "SELECT "
                + "employers.ID AS emp_ID, "
                + "CONCAT_WS(' ', employers.surname , employers.name) AS emp_Name "
                + "FROM employers "
                + "WHERE employers.department_ID = 2 "
                + "ORDER BY employers.surname, employers.name";

        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            while (rs.next()) {
                // СОЗДАЕМ ОБЪЕКТ НА ОСНОВЕ ПОЛУЧЕННЫХ ДАННЫХ
                ComboBoxDataObject CB_Object = new ComboBoxDataObject(
                        rs.getInt("emp_ID"),
                        rs.getString("emp_Name"));
                // ДОБАВЛЯЕМ ЭТОТ ОБЪЕКТ В МОДЕЛЬ
                Manager_CB_Model.addElement(CB_Object);
            }
            // ВСТАВЛЯЕМ ДАННЫЕ МОДЕЛИ В ComboBox
            CB_Manager.setModel(Manager_CB_Model);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        CB_Manager.setSelectedIndex(-1);
        //***********************************************************************
        fillDesignerComboBox();
        //***********************************************************************
        TF_Job_Number.setDocument(new PlainDocument() {
            String chars = "0123456789";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 5) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
         //***********************************************************************
        //***********************************************************************
        TF_Volume.setDocument(new PlainDocument() {
            String chars = "0123456789.,";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.contains(str)) {
                    if (getLength()< 6) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
         //***********************************************************************

         // Определяем Listener поискового текстового поля
        TF_Customer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

            JOB_Jornal_JFrame.Customer_List_Model.clear();
                // подключаемся к базе и вытаскиваем из нее данные
                // Заполняем ComboBox Менеджеры
                String Query = "CALL GetCustomerDataObjectByFilter('"
                        + TF_Customer.getText() + "')";
                ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                conn.init();
                ResultSet rs = conn.query(Query);
                try {
                    while (rs.next()) {
                        // СОЗДАЕМ ОБЪЕКТ НА ОСНОВЕ ПОЛУЧЕННЫХ ДАННЫХ
                        CustomerDataObject Customer_Object = new CustomerDataObject(
                                rs.getInt("cust_ID"),
                                rs.getString("cust_Alias"),
                                rs.getString("cust_Name"));
                        // ДОБАВЛЯЕМ ЭТОТ ОБЪЕКТ В МОДЕЛЬ
                        JOB_Jornal_JFrame.Customer_List_Model.addElement(Customer_Object);
                    }
                    JL_Customers.setModel(Customer_List_Model);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.close();
            }
        });

//        fillNotCheckedJobList();


// При инициализации первым получает фокус поле ТЗ№
        TF_Job_Number.grabFocus();

        //***********************************************************************
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TF_TM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TF_NameOfKind = new javax.swing.JTextField();
        TF_Volume = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JL_KindList = new javax.swing.JList<>();
        JB_AddKind = new javax.swing.JButton();
        CB_Unit = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        JB_AddKind1 = new javax.swing.JButton();
        JB_AddKind2 = new javax.swing.JButton();
        jLabel_Job_Number = new javax.swing.JLabel();
        TF_Job_Number = new javax.swing.JTextField();
        jLabel_Job_Number9 = new javax.swing.JLabel();
        TF_Job_Number1 = new javax.swing.JTextField();
        jLabel_Job_Number1 = new javax.swing.JLabel();
        CB_Manager = new javax.swing.JComboBox<>();
        LB_FIO_Redactor = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TF_Customer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JL_Customers = new javax.swing.JList<>();
        JB_AddJOB = new javax.swing.JButton();
        jClearButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel_Status = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_NotCheckedJobs = new javax.swing.JList<>();
        jButton_1Check_Save = new javax.swing.JButton();
        jButton_1Check_Cancel = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel_Job_Number2 = new javax.swing.JLabel();
        jComboBox_Status_Of_Choice = new javax.swing.JComboBox<>();
        jLabel_Job_Number3 = new javax.swing.JLabel();
        jComboBox_TypeOfWork = new javax.swing.JComboBox<>();
        jLabel_Job_Number4 = new javax.swing.JLabel();
        jComboBox_Difficulty = new javax.swing.JComboBox<>();
        jLabel_Job_Number5 = new javax.swing.JLabel();
        jLabel_Job_Number6 = new javax.swing.JLabel();
        jLabel_Max_Time = new javax.swing.JLabel();
        jLabel_Min_Time = new javax.swing.JLabel();
        CB_Designer = new javax.swing.JComboBox<>();
        jLabel_Job_Number7 = new javax.swing.JLabel();
        jButton_Clear_CB_Designer = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel_CheckJobInfo = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_NotAssignedJobs = new javax.swing.JList<>();
        CB_Designer_1 = new javax.swing.JComboBox<>();
        jButton_AssigneDesigner = new javax.swing.JButton();
        jButton_ClearAssigne = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TF_TM.setNextFocusableComponent(TF_NameOfKind);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Торговая Марка");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Название Вида");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Масса (Объем)");

        TF_NameOfKind.setNextFocusableComponent(TF_Volume);

        TF_Volume.setNextFocusableComponent(CB_Unit);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Виды; Масса (Объем)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        JL_KindList.setModel(KDO_Model);
        jScrollPane2.setViewportView(JL_KindList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );

        JB_AddKind.setMnemonic('+');
        JB_AddKind.setText("Добавить этот ВИД");
        JB_AddKind.setNextFocusableComponent(TF_NameOfKind);
        JB_AddKind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AddKindActionPerformed(evt);
            }
        });

        CB_Unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "кг.", "г.", "мг.", "л.", "мл." }));
        CB_Unit.setSelectedIndex(-1);
        CB_Unit.setToolTipText("");
        CB_Unit.setNextFocusableComponent(JB_AddKind);
        CB_Unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_UnitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ед.изм.");

        JB_AddKind1.setMnemonic('+');
        JB_AddKind1.setText("Исправить");
        JB_AddKind1.setNextFocusableComponent(TF_NameOfKind);
        JB_AddKind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AddKind1ActionPerformed(evt);
            }
        });

        JB_AddKind2.setMnemonic('+');
        JB_AddKind2.setText("Удалить");
        JB_AddKind2.setNextFocusableComponent(TF_NameOfKind);
        JB_AddKind2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AddKind2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JB_AddKind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JB_AddKind2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JB_AddKind1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TF_TM, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TF_NameOfKind, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TF_Volume, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel7)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_TM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_NameOfKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_Volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JB_AddKind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_AddKind1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_AddKind2)
                        .addContainerGap())))
        );

        jLabel_Job_Number.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Job_Number.setText("№ ТЗ");

        TF_Job_Number.setNextFocusableComponent(CB_Manager);
        TF_Job_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Job_NumberActionPerformed(evt);
            }
        });
        TF_Job_Number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TF_Job_NumberFocusLost(evt);
            }
        });

        jLabel_Job_Number9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Job_Number9.setText("/");

        TF_Job_Number1.setNextFocusableComponent(CB_Manager);
        TF_Job_Number1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Job_Number1ActionPerformed(evt);
            }
        });
        TF_Job_Number1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TF_Job_Number1FocusLost(evt);
            }
        });

        jLabel_Job_Number1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Job_Number1.setText("Менеджер");

        CB_Manager.setModel(Manager_CB_Model);
        CB_Manager.setNextFocusableComponent(TF_Customer);
        CB_Manager.setRenderer(new CB_DataRenderer("ВЫБЕРИТЕ МЕНЕДЖЕРА"));
        CB_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ManagerActionPerformed(evt);
            }
        });

        LB_FIO_Redactor.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        LB_FIO_Redactor.setForeground(new java.awt.Color(0, 0, 204));
        LB_FIO_Redactor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LB_FIO_Redactor.setText("User");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Фильтр");

        TF_Customer.setNextFocusableComponent(JL_Customers);

        JL_Customers.setModel(Customer_List_Model);
        JL_Customers.setNextFocusableComponent(TF_TM);
        JL_Customers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                JL_CustomersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(JL_Customers);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Customer)))
                .addGap(3, 3, 3))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        JB_AddJOB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JB_AddJOB.setText("<html><center>Внести<br>запись в<br>журнал</html>");
        JB_AddJOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AddJOBActionPerformed(evt);
            }
        });

        jClearButton1.setText("Очистить");
        jClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Выход");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_Status.setText("<html>Строка<br>статуса</html>");
        jLabel_Status.setMaximumSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setMinimumSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setPreferredSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setRequestFocusEnabled(false);
        jLabel_Status.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_Job_Number)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Job_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Job_Number9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Job_Number1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Job_Number1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(LB_FIO_Redactor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jClearButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_AddJOB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Job_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number)
                    .addComponent(jLabel_Job_Number9)
                    .addComponent(TF_Job_Number1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number1)
                    .addComponent(CB_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_FIO_Redactor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JB_AddJOB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ввод новых ТЗ", jPanel1);

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        jLabel4.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(268, 268, 268))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Задания для проверки"));

        jList_NotCheckedJobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_NotCheckedJobs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_NotCheckedJobsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList_NotCheckedJobs);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );

        jButton_1Check_Save.setText("Сохранить");
        jButton_1Check_Save.setEnabled(false);
        jButton_1Check_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1Check_SaveActionPerformed(evt);
            }
        });

        jButton_1Check_Cancel.setText("Отменить");
        jButton_1Check_Cancel.setEnabled(false);
        jButton_1Check_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1Check_CancelActionPerformed(evt);
            }
        });

        jButton5.setText("Выход");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Статусы"));

        jLabel_Job_Number2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Job_Number2.setText("Статус после проверки");

        jComboBox_Status_Of_Choice.setMaximumRowCount(5);
        jComboBox_Status_Of_Choice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "СДЕЛАЙТЕ ВЫБОР", "ОК", "Не соответствует требованиям", "Не хватает материалов, файлов" }));
        jComboBox_Status_Of_Choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Status_Of_ChoiceActionPerformed(evt);
            }
        });

        jLabel_Job_Number3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Job_Number3.setText("Вид работы");

        jComboBox_TypeOfWork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "СДЕЛАЙТЕ ВЫБОР", "Изменения", "Адаптация", "Отрисовка", "Разработка" }));
        jComboBox_TypeOfWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TypeOfWorkActionPerformed(evt);
            }
        });

        jLabel_Job_Number4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number4.setText("Сложность");

        jComboBox_Difficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "СДЕЛАЙТЕ ВЫБОР", "Очень низкая", "Низкая", "Средняя", "Высокая", "Очень высокая" }));
        jComboBox_Difficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DifficultyActionPerformed(evt);
            }
        });

        jLabel_Job_Number5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number5.setText("Время в часах минимум");

        jLabel_Job_Number6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number6.setText("Время в часах максимум");

        jLabel_Max_Time.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Max_Time.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_Max_Time.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Max_Time.setText("0");

        jLabel_Min_Time.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Min_Time.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_Min_Time.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Min_Time.setText("0");

        CB_Designer.setMaximumRowCount(12);
        CB_Designer.setMaximumSize(new java.awt.Dimension(266, 20));
        CB_Designer.setMinimumSize(new java.awt.Dimension(266, 20));
        CB_Designer.setPreferredSize(new java.awt.Dimension(266, 20));
        CB_Designer.setRenderer(new CB_DataRenderer("ВЫБЕРИТЕ ДИЗАЙНЕРА"));
        CB_Designer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_DesignerActionPerformed(evt);
            }
        });

        jLabel_Job_Number7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number7.setText("Дизайнер");

        jButton_Clear_CB_Designer.setText("<- Очистить");
        jButton_Clear_CB_Designer.setEnabled(false);
        jButton_Clear_CB_Designer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Clear_CB_DesignerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel_Job_Number2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_Status_Of_Choice, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Job_Number3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Job_Number4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Job_Number7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_Difficulty, 0, 167, Short.MAX_VALUE)
                                    .addComponent(jComboBox_TypeOfWork, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel_Job_Number5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Min_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel_Job_Number6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_Max_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(CB_Designer, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Clear_CB_Designer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Status_Of_Choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number2))
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_TypeOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number3)
                    .addComponent(jLabel_Job_Number5)
                    .addComponent(jLabel_Min_Time))
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Job_Number4)
                    .addComponent(jComboBox_Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number6)
                    .addComponent(jLabel_Max_Time))
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Designer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number7)
                    .addComponent(jButton_Clear_CB_Designer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Примечание"));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(801, 45));
        jPanel12.setRequestFocusEnabled(false);

        jLabel_CheckJobInfo.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel_CheckJobInfo.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_CheckJobInfo.setText("Выберите строку ТЗ в списке сверху...");
        jLabel_CheckJobInfo.setAlignmentX(1.0F);
        jLabel_CheckJobInfo.setAlignmentY(1.0F);
        jLabel_CheckJobInfo.setFocusable(false);
        jLabel_CheckJobInfo.setInheritsPopupMenu(false);
        jLabel_CheckJobInfo.setMaximumSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setMinimumSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setName(""); // NOI18N
        jLabel_CheckJobInfo.setPreferredSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setRequestFocusEnabled(false);
        jLabel_CheckJobInfo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_CheckJobInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel_CheckJobInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setText("Оповестить менеджера по E-Mail");
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_1Check_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_1Check_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton_1Check_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_1Check_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jTabbedPane1.addTab("Первая проверка", jPanel3);

        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4FocusGained(evt);
            }
        });

        jList_NotAssignedJobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList_NotAssignedJobs);

        CB_Designer_1.setRenderer(new CB_DataRenderer("ВЫБЕРИТЕ ДИЗАЙНЕРА"));
        CB_Designer_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Designer_1ActionPerformed(evt);
            }
        });

        jButton_AssigneDesigner.setText("Назначить");
        jButton_AssigneDesigner.setEnabled(false);
        jButton_AssigneDesigner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AssigneDesignerActionPerformed(evt);
            }
        });

        jButton_ClearAssigne.setText("Очистить");
        jButton_ClearAssigne.setEnabled(false);
        jButton_ClearAssigne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearAssigneActionPerformed(evt);
            }
        });

        jButton3.setText("Выход");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Оповестить менеджера по E-Mail");
        jCheckBox3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CB_Designer_1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_ClearAssigne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_AssigneDesigner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(CB_Designer_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jCheckBox3))
                    .addComponent(jButton_AssigneDesigner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ClearAssigne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Назначение Исполнителя", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        cleanFirstCheckTab();
        fillNotAssignedJobList();
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        doExit();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearButton1ActionPerformed
        clearTab_1();
    }//GEN-LAST:event_jClearButton1ActionPerformed

    private void JB_AddJOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AddJOBActionPerformed
        String CName = "";
        String output;
        String statusHTML;
        String query;
        String query2= "";
        int i = JL_Customers.getSelectedIndex();
        int cust_ID = 0;
        Object obj = JL_Customers.getModel().getElementAt(i);
        if (obj instanceof CustomerDataObject) {
            CustomerDataObject item = (CustomerDataObject) obj;
            cust_ID = item.getCust_ID();
            CName = item.getCust_Name();
        }
        output = "Заполнил: " + LB_FIO_Redactor.getText() + "\n";
        output = output + "ТЗ №: " + TF_Job_Number.getText() + "\n"
        + " Менеджер: "
        + ((ComboBoxDataObject) CB_Manager.getSelectedItem()).toString() + " (ID "
        + ((ComboBoxDataObject) CB_Manager.getSelectedItem()).getField1() + ");\n"
        + " Заказчик: "
        + CName + " ID(" + Integer.toString(cust_ID) + "); \n\t ТМ: " + TF_TM.getText() + ";\n";

        statusHTML = "<html><b>Запись внесена в базу:</b><i> ТЗ №: </i>" + TF_Job_Number.getText()
        + "<i> Менеджер: </i>"
        + ((ComboBoxDataObject) CB_Manager.getSelectedItem()).toString() + "<br>"
        + "<i>Заказчик: </i>"
        + CName + "; ТМ: " + TF_TM.getText();


        query = "INSERT INTO designers_jobs (Job_Number, Create_Date, ID_Manager, ID_Customer, Trade_Mark) "
        + "  VALUES ("
        + TF_Job_Number.getText() + ","
        + " NOW(), "
        + ((ComboBoxDataObject) CB_Manager.getSelectedItem()).getField1() + ", "
        + Integer.toString(cust_ID) + ", '"
        + TF_TM.getText()
        + "')";
        if (KDO_Model.getSize() > 0) {
            query2 = "INSERT INTO kind_of_job (Job_ID, kind, volume, unit)  VALUES ";

            for (int j = 0; j < KDO_Model.getSize(); j++) {
                output = output + "\t\t Вид № "
                + Integer.toString(j + 1) + " - "
                + ((KindDataObject) KDO_Model.getElementAt(j)).toString()
                + "\n";

                statusHTML = statusHTML + " Вид № "
                + Integer.toString(j + 1) + " - "
                + ((KindDataObject) KDO_Model.getElementAt(j)).toString()
                + "; ";

                query2 = query2 + "(-###-, '"
                + ((KindDataObject) KDO_Model.getElementAt(j)).getKind().trim() + "', ";
                if (((KindDataObject) KDO_Model.getElementAt(j)).getVolume() == 0) {
                    query2 = query2 + "NULL, ";
                } else {
                    query2 = query2 + ((KindDataObject) KDO_Model.getElementAt(j)).getVolume_toString().replace(",", ".").trim() + ", '";
                }
                if (((KindDataObject) KDO_Model.getElementAt(j)).getUnit() == null) {
                    query2 = query2 + "NULL) ";
                } else {
                    query2 = query2 + ((KindDataObject) KDO_Model.getElementAt(j)).getUnit().trim() + "')";
                }
                if (j < KDO_Model.getSize()-1) {
                    query2 = query2 + ", ";
                }
            }
        }
        if (JOptionPane.showConfirmDialog(null, output,
            "Внести информацию в базу?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        conn.updateTransactionOneToMany(query, query2, "-###-");
        conn.close();
        jLabel_Status.setText(statusHTML);
        }
        clearTab_1();
    }//GEN-LAST:event_JB_AddJOBActionPerformed

    private void JL_CustomersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_JL_CustomersValueChanged
        int i = JL_Customers.getSelectedIndex();
        Object obj = JL_Customers.getModel().getElementAt(i);
        if (obj instanceof CustomerDataObject) {
            CustomerDataObject item = (CustomerDataObject) obj;
//            JL_Cust_ID.setText(Integer.toString(item.getCust_ID()));
            TF_Customer.setText(item.getCust_Name());
        }
    }//GEN-LAST:event_JL_CustomersValueChanged

    private void CB_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ManagerActionPerformed
        //        DefaultListModel Customer_List_Model = new DefaultListModel();

        // подключаемся к базе и вытаскиваем из нее данные
        // Заполняем ComboBox Менеджеры
        int managerID = 0;
        if (CB_Manager.getSelectedIndex() >= 0) {
            managerID = ((ComboBoxDataObject) CB_Manager.getSelectedItem()).getField1();
            fillCustomerNameByManagerID(0);
            //            fillCustomerNameByManagerID(managerID);
        }
    }//GEN-LAST:event_CB_ManagerActionPerformed

    private void TF_Job_Number1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_Job_Number1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Job_Number1FocusLost

    private void TF_Job_Number1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Job_Number1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Job_Number1ActionPerformed

    private void TF_Job_NumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_Job_NumberFocusLost

        // подключаемся к базе и проверяем нет ли такого номера ТЗ
        if (TF_Job_Number.getText().length() > 0) {
            try {
                int jNum = Integer.parseInt(TF_Job_Number.getText().trim());
                String Query = "CALL JobNumberIsPresent(" + TF_Job_Number.getText().trim() + ")";
                ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                conn.init();
                ResultSet rs = conn.query(Query);
                try {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "В этом году ТЗ с таким номером уже есть!!!");
                        TF_Job_Number.grabFocus();
                        TF_Job_Number.selectAll();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.close();
            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Введите число в поле [№ ТЗ]");
                TF_Job_Number.grabFocus();
                TF_Job_Number.selectAll();
            }
        }
    }//GEN-LAST:event_TF_Job_NumberFocusLost

    private void TF_Job_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Job_NumberActionPerformed

    }//GEN-LAST:event_TF_Job_NumberActionPerformed

    private void JB_AddKind2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AddKind2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_AddKind2ActionPerformed

    private void JB_AddKind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AddKind1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_AddKind1ActionPerformed

    private void CB_UnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_UnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_UnitActionPerformed

    private void JB_AddKindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AddKindActionPerformed
        String K = TF_NameOfKind.getText().trim().toUpperCase();
        //        String FF = TF_Volume.getText().trim().replace(",", ".");
        try {
            float V = Float.parseFloat(TF_Volume.getText().trim().replace(",", "."));
            String U = CB_Unit.getSelectedItem().toString().trim();
            KindDataObject iKind = new KindDataObject(K, V, U);
            KDO_Model.addElement(iKind);
        } catch (Exception e) {
            KindDataObject iKind = new KindDataObject(K);
            KDO_Model.addElement(iKind);
        }
    }//GEN-LAST:event_JB_AddKindActionPerformed

    private void jComboBox_DifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DifficultyActionPerformed
        getMinMaxTime();
    }//GEN-LAST:event_jComboBox_DifficultyActionPerformed

    private void jComboBox_TypeOfWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TypeOfWorkActionPerformed
        getMinMaxTime();
    }//GEN-LAST:event_jComboBox_TypeOfWorkActionPerformed

    private void jComboBox_Status_Of_ChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Status_Of_ChoiceActionPerformed
        if (jComboBox_Status_Of_Choice.getSelectedIndex() == 1){
        jComboBox_TypeOfWork.setEnabled(true);
        jComboBox_Difficulty.setEnabled(true);
        CB_Designer.setEnabled(true);
        jTextArea1.setEnabled(false);
        } else {
        jComboBox_TypeOfWork.setEnabled(false);
        jComboBox_Difficulty.setEnabled(false);
        CB_Designer.setSelectedIndex(-1);
        CB_Designer.setEnabled(false);
        jTextArea1.setEnabled(true);
        jComboBox_TypeOfWork.setSelectedIndex(0);
        jComboBox_Difficulty.setSelectedIndex(0);

        }
    }//GEN-LAST:event_jComboBox_Status_Of_ChoiceActionPerformed

    private void jList_NotCheckedJobsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_NotCheckedJobsValueChanged
        int i = jList_NotCheckedJobs.getSelectedIndex();
        Object obj = jList_NotCheckedJobs.getModel().getElementAt(i);
        if (obj instanceof JobDataObject_Full) {
            JobDataObject_Full item = (JobDataObject_Full) obj;
//            JL_Cust_ID.setText(Integer.toString(item.getCust_ID()));
            jLabel_CheckJobInfo.setText(item.toStringHTML());
            jButton_1Check_Save.setEnabled(true);
            jButton_1Check_Cancel.setEnabled(true);
        }
    }//GEN-LAST:event_jList_NotCheckedJobsValueChanged

    private void jButton_1Check_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1Check_CancelActionPerformed
        cleanFirstCheckTab();
    }//GEN-LAST:event_jButton_1Check_CancelActionPerformed

    private void jButton_1Check_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1Check_SaveActionPerformed
        checkBeforeSaveFirstCheck();
        cleanFirstCheckTab();
    }//GEN-LAST:event_jButton_1Check_SaveActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        doExit();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton_Clear_CB_DesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Clear_CB_DesignerActionPerformed
        CB_Designer.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton_Clear_CB_DesignerActionPerformed

    private void CB_DesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_DesignerActionPerformed
        if (CB_Designer.getSelectedIndex() < 0) jButton_Clear_CB_Designer.setEnabled(false);
        else jButton_Clear_CB_Designer.setEnabled(true);
    }//GEN-LAST:event_CB_DesignerActionPerformed

    private void jPanel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4FocusGained
        fillNotAssignedJobList();
    }//GEN-LAST:event_jPanel4FocusGained

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained
        cleanFirstCheckTab();
    }//GEN-LAST:event_jPanel3FocusGained

    private void CB_Designer_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Designer_1ActionPerformed
        if (CB_Designer_1.getSelectedIndex() < 0) {
            jButton_AssigneDesigner.setEnabled(false);
            jButton_ClearAssigne.setEnabled(false);
        } else {
            jButton_AssigneDesigner.setEnabled(true);
            jButton_ClearAssigne.setEnabled(true);

        }
    }//GEN-LAST:event_CB_Designer_1ActionPerformed

    private void jButton_AssigneDesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AssigneDesignerActionPerformed
        checkBeforeSaveAssigneDesigner();
        cleanAssigneDesignerTab();
    }//GEN-LAST:event_jButton_AssigneDesignerActionPerformed

    private void jButton_ClearAssigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearAssigneActionPerformed
        cleanAssigneDesignerTab();
    }//GEN-LAST:event_jButton_ClearAssigneActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        doExit();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JOB_Jornal_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Designer;
    private javax.swing.JComboBox<String> CB_Designer_1;
    private javax.swing.JComboBox<String> CB_Manager;
    private javax.swing.JComboBox<String> CB_Unit;
    private javax.swing.JButton JB_AddJOB;
    private javax.swing.JButton JB_AddKind;
    private javax.swing.JButton JB_AddKind1;
    private javax.swing.JButton JB_AddKind2;
    private javax.swing.JList<String> JL_Customers;
    private javax.swing.JList<String> JL_KindList;
    private javax.swing.JLabel LB_FIO_Redactor;
    private javax.swing.JTextField TF_Customer;
    private javax.swing.JTextField TF_Job_Number;
    private javax.swing.JTextField TF_Job_Number1;
    private javax.swing.JTextField TF_NameOfKind;
    private javax.swing.JTextField TF_TM;
    private javax.swing.JTextField TF_Volume;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_1Check_Cancel;
    private javax.swing.JButton jButton_1Check_Save;
    private javax.swing.JButton jButton_AssigneDesigner;
    private javax.swing.JButton jButton_ClearAssigne;
    private javax.swing.JButton jButton_Clear_CB_Designer;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JButton jClearButton1;
    private javax.swing.JComboBox<String> jComboBox_Difficulty;
    private javax.swing.JComboBox<String> jComboBox_Status_Of_Choice;
    private javax.swing.JComboBox<String> jComboBox_TypeOfWork;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_CheckJobInfo;
    private javax.swing.JLabel jLabel_Job_Number;
    private javax.swing.JLabel jLabel_Job_Number1;
    private javax.swing.JLabel jLabel_Job_Number2;
    private javax.swing.JLabel jLabel_Job_Number3;
    private javax.swing.JLabel jLabel_Job_Number4;
    private javax.swing.JLabel jLabel_Job_Number5;
    private javax.swing.JLabel jLabel_Job_Number6;
    private javax.swing.JLabel jLabel_Job_Number7;
    private javax.swing.JLabel jLabel_Job_Number9;
    private javax.swing.JLabel jLabel_Max_Time;
    private javax.swing.JLabel jLabel_Min_Time;
    private javax.swing.JLabel jLabel_Status;
    private javax.swing.JList<String> jList_NotAssignedJobs;
    private javax.swing.JList<String> jList_NotCheckedJobs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void clearTab_1() {
        TF_Job_Number.setText("");
        CB_Manager.setSelectedIndex(-1);
        TF_Customer.setText("");
        TF_TM.setText("");
        TF_NameOfKind.setText("");
        TF_Volume.setText("");
        CB_Unit.setSelectedIndex(-1);
        JL_KindList.clearSelection();
        KDO_Model.removeAllElements();
//        KDO_Model.clear();
        JL_KindList.setModel(KDO_Model);
        JL_Customers.clearSelection();
        Customer_List_Model.removeAllElements();
        JL_Customers.setModel(Customer_List_Model);
        TF_Job_Number.grabFocus();
    }

    void fillCustomerNameByManagerID(int ID) {

        String Query = "CALL GetCustomerDataObjectsByManagerID(";
        Query = Query + Integer.toString(ID) + ")";
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            while (rs.next()) {
                // СОЗДАЕМ ОБЪЕКТ НА ОСНОВЕ ПОЛУЧЕННЫХ ДАННЫХ
                CustomerDataObject Customer_Object = new CustomerDataObject(
                        rs.getInt("cust_ID"),
                        rs.getString("cust_Alias"),
                        rs.getString("cust_Name"));
                // ДОБАВЛЯЕМ ЭТОТ ОБЪЕКТ В МОДЕЛЬ
                Customer_List_Model.addElement(Customer_Object);
            }
            JL_Customers.setModel(Customer_List_Model);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }

    void fillNotAssignedJobList() {

        String Query = "CALL GetNotAssignedJobs_split()";
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            DefaultListModel NotAssignedJob_ObjectModel = new DefaultListModel();
            while (rs.next()) {
                JobDataObject_Full jobDataObject = new JobDataObject_Full(
                        rs.getInt("job_ID"),
                        rs.getInt("job_Number"),
                        0,
                        new EmployerDataObject(rs.getInt("job_Manager_ID"),
                                rs.getString("job_Manager_Surname"),
                                rs.getString("job_Manager_Name"),
                                rs.getString("job_Manager_EMail")),
                        new CustomerDataObject(rs.getInt("job_Customer_ID"),
                                rs.getString("job_Customer_Alias"),
                                rs.getString("job_Customer_Name")),
                        rs.getString("job_TM"),
                        (rs.getString("job_KindString")==null ? "" : rs.getString("job_KindString")) );
               NotAssignedJob_ObjectModel.addElement(jobDataObject);
            }
            jList_NotAssignedJobs.setModel(NotAssignedJob_ObjectModel);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();

    }
    void fillJobListObjectsList() {

        String Query = "CALL GetNotCheckedJobs_split()";
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            DefaultListModel NotCheckedJob_ObjectModel = new DefaultListModel();
            while (rs.next()) {
                JobDataObject_Full jobDataObject = new JobDataObject_Full(
                        rs.getInt("job_ID"),
                        rs.getInt("job_Number"),
                        0,
                        new EmployerDataObject(rs.getInt("job_Manager_ID"),
                                rs.getString("job_Manager_Surname"),
                                rs.getString("job_Manager_Name"),
                                rs.getString("job_Manager_EMail")),
                        new CustomerDataObject(rs.getInt("job_Customer_ID"),
                                rs.getString("job_Customer_Alias"),
                                rs.getString("job_Customer_Name")),
                        rs.getString("job_TM"),
                        (rs.getString("job_KindString")==null ? "" : rs.getString("job_KindString")) );
               NotCheckedJob_ObjectModel.addElement(jobDataObject);
            }
            jList_NotCheckedJobs.setModel(NotCheckedJob_ObjectModel);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }
    void cleanFirstCheckTab() {
        jCheckBox1.setSelected(true);
        jButton_1Check_Save.setEnabled(false);
        jButton_1Check_Cancel.setEnabled(false);
        jComboBox_Status_Of_Choice.setSelectedIndex(0);
        jComboBox_TypeOfWork.setSelectedIndex(0);
        jComboBox_Difficulty.setSelectedIndex(0);
        jComboBox_TypeOfWork.setEnabled(false);
        jComboBox_Difficulty.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextArea1.setText("");
        jLabel_Min_Time.setText("0");
        jLabel_Max_Time.setText("0");
        fillJobListObjectsList();
        jLabel_CheckJobInfo.setText("Выберите строку ТЗ в списке сверху...");
    }

    void cleanAssigneDesignerTab() {
        jCheckBox3.setSelected(true);
        jButton_AssigneDesigner.setEnabled(false);
        jButton_ClearAssigne.setEnabled(false);
        CB_Designer_1.setSelectedIndex(-1);
        fillNotAssignedJobList();
    }


    void getMinMaxTime(){
        String Query = "CALL GetMinMaxTime("
                        + jComboBox_TypeOfWork.getSelectedIndex() + ", "
                        + jComboBox_Difficulty.getSelectedIndex() + ")";
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            DefaultListModel NotCheckedJob_ObjectModel = new DefaultListModel();
            if (rs.next()) {
                        jLabel_Min_Time.setText(Integer.toString(rs.getInt("min")));
                        jLabel_Max_Time.setText(Integer.toString(rs.getInt("max")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }

    void checkBeforeSaveFirstCheck() {
        int i = jList_NotCheckedJobs.getSelectedIndex();
        int status = jComboBox_Status_Of_Choice.getSelectedIndex();
        int type = jComboBox_TypeOfWork.getSelectedIndex();
        int difficulty = jComboBox_Difficulty.getSelectedIndex();
        int designer = CB_Designer.getSelectedIndex();
//        int designer = ((ComboBoxDataObject) CB_Designer.getSelectedItem()).getField1();
        //Проверяем, выбран ли ТЗ в списке
        if (i >= 0) {
            // Если выбран, проверяем выбран ли СТАТУС проверки
            if (status > 0) {
                //Получаем Объект ТЗ
                String query;
                String query1;
                Object obj = jList_NotCheckedJobs.getModel().getElementAt(i);
                if (obj instanceof JobDataObject_Full) {
                    JobDataObject_Full item = (JobDataObject_Full) obj;
                    query = "UPDATE designers_jobs "
                            + "SET Check_1 = NOW(), "
                            + "Check_1_Status_ID = "
                            + Integer.toString(status) ;
                    query1 = " WHERE ID = " + Integer.toString(item.getJob_ID());
                    // Если выбран СТАТУС, проверяем выбраны ли ТипРаботы и Сложность
                    if (type > 0 && difficulty > 0) {
                        query = query
                                + ", Type_Of_Work_ID = "
                                + Integer.toString(type) + ", "
                                + "Difficulty = "
                                + Integer.toString(difficulty);
                        if (designer >= 0){
                           query = query
                            + ", Designer_ID = "
                            + ((ComboBoxDataObject) CB_Designer.getSelectedItem()).getField1();
                        }
                    } else {
                        if (status == 1) {
                            JOptionPane.showMessageDialog(null, "Не выбран Тип работы и Сложность!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "SQL: \n" + query + "\n" + query1);
                    ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                    conn.init();
                    conn.updateQuery(query + query1);
                    conn.close();
                }
            } else  JOptionPane.showMessageDialog(null, "Не выбран Статус ТЗ после проверки!");
        } else  JOptionPane.showMessageDialog(null, "Не выбрано ТЗ из списка!");
    }

    void checkBeforeSaveAssigneDesigner() {

        int i = jList_NotAssignedJobs.getSelectedIndex();
        int designer = CB_Designer_1.getSelectedIndex();
        //Проверяем, выбран ли ТЗ в списке
        if (i >= 0) {
            // Если выбран, проверяем выбран ли Дизайнер
            if (designer > 0) {
                //Получаем Объект ТЗ
                Object obj = jList_NotAssignedJobs.getModel().getElementAt(i);
                if (obj instanceof JobDataObject_Full) {
                    JobDataObject_Full item = (JobDataObject_Full) obj;
                    assigneDesignerDB(((ComboBoxDataObject) CB_Designer_1.getSelectedItem()).getField1(),
                                      item.getJob_ID());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Не выбран Статус ТЗ после проверки!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Не выбрано ТЗ из списка!");
        }
    }


void fillDesignerComboBox(){
        // подключаемся к базе и вытаскиваем из нее данные
        // Заполняем ComboBox Менеджеры
        String Query = "SELECT "
                + "employers.ID AS emp_ID, "
                + "CONCAT_WS(' ', employers.surname , employers.name) AS emp_Name "
                + "FROM employers "
                + "WHERE employers.department_ID = 4 "
                + "ORDER BY employers.surname, employers.name";
        DefaultComboBoxModel Designer_CB_Model = new DefaultComboBoxModel();
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
            while (rs.next()) {
                // СОЗДАЕМ ОБЪЕКТ НА ОСНОВЕ ПОЛУЧЕННЫХ ДАННЫХ
                ComboBoxDataObject CB_Object = new ComboBoxDataObject(
                        rs.getInt("emp_ID"),
                        rs.getString("emp_Name"));
                // ДОБАВЛЯЕМ ЭТОТ ОБЪЕКТ В МОДЕЛЬ
                Designer_CB_Model.addElement(CB_Object);
            }
            // ВСТАВЛЯЕМ ДАННЫЕ МОДЕЛИ В ComboBox
            CB_Designer.setModel(Designer_CB_Model);
            CB_Designer_1.setModel(Designer_CB_Model);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        CB_Designer.setSelectedIndex(-1);
        CB_Designer_1.setSelectedIndex(-1);
}
    void doExit() {
        this.setVisible(false);
        JobsForDesigners.LoginWindow.setVisible(true);
//        System.exit(0);
    }

    void assigneDesignerDB(int Designer_ID, int Job_ID) {
        String query = "UPDATE designers_jobs SET Designer_ID = "
                + Designer_ID
                + " WHERE ID = " + Job_ID;
//        JOptionPane.showMessageDialog(null, "SQL: \n" + query);
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        conn.updateQuery(query);
        conn.close();
    }

}

