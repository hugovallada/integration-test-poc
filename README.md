# Proof of concept: Testes de integração com Kotlin e Ktor.

## Objetivo: Demonstrar a viabilidade da linguagem Kotlin para a criação dos testes de fluxo, aliada ao microframework Ktor.

### O que são:
  Kotlin: Linguagem moderna, multiparadigma, capaz de executar na JVM, com uma simplicidade comparada ao Python.
  
  Ktor: Microframework específico para Kotlin, desenvolvido pela JetBrains, criadora do Kotlin.
  
  Gradle Kotlin DSL: Gradle é um gerenciador de dependências moderno, que aceita tanto o uso de groovy, quanto kotlin, e permite a programação de suas funcionalidades.
  
  Quarkus: Framework nativo, focado em produtivade e alto desempenho com redução de tempo de inicialização e consumo de memória
  

### Como testar:
  Inicializar a api Rest Quarkus: 
  ```
      É necessário ter o Docker instalado, pois o quarkus irá usar o docker para gerar automaticamente um banco de testes, sem a necessidade de criação manual 
      do banco ou uso de properties como a senha, nome de usuário, url de conexão...o Quarkus, por meio dos test containers se responsabilizará por isso.
      
      Esse comportamento do Quarkus se repete para outras situações, como Keycloak, Apache e etc...
      
      Acessar o terminal e usar o comando gradle quarkusDev ou caso não tenha o gradle instaldo, usar o wrapper disponível no root ./gradlew quarkusDev
      
      PS: O PONTO A SEGUIR NÃO É OBRIGATÓRIO, POIS VOCÊ PODERÁ INSERIR E BUSCAR VIA KTOR.
      Após iniciar, apertar d e Enter no terminal, isso irá abrir a tela de administração do ambiente de dev do quarkus. Nela, ir até o SmallRey OpenApi e 
      selecionar Swagger UI e usar o Swagger para testar. 
   ```
   
   Rodar o fluxo de testes:
   ```
      No teste de integração, rodar os comandos gradle clean build ou o wrapper ./gradlew clean build.
      
      Uma pasta build será gerada, acessar e navegar até libs via terminal, nela rodar o comando java -jar api-consumer-1.0.jar [opt] para iniciar o teste.
      [opt] = get (Listagem), post(Inserção), all(mostra tudo e já realiza uma inserção), exists(verifica se um pokemon existe), qualquer outro valor lançara uma exceção.      
      OBS: No endpoint de POST, há um log que usa 2 variáveis de ambiente, INTEGRATION_TEST_USERNAME e INTEGRATION_TEST_PASSWORD.
      Antes de rodar o comando java -jar api-consumer-1.0.jar, no seu terminal set as váriaveis com export NOME_VARIAVEL=VALOR.
      Variáveis setadas dessa maneira, terão um escopo do terminal, só serão acessadas nesse terminal e até que ele seja reiniciado.
   ```
      
 
 
