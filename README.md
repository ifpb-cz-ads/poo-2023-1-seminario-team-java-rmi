# O que é Java RMI?

Java RMI (Remote Method Invocation) é um mecanismo para permitir a invocação de métodos que residem em diferentes máquinas virtuais Java (JVM). A JVM pode estar em diferentes máquinas ou podem estar na mesma máquina.  Em ambos os casos, o método pode ser executado em um endereço diferente do processo de chamada


# Loja com Java RMI

Este projeto implementa uma loja virtual utilizando a tecnologia Java RMI (Remote Method Invocation). O sistema permite que os clientes acessem informações sobre os produtos da loja, consultem o estoque, preços e adicionem itens ao carrinho de compras.

## Funcionalidades

- Consultar informações sobre produtos da loja, incluindo nome, estoque e preço.
- Adicionar itens ao carrinho de compras.
- Visualizar o carrinho de compras com os itens selecionados.

## Tecnologias utilizadas

- Java
- Java RMI (Remote Method Invocation)

## Estrutura do projeto

O projeto está organizado da seguinte maneira:

- `Loja` - Contém a interface remota `Loja` que define os métodos disponíveis para acesso remoto.
- `Estoque` - Implementação da interface `Loja`. Esta classe fornece a lógica para consultar informações sobre os produtos e adicionar itens ao carrinho.
- `Cliente` - Aplicação do cliente que se conecta ao servidor RMI e interage com a loja virtual.
- `Server` - Inicializa o objeto remoto e registra no registro RMI para que os clientes possam localizá-lo.
- `README.md` - Este arquivo que fornece informações sobre o projeto.

## Como executar

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
2. Clone este repositório ou faça o download dos arquivos.
3. Compile os arquivos Java utilizando o comando `javac`:
javac *.java
4. Inicie o registro RMI executando o comando: rmiregistry
5. Inicie o servidor RMI executando o comando: java Server
6. Em outro terminal, inicie o cliente executando o comando: java Client
7. Siga as instruções exibidas no console do cliente para interagir com a loja virtual.










