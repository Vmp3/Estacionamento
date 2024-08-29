<h1>Projeto Estacionamento</h1>

<h3>Este projeto é uma aplicação para gerenciar veículos, modelos, fabricantes e tipos de veículos. Utiliza Spring Framework para o backend e é estruturado para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em entidades como Veículo, Modelo, Fabricante e Tipo.</h3>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Backend:</strong> Spring Framework (Spring Boot)</li>
    <li><strong>Banco de Dados:</strong> MySQL</li>
    <li><strong>Mapeamento:</strong> JPA (Java Persistence API)</li>
</ul>

<h2>Estrutura do Projeto</h2>
<p>O projeto está estruturado da seguinte forma:</p>
<ul>
    <li><strong>Entidades:</strong> Fabricante, Modelo, Tipo, Veículo, Status</li>
    <li><strong>DTOs:</strong> Objetos de Transferência de Dados usados para a comunicação entre o frontend e o backend.</li>
    <li><strong>Mappers:</strong> Conversão entre Entidades e DTOs.</li>
    <li><strong>Controllers:</strong> Manipulação das requisições HTTP e execução das operações CRUD.</li>
    <li><strong>Services:</strong> Lógica de negócio e manipulação de dados.</li>
</ul>

<h2>Endpoints</h2>

<h3>Fabricantes</h3>
<ul>
    <li><strong>GET /fabricantes</strong> - Retorna a lista de todos os fabricantes.</li>
    <li><strong>GET /fabricantes/{id}</strong> - Retorna os detalhes de um fabricante específico pelo ID.</li>
    <li><strong>POST /fabricantes</strong> - Cria um novo fabricante.
    <li><strong>PUT /fabricantes/{id}</strong> - Atualiza os dados de um fabricante específico pelo ID.</li>
    <li><strong>DELETE /fabricantes/{id}</strong> - Remove um fabricante específico pelo ID.</li>
</ul>

<h3>Modelos</h3>
<ul>
    <li><strong>GET /modelos</strong> - Retorna a lista de todos os modelos.</li>
    <li><strong>GET /modelos/{id}</strong> - Retorna os detalhes de um modelo específico pelo ID.</li>
    <li><strong>POST /modelos</strong> - Cria um novo modelo.</li>
    <li><strong>PUT /modelos/{id}</strong> - Atualiza os dados de um modelo específico pelo ID.</li>
    <li><strong>DELETE /modelos/{id}</strong> - Remove um modelo específico pelo ID.</li>
</ul>

<h3>Tipos</h3>
<ul>
    <li><strong>GET /tipos</strong> - Retorna a lista de todos os tipos de veículos.</li>
    <li><strong>GET /tipos/{id}</strong> - Retorna os detalhes de um tipo específico pelo ID.</li>
    <li><strong>POST /tipos</strong> - Cria um novo tipo de veículo.</li>
    <li><strong>PUT /tipos/{id}</strong> - Atualiza os dados de um tipo específico pelo ID.</li>
    <li><strong>DELETE /tipos/{id}</strong> - Remove um tipo específico pelo ID.</li>
</ul>

<h3>Veículos</h3>
<ul>
    <li><strong>GET /veiculos</strong> - Retorna a lista de todos os veículos.</li>
    <li><strong>GET /veiculos/{id}</strong> - Retorna os detalhes de um veículo específico pelo ID.</li>
    <li><strong>POST /veiculos</strong> - Cria um novo veículo.</li>
    <li><strong>PUT /veiculos/{id}</strong> - Atualiza os dados de um veículo específico pelo ID.</li>
    <li><strong>DELETE /veiculos/{id}</strong> - Remove um veículo específico pelo ID.</li>
</ul>

<h2>Configuração e Execução</h2>

<h3>Clonar o Repositório</h3>
<pre><code>git clone https://github.com/Vmp3/projeto-estacionamento.git</code></pre>

<h3>Configurar o Banco de Dados</h3>
<p>Crie um banco de dados MySQL.</p>
<p>Atualize as configurações de conexão no arquivo <code>application.properties</code> ou <code>application.yml</code>:</p>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/estacionamento
spring.datasource.username=usuario
spring.datasource.password=senha</code></pre>

<h3>Construir o Projeto</h3>
<p>Navegue até o diretório do projeto e execute o comando Maven para construir o projeto:</p>
<pre><code>mvn clean install</code></pre>

<h3>Executar a Aplicação</h3>
<p>Execute a aplicação Spring Boot:</p>
<pre><code>mvn spring-boot:run</code></pre>

<h3>Testar os Endpoints</h3>
<p>Utilize ferramentas como Postman ou curl para testar os endpoints.</p>

