import json
import requests
from conteudo import Conteudo

class ExtratorDeConteudoDoImdb:

    def extrai_conteudos(self, url):

        endereco = requests.get(url)

        dicionario_de_filmes = json.loads(endereco.content)

        lista_de_filmes = dicionario_de_filmes["items"]

        conteudos = []

        for url in lista_de_filmes:
            
            titulo =  url.get('title')
            url_imagem = url.get('image')

            conteudo = Conteudo(titulo, url_imagem)

            conteudos.append(conteudo)
        return conteudos