# Customer and Employee Management

## Build

1. Create database postgreSQL in docker

```sudo docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres```

2. Running the class CustomerAndEmployeeManagementApplication
3. Open swagger in your browser

```http://localhost:8080/swagger-ui/index.html#```

## API REST

Foi Desenvolvido uma API REST para a criação de Endpoints que iriam administrar as informações do banco de dados, para desenvolver essa aplicação foi utilizado a linguagem JAVA, com o Spring Boot 3.0.1, visto que o spring é um framework que auxilia no desenvolvimento da API, utilizando o spring web que irá criar a nossa api e utilizando os decorator facilitando a interação entre as classes.

Chegando ao Banco de dados que é onde iremos utilizar para armazenar as informações foi escolhido utilizar o PostgreSQL como o banco de dados e para facilitar o desenvolvimento e a facilidade de instalação foi utilizado o docker para rodar o banco, pois assim ele era instalado no container e com todas as suas dependências. Para fazer o gerenciamento desse banco foi utilizado o Hibernate e o Spring Data JPA. Uma coisa interessante que como os Objetos tinham atributos em comuns entre eles, foi criado uma classe acima chamada Pessoa que iria conter todos os atributos em comum e os atributos que seriam individuais ficariam nas classes específicas que estenderiam de Pessoa. Com isso só foi preciso criar uma tabela no banco de dados visto que tanto o cliente como o funcionário são pessoas com atributos específicos para cada um.

Ao fim foi utilizado o Swagger para documentar os Endpoints da aplicação, como cada requisição vai diferir umas das outras foi documentado para cada requisição no controller as informações que elas iram receber no request e retornar no response. Além disso, foi utilizado o hibernate-validator para validar se as informações que foram enviadas não eram nulas ou vazias.

Pontos que poderiam melhorar no desenvolvimento é o tratamento de erros para retornar para o usuário um erro com o código mais correto sobre o que é o problema, como, por exemplo, conflitos quando não se tem aquela informação ou quando tem uma informação que não é valida nos parâmetros passados pelo request. Segundo ponto a melhorar seria adicionar alguns enum a alguns campos no banco de dados, como status e function. É claro também a realização de testes para validar as classes e ter a certeza que tudo está funcionando conforme o esperado.