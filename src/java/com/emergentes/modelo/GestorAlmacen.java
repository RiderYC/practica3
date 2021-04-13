package com.emergentes.modelo;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorAlmacen {
    private ArrayList<almacen> lista;
    
    public GestorAlmacen()
    {
        lista = new ArrayList<almacen>();
    }

    public ArrayList<almacen> getLista() {
        return lista;
    }

    public void setLista(ArrayList<almacen> lista) {
        this.lista = lista;
    }
    

    public void insertarProducto(almacen item){
        lista.add(item);
    }
    public void modificarProducto(int pos,almacen item){
        lista.set(pos, item);
    }
    public void eliminarProducto(int pos){
        lista.remove(pos);
    }
    public int obtieneId(){
        int idaux = 0;
        
        for (almacen item : lista){
            idaux = item.getId();
        }
        return idaux +1 ;
    }
    public int ubicarProducto(int id){
        int pos = -1;
        Iterator<almacen> it = lista.iterator();
        
        while (it.hasNext()){
            ++pos;
            almacen aux = it.next();
            
            if(aux.getId() == id){
                break;
            }
        }
        return pos; 
    }
}
