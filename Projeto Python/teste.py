from bs4 import BeautifulSoup
import markdownify
import requests
  

r = requests.get('https://sites.unipampa.edu.br/eventos/')
c = BeautifulSoup(r.content, 'html.parser')

s = c.find_all('article', class_='eventos')
for e in s:
  content = e.find('h2')
  
# Arquivo para testes.