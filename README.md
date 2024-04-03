# Linketinder-Project

_A ideia do Linketinder é ser uma aplicação que conecta empresas e candidatos sem que ambos sejam previamente identificados. A essência é que características pessoais do candidato, como idade e gênero, não interfiram na escolha inicial para a vaga, evidenciando apenas suas competências técnicas e comportamentais. O mesmo conceito se encaixa para o outro lado, considerando que, por exemplo, o tamanho da empresa poderia impactar na quantidade de candidatos para uma vaga. A identificação de ambos os lados ocorre apenas quando ocorre o match (curtida mútua)._


## MVP do software Linketinder - utilizando recursos simples

por: Verônica Medeiros
 
O repositório atual contém o back-end do código em Groovy integrado ao banco de dados em SQL com adaptação para build em Gradle e o front-end em TypeScript (ainda não integrado).<br/>


**Código em Groovy** (integrado ao banco):

Funcionalidades:
 - Listar Candidatos;
 - Listar Empresas
 - Listar Vagas
 - Atualizar e apagar informações das Vagas
 - Atualizar e apagar informações de Candidatos
 - Atualizar e apagar informações de Empresas
 - Cadastrar Candidatos, Empresas, Vagas
 - Cadastrar, listar, atualizar e deletar Habilidades (estas funcionalidade são acessível dentro das funcionalidades anteriores)
 - Sair

_O arquivo que deve ser executado é o Main.groovy, localizado no caminho backend/src/main/groovy/org/linketinder, que iniciará com um menu._
    
_Pre-requisitos - para rodar o projeto, é necessário instalar e configurar:_
- Groovy;
- JVM (Java Virtual Machine);
- IDE (sugerida: IntelliJ IDEA; aqui é necessário alterar as informações de conexão para se conectar ao servidor local);
- PostgreSQL e arquivo sql do banco.<br/>
  
  
**Banco de dados**:
 
 _Realizou-se previamente uma modelagem de dados pela ferramenta dbdiagram.io, o print deste modelo consta na página sql/modelagem/modelagem-LinkeTinder.png._
 
 _O banco de dados foi feito em linguagem SQL pelo PostgreSQL e integrado ao código em Groovy pelo JDBC._
 
Possui as seguintes tabelas: 

 - skills - para código e nome das habilidades, utilizado tanto para o candidato quanto para requesitos da vaga;
 - cadidates - para as informações de candidato;
 - company - para as informações da empresa;
 - vacancy - para informações de vaga; 
 - cadidate_skills - para armazenar as habilidades de cada candidatos;
 - vacancy_skills - para armazenar as habilidades desejadas para cada vaga;
 
 _Foram inseridos dados em todas as tabelas acima e realizadas algumas queries para demonstrar a relação entre tabelas, que podem ser visualizadas em backend/sql/linketinder-database._
   

**Front-end**:

Funcionalidades:
 - Listar candidatos;
 - Listar vagas;
 - Cadastrar candidatos;
 - Cadastrar empresas.
 
 São 5 páginas simples:
 - Página inicial (com direcionamento para os perfis de candidato e empresa);
 - Página de perfil da empresa, onde é possível visualizar os candidatos (sem as informações pessoais);
 - Página de cadastro da empresa (formulário com validação Regex);
 - Página de perfil do candidato, onde é possível visualizar as vagas (sem as informações que possam identificar a empresa);
 - Página de cadastro do candidato (formulário com validação Regex).
 
 _Pre-requisitos - para rodar o projeto, é necessário instalar e configurar:_
 - TypeScript;
 - Webpack.
 
