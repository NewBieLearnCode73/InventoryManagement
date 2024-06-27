package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.AdminControlController;
import dao.UsersDAO;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Users;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import raven.toast.Notifications;
import helper.BCrypt.BcryptHash;
import helper.util.Constant;
import helper.util.Validate;
import raven.table.TableRenderer;

/**
 *
 * @author Raven
 */
public class FormAdminControl extends javax.swing.JPanel {

    public FormAdminControl() {
        initComponents();
        this.Load();
        this.IDtempt.setVisible(false);
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        // Gắn sự kiện vào table
        MouseListener actionMouse = new AdminControlController(this);

        jTableUsers.addMouseListener(actionMouse);
        TableRenderer jTableUsersRenderer = new TableRenderer(jTableUsers);
        jTableUsersRenderer.setAll();

        // Gắn sự kiện tìm kiếm
        KeyListener actionKey = new AdminControlController(this);
        jTextFieldFind.addKeyListener(actionKey);

        DefaultTableModel model = (DefaultTableModel) jTableUsers.getModel();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onLock(int row) {
                IDtempt.setText(model.getValueAt(row, 0).toString());
                String input = JOptionPane.showInputDialog("Enter new password for this user: ");
                if (Validate.getInstance().isPasswordValid(input)) {
                    UsersDAO.getInstance().changePassword(Integer.parseInt(IDtempt.getText()), BcryptHash.hashPassword(input));
                    Load();
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, Constant.VALIDATE_PASSWORD_ERROR);
                }
            }

            @Override
            public void onRole(int row) {
                IDtempt.setText(model.getValueAt(row, 0).toString());
                String[] choices = {"ADMIN", "USER"};
                String input = (String) JOptionPane.showInputDialog(null, "ADMIN or USER for this user?",
                        "Changing role for this user", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        choices, // Array of choices
                        choices[0]); // Initial choice
                if (input != null && !"".equals(input.trim())) {
                    UsersDAO.getInstance().changeRole(Integer.parseInt(IDtempt.getText()), input);
                    Load();
                }
            }

            // Active User 
            @Override
            public void onActive(int row) {
                IDtempt.setText(model.getValueAt(row, 0).toString());

                String[] choices = {"Active", "Inactive"};
                String input = (String) JOptionPane.showInputDialog(null, "Active or Inactive for this user?",
                        "Choosing status for user", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        choices, // Array of choices
                        choices[0]); // Initial choice
                if (input != null && !"".equals(input.trim())) {
                    UsersDAO.getInstance().changeStatus(Integer.parseInt(IDtempt.getText()), input);
                    Load();
                }
            }

        };
        jTableUsers.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableUsers.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        jTableUsers.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    }

    public void Load() {
        try {
            ArrayList<Users> listUsers = UsersDAO.getInstance().getAll();
            DefaultTableModel tableModel = (DefaultTableModel) this.jTableUsers.getModel();

            tableModel.setRowCount(0);

            for (Users user : listUsers) {
                Object[] row = new Object[]{
                    user.getUserID(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getRole(),
                    user.getStatus()
                };
                tableModel.addRow(row);
            }

            this.jTableUsers.setModel(tableModel);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_DATABSE_SUCCESS);
        } catch (Exception ex) {

            // Thả lỗi ra ngoài
            System.out.println(ex.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_DATABASE_ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        IDtempt = new javax.swing.JLabel();
        jTextFieldFind = new javax.swing.JTextField();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Admin Control");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List of user", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Email", "Role", "Status", "Action"
            }
        ));
        jTableUsers.setColumnSelectionAllowed(true);
        jTableUsers.setRowHeight(30);
        jTableUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableUsers);
        jTableUsers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("  Find user");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(255, 255, 255)));

        IDtempt.setText("jLabel2");

        jTextFieldFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IDtempt)
                        .addGap(1072, 1072, 1072)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFind)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDtempt)
                    .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFindActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel IDtempt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTableUsers;
    public javax.swing.JTextField jTextFieldFind;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
