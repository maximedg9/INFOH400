/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Adrien Foucart
 */
public class EntityListModel<T> extends AbstractListModel {
 /*utilisation de templates = peut être remplacé par n'importe quelle classe*/
 /*<T> peut être un patient, docteur...*/ 
 /*va contenir une liste de n'importe quelle entité 
 et utiliser les éléments de cette liste pour remplir le jlist. */ 
    private List<T> entities;
    
    public EntityListModel(List<T> entities){
        if( entities == null ){
            entities = new ArrayList();
        }
        this.entities = entities;
    }
    
    public void setList(List<T> entities){
        this.entities = entities;
    }
    
    public List<T> getList(){
        return entities;
    }
/*2 methodes qui viennent de classe abstract list model*/    
/*va dire à l'interface quelle est la taille de la liste*/    
    @Override
    public int getSize() {
        return entities.size();
    }
/*va dire quel élément on trouve à un certain index*/ 

    @Override
    public Object getElementAt(int index) {
        return entities.get(index);
    }
    
}
