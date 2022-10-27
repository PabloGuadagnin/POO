from bs4 import BeautifulSoup
import markdownify
import requests
  
# Referencia a html à transformar  
html = requests.get('https://sites.unipampa.edu.br/eventos/')  

# Adiciona o parser para tratarmos o conteúdo do html
newhtml = BeautifulSoup(html.content, 'html.parser')

print(newhtml.body)

# convert html to markdown
md = markdownify.markdownify(html.content, heading_style="ATX")
  
print(md)

arquivo = open("arquivo.MD", "a")
arquivo.write(md)