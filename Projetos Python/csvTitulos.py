from bs4 import BeautifulSoup
import requests
import csv

def main():
  titles = []
  r = requests.get('https://sites.unipampa.edu.br/eventos/')
  c = BeautifulSoup(r.content, 'html.parser')
  s = c.find_all('article', class_='eventos')

  count = 1
  for e in s:
    d = {}
    content = e.find('h2')
    link = content.find('a')
    d['Title Number'] = f'Title {count}'
    d['Title Name'] = link.text # Dica: use o atributo 'text' para obter o título
    count += 1
    titles.append(d)

  with open('titles.csv', 'w', newline='') as f:
    # Aqui estamos usando o módulo 'csv' para facilitar essa etapa
    # O método 'DictWriter' permite criar um gerenciador para escrever um arquivo CSV
    w = csv.DictWriter(f,['Title Number','Title Name'])
    # O objeto 'w' contém vários métodos para criar a estrutura do arquivo
    # Aqui estamos chamando 'writeheader' para escrever o cabeçario do CSV
    w.writeheader()

    # O método 'writerows' aceita uma lista com todos os dados que queremos escrever
    w.writerows(titles)

if __name__ == '__main__':
  main()