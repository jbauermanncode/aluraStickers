import requests
import json

class App:

    if __name__ == '__main__':
        
       # fazer uma conexão HTTP e buscar os top 250 filmes
        url = requests.get("http://127.0.0.1:8000/linguagens/?format=json")

       # pegar somente os dados que interessam (título, imagem, classificação)
        dicionario_de_filmes = json.loads(url.content)
        print(type(dicionario_de_filmes))
        lista_de_filmes = dicionario_de_filmes["items"]
        print(lista_de_filmes.get('title'))
        
        for filme in dicionario_de_filmes:
            estrela = "\u2B50"
            nota = float(filme.get('imDbRating'))
            valor_nota = int(nota//2 + 1)

            print('\033[1;32;40m' + filme.get('title') + '\033[0;30;40m')
            resposta = input('\033[1;33;40m'+'Deseja dar nota para este filme? (S/N)? ')
            if (resposta == 'S'):
                minha_nota = int(input('Minha Nota(número inteiro de 1 a 5): '))

                print('\033[1;32;40m' + filme.get('title') + '\033[0;30;40m')
                print('\033[0;33;44m' + filme.get('image') + '\033[0;30;40m')


                # estrelas das notas do imdb
                print('Nota do IMDB: ' + valor_nota * estrela)
                # minhas estrelas
                print('Minha Nota: ' + minha_nota * estrela)
            
            elif (resposta == 'N'):
                print('\033[1;32;40m' + filme.get('title') + '\033[0;30;40m')
                print('\033[0;33;44m' + filme.get('image') + '\033[0;30;40m')
                print('Nota do IMDB: ' + valor_nota * estrela)
            




            
        
        
