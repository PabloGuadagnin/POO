from importlib.util import source_hash
from bs4 import BeautifulSoup
import markdownify
import requests
  
  
# create html
html = requests.get('https://sites.unipampa.edu.br/eventos/')
  
conteudo = html.content

site = BeautifulSoup(conteudo, 'html.parser')

corpo = site.find('div' , attrs={'class' : 'site'})

# print(corpo)
  
# convert html to markdown
h = markdownify.markdownify(html.content, heading_style="ATX")

arquivo = open("arquivo.txt", "a")
arquivo.write(h)
  
# print(h)

def main():
    arquivo = open("arquivo.txt", "a")
    source = arquivo.read()
    arquivo.close()

    target = markdownify.markdownify(source)
    arquivo = open("arquivo.MD", "w")
    arquivo.write(target)
    arquivo.close()