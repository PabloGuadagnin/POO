from bs4 import BeautifulSoup
import markdownify
import requests
  
  
r = requests.get('https://eventos.unipampa.edu.br/')
c = BeautifulSoup(r.content, 'html.parser')

corpo = c.find('div' , attrs={'class' : 'site'})

html = str(corpo)
# print(html)

# convert html to markdown
md = markdownify.markdownify(html, heading_style="ATX")
  
# print(md)

arquivo = open("Projeto Python/arquivo.MD", "a")
arquivo.write(md)