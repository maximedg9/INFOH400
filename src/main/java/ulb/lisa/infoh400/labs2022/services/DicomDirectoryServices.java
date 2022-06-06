/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.services;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomDirectory;
import com.pixelmed.dicom.DicomDirectoryRecord;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.DicomInputStream;
import com.pixelmed.dicom.TagFromName;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Adrien Foucart
 */
public class DicomDirectoryServices {   
    private static final Logger LOGGER = LogManager.getLogger(DicomDirectoryServices.class.getName());
    
    private DicomDirectory ddr;
    private DicomDirectoryRecord selectedRecord;
    
    public DicomDirectoryServices(String path){
        readDicomDirectory(new File(path));
    }
    
    public DicomDirectoryServices(File f){
        readDicomDirectory(f);
    }
    
    private void readDicomDirectory(File f){
        try {
/*read dicom directory 
qui va faire partie attribute list, create 
et qui va renvoyer avec le get model. 
*/
            AttributeList list = new AttributeList();
            list.read(new DicomInputStream(f));
            ddr = new DicomDirectory(list);
        } catch (IOException | DicomException ex) {
            LOGGER.error("Couldn't read DICOM Directory", ex);
            ddr = null;
            /*si c'est pas formaté au standard DICOM cela renvoit exception*/
        }
    }

    public DicomDirectory getModel() {
        return ddr;
    }
    
    public void setSelectedRecord(Object o){
        selectedRecord = (DicomDirectoryRecord) o;
    /*c'est la qu'on dit que l'objet sélectionné est bien de type DicomDirectoryRecord*/
    }
    
    public String getSelectedRecordAttributes(){
        if( selectedRecord == null ){
            return "No selected record";
        }
        
        AttributeList al = selectedRecord.getAttributeList();
        String out = "";

        for( AttributeTag tag: al.keySet() ){
/*on peut recuperer attribut list = Dictionnaire pour faire lien entre
tag dicom <-> et les valeurs qu'ils contiennent. */
/*    On peut faire une boucle qui va recuperer toutes les clefs du dictionnaires
    qui sont tous les tag
*/
            out += tag + " : " + al.get(tag).getDelimitedStringValuesOrEmptyString() + "\n";
        }

        return out;
    }
    
    public boolean selectedRecordIsImage(){
        if( selectedRecord == null ){
            return false;
        }
        
        AttributeList al = selectedRecord.getAttributeList();
        String recordType = al.get(TagFromName.DirectoryRecordType).getSingleStringValueOrEmptyString();
        
        return recordType.equalsIgnoreCase("IMAGE");
    }
    
    public File getSelectedRecordFile(String selectedDirectory){
        if( selectedRecord == null ){
            return null;
        }
        
        AttributeList al = selectedRecord.getAttributeList();
        
        String relativePath = al.get(TagFromName.ReferencedFileID).getDelimitedStringValuesOrEmptyString();
        return new File(selectedDirectory, relativePath);
    }
    
}
