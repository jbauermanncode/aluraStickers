import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DesafiosAula1  {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        
        var client = HttpClient.newHttpClient(); 
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // pegar somente os dados que interessam (título, imagem, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes);
        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {

        // mudar cores do texto na saída do código no terminal
           final String ANSI_RESET = "\u001B[0m";
           final String ANSI_YELLOW = "\u001B[33m";
           final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
           final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
           
           // os códigos em aspas duplas servem para deixar o texto em italico e negrito
           System.out.println("\u001B[3m"+ "\u001B[1m" + ANSI_BLUE_BACKGROUND  + filme.get("title") + ANSI_RESET);
           System.out.println(ANSI_YELLOW + filme.get("image")+ ANSI_RESET);
           
        // calcular para pegar o número de estrelas correto   
           var nota = Float.valueOf(filme.get("imDbRating"));
           var valorNota = nota / 2;
        
        // variável para apresentar estrelas no lugar da nota no lugar da classificação
           var context = Character.toChars(0x2B50);
        // números acima de 4 recebem 5 estrelas   
           if (valorNota > 4){
                System.out.print(context);
                System.out.print(context);
                System.out.print(context);
                System.out.print(context);
                System.out.println(context);
                System.out.println(ANSI_GREEN_BACKGROUND);  
                System.out.println(ANSI_RESET);   
           }
           // números acima de 3 recebem 4 estrelas 
           else if (valorNota > 3){
                System.out.print(context);
                System.out.print(context);
                System.out.print(context);
                System.out.println(context); 
                System.out.println(ANSI_GREEN_BACKGROUND); 
                System.out.println(ANSI_RESET);         
           }

                   // Dar nota para um filme
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja dar nota para o filme?");
        System.out.println("[1] = SIM");
        System.out.println("[2] = NÃO");
        
        try{
            int resposta = scanner.nextInt();

            System.out.println(resposta);
    
            if (resposta == 1){

                System.out.print("Digite a nota para este filme de 1 a 5 :");
                int notaFilme = scanner.nextInt();

                System.out.println("A sua nota é: ");

                if(notaFilme > 4){
                    System.out.print(context);
                    System.out.print(context);
                    System.out.print(context);
                    System.out.print(context);
                    System.out.println(context);
                    System.out.println(ANSI_GREEN_BACKGROUND);  
                    System.out.println(ANSI_RESET);  
                } else if(notaFilme > 3){
                    System.out.print(context);
                    System.out.print(context);
                    System.out.print(context);
                    System.out.print(context);
                    System.out.println(ANSI_GREEN_BACKGROUND);  
                    System.out.println(ANSI_RESET);  
                }else if(notaFilme > 2){
                    System.out.print(context);
                    System.out.print(context);
                    System.out.print(context);
                    System.out.println(ANSI_GREEN_BACKGROUND);  
                    System.out.println(ANSI_RESET);  
                }else if(notaFilme > 1){
                    System.out.print(context);
                    System.out.print(context);
                    System.out.println(ANSI_GREEN_BACKGROUND);  
                    System.out.println(ANSI_RESET);  
                }else{
                    System.out.print(context);
                    System.out.println(ANSI_GREEN_BACKGROUND);  
                    System.out.println(ANSI_RESET); 
                }

                
            } else if (resposta == 2){
                System.out.println("Muito Obrigado!");
            } else{
                System.out.println("Número Inválido");
            }
        } catch (InputMismatchException e){
            System.out.println("O valor informado é inválido");
        }
        }
    }
}

