from importlib.util import source_hash
from bs4 import BeautifulSoup
import markdownify
import requests
  
  
# create html
html = requests.get('https://sites.unipampa.edu.br/eventos/')
  
conteudo = html.content

site = BeautifulSoup(conteudo, 'html.parser')

corpo = site.find('div' , attrs={'class' : 'site'})

arquivo = open("arquivo.txt", "w")
arquivo.write(corpo.string)
arquivo.close()

#print(corpo)
  
# convert html to markdown
h = markdownify.markdownify(html.content, heading_style="ATX")
  
# print(h)

