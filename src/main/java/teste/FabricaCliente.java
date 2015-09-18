package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author prog
 */
public class FabricaCliente {

    public ArrayList<Cliente> clientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(1, "teste"));
        lista.add(new Cliente(2, "teste2"));

        return lista;
    }
}
