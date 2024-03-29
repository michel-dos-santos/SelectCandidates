# Solução

Para que o objetivo do teste fosse atingido, foi utilizado um webservice e criado os end-points em sua primeira versão:
Observação: Todos os end-points serão consumidas e produzidas usando JSON.

1 - http://localhost:9000/v1/vagas
    Para a realização de cadastro de vagas, usando o method POST e no Body enviado as seguintes informações:
       Empresa, Titulo, Descrição, Localização e Nível.
    Em caso positivo devolverá o código de retorno 201 com as informações sobre a vaga no body.
    Em caso negativo devolverá o código de retorno 409 com a informação de erro no header.

2 - http://localhost:9000/v1/pessoas
    Para a realização de cadastro de pessoas, usando o method POST e no Body enviado as seguintes informações:
       Nome, Profissão, Localização e Nível.
    Em caso positivo devolverá o código de retorno 201 com as informações sobre a pessoa no body.
    Em caso negativo devolverá o código de retorno 409 com a informação de erro no header.

3 - http://localhost:9000/v1/candidaturas
    Para a realização de cadastro das candidaturas onde será atrelado a vaga ao candidato, usando o method POST e no Body enviado as seguintes informações:
       ID da Vaga e ID da Pessoa.
    Em caso positivo devolverá o código de retorno 201 com as informações sobre a pessoa e seu score em relação a vaga no body.
    Em caso negativo devolverá o código de retorno 409 com a informação de erro no header.

4 - http://localhost:9000/v1/vagas/{idVaga}/candidaturas/ranking
    Para a realização da listagem de candidatos em relação a vaga ordenado de forma decrescente pelo score calculado, usando o method GET.
    Em caso positivo devolverá o código de retorno 200 com as informações sobre os candidatos e seus respectivos scores no body.
    Em caso negativo devolverá o código de retorno 409 com a informação de erro no header.

    Para calcular o score do candidato foi levado em consideração a localização em relação a vaga, usando a seguinte formula:
       SCORE = (N + D) / 2
       Onde N é definido por:
       N = 100 - 25 x (NV - NC)
       Onde NV é o nível de experiência esperada para a vaga e NC é o nível de experiência do candidato.
       O D foi definido com base na menor distância entre o candidato e a vaga e utilize este valor para consultar a tabela a seguir:
                 0 até 5 => 100
                 maiores que 5 até 10 => 75
                 maiores que 10 até 15 => 50
                 maiores que 15 até 20 => 25
                 maiores que 20 => 0

     Para encontrar a menor distância entre o candidato e a vaga foi utilizado o algoritmo de Dijkstra

# Algoritmos

Para resolver o problema de encontrar a menor distância entre dois pontos, foi utilizado o algoritmo de Dijkstra (Grafo Ponderado).

    O algoritmo consiste em executar os seguintes passos sendo eles:
       1 - Inicialização das variaveis contidas no grafo
       2 - Verificação dos vertices com menor custo
       3 - Relaxamento das arestas 
    
    Para representar o mapa abaixo foi utilizado um arquivo [mapa.properties] onde contem a relação entre os vertices e suas arestas.
![](./graph.png)

    A representação deste grafo é:
    
    A,B=5  ----> De A para B a distância é 5
    
    B,A,C,D=5,7,3  ----> De B para A a distância é 5, de B para C a distância é 7, de B para D a distância é 3  
    
    C,B,E=7,4  ----> De C para B a distância é 7, de C para E a distância é 4 
    
    D,B,E,F=3,10,8  ----> De D para B a distância é 3, de D para E a distância é 10, de D para F a distância é 8
    
    E,C,D=4,10  ----> De E para C a distância é 4, de E para D a distância é 10 
    
    F,D=8  ----> De F para D a distância é 8
    ... E caso tivesse mais 
    
    Para que o algoritmo funcione corretamente todos os vertices devem serem identificados e mapeados juntamente com suas respectivas arestas.

# Frameworks e Bibliotecas

Foi utilizado projetos do Spring como: Boot, Data JPA, Web, Test e Lombok.  

# Testes

Para a realização dos testes unitários foi utilizado a Biblioteca JUnit.

# Linguagem de Programação

A linguagem de programação que foi adotada é o Java 8, a praticidade de criação e manutenibilidade juntamente com suas bibliotecas e frameworks são incrivéis, com o Java 8 podemos criar códigos mais limpos e legiveis.

# Banco de Dados

Para que os dados fossem armazenados foi utilizado o banco de dados MySql onde suas vantagens são: Segurança, Integridade e Desempenho.


## Ir para o [Deploy](deploy.md) ou Voltar para o [README](README.md)
