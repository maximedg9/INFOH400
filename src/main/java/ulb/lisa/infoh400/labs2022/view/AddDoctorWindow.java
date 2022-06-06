/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.view;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ulb.lisa.infoh400.labs2022.controller.DoctorJpaController;
import ulb.lisa.infoh400.labs2022.controller.PersonJpaController;
import ulb.lisa.infoh400.labs2022.controller.exceptions.IllegalOrphanException;
import ulb.lisa.infoh400.labs2022.controller.exceptions.NonexistentEntityException;
import ulb.lisa.infoh400.labs2022.model.Doctor;

/**
 *
 * @author Adrien Foucart
 */
public class AddDoctorWindow extends javax.swing.JFrame {
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
    private final DoctorJpaController doctorCtrl = new DoctorJpaController(emfac);
    private final PersonJpaController personCtrl = new PersonJpaController(emfac);
    
    private static final Logger LOGGER = LogManager.getLogger(AddDoctorWindow.class.getName());
    
    Doctor doctor = null;
    
    /**
     * Creates new form AddDoctorWindow
     */
    public AddDoctorWindow() {
        initComponents();
    }
    
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
        
        addPersonPanel.setPerson(doctor.getIdperson());
        inamiTextField.setText(doctor.getInami());
        specialtyTextField.setText(doctor.getSpecialty());
    }
    
    public Doctor getDoctor(){
        updateDoctor();
                
        return doctor;
    }
    
    public void updateDoctor(){
        if( doctor == null ){
            doctor = new Doctor();
        }
        
        doctor.setIdperson(addPersonPanel.getPerson());
        doctor.setInami(inamiTextField.getText());
        doctor.setSpecialty(specialtyTextField.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addPersonPanel = new ulb.lisa.infoh400.labs2022.view.AddPersonPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
   /*un docteur c'est comme un patient mais il aura numero inami et une specialisation*/
        inamiTextField = new javax.swing.JTextField();
        specialtyTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Doctor");

        jLabel2.setText("INAMI:");

        jLabel3.setText("Specialty:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inamiTextField)
                                    .addComponent(specialtyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inamiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(specialtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        updateDoctor();

        // Create person if necessary:
        if( doctor.getIdperson().getIdperson() == null ){
            personCtrl.create(doctor.getIdperson());
            LOGGER.debug("Created new person (id = %d)".formatted(doctor.getIdperson().getIdperson()));
        }
        // Create patient if necessary
        if( doctor.getIddoctor() == null ){
            doctorCtrl.create(doctor);
            LOGGER.debug("Created new doctor (id = %d)".formatted(doctor.getIddoctor()));
        }

        // Save changes
        try {
            personCtrl.edit(doctor.getIdperson());
            doctorCtrl.edit(doctor);
            LOGGER.debug("Edited doctor (id = %d)".formatted(doctor.getIddoctor()));
        } catch (NonexistentEntityException | IllegalOrphanException ex) {
            LOGGER.error("Couldn't edit doctor", ex);
        } catch (Exception ex){
            LOGGER.error("Couldn't edit doctor", ex);
        }

        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ulb.lisa.infoh400.labs2022.view.AddPersonPanel addPersonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField inamiTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField specialtyTextField;
    // End of variables declaration//GEN-END:variables
}
