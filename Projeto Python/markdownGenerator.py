from bs4 import BeautifulSoup
import markdownify
import requests
  
  
r = requests.get('https://www.youtube.com/')
c = BeautifulSoup(r.content, 'html.parser')

# print(r.content)

# convert html to markdown
md = markdownify.markdownify(r.content, heading_style="ATX")
  
print(md)

arquivo = open("arquivo.MD", "a")
arquivo.write(md)