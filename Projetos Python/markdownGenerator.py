# @author Pablo Guadagnin
# Programa para geração de arquivos.MD à partir de sites.

from bs4 import BeautifulSoup
import markdownify
import requests
  
r = requests.get('https://unipampa.edu.br/portal/graduacao/modalidade')
c = BeautifulSoup(r.content, 'html.parser')

# Indica o que buscar no site, nesse caso ignorei algumas "sujeiras" que haviam antes do corpo do site.
corpo = c.find('body' , attrs={'class' : 'html'})

# Transforma o corpo em uma string, pois o markdownify não suporta objetos do BeautifulSoup
html = str(corpo)
# print(html)

# converte a string html para markdown
md = markdownify.markdownify(html, heading_style="ATX")
# print(md)

# Gera um arquivo com a extensão .MD onde está o site em formato markdown
arquivo = open("Projeto Python/arquivo.MD", "a")
arquivo.write(md)
arquivo.close()