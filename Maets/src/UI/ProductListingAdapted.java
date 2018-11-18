package UI;

import Common.DoNothingCommand;
import Common.LogoutCommand;
import Common.NavigateToCommand;
import Controller.StorePageHandler;
import Controller.UIHandler;
import Memento.CareTaker;
import Memento.Memento;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vilius
 */
public class ProductListingAdapted extends javax.swing.JPanel {

    private UIHandler uiHandler;
    private StorePageHandler handler = new StorePageHandler();
    private javax.swing.JFrame frame;
    
    public ProductListingAdapted(JFrame mainFrame, UIHandler uiHandler) {
        this.frame = mainFrame;
        this.uiHandler = uiHandler;       
        logoutB = new CommandJbutton(new LogoutCommand(uiHandler.getUsername()));
        productPageB = new CommandJbutton(new DoNothingCommand());
        libraryB = new CommandJbutton(new DoNothingCommand());
        initComponents();
        
        // Display product info in the table
        displayProductInfoInTable();
    }
    
    public ProductListingAdapted(JFrame frame, JPanel panel, UIHandler uiHandler) {
        this.frame = frame;
        this.uiHandler = uiHandler;        
        logoutB = new CommandJbutton(new LogoutCommand(uiHandler.getUsername()));
        productPageB = new CommandJbutton(new DoNothingCommand());
        libraryB = new CommandJbutton(new DoNothingCommand());
        initComponents();
        
        // Display product info in the table
        displayProductInfoInTable();
    }
    
    private void displayProductInfoInTable() {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        int rowCount = model.getRowCount();
        
        // Remove all existing rows
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        // Add product listings
        Object[][] listings = handler.getAllProductListing();
        
        for (Object[] list : listings) {
            model.addRow(list);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
                cartB = new CommandJbutton(new DoNothingCommand());
        productScrollPane = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        storeLabel = new javax.swing.JLabel();

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productScrollPane.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
        }
        
        productTable.setSelectionModel(new ForcedListSelectionModel());

        productPageB.setText("Product Page");
        productPageB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPageBActionPerformed(evt);
            }
        });

        logoutB.setText("Logout");
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });
        libraryB.setText("Library");
        libraryB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryBActionPerformed(evt);
            }
        });

        storeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        storeLabel.setText("Store");

        cartB.setText("Cart");
        cartB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(storeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPageB, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutB, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(libraryB, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartB, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(storeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(libraryB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cartB)
                        .addGap(127, 127, 127)
                        .addComponent(productPageB))
                    .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void productPageBActionPerformed(java.awt.event.ActionEvent evt) {               
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) return;
        
        
        CareTaker.getInstance().add(new Memento(this));
        String selectedProduct = (String) productTable.getValueAt(selectedRow, 0);
        productPageB = new CommandJbutton(new NavigateToCommand(new ProductPanelAdapted(frame,this,uiHandler,selectedProduct),frame));
        productPageB.execute();
    }

    private void logoutBActionPerformed(java.awt.event.ActionEvent evt) {          
        logoutB.execute();
        logoutB.setCommand(new NavigateToCommand(new LoginPanel(frame,this,uiHandler),frame));
        logoutB.execute();
        // TODO add your handling code here:
    }
    
    private void libraryBActionPerformed(java.awt.event.ActionEvent evt) {
        libraryB.setCommand( new NavigateToCommand(new LibraryPanelAdapted(frame,this,uiHandler),frame));
        libraryB.execute();
    }
    
    private void cartBActionPerformed(java.awt.event.ActionEvent evt) {
       cartB.setCommand( new NavigateToCommand(new CheckoutPanel(frame,this,uiHandler),frame));
        cartB.execute();
    }


    // Variables declaration - do not modify                     
    private CommandJbutton cartB;
    private CommandJbutton libraryB;
    private CommandJbutton logoutB;
    private CommandJbutton productPageB;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel storeLabel;
    // End of variables declaration                   
}
