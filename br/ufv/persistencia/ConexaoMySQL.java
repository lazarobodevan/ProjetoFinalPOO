/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Nome do nosso pacote //

package br.ufv.persistencia;



//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



//Início da classe de conexão//

public class ConexaoMySQL {

    public static String status = "Não conectou...";

//Método Construtor da Classe//

        public ConexaoMySQL() {

    }



//Método de Conexão//

public static java.sql.Connection getConexaoMySQL() {

        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/projetofinalpoo?useTimezonhe=true&serverTimezone=UTC", "root", "lazaro");
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }



    //Método que retorna o status da sua conexão//

    public static String statusConection() {

        return status;

    }



   //Método que fecha sua conexão//

    public static boolean FecharConexao() {

        try {

            ConexaoMySQL.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

   //Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();
        
        return ConexaoMySQL.getConexaoMySQL();

    }

}