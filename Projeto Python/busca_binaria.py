'''
Implementando uma busca binária em um vetor ordenado de caracteres aleatórios.
@autor Pablo Guadagnin
'''          

from random import randint
# Pede ao usuário o tamanho do vetor aleatório desejado
x = int(input('Entre com a quantidade de caracteres que desejar: '))
vec = []
# Gera um vetor aleatório com números de 0 à 1000
for i in range (x):
    vec.append(randint(0, 1000))
# Organiza o vetor em ordem crescente, para que seja possível aplicar a busca binária
def bubbleSort(vec):
    for passnum in range(len(vec)-1,0,-1):
        for i in range(passnum):
            if vec[i]>vec[i+1]:
                temp = vec[i]
                vec[i] = vec[i+1]
                vec[i+1] = temp
bubbleSort(vec)
# Print para testar se está rodando certo (Descomentar para teste).
print(vec)

# Modela e aplica a busca binária no vetor criado anteriormente      
def busca_binaria(vec, item, comeco=0, fim=-1):
    if comeco <= fim:
        meio = (comeco+fim)//2
        if vec[meio] == item:
            return meio
        if item < vec[meio]:
            return busca_binaria(vec, item, comeco, meio-1)
        else:
            return busca_binaria(vec, item, meio+1, fim)
    return -1
# Pede ao usuário o número a ser procurado e retorna sua posição no vetor ou informa que o mesmo não existe
if __name__ == "__main__":
    alvo = int(input('Introduza um número entre 0 e 1000: '))
    posicao = busca_binaria(vec, alvo, 0, len(vec)-1)
    if posicao == -1:
        print("O elemento %d não foi encontrado." % alvo)
    elif posicao <= len(vec) | posicao >= 0:
        print("O elemento %d foi encontrado na posição: %d" % (alvo, posicao+1))