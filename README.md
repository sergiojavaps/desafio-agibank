# Desafio Agibank

### Sistema de análise de dados.

#### O sistema faz a importação de arquivos, lê, analisa os dados e faz um relatório.  
1. Processa apenas arquivos .dat.
2. Para cada arquivo .dat processado, o sistema gera um arquivo de saída {flat_file_name}.done.dat.
3. O sistema gera os diretórios %HOMEPATH%/data/in e %HOMEPATH%/data/out.
4. Os arquivos de entrada, para serem processados, devem ser copiados para a pasta %HOMEPATH%/data/in.
5. Os arquivos processados são gerados na pasta %HOMEPATH%/data/out. 
6. Existem três tipos de dados dentro dos arquivos.
### Dados do vendedor
Os dados do vendedor têm o formato id 001 e a linha terá o seguinte formato: 001çCPFçNameçSalary
### Dados do cliente
Os dados do cliente têm o formato id 002 e a linha terá o seguinte formato: 002çCNPJçNameçBusiness Area
### Dados de vendas
Os dados de vendas têm o formato id 003. Dentro da linha de vendas, existe a lista de itens, que é envolto por colchetes []. A linha terá o seguinte formato: 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

### Exemplo dos dados que o sistema deve ler
001ç05708232005çJean Gray Summersç50000   
001ç41093470097çCharles Xavierç40000.99   
002ç92560174000127çEric Von DoomçLatveria   
002ç28973199000153çTony StarkçStark Enterprise   
003ç03ç[1-10-1000000,2-30-1000000,3-40-1000000]çJean Gray Summers     
003ç04ç[1-34-10,2-33-1.50,3-40-0.10]çCharles Xavier     
