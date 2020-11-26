# Desafio Agibank

### Sistema de análise de dados.

#### O sistema faz a importação de arquivos, lê, analisa os dados e faz um relatório.  
1. Processa apenas arquivos .dat.
2. Para cada arquivo processado, o sistema gera um arquivo de saída {flat_file_name}.done.dat. 
  O arquivo de saída é gerado no diretório %HOMEPATH%/data/in.  
  O conteúdo do arquivo de saída deve resumir os seguintes dados:   
. Quantidade de clientes no arquivo de entrada  
. Quantidade de vendedor no arquivo de entrada  
. ID da venda mais cara  
. O pior vendedor   

3. Os arquivos para processamento devem ser copiados para para a pasta %HOMEPATH%/data/in
4. Existem três tipos de dados dentro dos arquivos.

#### Dados do vendedor
Os dados do vendedor têm o formato id ​ 001​ e a linha terá o seguinte formato.
001çCPFçNameçSalary

#### Dados do cliente
Os dados do cliente têm o formato id ​ 002​ e a linha terá o seguinte formato.
002çCNPJçNameçBusiness Area

#### Dados de vendas
Os dados de vendas têm o formato id ​ 003​ . Dentro da linha de vendas, existe a lista de itens, que é envolto por colchetes []. A linha terá o seguinte formato.
003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
