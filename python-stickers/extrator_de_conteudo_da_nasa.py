import json
import requests
from conteudo import Conteudo


class ExtratorDeConteudoDaNasa:

    def extrai_conteudos(self, url):

        endereco = requests.get(url)

        lista_de_filmes = json.loads(endereco.content)

        conteudos = []

        for url in lista_de_filmes:
            
            titulo =  url.get('title')
            url_imagem = url.get('url')

            conteudo = Conteudo(titulo, url_imagem)

            conteudos.append(conteudo)
        return conteudos