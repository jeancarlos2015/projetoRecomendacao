/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public boolean salvar(Object objeto);
    public boolean delete(Object objeto);
    public boolean existe(Object objeto);
    public Object buscar(String id);
    
    
}
