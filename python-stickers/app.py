from matplotlib.font_manager import json_load
import requests
import json

from extrator_de_conteudo_da_nasa import ExtratorDeConteudoDaNasa
from extrator_de_conteudo_do_IMDB import ExtratorDeConteudoDoImdb
from geradora_de_imagem import GeradoraDeImagem

class App:

    if __name__ == '__main__':
        
       # fazer uma conexão HTTP e buscar os top 250 filmes
        url = "http://127.0.0.1:8000/linguagens/?format=json"
        #url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"
        extrator = ExtratorDeConteudoDaNasa()

        conteudos = extrator.extrai_conteudos(url)

        geradora = GeradoraDeImagem()

        for conteudo in conteudos:

            url_imagem = conteudo.get_url_imagem()
            nome_arquivo = conteudo.get_titulo()

            geradora.cria(nome_arquivo, url_imagem)

            print(conteudo.get_titulo())
 
            




            
        
        
