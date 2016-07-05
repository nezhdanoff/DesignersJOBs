/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

//     final static DefaultListModel Customer_List_Model = new DefaultListModel();
    /**
     * Creates new form JOB_Jornal_JFrame
     */
    JOB_Jornal_JFrame() {

        initComponents();

// ��������� ComboBox ������ �������
        jComboBox_Customer.setModel(getCustomerListModel(""));
//*****************************************************************************

// ������� FocusListener ��� ��������� � ComboBox
        jComboBox_Customer.getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                jComboBox_Customer.showPopup(); // ���������� ������
                jComboBox_Customer.getEditor().selectAll(); // �������� ���� ����� � ������ ��������������
            }
        });
//*****************************************************************************

// ������� Listener ����������, ����������� ���� ������ � ��������� ������ ��� ComboBox
        jComboBox_Customer.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {

                String inputString = jComboBox_Customer.getEditor().getItem().toString();

                /*
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if(comparar(cadenaEscrita)){// compara si el texto escrito se ecuentra en la lista
                // busca el texto escrito en la base de datos
                buscar(cadenaEscrita);
                }else{// en caso contrario toma como default el elemento 0 o sea el primero de la lista y lo busca.
                buscar(boxNombre.getItemAt(0).toString());
                boxNombre.setSelectedIndex(0);
                }
                }
                 */
                String str = "0123456789����������������������������������Ũ�����������������������"
                        + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-+*(){}[].,;:";
                int j = str.indexOf(evt.getKeyChar()); // ���������, ���� �� ��������� ������ � ������ str

                if (evt.getKeyCode() >= 48 && evt.getKeyCode() <= 57
                        || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 107
                        || evt.getKeyCode() >= 109 && evt.getKeyCode() <= 111
                        || evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90
                        || evt.getKeyCode() == 191
                        || evt.getKeyCode() == 8
                        || j >0) {

                    jComboBox_Customer.setModel(getCustomerListModel(inputString));
                    if (jComboBox_Customer.getItemCount() > 0) {
                        jComboBox_Customer.getEditor().setItem(inputString);
                        jComboBox_Customer.showPopup();
                    } else {
//                        jComboBox_Employer.addItem(cadenaEscrita);
                    }
                }
            }
        });
//*****************************************************************************




        LB_FIO_Redactor.setText(User.getEmp_Surname() + " " + User.getEmp_Name());

        DefaultListModel KDO_Model = new DefaultListModel();
        JL_KindList.setModel(KDO_Model);

        // ��������� ComboBox ���������
        fillManagerComboBox();
        //***********************************************************************
        fillDesignerComboBox();
        //***********************************************************************

        /*         // ���������� Listener ���������� ���������� ����
         * TF_Customer.addKeyListener(new KeyAdapter() {
         * @Override
         * public void keyReleased(KeyEvent e) {
         * DefaultListModel dlm = new DefaultListModel();
         * // ������������ � ���� � ����������� �� ��� ������
         * // ��������� ComboBox ���������
         * String Query = "CALL GetCustomerDataObjectByFilter('"
         * + TF_Customer.getText() + "')";
         * ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
         * conn.init();
         * ResultSet rs = conn.query(Query);
         * try {
         * while (rs.next()) {
         * // ������� ������ �� ������ ���������� ������
         * CustomerDataObject Customer_Object = new CustomerDataObject(
         * rs.getInt("cust_ID"),
         * rs.getString("cust_Alias"),
         * rs.getString("cust_Name"));
         * // ��������� ���� ������ � ������
         * dlm.addElement(Customer_Object);
         * }
         * JL_Customers.setModel(dlm);
         * } catch (SQLException ex) {
         * Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
         * }
         * conn.close();
         * }
         * });*/
//        fillNotCheckedJobList();


