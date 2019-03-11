# Dojo java para conversão de  inteiros para numeral > romano e romano > inteiro

### Lógica do algoritmo.

#### Conversão para Romanos
O algoritmo foi criado utilizando cálculos para extrair os milhares, centenas, dezenas e unidades do número informado por parâmetro.

Passos para implementação:
 1. divido o componente em 4 métodos, para tratar milhar, centena, dezena e unidade.
 2. cada método extrai sua unidade correspondente.
 3. tenta obter do mapa de unidades seu número expecífico.
 4. se não encontra no mapa, repete a letra da unidade correspondente por 3;
 5. em um dos testes unitários o sistema havia impresso mais que 3 repetições, então precisei adicionar um tratamento para ele.
 6. criei testes unitários para cobrir os números chave para a conversão e alguns intermediários que utilizam esses números chaves que considerei limites superiores e inferiores.

Por exemplo: 
número chave 40, procurei testar o 40, 39 e 41.
número chave 100, procurei testar o 100, 99 e 101.
Adicionei mais testes pois testando os números chave os testes passavam, mas quando adicionava testes aleatórios alguns testes não passavam e precisei trata-los para que o conversor funcionasse corretamente.

#### Conversão para Inteiros


 
### Como executar o projeto por linha de comando
Instale o maven versão 3.x, entre no diretório do projeto e execute **mvn test**.

### Como executar o projeto no eclipse
Importe o projeto maven no eclipse.
Clique com botão direito no projeto **-> Run As -> JUnit Test**.


## Componente e métodos para conversões.
Projeto contém a classe **RomanNumberComponent** responsável pelas conversões da números inteiros para numeral romano e numeral romano para números inteiros.

- **public String convertToRoman(Integer number)**
Recebe um número inteiro e retorna a string corresponente ao número Romano.
O número deve ser positivo, maior que zero e menor ou igual a 3000.


- **public Integer convertToNumber(String number)**
Recebe uma String correspondente a um número Romano e retorna o Inteiro correspondente.
Caso não seja um número romano válido, uma exception é lançada.


