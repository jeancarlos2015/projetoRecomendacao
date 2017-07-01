/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Genre;
import cdp.Item;
import cdp.Link;
import cdp.Movie;
import cdp.Rating;
import cdp.Tag;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jean
 */
public class Persistencia {
     private String url="jdbc:postgresql://localhost:5432/bancoRecomendacao", 
            usuario="postgres", senha="ifes";
    private Connection con;
    private Statement stm;
    private String driver = "org.postgresql.Driver";
    private ResultSet rs;
    private Item item;

    public Persistencia(Item item) {
        this.item = item;
    }
    public Persistencia() {}
    
    public boolean executar(String comando) {
        try {

            Class.forName(driver);

            con = DriverManager.getConnection(url, usuario, senha);

            stm = con.createStatement();

            //stm.executeQuery(comando);  
            stm.executeUpdate(comando);
            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
            con.close();

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public List<String> obterColunas(String comando) {
        String parte1 = null;
        String buffer = comando.toLowerCase();
        List<String> list = new ArrayList<>();
        
        if (buffer.contains("as")) {
            parte1 = buffer.split("as")[1];
            String coluna = parte1.split("from")[0];
            list.add(coluna.trim());
            return list;
        }
        if (!buffer.contains("*from")) {
            parte1 = buffer.split("from")[0];
            if (!parte1.contains(",")) {
                list.add(parte1.trim().split(" ")[1]);
                System.out.println(list);
                return list;
            } else if(parte1.contains("select")) {
                 parte1 = parte1.replace("select", "");
                String[] result = parte1.split(",");
                for(String str:result){
                    if(!str.contains(".")){
                        list.add(str.trim());
                    }else{
                        String[] str1 = str.split(".");
                        list.add(str1[1].trim());
                    }
                    
                }
                return list;
            }
        } else {
            String tabela = obterTabela(comando);
            Item item = obterItem(tabela);
            if (item == null) {
                return new ArrayList<>();
            }
            return Arrays.asList(item.getAtributos());
        }
        return list;
    }
    
    private Item obterItem(String tabela) {
        switch (tabela) {
            case "rating":
                return new Rating();
            case "movie":
                return new Movie();
            case "link":
                return new Link();
            case "tag":
                return new Tag();
            case "genre":
                return new Genre();
            default:
                return null;
        }
    }
  public String obterTabela(String comando) {
        
        String comando1 = comando.toLowerCase();
     
        if (!comando1.contains("where")) {
            return comando.toLowerCase().split("from")[1].trim();
        }

        String parte2 = comando1.split("from")[1];
        String tabela = parte2.split(" ")[1];
        return tabela;

    }

   
   public String executarSelecao(String comando) {
        try {
            Class.forName(driver);
            String comando1 = comando.toLowerCase();
            con = DriverManager.getConnection(url, usuario, senha);
            stm = con.createStatement();
            rs = stm.executeQuery(comando1);
            String result = "";
            List<String> itens = obterColunas(comando1);
            while (rs.next()) {
                if (itens.size() == 1) {
                    
                    result += rs.getString(itens.get(0)) + ";";
                } else {
                    for (String dado : itens) {
                        result += rs.getString(dado) + ",";
                    }
                    result += ";";
                }
            }
            rs.close();
            stm.close();
            con.close();
            return result;
        } catch (SQLException | ArrayIndexOutOfBoundsException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
   }
   
   public String executarSelecaoA(String comando, String colunas) {
        try {
            Class.forName(driver);
            String comando1 = comando.toLowerCase();
            con = DriverManager.getConnection(url, usuario, senha);
            stm = con.createStatement();
            rs = stm.executeQuery(comando1);
            String[] colunas_str = colunas.split(",");
            String result = "";
            int index=0;
            while (rs.next()) {
                for(index=0;index<colunas_str.length-1;index++){
                    if(rs.getString(colunas_str[index].trim())!=null){
                        result+=rs.getString(colunas_str[index].trim())+",";
                    }
                }
                result+=rs.getString(colunas_str[index].trim())+";";
            }
            rs.close();
            stm.close();
            con.close();
            return result;
        } catch (SQLException | ArrayIndexOutOfBoundsException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
   }
   
    public String getUrl() {
        return url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public void toBD() {

    }

    public String lerArquivo(String arquivo) {
        String buffer="";
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            
            while (linha != null) {
                //System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
                buffer+=linha+";";
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
        return buffer;
    }
    
    public boolean criaBancoTag(){
        return executar("create table Tag(tagId SERIAL, userId int, movieId int, tag varchar(50), time_stamp varchar(50));");
    }
    public boolean criaBancoRatings(){
        return executar("create table Rating(rating float, userId int, movieId int, times_tamp varchar(50));");
    }
    
    public boolean criaBancoMovie(){
        return executar("create table Movie(movieId int not null primary key, title varchar(100), year varchar(100));");
    }
    
    public boolean criaBancoGenre(){
        return executar("create table Genre(genreId SERIAL, movieId int, name varchar(50));");
    }
    public boolean criaBancoLink(){
        return executar("create table Link(linkId SERIAL, imdbld int, tmdbld int, movieId int);");
    }
    
    public boolean criaChavesExtrangeira(){
        
        boolean result = executar("alter table Tag add foreign key(movieId) REFERENCES movie(movieId);");
        result = result && executar("alter table Rating add foreign key(movieId) REFERENCES movie(movieId);");
        result = result && executar("alter table Link add foreign key(movieId) REFERENCES movie(movieId);");
        //result = result && persistencia.executar("alter table Genre add foreign key(movieId) REFERENCES movie(movieId);");
        return result;
    }
    
    public boolean criaPreProcessamento(){
        boolean result= executar("create view classificacoesUsuario as select userid, movieid, rating from rating;");
        result = result && executar("create view MediaClassificaoesUsuarios as select userid, movieid, avg(rating) as media from rating group by userid,movieid;");
        return result;
    }
    
    
    public boolean criaBanco(){
        //boolean result=criaBancoGenre();
        boolean result=true;
        result = result && criaBancoLink();
        //result = result && criaBancoMovie();
        result = result && criaBancoRatings();
        result = result && criaBancoTag();
        if(result){
            criaPreProcessamento();
            return criaChavesExtrangeira();
        }
        return false;
    }
}
