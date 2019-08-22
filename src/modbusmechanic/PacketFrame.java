/* 
 * Copyright 2019 Matt Jamesson <scifidryer@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package modbusmechanic;

import com.intelligt.modbus.jlibmodbus.exception.*;
import com.intelligt.modbus.jlibmodbus.utils.DataUtils;
import com.intelligt.modbus.jlibmodbus.msg.base.*;
import com.intelligt.modbus.jlibmodbus.msg.response.*;
import javax.xml.bind.DatatypeConverter;
import javax.swing.*;
import jssc.SerialPortList;
/**
 *
 * @author Matt Jamesson
 */
public class PacketFrame extends javax.swing.JFrame {

    /**
     * Creates new form PacketFrame
     */
    public ModbusResponse lastResponse = null;
    public int lastResponseType = 0;
    public int lastFunctionCode = 0;
    public int mediumType = 0;
    public PacketFrame()
    {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PacketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PacketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PacketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PacketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        initComponents();
        functionSelector.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        typePanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tcpMsgButton = new javax.swing.JRadioButton();
        rtuMsgButton = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        serialPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comPortSelector = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        baudRateSelector = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        dataBitsField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        stopBitsField = new javax.swing.JTextField();
        serialPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        paritySelector = new javax.swing.JComboBox<>();
        serialMonitorButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        modbusPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        destHostField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        slaveNodeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel5 = new javax.swing.JPanel();
        functionCodeField = new javax.swing.JTextField();
        functionSelector = new javax.swing.JComboBox<>();
        modbusPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        registerField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        transactionField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        protoIdField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        messagePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        customMessageButton = new javax.swing.JRadioButton();
        readFloatButton = new javax.swing.JRadioButton();
        asciiReadButton = new javax.swing.JRadioButton();
        u16ReadButton = new javax.swing.JRadioButton();
        u32ReadButton = new javax.swing.JRadioButton();
        messagePanel2 = new javax.swing.JPanel();
        transmitPacketButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        interpPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        byteSwapCheckbox = new javax.swing.JCheckBox();
        wordSwapCheckbox = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        responsePanel = new javax.swing.JPanel();
        responseField = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        packetPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawTextBox = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modbus Mechanic");
        setPreferredSize(new java.awt.Dimension(751, 900));
        setSize(new java.awt.Dimension(751, 1000));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        typePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel11.setText("Type:");
        typePanel.add(jLabel11);

        buttonGroup2.add(tcpMsgButton);
        tcpMsgButton.setSelected(true);
        tcpMsgButton.setText("TCP");
        tcpMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpMsgButtonActionPerformed(evt);
            }
        });
        typePanel.add(tcpMsgButton);

        buttonGroup2.add(rtuMsgButton);
        rtuMsgButton.setText("RTU");
        rtuMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtuMsgButtonActionPerformed(evt);
            }
        });
        typePanel.add(rtuMsgButton);

        getContentPane().add(typePanel);
        getContentPane().add(jSeparator1);

        jLabel14.setText("Serial settings");
        serialPanel.add(jLabel14);

        jLabel12.setText("Port");
        serialPanel.add(jLabel12);

        comPortSelector.setModel(new DefaultComboBoxModel(SerialPortList.getPortNames()));
        serialPanel.add(comPortSelector);

        jLabel13.setText("Baud");
        serialPanel.add(jLabel13);

        baudRateSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4800", "9600", "14400", "19200", "38400", "57600" }));
        serialPanel.add(baudRateSelector);

        jLabel15.setText("Data bits");
        serialPanel.add(jLabel15);

        dataBitsField.setColumns(2);
        dataBitsField.setText("8");
        serialPanel.add(dataBitsField);

        jLabel16.setText("Stop bits");
        serialPanel.add(jLabel16);

        stopBitsField.setColumns(2);
        stopBitsField.setText("1");
        serialPanel.add(stopBitsField);

        getContentPane().add(serialPanel);

        jLabel17.setText("Parity");
        serialPanel2.add(jLabel17);

        paritySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Odd", "Even", "Mark", "Space" }));
        paritySelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paritySelectorActionPerformed(evt);
            }
        });
        serialPanel2.add(paritySelector);

        serialMonitorButton.setText("Launch RTU Serial Monitor");
        serialMonitorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialMonitorButtonActionPerformed(evt);
            }
        });
        serialPanel2.add(serialMonitorButton);

        getContentPane().add(serialPanel2);
        getContentPane().add(jSeparator2);

        jLabel1.setText("IP");
        modbusPanel.add(jLabel1);

        destHostField.setColumns(12);
        destHostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destHostFieldActionPerformed(evt);
            }
        });
        modbusPanel.add(destHostField);

        jLabel2.setText("Slave Node");
        modbusPanel.add(jLabel2);

        slaveNodeField.setColumns(3);
        modbusPanel.add(slaveNodeField);

        jLabel5.setText("Function");
        modbusPanel.add(jLabel5);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(250, 30));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        functionCodeField.setColumns(3);
        functionCodeField.setPreferredSize(new java.awt.Dimension(6, 26));
        jPanel5.add(functionCodeField);

        jLayeredPane1.add(jPanel5, "card4");

        functionSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Read Holding Registers (0x03)", "Read Input Registers (0x04)" }));
        functionSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionSelectorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(functionSelector, "card2");

        modbusPanel.add(jLayeredPane1);

        getContentPane().add(modbusPanel);

        modbusPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setText("Register");
        modbusPanel2.add(jLabel6);

        registerField.setColumns(4);
        modbusPanel2.add(registerField);

        jLabel3.setText("Transaction");
        modbusPanel2.add(jLabel3);

        transactionField.setColumns(5);
        transactionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionFieldActionPerformed(evt);
            }
        });
        modbusPanel2.add(transactionField);

        jLabel4.setText("Protocol ID");
        modbusPanel2.add(jLabel4);

        protoIdField.setColumns(5);
        modbusPanel2.add(protoIdField);

        jLabel7.setText("Quantity");
        modbusPanel2.add(jLabel7);

        quantityField.setColumns(2);
        modbusPanel2.add(quantityField);

        getContentPane().add(modbusPanel2);
        getContentPane().add(jSeparator3);

        jLabel8.setText("Meassage type");
        messagePanel.add(jLabel8);

        buttonGroup1.add(customMessageButton);
        customMessageButton.setSelected(true);
        customMessageButton.setText("Custom");
        customMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customMessageButtonActionPerformed(evt);
            }
        });
        messagePanel.add(customMessageButton);

        buttonGroup1.add(readFloatButton);
        readFloatButton.setText("Read Float");
        readFloatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFloatButtonActionPerformed(evt);
            }
        });
        messagePanel.add(readFloatButton);

        buttonGroup1.add(asciiReadButton);
        asciiReadButton.setText("Read ASCII");
        asciiReadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asciiReadButtonActionPerformed(evt);
            }
        });
        messagePanel.add(asciiReadButton);

        buttonGroup1.add(u16ReadButton);
        u16ReadButton.setText("Read U16");
        u16ReadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u16ReadButtonActionPerformed(evt);
            }
        });
        messagePanel.add(u16ReadButton);

        buttonGroup1.add(u32ReadButton);
        u32ReadButton.setText("Read U32");
        u32ReadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u32ReadButtonActionPerformed(evt);
            }
        });
        messagePanel.add(u32ReadButton);

        getContentPane().add(messagePanel);

        transmitPacketButton.setText("Transmit packet");
        transmitPacketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmitPacketButtonActionPerformed(evt);
            }
        });
        messagePanel2.add(transmitPacketButton);

        getContentPane().add(messagePanel2);
        getContentPane().add(jSeparator4);

        interpPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel9.setText("Interpretation options");
        interpPanel.add(jLabel9);

        byteSwapCheckbox.setText("Byte Swap");
        byteSwapCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byteSwapCheckboxActionPerformed(evt);
            }
        });
        interpPanel.add(byteSwapCheckbox);

        wordSwapCheckbox.setText("Word Swap");
        wordSwapCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordSwapCheckboxActionPerformed(evt);
            }
        });
        interpPanel.add(wordSwapCheckbox);

        getContentPane().add(interpPanel);
        getContentPane().add(jSeparator5);

        responsePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        responseField.setText("Response value: ");
        responsePanel.add(responseField);

        getContentPane().add(responsePanel);
        getContentPane().add(jSeparator6);

        jLabel10.setText("Raw packet:");
        packetPanel.add(jLabel10);

        rawTextBox.setColumns(20);
        rawTextBox.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        rawTextBox.setRows(5);
        jScrollPane1.setViewportView(rawTextBox);

        packetPanel.add(jScrollPane1);

        getContentPane().add(packetPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void destHostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destHostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destHostFieldActionPerformed

    private void transactionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionFieldActionPerformed

    private void transmitPacketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmitPacketButtonActionPerformed
        //todo no thread dispatched when this action is performed which causes the UI to freeze for a few seconds
        lastResponse = null;
        int slaveNode = Integer.parseInt(slaveNodeField.getText());
        int register = Integer.parseInt(registerField.getText());
        int functionCode = 0;
        int quantity = 0;
        int transactionId = 1;
        int protocolId = 0;
        if (customMessageButton.isSelected())
        {
            functionCode = Integer.parseInt(functionCodeField.getText());
            transactionId = Integer.parseInt(transactionField.getText());
            protocolId = Integer.parseInt(protoIdField.getText());
            quantity = Integer.parseInt(quantityField.getText());
        }
        
        if (!customMessageButton.isSelected())
        {
            if (functionSelector.getSelectedItem().equals("Read Holding Registers (0x03)"))
            {
                functionCode = ModbusMechanic.HOLDING_REGISTER_CODE;
            }
            else if (functionSelector.getSelectedItem().equals("Read Input Registers (0x04)"))
            {
                functionCode = ModbusMechanic.INPUT_REGISTER_CODE;
            }
        }
        lastFunctionCode = functionCode;
        quantity = Integer.parseInt(quantityField.getText());
        if (rtuMsgButton.isSelected())
        {
            try
            {
                //todo error check user's input here
                lastResponse = ModbusMechanic.generateModbusRTURequest(comPortSelector.getItemAt(comPortSelector.getSelectedIndex()), Integer.parseInt(baudRateSelector.getItemAt(baudRateSelector.getSelectedIndex())), Integer.parseInt(dataBitsField.getText()), Integer.parseInt(stopBitsField.getText()), paritySelector.getSelectedIndex(), slaveNode, functionCode, register, quantity);
            }
            catch (Exception e)
            {
                handleModbusException(e);
            }
        }
        if (tcpMsgButton.isSelected())
        {
            try
            {
                lastResponse = ModbusMechanic.generateModbusTCPRequest(destHostField.getText(), 502, protocolId, transactionId, slaveNode, functionCode, register, quantity);
            }
            catch (Exception e)
            {
                handleModbusException(e);
            }
        }
        //todo: lastResponseType is referenced from the current class, but the response definitions are referenced statically from MM class
        if (readFloatButton.isSelected())
        {
            lastResponseType = ModbusMechanic.RESPONSE_TYPE_FLOAT;
        }
        if (asciiReadButton.isSelected())
        {
            lastResponseType = ModbusMechanic.RESPONSE_TYPE_ASCII;
        }
        if (u16ReadButton.isSelected())
        {
            lastResponseType = ModbusMechanic.RESPONSE_TYPE_UINT16;
        }
        if (u32ReadButton.isSelected())
        {
            lastResponseType = ModbusMechanic.RESPONSE_TYPE_UINT32;
        }
        if (customMessageButton.isSelected())
        {
            lastResponseType = ModbusMechanic.RESPONSE_TYPE_RAW;
        }
        if (lastResponse == null)
        {
            clearResponse();
        }
        else
        {
            displayResponse();
            displayRaw();
        }
    }//GEN-LAST:event_transmitPacketButtonActionPerformed

    public byte[] getLastResponseBytes()
    {
        if (lastFunctionCode == ModbusMechanic.HOLDING_REGISTER_CODE)
        {
            //todo all references to the underlying library should be done in the modbus mechanic class
            return ((ReadHoldingRegistersResponse)lastResponse).getBytes();
        }
        if (lastFunctionCode == ModbusMechanic.INPUT_REGISTER_CODE)
        {
            return ((ReadInputRegistersResponse)lastResponse).getBytes();
        }
        return null;
    }
    public void displayResponse()
    {
        byte[] result = getLastResponseBytes();
        if (byteSwapCheckbox.isSelected())
        {
            result = ModbusMechanic.byteSwap(result); 
        }
        if (wordSwapCheckbox.isSelected())
        {
            result = ModbusMechanic.wordSwap(result); 
        }
        if (lastResponseType == ModbusMechanic.RESPONSE_TYPE_ASCII)
        {
            responseField.setText("Response value: " + new String(result));
        }
        if (lastResponseType == ModbusMechanic.RESPONSE_TYPE_FLOAT)
        {
             responseField.setText("Response value: " + DataUtils.toFloat(result));
        }
        if (lastResponseType == ModbusMechanic.RESPONSE_TYPE_UINT16)
        {
             responseField.setText("Response value: " + DataUtils.BeToIntArray(result)[0]);
        }
        if (lastResponseType == ModbusMechanic.RESPONSE_TYPE_UINT32)
        {
             int[] regs = DataUtils.BeToIntArray(result);
             responseField.setText("Response value: " + (((long)regs[0]*65536) + (long)regs[1]));
        }
    }
    public void displayRaw()
    {
        StringBuffer sb = new StringBuffer();
        if (tcpMsgButton.isSelected())
        {
            sb.append("Transaction ID: " + lastResponse.getTransactionId() + "\n");
            sb.append("Protocol ID: " + lastResponse.getProtocolId() + "\n");
        }
        sb.append("Function code: " + lastFunctionCode + "\n");
        sb.append("Words:\n");
        byte[] responseBytes = getLastResponseBytes();
        for (int i = 0; i < responseBytes.length; i = i + 2)
        {
            sb.append(DatatypeConverter.printHexBinary(new byte[] {responseBytes[i], responseBytes[i+1]}) + " ");
            if ((i+2) % 4 == 0)
            {
                sb.append("\n");
            }
        }
        rawTextBox.setText(sb.toString());
    }
    public void clearResponse()
    {
        responseField.setText("Response value: ");
        rawTextBox.setText("");
    }
    public void handleModbusException(Exception e)
    {
            if (e instanceof ModbusProtocolException)
            {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Protocol Error", JOptionPane.ERROR_MESSAGE);
            }
            if (e instanceof ModbusNumberException)
            {
                e.printStackTrace();
            }
            if (e instanceof ModbusIOException)
            {
                JOptionPane.showMessageDialog(this, e.getMessage(), "IO Error", JOptionPane.ERROR_MESSAGE);
            }
            if (e instanceof Exception)
            {
                e.printStackTrace();
            }
    }
    private void customMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customMessageButtonActionPerformed
        if (customMessageButton.isSelected())
        {
            protoIdField.setEnabled(true);
            transactionField.setEnabled(true);
            quantityField.setEnabled(true);
            functionSelector.setVisible(false);
            jPanel5.setVisible(true);
        }
    }//GEN-LAST:event_customMessageButtonActionPerformed

    private void readFloatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFloatButtonActionPerformed
        // TODO add your handling code here:
        if (readFloatButton.isSelected())
        {
            protoIdField.setEnabled(false);
            transactionField.setEnabled(false);
            quantityField.setEnabled(false);
            quantityField.setText("2");
            jPanel5.setVisible(false);
            functionSelector.setVisible(true);
            
        }
        
    }//GEN-LAST:event_readFloatButtonActionPerformed

    private void functionSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_functionSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_functionSelectorActionPerformed

    private void asciiReadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asciiReadButtonActionPerformed
        // TODO add your handling code here:
        if (asciiReadButton.isSelected())
        {
            protoIdField.setEnabled(false);
            transactionField.setEnabled(false);
            quantityField.setEnabled(true);
            jPanel5.setVisible(false);
            functionSelector.setVisible(true);
            
        }
    }//GEN-LAST:event_asciiReadButtonActionPerformed

    private void byteSwapCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byteSwapCheckboxActionPerformed
        displayResponse();
    }//GEN-LAST:event_byteSwapCheckboxActionPerformed

    private void wordSwapCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordSwapCheckboxActionPerformed
        displayResponse();
    }//GEN-LAST:event_wordSwapCheckboxActionPerformed

    private void u16ReadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u16ReadButtonActionPerformed
        if (u16ReadButton.isSelected())
        {
            protoIdField.setEnabled(false);
            transactionField.setEnabled(false);
            quantityField.setEnabled(false);
            quantityField.setText("1");
            jPanel5.setVisible(false);
            functionSelector.setVisible(true);
        }
    }//GEN-LAST:event_u16ReadButtonActionPerformed

    private void u32ReadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u32ReadButtonActionPerformed
        if (u32ReadButton.isSelected())
        {
            protoIdField.setEnabled(false);
            transactionField.setEnabled(false);
            quantityField.setEnabled(false);
            quantityField.setText("2");
            jPanel5.setVisible(false);
            functionSelector.setVisible(true);
        }
    }//GEN-LAST:event_u32ReadButtonActionPerformed

    private void rtuMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtuMsgButtonActionPerformed
        if(rtuMsgButton.isSelected())
        {
            destHostField.setEnabled(false);
            protoIdField.setEnabled(false);
            transactionField.setEnabled(false);
        }
    }//GEN-LAST:event_rtuMsgButtonActionPerformed

    private void tcpMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpMsgButtonActionPerformed
        if(tcpMsgButton.isSelected())
        {
            protoIdField.setEnabled(true);
            transactionField.setEnabled(true);
            destHostField.setEnabled(true);
        }
    }//GEN-LAST:event_tcpMsgButtonActionPerformed

    private void serialMonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialMonitorButtonActionPerformed
        
        ModbusMechanic.startSerialMonitorFrame(comPortSelector.getItemAt(comPortSelector.getSelectedIndex()), Integer.parseInt(baudRateSelector.getItemAt(baudRateSelector.getSelectedIndex())), Integer.parseInt(dataBitsField.getText()), Integer.parseInt(stopBitsField.getText()), paritySelector.getSelectedIndex());
        
    }//GEN-LAST:event_serialMonitorButtonActionPerformed

    private void paritySelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paritySelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paritySelectorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton asciiReadButton;
    private javax.swing.JComboBox<String> baudRateSelector;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox byteSwapCheckbox;
    private javax.swing.JComboBox<String> comPortSelector;
    private javax.swing.JRadioButton customMessageButton;
    private javax.swing.JTextField dataBitsField;
    private javax.swing.JTextField destHostField;
    private javax.swing.JTextField functionCodeField;
    private javax.swing.JComboBox<String> functionSelector;
    private javax.swing.JPanel interpPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JPanel messagePanel2;
    private javax.swing.JPanel modbusPanel;
    private javax.swing.JPanel modbusPanel2;
    private javax.swing.JPanel packetPanel;
    private javax.swing.JComboBox<String> paritySelector;
    private javax.swing.JTextField protoIdField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextArea rawTextBox;
    private javax.swing.JRadioButton readFloatButton;
    private javax.swing.JTextField registerField;
    private javax.swing.JLabel responseField;
    private javax.swing.JPanel responsePanel;
    private javax.swing.JRadioButton rtuMsgButton;
    private javax.swing.JButton serialMonitorButton;
    private javax.swing.JPanel serialPanel;
    private javax.swing.JPanel serialPanel2;
    private javax.swing.JTextField slaveNodeField;
    private javax.swing.JTextField stopBitsField;
    private javax.swing.JRadioButton tcpMsgButton;
    private javax.swing.JTextField transactionField;
    private javax.swing.JButton transmitPacketButton;
    private javax.swing.JPanel typePanel;
    private javax.swing.JRadioButton u16ReadButton;
    private javax.swing.JRadioButton u32ReadButton;
    private javax.swing.JCheckBox wordSwapCheckbox;
    // End of variables declaration//GEN-END:variables
}