// ��� ������������� ������ �������� ����� ���� �ǹ
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

        jTabbed_Pan1 = new javax.swing.JTabbedPane();
        jPanel_NewJob = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_TM = new javax.swing.JLabel();
        TF_TM = new javax.swing.JTextField();
        jLabel_NameOfKind = new javax.swing.JLabel();
        TF_NameOfKind = new javax.swing.JTextField();
        jLabel_Volume = new javax.swing.JLabel();
        TF_Volume = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JL_KindList = new javax.swing.JList<>();
        CB_Unit = new javax.swing.JComboBox<>();
        jLabel_Unit = new javax.swing.JLabel();
        JB_AddKind = new javax.swing.JButton();
        jButton__DeleteKind = new javax.swing.JButton();
        jComboBox_Customer = new javax.swing.JComboBox<>();
        jButton_ADD_Customer = new javax.swing.JButton();
        jLabel_Job_Number = new javax.swing.JLabel();
        TF_Job_Number = new javax.swing.JTextField();
        jLabel_Job_Number9 = new javax.swing.JLabel();
        TF_Job_Number_Index = new javax.swing.JTextField();
        jLabel_Job_Number1 = new javax.swing.JLabel();
        CB_Manager = new javax.swing.JComboBox<>();
        LB_FIO_Redactor = new javax.swing.JLabel();
        jPanel_FirstCheck = new javax.swing.JPanel();
        jPanel_Status = new javax.swing.JPanel();
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
        jPanel_Note = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel_InfoTab2 = new javax.swing.JPanel();
        jLabel_CheckJobInfo = new javax.swing.JLabel();
        jPanel_JobList = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_NotCheckedJobs = new javax.swing.JList<>();
        jPanel_AssigneDesigner = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_NotAssignedJobs = new javax.swing.JList<>();
        jLabel_Status = new javax.swing.JLabel();
        jButton_OK = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jCheckBox_Send_Mail = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(870, 575));
        setMinimumSize(new java.awt.Dimension(870, 575));
        setPreferredSize(new java.awt.Dimension(870, 575));
        setResizable(false);

        jTabbed_Pan1.setMaximumSize(new java.awt.Dimension(32767, 464));
        jTabbed_Pan1.setMinimumSize(new java.awt.Dimension(145, 464));
        jTabbed_Pan1.setPreferredSize(new java.awt.Dimension(902, 464));
        jTabbed_Pan1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbed_Pan1StateChanged(evt);
            }
        });
        jTabbed_Pan1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbed_Pan1FocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_TM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_TM.setText("�������� �����");
        jLabel_TM.setFocusable(false);

        TF_TM.setNextFocusableComponent(TF_NameOfKind);

        jLabel_NameOfKind.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_NameOfKind.setText("�������� ����");
        jLabel_NameOfKind.setFocusable(false);

        TF_NameOfKind.setNextFocusableComponent(TF_Volume);

        jLabel_Volume.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Volume.setText("����� (�����)");
        jLabel_Volume.setFocusable(false);

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
        TF_Volume.setNextFocusableComponent(CB_Unit);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "����; ����� (�����)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        JL_KindList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JL_KindList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                JL_KindListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(JL_KindList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2)
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        CB_Unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "��.", "�.", "��.", "�.", "��." }));
        CB_Unit.setSelectedIndex(-1);
        CB_Unit.setToolTipText("");
        CB_Unit.setNextFocusableComponent(JB_AddKind);
        CB_Unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_UnitActionPerformed(evt);
            }
        });
        CB_Unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CB_UnitFocusGained(evt);
            }
        });

        jLabel_Unit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Unit.setText("��.���.");
        jLabel_Unit.setFocusable(false);

        JB_AddKind.setMnemonic('+');
        JB_AddKind.setText("�������� ���� ���");
        JB_AddKind.setNextFocusableComponent(TF_NameOfKind);
        JB_AddKind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AddKindActionPerformed(evt);
            }
        });

        jButton__DeleteKind.setMnemonic('+');
        jButton__DeleteKind.setText("�������");
        jButton__DeleteKind.setEnabled(false);
        jButton__DeleteKind.setNextFocusableComponent(TF_NameOfKind);
        jButton__DeleteKind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton__DeleteKindActionPerformed(evt);
            }
        });

        jComboBox_Customer.setEditable(true);
        jComboBox_Customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "���", "�����������", "��������", "������" }));
        jComboBox_Customer.setSelectedIndex(-1);
        jComboBox_Customer.setRenderer(new CB_DataRenderer("�������� ��������"));
        jComboBox_Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CustomerActionPerformed(evt);
            }
        });

        jButton_ADD_Customer.setText("+");
        jButton_ADD_Customer.setFocusable(false);
        jButton_ADD_Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ADD_CustomerActionPerformed(evt);
            }
        });

        jLabel_Job_Number.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Job_Number.setText("� ��");
        jLabel_Job_Number.setFocusable(false);

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
        TF_Job_Number.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TF_Job_Number.setNextFocusableComponent(TF_Job_Number_Index);
        TF_Job_Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Job_NumberActionPerformed(evt);
            }
        });
        TF_Job_Number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TF_Job_NumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TF_Job_NumberFocusLost(evt);
            }
        });

        jLabel_Job_Number9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Job_Number9.setText("/");
        jLabel_Job_Number9.setFocusable(false);

        TF_Job_Number_Index.setDocument(new PlainDocument() {
            String chars = "0123456789";

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (chars.indexOf(str) != -1) {
                    if (getLength()< 3) {
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
        TF_Job_Number_Index.setNextFocusableComponent(CB_Manager);
        TF_Job_Number_Index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Job_Number_IndexActionPerformed(evt);
            }
        });
        TF_Job_Number_Index.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TF_Job_Number_IndexFocusLost(evt);
            }
        });

        jLabel_Job_Number1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Job_Number1.setText("��������");
        jLabel_Job_Number1.setFocusable(false);

        CB_Manager.setRenderer(new CB_DataRenderer("�������� ���������"));
        CB_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ManagerActionPerformed(evt);
            }
        });
        CB_Manager.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CB_ManagerFocusGained(evt);
            }
        });

        LB_FIO_Redactor.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        LB_FIO_Redactor.setForeground(new java.awt.Color(0, 0, 204));
        LB_FIO_Redactor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LB_FIO_Redactor.setText("User");
        LB_FIO_Redactor.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_Volume, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_Volume, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(JB_AddKind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton__DeleteKind, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_NameOfKind)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TF_NameOfKind)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_Job_Number)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_Job_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Job_Number9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Job_Number_Index, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Job_Number1)
                        .addGap(18, 18, 18)
                        .addComponent(CB_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LB_FIO_Redactor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_TM)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox_Customer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_ADD_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TF_TM))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Job_Number)
                        .addComponent(TF_Job_Number_Index, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TF_Job_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Job_Number9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Job_Number1)
                        .addComponent(CB_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LB_FIO_Redactor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ADD_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_TM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_TM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_NameOfKind)
                .addGap(1, 1, 1)
                .addComponent(TF_NameOfKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JB_AddKind)
                    .addComponent(CB_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Unit)
                    .addComponent(TF_Volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Volume)
                    .addComponent(jButton__DeleteKind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CB_Manager, CB_Unit, JB_AddKind, LB_FIO_Redactor, TF_Job_Number, TF_Job_Number_Index, TF_NameOfKind, TF_TM, TF_Volume, jButton_ADD_Customer, jButton__DeleteKind, jComboBox_Customer, jLabel_Job_Number, jLabel_Job_Number1, jLabel_Job_Number9, jLabel_NameOfKind, jLabel_TM, jLabel_Unit, jLabel_Volume});

        javax.swing.GroupLayout jPanel_NewJobLayout = new javax.swing.GroupLayout(jPanel_NewJob);
        jPanel_NewJob.setLayout(jPanel_NewJobLayout);
        jPanel_NewJobLayout.setHorizontalGroup(
            jPanel_NewJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NewJobLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_NewJobLayout.setVerticalGroup(
            jPanel_NewJobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_NewJobLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbed_Pan1.addTab("���� ����� ��", jPanel_NewJob);

        jPanel_FirstCheck.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel_FirstCheckFocusGained(evt);
            }
        });

        jPanel_Status.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_Job_Number2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number2.setText("������ ");

        jComboBox_Status_Of_Choice.setMaximumRowCount(5);
        jComboBox_Status_Of_Choice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "�������� �����", "��", "�� ������������� �����������", "�� ������� ����������, ������" }));
        jComboBox_Status_Of_Choice.setEnabled(false);
        jComboBox_Status_Of_Choice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Status_Of_ChoiceActionPerformed(evt);
            }
        });

        jLabel_Job_Number3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel_Job_Number3.setText("��� ������");

        jComboBox_TypeOfWork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "�������� �����", "���������", "���������", "���������", "����������" }));
        jComboBox_TypeOfWork.setEnabled(false);
        jComboBox_TypeOfWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TypeOfWorkActionPerformed(evt);
            }
        });

        jLabel_Job_Number4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number4.setText("���������");

        jComboBox_Difficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "�������� �����", "����� ������", "������", "�������", "�������", "����� �������" }));
        jComboBox_Difficulty.setEnabled(false);
        jComboBox_Difficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DifficultyActionPerformed(evt);
            }
        });

        jLabel_Job_Number5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number5.setText("����� � ����� �������");

        jLabel_Job_Number6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number6.setText("����� � ����� ��������");

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
        CB_Designer.setRenderer(new CB_DataRenderer("�������� ���������"));
        CB_Designer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_DesignerActionPerformed(evt);
            }
        });

        jLabel_Job_Number7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Job_Number7.setText("��������");

        jButton_Clear_CB_Designer.setText("<- ��������");
        jButton_Clear_CB_Designer.setEnabled(false);
        jButton_Clear_CB_Designer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Clear_CB_DesignerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_StatusLayout = new javax.swing.GroupLayout(jPanel_Status);
        jPanel_Status.setLayout(jPanel_StatusLayout);
        jPanel_StatusLayout.setHorizontalGroup(
            jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel_Job_Number3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Job_Number4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Job_Number7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel_Job_Number2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_StatusLayout.createSequentialGroup()
                        .addComponent(jComboBox_Status_Of_Choice, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_StatusLayout.createSequentialGroup()
                        .addComponent(CB_Designer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Clear_CB_Designer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_StatusLayout.createSequentialGroup()
                        .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_Difficulty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_TypeOfWork, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                                .addComponent(jLabel_Job_Number6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_Max_Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                                .addComponent(jLabel_Job_Number5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_Min_Time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel_StatusLayout.setVerticalGroup(
            jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Status_Of_Choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_TypeOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number3)
                    .addComponent(jLabel_Job_Number5)
                    .addComponent(jLabel_Min_Time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Job_Number4)
                    .addComponent(jComboBox_Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number6)
                    .addComponent(jLabel_Max_Time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Designer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Job_Number7)
                    .addComponent(jButton_Clear_CB_Designer))
                .addContainerGap())
        );

        jPanel_Note.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "����������"));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel_NoteLayout = new javax.swing.GroupLayout(jPanel_Note);
        jPanel_Note.setLayout(jPanel_NoteLayout);
        jPanel_NoteLayout.setHorizontalGroup(
            jPanel_NoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NoteLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel_NoteLayout.setVerticalGroup(
            jPanel_NoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_NoteLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane5)
                .addGap(1, 1, 1))
        );

        jPanel_InfoTab2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel_InfoTab2.setMaximumSize(new java.awt.Dimension(801, 50));
        jPanel_InfoTab2.setMinimumSize(new java.awt.Dimension(801, 50));
        jPanel_InfoTab2.setName(""); // NOI18N
        jPanel_InfoTab2.setPreferredSize(new java.awt.Dimension(801, 50));
        jPanel_InfoTab2.setRequestFocusEnabled(false);

        jLabel_CheckJobInfo.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_CheckJobInfo.setText("�������� ������ ��  � ������ ������...");
        jLabel_CheckJobInfo.setAlignmentX(1.0F);
        jLabel_CheckJobInfo.setAlignmentY(1.0F);
        jLabel_CheckJobInfo.setFocusable(false);
        jLabel_CheckJobInfo.setMaximumSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setMinimumSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setName(""); // NOI18N
        jLabel_CheckJobInfo.setPreferredSize(new java.awt.Dimension(224, 35));
        jLabel_CheckJobInfo.setRequestFocusEnabled(false);
        jLabel_CheckJobInfo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel_InfoTab2Layout = new javax.swing.GroupLayout(jPanel_InfoTab2);
        jPanel_InfoTab2.setLayout(jPanel_InfoTab2Layout);
        jPanel_InfoTab2Layout.setHorizontalGroup(
            jPanel_InfoTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_CheckJobInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_InfoTab2Layout.setVerticalGroup(
            jPanel_InfoTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_CheckJobInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jPanel_JobList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "������� ��� ��������"));
        jPanel_JobList.setToolTipText("�������� ������ ��� ���������� ������");
        jPanel_JobList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_JobListMouseClicked(evt);
            }
        });

        jList_NotCheckedJobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_NotCheckedJobs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_NotCheckedJobsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList_NotCheckedJobs);

        javax.swing.GroupLayout jPanel_JobListLayout = new javax.swing.GroupLayout(jPanel_JobList);
        jPanel_JobList.setLayout(jPanel_JobListLayout);
        jPanel_JobListLayout.setHorizontalGroup(
            jPanel_JobListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_JobListLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3)
                .addGap(5, 5, 5))
        );
        jPanel_JobListLayout.setVerticalGroup(
            jPanel_JobListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_JobListLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel_FirstCheckLayout = new javax.swing.GroupLayout(jPanel_FirstCheck);
        jPanel_FirstCheck.setLayout(jPanel_FirstCheckLayout);
        jPanel_FirstCheckLayout.setHorizontalGroup(
            jPanel_FirstCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FirstCheckLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel_FirstCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_FirstCheckLayout.createSequentialGroup()
                        .addComponent(jPanel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_Note, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel_InfoTab2, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                    .addComponent(jPanel_JobList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel_FirstCheckLayout.setVerticalGroup(
            jPanel_FirstCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FirstCheckLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel_JobList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_InfoTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FirstCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Note, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbed_Pan1.addTab("�������� � ���������� �����������", jPanel_FirstCheck);

        jPanel_AssigneDesigner.setEnabled(false);
        jPanel_AssigneDesigner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel_AssigneDesignerFocusGained(evt);
            }
        });

        jList_NotAssignedJobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList_NotAssignedJobs);

        javax.swing.GroupLayout jPanel_AssigneDesignerLayout = new javax.swing.GroupLayout(jPanel_AssigneDesigner);
        jPanel_AssigneDesigner.setLayout(jPanel_AssigneDesignerLayout);
        jPanel_AssigneDesignerLayout.setHorizontalGroup(
            jPanel_AssigneDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AssigneDesignerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_AssigneDesignerLayout.setVerticalGroup(
            jPanel_AssigneDesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AssigneDesignerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbed_Pan1.addTab("��������", jPanel_AssigneDesigner);

        jLabel_Status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Status.setMaximumSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setMinimumSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setPreferredSize(new java.awt.Dimension(890, 35));
        jLabel_Status.setRequestFocusEnabled(false);
        jLabel_Status.setVerifyInputWhenFocusTarget(false);

        jButton_OK.setText("��");
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });

        jButton_Cancel.setText("������");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        jButton_Exit.setText("�����");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jCheckBox_Send_Mail.setSelected(true);
        jCheckBox_Send_Mail.setText("���������� �� E-Mail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbed_Pan1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox_Send_Mail))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbed_Pan1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_Send_Mail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_OK)
                            .addComponent(jButton_Cancel)
                            .addComponent(jButton_Exit)))
                    .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbed_Pan1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbed_Pan1FocusGained
        cleanFirstCheckTab();
        fillNotAssignedJobList();
    }//GEN-LAST:event_jTabbed_Pan1FocusGained

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

        if (i >= 0) { // ���� ������ ������� �� ������
            DefaultListModel dlm = (DefaultListModel) jList_NotCheckedJobs.getModel();
            JobDataObject_Full item = ((JobDataObject_Full) dlm.getElementAt(i));
            jLabel_CheckJobInfo.setText(item.toStringHTML());
            jComboBox_Status_Of_Choice.setEnabled(true);
            int status = item.getJob_StatusCheck().getStatus_ID();
            System.out.println("������ = " + status);

            // ���������� ������ � ����������� ��� � �������� �� �������� ��
            jComboBox_Status_Of_Choice.setEnabled(true);
            jComboBox_Status_Of_Choice.setSelectedIndex(status);

            if (status == 1) {
                // ���������� ��������� � ����������� ��� � �������� �� �������� ��
                int type_OfWork = item.getJob_TypeOfWork().getField1();
                System.out.println("��� = " + type_OfWork);
                if (type_OfWork > 0) {
                    jComboBox_TypeOfWork.setEnabled(true);
                    jComboBox_TypeOfWork.setSelectedIndex(type_OfWork);
                }
                // ���������� ��������� � ����������� ��� � �������� �� �������� ��
                int difficulty = item.getJob_Difficulty().getField1();
                System.out.println("��������� = " + difficulty);
                if (difficulty > 0) {
                    jComboBox_Difficulty.setEnabled(true);
                    jComboBox_Difficulty.setSelectedIndex(difficulty);
                }
                // ������������ ����������
                jTextArea1.setEditable(false);
                // ���������� � ���������� ����� ���������
                CB_Designer.setSelectedIndex(-1);
                CB_Designer.setEnabled(true);
            } else if (status > 1) {
                // ������������ ��� � ��������� ������, �������� ��������� ��� ����
                jComboBox_TypeOfWork.setEnabled(false);
                jComboBox_Difficulty.setEnabled(false);
                jComboBox_TypeOfWork.setSelectedIndex(0);
                jComboBox_Difficulty.setSelectedIndex(0);
                // ���������� ����������
                jTextArea1.setEditable(true);
                // ������������ � ���������� ����� ���������
                CB_Designer.setSelectedIndex(-1);
                CB_Designer.setEnabled(false);
            } else {
                // ������������ ��� � ��������� ������, �������� ��������� ��� ����
                jComboBox_TypeOfWork.setEnabled(false);
                jComboBox_Difficulty.setEnabled(false);
                jComboBox_TypeOfWork.setSelectedIndex(0);
                jComboBox_Difficulty.setSelectedIndex(0);
                // ������������ ����������
                jTextArea1.setEnabled(false);
                // ������������ � ���������� ����� ���������
                CB_Designer.setSelectedIndex(-1);
                CB_Designer.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jList_NotCheckedJobsValueChanged

    private void jButton_Clear_CB_DesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Clear_CB_DesignerActionPerformed
        CB_Designer.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton_Clear_CB_DesignerActionPerformed

    private void CB_DesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_DesignerActionPerformed
        if (CB_Designer.getSelectedIndex() < 0) jButton_Clear_CB_Designer.setEnabled(false);
        else jButton_Clear_CB_Designer.setEnabled(true);
    }//GEN-LAST:event_CB_DesignerActionPerformed

    private void jPanel_AssigneDesignerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel_AssigneDesignerFocusGained
        fillNotAssignedJobList();
    }//GEN-LAST:event_jPanel_AssigneDesignerFocusGained

    private void jPanel_FirstCheckFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel_FirstCheckFocusGained
        cleanFirstCheckTab();
    }//GEN-LAST:event_jPanel_FirstCheckFocusGained

    private void jButton_ADD_CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ADD_CustomerActionPerformed
        jFrame_ADD_Customer newADD_Customer = new jFrame_ADD_Customer();
        newADD_Customer.setVisible(true);
    }//GEN-LAST:event_jButton_ADD_CustomerActionPerformed

    private void jComboBox_CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CustomerActionPerformed
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel)jComboBox_Customer.getModel();
        int i = jComboBox_Customer.getSelectedIndex();
        TF_TM.setText(((CustomerDataObject)dcbm.getElementAt(i)).getCust_Name());
    }//GEN-LAST:event_jComboBox_CustomerActionPerformed

    private void CB_ManagerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CB_ManagerFocusGained
        CB_Manager.showPopup();
    }//GEN-LAST:event_CB_ManagerFocusGained

    private void CB_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ManagerActionPerformed

        int managerID = 0;
        if (CB_Manager.getSelectedIndex() >= 0) {
            managerID = ((UserDataObjectWithEmail) CB_Manager.getSelectedItem()).getField1();
//            fillCustomerNameByManagerID(0);
            //            fillCustomerNameByManagerID(managerID);
        }
    }//GEN-LAST:event_CB_ManagerActionPerformed

    private void TF_Job_Number_IndexFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_Job_Number_IndexFocusLost

        // ������������ � ���� � ��������� ��� �� ������ ������ ��
        if (TF_Job_Number.getText().length() > 0 ) {
            int jNum = Integer.parseInt(TF_Job_Number.getText());
            int jIndex = (TF_Job_Number_Index.getText().length()> 0) ? Integer.parseInt(TF_Job_Number_Index.getText()): 0;
            String Query = "CALL JobNumberIndexIsPresent("
            + jNum + ", "
            + jIndex + ")";
            ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
            conn.init();
            ResultSet rs = conn.query(Query);
            try {
                if (rs.next()) {
                    /*
                    * JOptionPane.showMessageDialog(null, "� ���� ���� �� �
                        * ����� ������� ��� ����!!!");
                        * TF_Job_Number.grabFocus();
                        * TF_Job_Number.selectAll();
                        */
                        TF_Job_Number_Index.setBackground(Color.red);
                        TF_Job_Number_Index.setForeground(Color.yellow);
                        TF_Job_Number.setBackground(Color.red);
                        TF_Job_Number.setForeground(Color.yellow);

                        /*
                        JOptionPane.showMessageDialog(null,
                        "� ���� ���� �� � �������: "
                        + jNum
                        + (jIndex == 0 ? "" : "/" + jIndex)
                        + "  ��� ����!!! "
                        );
                        */

                        TF_Job_Number.grabFocus();
                        TF_Job_Number.selectAll();
                    } else {
                        TF_Job_Number_Index.setBackground(Color.white);
                        TF_Job_Number_Index.setForeground(Color.black);
                        TF_Job_Number.setBackground(Color.white);
                        TF_Job_Number.setForeground(Color.black);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.close();

            }
    }//GEN-LAST:event_TF_Job_Number_IndexFocusLost

    private void TF_Job_Number_IndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Job_Number_IndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Job_Number_IndexActionPerformed

    private void TF_Job_NumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_Job_NumberFocusLost

        // ������������ � ���� � ��������� ��� �� ������ ������ ��
        if (TF_Job_Number.getText().length() > 0) {
            try {
                int jNum = Integer.parseInt(TF_Job_Number.getText().trim());
                String Query = "CALL JobNumberIsPresent(" + TF_Job_Number.getText().trim() + ")";
                ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                conn.init();
                ResultSet rs = conn.query(Query);
                try {
                    if (rs.next()) {
                        /*                        JOptionPane.showMessageDialog(null, "� ���� ���� �� � ����� ������� ��� ����!!!");
                        * TF_Job_Number.grabFocus();
                        * TF_Job_Number.selectAll();
                        */
                        TF_Job_Number.setBackground(Color.red);
                        TF_Job_Number.setForeground(Color.yellow);
                    } else {
                        TF_Job_Number.setBackground(Color.white);
                        TF_Job_Number.setForeground(Color.black);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.close();
            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "������� ����� � ���� [� ��]");
                TF_Job_Number.grabFocus();
                TF_Job_Number.selectAll();
            }
        }
    }//GEN-LAST:event_TF_Job_NumberFocusLost

    private void TF_Job_NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Job_NumberActionPerformed

    }//GEN-LAST:event_TF_Job_NumberActionPerformed

    private void jButton__DeleteKindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton__DeleteKindActionPerformed
        int i = JL_KindList.getSelectedIndex();
        if (i >= 0) {
            ((DefaultListModel)JL_KindList.getModel()).remove(i);
        }
        jButton__DeleteKind.setEnabled(false);
    }//GEN-LAST:event_jButton__DeleteKindActionPerformed

    private void CB_UnitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CB_UnitFocusGained
        CB_Unit.showPopup();
    }//GEN-LAST:event_CB_UnitFocusGained

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
            ((DefaultListModel)JL_KindList.getModel()).addElement(iKind);
        } catch (Exception e) {
            KindDataObject iKind = new KindDataObject(K);
            ((DefaultListModel)JL_KindList.getModel()).addElement(iKind);
        }
    }//GEN-LAST:event_JB_AddKindActionPerformed

    private void JL_KindListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_JL_KindListValueChanged
        if (JL_KindList.getSelectedIndex() >= 0) {
            jButton__DeleteKind.setEnabled(true);
        }
    }//GEN-LAST:event_JL_KindListValueChanged

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        doExit();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed

        int i = jTabbed_Pan1.getSelectedIndex();


        switch (i) {
            case 0:
                checkBeforeAddJob();
                break;
            case 1:
                checkBeforeSaveFirstCheck();
                cleanFirstCheckTab();
                break;
            case 2:
//                checkBeforeSaveAssigneDesigner();
                cleanAssigneDesignerTab();
                break;
            default:
                jLabel_Status.setText("OK");
                break;
}
    }//GEN-LAST:event_jButton_OKActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed

        int i = jTabbed_Pan1.getSelectedIndex();

        switch (i) {
            case 0:
                clearTab_1();
                break;
            case 1:
                cleanFirstCheckTab();
                break;
            case 2:
                cleanAssigneDesignerTab();
                break;
            default:
                jLabel_Status.setText("OK");
                break;
        }
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jTabbed_Pan1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbed_Pan1StateChanged
        switch (jTabbed_Pan1.getSelectedIndex()) {
            case 0:
                initTabNewJob();
                break;
            case 1:
                initTabCheck();
                break;
            case 2:
                break;
            default:
                break;
}
    }//GEN-LAST:event_jTabbed_Pan1StateChanged

    private void jPanel_JobListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_JobListMouseClicked
       fillJobListObjectsList();
    }//GEN-LAST:event_jPanel_JobListMouseClicked

    private void TF_Job_NumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TF_Job_NumberFocusGained
        TF_Job_Number_Index.setBackground(Color.white);
        TF_Job_Number_Index.setForeground(Color.black);
    }//GEN-LAST:event_TF_Job_NumberFocusGained

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
            @Override
            public void run() {
                new JOB_Jornal_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Designer;
    private javax.swing.JComboBox<String> CB_Manager;
    private javax.swing.JComboBox<String> CB_Unit;
    private javax.swing.JButton JB_AddKind;
    private javax.swing.JList<String> JL_KindList;
    private javax.swing.JLabel LB_FIO_Redactor;
    private javax.swing.JTextField TF_Job_Number;
    private javax.swing.JTextField TF_Job_Number_Index;
    private javax.swing.JTextField TF_NameOfKind;
    private javax.swing.JTextField TF_TM;
    private javax.swing.JTextField TF_Volume;
    private javax.swing.JButton jButton_ADD_Customer;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Clear_CB_Designer;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JButton jButton__DeleteKind;
    private javax.swing.JCheckBox jCheckBox_Send_Mail;
    private javax.swing.JComboBox<String> jComboBox_Customer;
    private javax.swing.JComboBox<String> jComboBox_Difficulty;
    private javax.swing.JComboBox<String> jComboBox_Status_Of_Choice;
    private javax.swing.JComboBox<String> jComboBox_TypeOfWork;
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
    private javax.swing.JLabel jLabel_NameOfKind;
    private javax.swing.JLabel jLabel_Status;
    private javax.swing.JLabel jLabel_TM;
    private javax.swing.JLabel jLabel_Unit;
    private javax.swing.JLabel jLabel_Volume;
    private javax.swing.JList<String> jList_NotAssignedJobs;
    private javax.swing.JList<String> jList_NotCheckedJobs;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_AssigneDesigner;
    private javax.swing.JPanel jPanel_FirstCheck;
    private javax.swing.JPanel jPanel_InfoTab2;
    private javax.swing.JPanel jPanel_JobList;
    private javax.swing.JPanel jPanel_NewJob;
    private javax.swing.JPanel jPanel_Note;
    private javax.swing.JPanel jPanel_Status;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbed_Pan1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void clearTab_1() {
        TF_Job_Number.setText("");
        TF_Job_Number.grabFocus();
        TF_TM.setText("");
        TF_NameOfKind.setText("");
        TF_Volume.setText("");
        TF_Job_Number.grabFocus();
        jComboBox_Customer.setModel(getCustomerListModel(""));
        CB_Manager.setSelectedIndex(-1);
        CB_Unit.setSelectedIndex(-1);
        CB_Manager.setSelectedIndex(-1);
        JL_KindList.setModel(new DefaultListModel());
        jCheckBox_Send_Mail.setSelected(true);
    }

    /*    void fillCustomerNameByManagerID(int ID) {
     *
     * DefaultListModel dlm = new DefaultListModel();
     * String Query = "CALL GetCustomerDataObjectsByManagerID(";
     * Query = Query + Integer.toString(ID) + ")";
     * ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
     * conn.init();
     * ResultSet rs = conn.query(Query);
     * try {
     * while (rs.next()) {
     * // ������� ������ �� ������ ���������� ������
     * CustomerDataObject Customer_Object = new CustomerDataObject(
     * rs.getInt("cust_ID"),
     * rs.getString("cust_Alias"),
     * rs.getString("cust_Name"));
     * // ��������� ���� ������ � ������
     * dlm.addElement(Customer_Object);
     * }
     * JL_Customers.setModel(dlm);
     * } catch (SQLException ex) {
     * Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * conn.close();
     * }*/
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
                        rs.getInt("job_Number_Index"),
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
                        rs.getInt("job_Number_Index"),
                        new EmployerDataObject(rs.getInt("job_Manager_ID"),
                                rs.getString("job_Manager_Surname"),
                                rs.getString("job_Manager_Name"),
                                rs.getString("job_Manager_EMail")),
                        new CustomerDataObject(rs.getInt("job_Customer_ID"),
                                rs.getString("job_Customer_Alias"),
                                rs.getString("job_Customer_Name")),
                        rs.getString("job_TM"),
                        (rs.getString("job_KindString")==null ? "" : rs.getString("job_KindString")),
                        new StatusCheckDataObject(rs.getInt("job_StatusID"),
                                rs.getString("job_Status")),
                        new ComboBoxDataObject(rs.getInt("job_TypeOfWork_ID"),
                                rs.getString("job_TypeOfWork_Type")),
                        new ComboBoxDataObject(rs.getInt("job_Difficulty_ID"),
                                rs.getString("job_Difficulty_Tupe"))
                );
               NotCheckedJob_ObjectModel.addElement(jobDataObject);


            }
            jList_NotCheckedJobs.setModel(NotCheckedJob_ObjectModel);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }
    void cleanFirstCheckTab() {
        jCheckBox_Send_Mail.setSelected(true);
//        jButton_OK.setEnabled(false);
//        jButton_Cancel.setEnabled(false);
        jComboBox_Status_Of_Choice.setSelectedIndex(0);
        jComboBox_TypeOfWork.setSelectedIndex(0);
        jComboBox_Difficulty.setSelectedIndex(0);
        jComboBox_Status_Of_Choice.setEnabled(false);
        jComboBox_TypeOfWork.setEnabled(false);
        jComboBox_Difficulty.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextArea1.setText("");
        jLabel_Min_Time.setText("0");
        jLabel_Max_Time.setText("0");
        fillJobListObjectsList();
        jLabel_CheckJobInfo.setText("�������� ������ �� � ������ ������...");
    }

    void cleanAssigneDesignerTab() {
        jCheckBox_Send_Mail.setSelected(true);
//        jButton_OK.setEnabled(false);
//        jButton_ClearAssigne.setEnabled(false);
//        CB_Designer_1.setSelectedIndex(-1);
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

    void checkBeforeAddJob(){

        String output;
        String statusHTML;
        String query;
        String query2 = "";
        String rcpt1 = "nezhdanoff@itak.ua";
        String rcpt;
        String subj;
        String body;

        // ��������, ������ �� ��������...
        if (CB_Manager.getSelectedIndex() >=0){
        rcpt = ((UserDataObjectWithEmail) CB_Manager.getSelectedItem()).getEmp_EMail();
        } else {
            JOptionPane.showMessageDialog(null, "�� ������ ��������");
            CB_Manager.grabFocus();
            return;
        }


//        int i = JL_Customers.getSelectedIndex();
        int i = jComboBox_Customer.getSelectedIndex();

        DefaultComboBoxModel Manager_LM = (DefaultComboBoxModel) CB_Manager.getModel();
        DefaultComboBoxModel Cust_List_Model = (DefaultComboBoxModel) jComboBox_Customer.getModel();
        DefaultListModel KDO_Model = ((DefaultListModel) JL_KindList.getModel());


        if (i >= 0) {


            String CName = ((CustomerDataObject) Cust_List_Model.getElementAt(i)).getCust_Name();
            String MName = Manager_LM.getSelectedItem().toString();
            String TM = TF_TM.getText();

            int cust_ID = ((CustomerDataObject)Cust_List_Model.getElementAt(i)).getCust_ID();
            int Job_NUM = Integer.parseInt(TF_Job_Number.getText());
            int Job_NUM_INDEX = TF_Job_Number_Index.getText().length()>0 ? Integer.parseInt(TF_Job_Number_Index.getText()): 0;
            int Manager_ID = ((UserDataObjectWithEmail) CB_Manager.getSelectedItem()).getField1();
            String JobNumIndexStr = (Job_NUM_INDEX==0) ? "" : "/" + Integer.toString(Job_NUM_INDEX);


            output =  "�� �: "
                    + Job_NUM
                    + JobNumIndexStr + "\n"
                    + "��������: "
                    + MName+ ";\n"
                    + "��������: "
                    + CName + "; \n��: " + TM + ";\n";
            subj = "�� �: "
                    + Job_NUM
                    + JobNumIndexStr + " ���������������� � ������� �������";

            statusHTML = "<html><b>������ ������� � ����:</b><bi> �� �: </bi>"
                    + Job_NUM + JobNumIndexStr + "; "
                    + "<bi>��������: </bi>"
                    + MName + ";<br>"
                    + "<bi>��������: </bi>"
                    + CName + "; <bi>��: </bi>" + TM;
// ���������� ���������� ����� ������� (�)
            int x = KDO_Model.getSize();
// ������� ��� ���������� � ����

            query = "INSERT INTO designers_jobs (Job_Number, Job_Number_Index, Create_Date, ID_Manager, ID_Customer, Trade_Mark, number_of_kinds) "
                    + "  VALUES ("
                    + Job_NUM + ","
                    + Job_NUM_INDEX + ","
                    + " NOW(), "
                    + Manager_ID + ", "
                    + cust_ID + ", '"
                    + TM + "', "
                    + (x <= 0 ? 1 : x)
                    + ")";

            if (x > 0) {
                query2 = "INSERT INTO kind_of_job (Job_ID, kind, volume, unit)  VALUES ";

                for (int j = 0; j < x; j++) {
                    output = output + "\t ��� � "
                            + Integer.toString(j + 1) + " - "
                            + ((KindDataObject) KDO_Model.getElementAt(j)).toString()
                            + ";\n";

                    statusHTML = statusHTML + " ��� � "
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
                    if (j < KDO_Model.getSize() - 1) {
                        query2 = query2 + ", ";
                    }
                }
                output = output + "\t\t\t��������: " + LB_FIO_Redactor.getText() + "\n";
            }
            if (JOptionPane.showConfirmDialog(null, output,
                                              "������ ���������� � ����?",
                                              JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                conn.init();
                conn.updateTransactionOneToMany(query, query2, "-###-");
                conn.close();
                jLabel_Status.setText(statusHTML);
                if (jCheckBox_Send_Mail.isSelected()) {
                    Mailer.sendMailTo(rcpt, subj, output);
                }
            } else
                return;
            clearTab_1();

        } else {
            JOptionPane.showMessageDialog(null, "�� ������ ��������");
            jComboBox_Customer.grabFocus();
        }
    }

    void checkBeforeSaveFirstCheck() {
        int i = jList_NotCheckedJobs.getSelectedIndex();
        int status = jComboBox_Status_Of_Choice.getSelectedIndex();
        int type = jComboBox_TypeOfWork.getSelectedIndex();
        int difficulty = jComboBox_Difficulty.getSelectedIndex();
        int designer = CB_Designer.getSelectedIndex();

        String rcpt1 = "nezhdanoff@itak.ua";
        String rcpt;
        String subj;
        String body = "";

//        int designer = ((ComboBoxDataObject) CB_Designer.getSelectedItem()).getField1();
        //���������, ������ �� �� � ������
        if (i >= 0) {
            // ���� ������, ��������� ������ �� ������ ��������
            DefaultListModel dlm = (DefaultListModel) jList_NotCheckedJobs.getModel();
            JobDataObject_Full item = ((JobDataObject_Full) dlm.getElementAt(i));
            rcpt = item.getJob_Manager().getEmp_EMail();
//            rcpt = rcpt1;

            if (status > 0) {
                //�������� ������ ��
                String query;
                String query1;
                int Job_NUM_INDEX = item.getJob_NumberIndex();
                String JobNumIndexStr = (Job_NUM_INDEX==0) ? "" : "/" + Integer.toString(Job_NUM_INDEX);


                query = "UPDATE designers_jobs "
                        + "SET Check_1 = NOW(), "
                        + "Check_1_Status_ID = "
                        + status ;
                query1 = " WHERE ID = " + item.getJob_ID();
                // ���� ������ ������, ��������� ������� �� ��������� � ���������

                    subj = "�� � "
                            + item.getJob_Number()
                            + JobNumIndexStr
                            + " ���������, �������� ������: "
                            + jComboBox_Status_Of_Choice.getSelectedItem().toString();
                    body = "�� � "
                            + item.getJob_Number()
                            + JobNumIndexStr
                            + " ���������.\n�������� ������: "
                            + jComboBox_Status_Of_Choice.getSelectedItem().toString() + "\n";

                if (status >1) { // ���� ������ �������� ������� �� ��
                    subj = subj + " (����������� � ������ ������)";
                    if (jTextArea1.getText().length()>0){
                            body = body + "\n"
                            + jTextArea1.getText() + "\n\n";
                    } else {
                        body = body + "\n"
                                + "-=  ������������ ���  =- \n\n";
;
                    }

                }
                    if (type > 0 && difficulty > 0) {
                        query = query
                                + ", Type_Of_Work_ID = "
                                + type + ", "
                                + "Difficulty = "
                                + difficulty;

                                body = body + "���������� ��������� ������. \n"
                                        + "��� ���������:\t"
                                        + jComboBox_TypeOfWork.getSelectedItem().toString() + "\n"
                                        + "���������:\t"
                                        + jComboBox_Difficulty.getSelectedItem().toString() + "\n"
                                        + "��������������, ����������� �� "
                                        + jLabel_Min_Time.getText() + " �� "
                                        + jLabel_Max_Time.getText() + " ����� ������ ���������.\n"
                                        + "����� ������� ��� ����� �������� ��������� ������� ��!" + "\n";

                        if (designer >= 0){
                           query = query
                            + ", Designer_ID = "
                            + ((ComboBoxDataObject) CB_Designer.getSelectedItem()).getField1();

                           body = body + "����� ������� ��� ������ ��������� : "
                                        + CB_Designer.getSelectedItem().toString() + "\n";
                        }
                    } else {
                        if (status == 1) {
                            JOptionPane.showMessageDialog(null, "�� ������ ��� ������ � ���������!");
                            return;
                        }
                    }
                         body = body + "\n\t\t\t �������� - "
                                + LB_FIO_Redactor.getText();

//                    JOptionPane.showMessageDialog(null, "SQL: \n" + query + "\n" + query1);
                    ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
                    conn.init();
                    conn.updateQuery(query + query1);
                    conn.close();
                    if (jCheckBox_Send_Mail.isSelected()) {

                        Mailer.sendMailTo(rcpt, subj, body);
                    }

            } else  JOptionPane.showMessageDialog(null, "�� ������ ������ �� ����� ��������!");
        } else  JOptionPane.showMessageDialog(null, "�� ������� �� �� ������!");
    }

    /*    void checkBeforeSaveAssigneDesigner() {
     *
     * int i = jList_NotAssignedJobs.getSelectedIndex();
     * int designer = CB_Designer_1.getSelectedIndex();
     * //���������, ������ �� �� � ������
     * if (i >= 0) {
     * // ���� ������, ��������� ������ �� ��������
     * if (designer >= 0) {
     * //�������� ������ ��
     * DefaultListModel dlm = (DefaultListModel) jList_NotAssignedJobs.getModel();
     * JobDataObject_Full item = ((JobDataObject_Full) dlm.getElementAt(i));
     * int designer_ID = ((ComboBoxDataObject) CB_Designer_1.getSelectedItem()).getField1();
     * assigneDesignerDB(designer_ID, item.getJob_ID());
     * } else {
     * JOptionPane.showMessageDialog(null, "�� ������ ��������!");
     * }
     * } else {
     * JOptionPane.showMessageDialog(null, "�� ������� �� �� ������!");
     * }
     * }*/

    void fillManagerComboBox() {
        String Query = "CALL GetUserDataObject_by_Departament(2)";

        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            while (rs.next()) {
                // ������� ������ �� ������ ���������� ������
                UserDataObjectWithEmail CB_Object = new UserDataObjectWithEmail(rs.getInt("emp_ID"),
                        rs.getString("emp_Surname"),
                        rs.getString("emp_Name"),
                        rs.getString("emp_Mname"),
                        rs.getString("emp_EMail"),
                        rs.getInt("dep_ID"),
                        rs.getString("dep_Name"),
                        rs.getInt("pos_ID"),
                        rs.getString("pos_Name"));
                // ��������� ���� ������ � ������
                cbm.addElement(CB_Object);
            }
            // ��������� ������ ������ � ComboBox
            CB_Manager.setModel(cbm);
        } catch (SQLException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        CB_Manager.setSelectedIndex(-1);

    }

    void fillDesignerComboBox(){
      // ������������ � ���� � ����������� �� ��� ������
      // ��������� ComboBox ���������
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
      // ������� ������ �� ������ ���������� ������
      ComboBoxDataObject CB_Object = new ComboBoxDataObject(
      rs.getInt("emp_ID"),
      rs.getString("emp_Name"));
      // ��������� ���� ������ � ������
      Designer_CB_Model.addElement(CB_Object);
      }
      // ��������� ������ ������ � ComboBox
      CB_Designer.setModel(Designer_CB_Model);
//      CB_Designer_1.setModel(Designer_CB_Model);
      } catch (SQLException ex) {
      Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
      conn.close();
      CB_Designer.setSelectedIndex(-1);
//      CB_Designer_1.setSelectedIndex(-1);
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
    String getEmailByEmployerID(int ID){

        String Email = null;
         String Query = "SELECT employers.EMail AS EMail FROM employers WHERE employers.ID = "
         + ID ;
        ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
        conn.init();
        ResultSet rs = conn.query(Query);
        try {
             if (rs.next())  Email = rs.getString("EMail");
        } catch (SQLException ex) {
            Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
        return Email;
    }
public DefaultComboBoxModel getCustomerListModel(String str){

    String query = "CALL GetCustomerDataObjectByFilter('"
            + str
            + "')";

    DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    ConnectDB conn = new ConnectDB(SERVER, USER, PASSWORD, BASE);
    conn.init();
    ResultSet rs = conn.query(query);


        try {
            while (rs.next()) {
                CustomerDataObject cdo = new CustomerDataObject(
                        rs.getInt("cust_ID"),
                        rs.getString("cust_Alias"),
                        rs.getString("cust_Name"));
                // ��������� ���� ������ � ������
                dcbm.addElement(cdo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JOB_Jornal_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    conn.close();
    return dcbm;
}
    void initTabNewJob(){
        clearTab_1();
    }

    void initTabCheck(){
        cleanFirstCheckTab();
    }

}

