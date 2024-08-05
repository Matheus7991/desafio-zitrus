# Desafio Zitrus

## Descrição
Este projeto é um sistema de sistema de controle de autorizações de procedimentos médicos para plano de saúde. Desenvolvido com JSP e Servlets.

## Instalação

### Banco de dados

Crie a tabela necessária para a aplicação. Script:
    CREATE TABLE solicitacao (
        id SERIAL PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        procedimento INT NOT NULL,
        idade INT NOT NULL,
        sexo CHAR(1) NOT NULL
    );

#### JBoss

1. Clone o repositório:
   - git clone https://github.com/Matheus7991/desafio-zitrus.git

2. Configure o arquivo context.xml com a conexão do banco de dados e o campo Resource:
   - context.xml-> desafio-zitrus\src\main\webapp\META-INF\context.xml
   - Conexao    -> desafio-zitrus\src\main\java\br\com\desafiozitrus\dao\util\Conexao.java

3. Compile o projeto e empacote como WAR:
   - mvn clean install
   
4. Copie o arquivo WAR para o diretório desejado do JBoss.

5. Inicie o JBoss:
   - cd /path/to/jboss
    ./standalone.sh   # Linux/Mac
    standalone.bat    # Windows

6. Acesse a aplicação:
   - Abra um navegador e acesse http://localhost:8080/desafio-zitrus.

##### Eclipse
1. Clone o repositório:
   - git clone https://github.com/Matheus7991/desafio-zitrus.git

2. Abra o Eclipse e importe o projeto:
    - Vá para *File > Import > Maven > Existing Maven Projects*.
    - Selecione o diretório onde você clonou o projeto e clique em *Finish*.

3. Configure o tomcat no Eclipse:
    - Na aba Servers instale o tomcat e adicione o projeto.
    - Obs: Caso não tenha o tomcat no na máquina, o eclipse dará uma opção para baixa-lo.

4. Configure o arquivo context.xml com a conexão do banco de dados e o campo Resource:
   - context.xml-> desafio-zitrus\src\main\webapp\META-INF\context.xml
   - Conexao    -> desafio-zitrus\src\main\java\br\com\desafiozitrus\dao\util\Conexao.java

5. Inicie o servidor:
    - Clique com o botão direito no servidor na aba **Servers** e selecione **Start**.

6. Acesse a aplicação:
    - Abra um navegador e acesse http://localhost:8080/desafio-zitrus.



