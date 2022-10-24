import requests
from bs4 import BeautifulSoup

r = requests.get('https://sites.unipampa.edu.br/eventos/')
c = BeautifulSoup(r.content, 'html.parser')

s = c.find_all('article', class_='eventos')
for e in s:
  content = e.find('h2')
  link = content.find('a')
  
  # Aqui estamos imprimindo o atributo 'text' do elemento 'a'
  print('Texto: ', link.text)
  # Aqui o método 'get' é usado para extrair o atributo 'href' do elemento 'a'
  print('URL: ', link.get('href'))