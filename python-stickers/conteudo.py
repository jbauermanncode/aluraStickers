
class Conteudo:

    def __init__(self, titulo, url_imagem):
        self.__titulo = titulo
        self.__url_imagem = url_imagem

    def get_titulo(self):
        return self.__titulo
    
    def get_url_imagem(self):
        return self.__url_imagem