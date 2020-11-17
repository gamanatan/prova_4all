# Prova_4all

Automação com Selenium WebDriver + Junit + Maven

##### Caso de teste 1
1. Acessar o site: https://shopcart-challenge.4all.com/
2. Selecionar categoria "Doces"
3. Adicionar todos os produtos ao carrinho
4. Selecionar categoria "Todos"
5. Acessar o carrinho
6. aumentar a quantidade do produto "Brigadeiro" em 4 unidades
7. Clicar no botão "Finalizar Compra"
8. Validar a mensagem "Pedido realizado com sucesso!"
9. Clicar no botão "Fechar"
10.  Fechar o browser

##### Caso de teste 2
1. Acessar o site: https://shopcart-challenge.4all.com/
2. Selecionar categoria "Bebidas"
3. Adicionar todos os produtos ao carrinho
4. Selecionar categoria "Todos"
5. Adicionar o produto "Rissole médio" ao carrinho
6. Acessar o carrinho
7. aumentar a quantidade do produto "Rissole médio" em 9 unidades
8. diminuir a quantidade do produto "Rissole médio" em 5 unidades
9. Validar o valor total dos produtos
10. Clicar no botão "Finalizar Compra"
11. Validar a mensagem "Pedido realizado com sucesso!"
12. Clicar no botão "Fechar"
13. Fechar o browser

### Requisitos:
- Java 1.8
- [Eclipse](https://www.eclipse.org/downloads/)
- Navegador [Chrome](https://www.google.com/intl/pt-BR_ALL/chrome/)

#### Estrutura de arquivos
`src/main/java/`
 - `Generics/` - Contém os métodos genericos.
 - `Pages/` - Contém os componentes/telas/objetos mapeados do teste.

`src/test/java/`
 - `Runs/` - Contém os arquivos para execuções de teste.

`/`
- `drivers/` - Contém os drivers dos navegadores.
- `Log/` - Contém as evidências de execução.

#### Execução
Obs.: Atualizar os arquivos maven antes de realizar a execução.

##### Com JUnit
Para executar o teste desenvolvido com Selenium Webdriver e Junit, você deve executar o seguinte arquivo: `src/test/java/Runs/RunJUnit.java`.

#### Evidências
A cada execução do script é gerada uma nova pasta para armazenar os screenshots da execução. Essas pastas são armazenada em `Log/`.
