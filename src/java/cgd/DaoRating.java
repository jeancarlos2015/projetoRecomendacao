/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Rating;
import cdp.Rating;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoRating implements Dao {

    private final Persistencia persistencia = new Persistencia();

    @Override
    public boolean salvar(Object objeto) {
        if (objeto == null) {
            return false;
        }
        Rating rating = (Rating) objeto;
        return persistencia.executar("insert into rating(userId, movieId, rating, times_tamp) values(" + rating.getUserId() + "," + rating.getMovieId() + "," + rating.getRating() + ",'" + rating.getTimestamp() + "')");
    }

    @Override
    public boolean delete(Object objeto) {
        Rating rating = (Rating) objeto;
        return persistencia.executar("delete from rating where movieid=" + rating.getMovieId());
    }

    public Rating getRating(int userid, int movieid) {
        String comando = "select *from rating where movieid=" + movieid + " and userid = " + userid;
        String[] result = persistencia.executarSelecaoA(comando, "userid,movieid,rating,times_tamp").split(";");
        for (String info : result) {
            String[] dado = info.split(",");
            if (dado.length == 4) {
                String rat = dado[0] + "," + dado[1] + "," + dado[2] + "," + dado[3];
                Rating rating = new Rating(rat);
                return rating;
            }
        }
        return null;
    }

    public Rating getRating(String userid, String movieid) {
        String comando = "select *from rating where movieid=" + movieid + " and userid = " + userid;
        String[] result = persistencia.executarSelecaoA(comando, "userid,movieid,rating, times_tamp").split(";");
        for (String info : result) {
            String[] dado = info.split(",");
            if (dado.length == 4) {
                String rat = dado[0] + "," + dado[1] + "," + dado[2] + "," + dado[3];
                Rating rating = new Rating(rat);
                return rating;
            }
        }
        return null;
    }

    private boolean equal(Rating ratingA, Rating ratingB) {
        return ratingA.getMovieId().equals(ratingB.getMovieId()) && ratingB.getUserId().equals(ratingA.getUserId());
    }

    public String getuserId(int movieId) {
        String comando = "select *from rating where movieid=" + movieId;
        Rating rating = null;
        String[] result = persistencia.executarSelecao(comando).split(";");
        for (String info : result) {
            String[] dado = info.split(",");
            if (dado.length == 4) {
                String rat = dado[1] + "," + dado[2] + "," + dado[0] + "," + dado[3];
                rating = new Rating(rat);
                return rating.getUserId();
            }
        }
        return null;
    }

    @Override
    public boolean existe(Object objeto) {
        Rating rating = (Rating) objeto;
        String comando = "select *from rating where movieid=" + rating.getMovieId() + " and userid = " + rating.getUserId();
        String[] result = persistencia.executarSelecaoA(comando,"userid,movieid,rating").split(";");
        for (String info : result) {
            String[] dado = info.split(",");
            if (dado.length == 3) {
                Rating rating1 = new Rating();
                rating1.setUserId(dado[0]);
                rating1.setMovieId(dado[1]);
                rating1.setRating(dado[2]);
                return equal(rating, rating1);
            }
        }
        return false;
    }

    public Rating maior(List<Rating> lista) {
        try {
            Rating r = lista.get(0);
            for (Rating rating : lista) {
                if (r.getRating() < rating.getRating()) {
                    r = rating;
                }
            }
            return r;
        } catch (IndexOutOfBoundsException ex) {
            
            return new Rating();
        }

    }

    public List<Rating> obterClassificacoesPorFilme(String movieid, int tam) {
        String comando = "select userid,rating from rating where movieid=" + movieid;
        String[] result = persistencia.executarSelecaoA(comando, "userid, rating").split(";");
        List<Rating> ratingsList = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null") && !dado[0].equals(" ") && !dado[0].equals("0") && dado.length == 2) {
                    Rating r = new Rating();
                    r.setUserId(dado[0]);
                    r.setRating(dado[1]);
                    ratingsList.add(r);
                    if (ratingsList.size() == tam) {
                        break;
                    }
                }

            }
            return ratingsList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

    public List<Rating> obterClassificacoesPorFilme(int movieid) {
        String comando = "select userid,rating from rating where movieid=" + movieid;
        String[] result = persistencia.executarSelecaoA(comando, "userid, rating").split(";");
        List<Rating> ratingsList = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                System.out.println(str);
                if (!dado[0].equals("null") && !dado[0].equals(" ") && !dado[0].equals("0") && dado.length == 2) {
                    Rating r = new Rating();
                    r.setUserId(dado[0]);
                    r.setRating(dado[1]);
                    ratingsList.add(r);
                }

            }
            return ratingsList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

    public List<Rating> obterClassificacoesPorUsuario(String userid, int tam) {
        String comando = "select userid , movieid , rating from rating where userid= " + userid;
        String[] result = persistencia.executarSelecaoA(comando, "userid,movieid, rating").split(";");
        List<Rating> ratingsList = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null") && !dado[0].equals(" ") && !dado[0].equals("0") && dado.length == 3) {
                    Rating r = new Rating();
                    r.setUserId(dado[0]);
                    r.setMovieId(dado[1]);
                    r.setRating(dado[2]);
                    ratingsList.add(r);
                    if (ratingsList.size() == tam) {
                        break;
                    }
                }
            }
            return ratingsList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

    //"rating","userid","movieid","times_tamp"
    public List<Integer> obterUsuarios(int movieid) {
        String comando = "select userid from rating where movieid=" + movieid;
        String[] result = persistencia.executarSelecao(comando).split(";");
        List<Integer> usuariosLista = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null")) {
                    usuariosLista.add(Integer.parseInt(dado[0].trim()));
                }
            }
            return usuariosLista;
        } catch (Exception e) {
            return new ArrayList();
        }

    }
    public List<Rating> obterUsuariosFilmes(String userid){
        String[] result = persistencia.executarSelecaoA("select r.userid, r.movieid, r.rating  from rating as r, rating as r2 where r.movieid=r2.movieid and r2.userid="+userid,"userid,movieid,rating").split(";");
        List<Rating> lista = new ArrayList();
        for(String str:result){
            String[] dado = str.split(",");
            if(dado.length==3){
                Rating r = new Rating();
                r.setUserId(dado[0]);
                r.setMovieId(dado[1]);
                r.setRating(dado[2]);
                lista.add(r);
            }
        }
        return lista;
    }
    public List<Integer> obterUsuarios(String movieid) {
        String comando = "select userid from rating where movieid=" + movieid;
        String[] result = persistencia.executarSelecao(comando).split(";");
        List<Integer> usuariosLista = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null")) {
                    usuariosLista.add(Integer.parseInt(dado[0].trim()));
                }
            }
            return usuariosLista;
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    public List<Rating> obtercalcMediaPorUsuario() {
        String[] result = persistencia.executarSelecaoA("select distinct userid, avg(rating) as media from rating group by userid", "userid,media").split(";");
        List<Rating> lista = new ArrayList();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null") && !dado[0].equals(" ") && !dado[0].equals("0")) {
                    Rating r = new Rating();
                    r.setUserId(dado[0]);
                    r.setMedia(dado[1]);
                    lista.add(r);
                }
            }
            return lista;
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    public Rating obtercalcMediaPorUsuario(String userid) {
        String[] result = persistencia.executarSelecaoA("select distinct userid , avg(rating) as media from rating where userid=" + userid + " group by userid", "userid,media").split(";");
        Rating r = new Rating();
        try {
            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null") && dado.length == 2) {
                    r.setUserId(dado[0]);
                    r.setMedia(dado[1]);
                    return r;
                }
            }
            return r;
        } catch (Exception e) {
            return new Rating();
        }

    }

    public Rating obtercalcMediaPorUsuario(Integer userid) {
        String[] result = persistencia.executarSelecaoA("select distinct userid , avg(rating) as media from rating where userid=" + userid + " group by userid", "userid,media").split(";");
        Rating r = new Rating();
        try {

            for (String str : result) {
                String[] dado = str.split(",");
                if (!dado[0].equals("null")) {
                    r.setUserId(dado[0]);
                    r.setMedia(dado[1]);
                    return r;
                }
            }
            return r;
        } catch (Exception e) {
            return new Rating();
        }

    }
    public List<String> getUsuarios(String movieid, float classificacao){
        String[] result = persistencia.executarSelecaoA("select distinct userid from rating where rating>="+classificacao+" and movieid="+movieid+" group by userid", "userid").split(";");
        return Arrays.asList(result);
    }
    //classificacao-media
    public List<Rating> obtercalcMediaDiferencaClassificao(String userid, int tam) {
        List<Rating> lista = new ArrayList();
        List<Rating> classificacoesDoItem = obterClassificacoesPorUsuario(userid, tam);
        Rating primeiro = obtercalcMediaPorUsuario(userid);
        try {
            for (Rating item : classificacoesDoItem) {
                float result = item.getRating() - primeiro.getMedia();
                Rating r = new Rating();
                r.setUserId(userid);
                r.setMedia(primeiro.getMedia());
                r.setRating(item.getRating());
                r.setRatingMenosMedia(result);
                r.setMovieId(item.getMovieId());
                lista.add(r);
                if (lista.size() == tam) {
                    break;
                }
            }
            return lista;
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    public Float obtercalcRaizSomaQuadrado(List<Rating> ratings) {
        float soma = 0;
        for (Rating r : ratings) {
            float media = r.getRatingMenosMedia();
            soma += (float) Math.pow(media, 2);
        }
        float result = (float) Math.sqrt(soma);
        return result;
    }

    @Override
    public Object buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
