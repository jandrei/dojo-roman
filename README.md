# Dojo java para conversão de  inteiros para numeral > romano e romano > inteiro

### Conversão para Romanos
O algoritmo foi criado utilizando enum ordenado do valor 1000 para o 1 com valores e letras apenas do números principais do algorítmo.

Passos para implementação:
 1. o método de conversão principal valida se o número é válido.
 2. itera os valores do enum testando se o parâmetro é maior ou igual ao valor do item do enum. 
 3. se for verdadeiro decrementa do parâmetro o valor encontrado e concatena a letra correspondente.
 4. continua no laço até zerar o valor, 
 Por exemplo, 
 para gerar o número 3 ele desconta de 1 em 1 formando III. 
 para gerar o número 30 ele desconta de 10 em 10 até ficar XXX, e assim por diante. 
 
Adicionei mais testes pois testando os números chave eles passavam, mas quando adicionava testes aleatórios alguns testes não passavam e precisei rever a lógica utilizada inicialmente.


### Conversão para Inteiros
O algoritmo é simples e foi utilizado testando letra a letra da string passada por parâmetro.
 1. é validado que todas letras do número existem no enumerador de romanos conhecido, se não existir o sistema lança exceção.
 2. obtenho a primeira letra e o valor correspondente no enum, se necessário obtenho a segunda letra.
 3. se a primeira for **maior** que a segunda como no caso do número 6(VI) apenas soma-se os valores V+I > 5+1 = 6
 4. se a primeira for **menor** que a segunda como o caso do número 40(XL) apenas subtrai-se os valores L - X > 50-10 = 40
 5. a soma continua até a última letra parâmetro.
 6. obtendo o número correspondente converto para a string em romano pela lógica do sistema para comparar com o parâmetro informado.
 7. se os parâmetros e o resultado da conversão não foram iguais então um número romano inválido foi informado por exemplo IIII poderia ser 4, mas não é válido. 
  
### Como executar o projeto por linha de comandoo
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


