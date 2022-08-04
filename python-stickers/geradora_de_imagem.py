import requests
from io import BytesIO
from PIL import Image, ImageFont, ImageDraw
import imageio
import os

class GeradoraDeImagem:

    diretorio = input('nome do diretório: ')

    os.makedirs(diretorio)

    def cria(self,nome_arquivo, url_imagem):

        response = requests.get(url_imagem)
        imagem = Image.open(BytesIO(response.content))
        draw = ImageDraw.Draw(imagem)
        font = ImageFont.truetype("Uchen-Regular.ttf", 80)
        draw.text((20, 25), "Hello World!", font=font)

        titulo_imagem = f"{nome_arquivo}.png"

        imageio.imwrite(f"{self.diretorio}/{titulo_imagem}", imagem)

#geradora = GeradoraDeImagem()
#geradora.cria('The Shawshank Redemption', 'https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg')

