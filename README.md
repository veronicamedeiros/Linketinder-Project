# Linketinder-Project

## MVP do software Linketinder - utilizando recursos simples

por: Verônica Medeiros

O projeto contém o back-end do código em Groovy, banco de dados em SQL e o front-end em TypeScript (ainda não integrados).


Código em Groovy:

_O código foi separado por pacotes a fim de deixar o código mais limpo, as Listas criadas com informações (lista de candidatos e lista de empresas) também foram incluídas em um pacote devido ao seu tamanho._
_O pacote Tests contém os testes para inserção dos novos elementos (Candidato e Empresa) em suas respectivas listas._

Funcionalidades:
 - Listar candidatos;
 - Listar empresas;
 - Cadastrar candidatos;
 - Cadastrar empresas;
 - Sair.

_Ao selecionar as opções de "Listar" do menu, as listas são exibidas contendo apenas duas informações, que são aquelas não sigilosas, devido à ideia do Linketinder possuir perfis de caráter anônimo. Porém todos os atributos são funcionais (possuem getters e setters) e formatação para String para quando for necessário exibir todas as informações em uma próxima etapa._

_O arquivo que deve ser executado é o App (src/Application)._
    
_Pre-requisitos - para rodar o projeto, é necessário instalar e configurar:_
- Groovy;
- JVM (Java Virtual Machine);
- IDE (sugerida: IntelliJ IDEA).



Front-end:

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
 
 
 
 Banco de dados:
 
 _Realizou-se previamente uma modelagem de dados pela ferramenta dbdiagram.io, o print deste modelo consta na página sql/modelagem._
 
 _O banco de dados foi feito em linguagem SQL pelo PostgreSQL._
 
Possui as seguintes tabelas:

 - skills - para código e nome das habilidades, utilizado tanto para o candidato quanto para requesitos da vaga;
 - cadidates - para as informações de candidato;
 - company - para as informações da empresa;
 - vacancy - para informações de vaga; 
 - cadidate_skills - para armazenar as habilidades de cada candidatos;
 - vacancy_skills - para armazenar as habilidades desejadas para cada vaga;
 
 _Foram inseridos dados em todas as tabelas acima e realizadas algumas queries para demonstrar a relação entre tabelas._

