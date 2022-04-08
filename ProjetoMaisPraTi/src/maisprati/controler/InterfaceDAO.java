/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package maisprati.controler;

import java.util.ArrayList;
import java.util.List;
import maisprati.model.Pessoa;

/**
 *
 * @author crist
 */
public interface InterfaceDAO {
    
    public boolean add(Object obj);
    public Object buscaPorNome(String str);
    public void atualiza(String str);
    public boolean delete(int index);
    public int getIndex(String str);
    public List<?>  getTodos();
    
}
