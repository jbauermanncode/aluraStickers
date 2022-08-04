import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        
        //String url = "https://api.nasa.gov/planetary/apod?api_key=OKAf5fPkPEUHhBKghVLqKBn8JKt48G5e7lihCEQx&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://127.0.0.1:8000/linguagens/";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 10; i++){
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";
    
                
            geradora.cria(inputStream, nomeArquivo);
    
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

        }

    }

