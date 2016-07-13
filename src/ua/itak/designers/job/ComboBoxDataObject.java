/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

/**
 *
 * @author Ed
 */
public class ComboBoxDataObject {
        private int field1;
        private String field2;

        public int getField1()
        {
            return field1;
        }

        public void setField1(int field1)
        {
            this.field1 = field1;
        }

        public String getField2()
        {
            return field2;
        }

        public void setField2(String field2)
        {
            this.field2 = field2;
        }

        @Override
       public String toString()
        {
//            return " Код : " + Integer.toString(field1) + " - " + field2;
            return field2;
        }
        
        ComboBoxDataObject(int field1, String field2)
        {
            this.field1 = field1;
            this.field2 = field2;
        }
    }    

