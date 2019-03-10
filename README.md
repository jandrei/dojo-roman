# Dojo java para conversão de  inteiros para numeral > romano e romano > inteiro

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


