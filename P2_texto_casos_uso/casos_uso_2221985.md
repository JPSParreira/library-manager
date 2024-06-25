
• - LISTAR EMPRÉSTIMOS (Auxiliar) - • 

Enquadramento: O utilizador clica no botão "Empréstimos" na "Janela Principal".

- Caminho Principal
1. O sistema percorre a lista de empréstimos e adiciona cada empréstimo activo à "Lista de Empréstimos".

- Caminhos Alternativos  
N/A

/--------------------/

• - LISTAR RESERVAS (Auxiliar) - •  

Enquadramento: O utilizador clica no botão "Reservas" na "Janela Principal".

- Caminho Principal
1. O sistema percorre a lista de reservas e apresenta a "Janela de Reservas" com a "Lista de Reservas" e com os botões "Anular Reserva" e "Voltar".

- Caminhos Alternativos  
N/A

/--------------------/

• - CRIAR EMPRÉSTIMO - •

- Caminho Principal
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Empréstimos".
3. O sistema efetua o caso de uso "Listar Empréstimos" e apresenta a "Janela Empréstimos" com a "Lista de Empréstimos" e com os botões "Novo Empréstimo", "Devolução" e "Voltar".
4. O utilizador clica no botão "Novo Empréstimo".
5. O sistema apresenta a "Janela Criar Empréstimo" com as combobox "Título" e "Sócio" e o botões "Submeter" e "Voltar".
6. O utilizador seleciona um título e um sócio e clica no botão "Submeter".
7. O sistema verifica que o utilizador não tem dívidas, o título que pretende emprestar tem um exemplar disponível e o sócio não excedeu o número máximo de empréstimos, grava o empréstimo e apresenta a messageBox com a mensagem "Empréstimo criado com sucesso!" e o botão "OK".
8. O utilizador clica no botão "OK".
9. O caso de uso volta ao ponto 3.

- Caminhos Alternativos  
2.1 O utilizador clica no botão "X" para fechar a janela.  
    2.1.1 O caso de uso termina.  
4.1 O utilizador clica no botão "Voltar".  
    4.1.1 O caso de uso termina.  
6.1 O utiliza clica no botão "Voltar".  
    6.1.1 O caso de uso volta ao ponto 3.  
7.1 O sistema verifica que o utilizador tem dívidas.  
  7.1.1 O sistema apresenta a messageBox com a mensagem "O sócio tem dívidas!" e o botão "OK".  
  7.1.2 O utilizador clica no botão "OK".  
  7.1.3 O caso de uso volta ao ponto 5.
7.2 O sistema verifica que o sócio atingiu o máximo de empréstimos definidos em sistema.  
  7.2.1 O sistema apresenta a messageBox com a mensagem "O sócio selecionado já atingiu o limite de empréstimos ativos." e o botão "OK".  
  7.2.2 O utilizador clica no botão "OK".  
  7.2.3 O caso de uso volta ao ponto 5.
7.3 O sistema verifica que o livro que pretende emprestar não está disponível.  
  7.3.1 O sistema apresenta a messageBox com a mensagem "O livro que pretende emprestar encontra-se emprestado. Pretende reservar" e os botões "Sim" e Não.  
  7.3.2.1 O utilizador clica no botão "Sim".  
  7.3.2.1.1 O caso de uso passa ao ponto 1 do caso de uso "Criar Reserva".  
  7.3.2.2 O utilizador clica no botão "Não".  
  7.3.2.2.1 O caso de uso volta ao ponto 5.
7.4 O sistema não consegue processar a informação das comboBox.
  7.4.1 O sistema apresenta a messageBox com a mensagem "Erro ao criar empréstimo." e o botão "OK".  
  7.4.2 O utilizador clica no botão "OK".  
  7.4.3 O caso de uso volta ao ponto 5.

- Mensagens de Sistema
  SUC_01: "Empréstimo criado com sucesso."
  ERR_01: "O sócio selecionado tem dívidas por pagar."
  ERR_02: "O sócio selecionado já atingiu o limite de empréstimos ativos."
  ERR_03: "Não existem exemplares disponíveis para o título selecionado. Deseja fazer uma reserva?"
  ERR_04: "Erro ao criar empréstimo."

/--------------------/

• - CRIAR DEVOLUÇÃO - •

- Caminho Principal
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Titulo.Titulo.Exemplar.Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Empréstimos".
3. O sistema efetua o caso de uso "Listar Empréstimos" e apresenta a "Janela Empréstimos" com a "Lista de Empréstimos" e com os botões "Novo Empréstimo", "Devolução" e "Voltar".
4. O utilizador clica no botão "Devolução".
5. O sistema apresenta a "Janela Devolver Empréstimo" com o text field "ID do empréstimo" e os botões "Submeter" e "Voltar".
6. O utilizador introduz o código de empréstimo e clica no botão "Submeter".
7. O sistema verifica que o empréstimo está a ser entregue dentro do prazo, grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".
8. O utilizador clica no botão "OK".
9. O caso de uso volta ao ponto 3.

- Caminhos Alternativos  
2.1 O utilizador clica no botão "X" para fechar a janela.  
    2.1.1 O caso de uso termina.  
4.1 O utilizador clica no botão "Voltar".  
    4.1.1 O caso de uso termina.  
6.1 O utiliza clica no botão "Voltar".  
    6.1.1 O caso de uso volta ao ponto 3.   
7.1 O sistema verifica que o empréstimo foi entregue fora do prazo.  
    7.1.1 O sistema apresenta a messageBox com a mensagem "O sócio 01224 entregou o livro com x dias de atraso. Valor da multa: x.xx€. Pretende efetuar o pagamento?" e os botões "Sim" e "Não".  
    7.1.2 O utilizador clica no botão "Sim".  
        7.1.2.1 O sistema grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".  
        7.1.2.2 O utilizador clica no botão "OK".  
        7.1.2.3 O caso de uso passa ao ponto X do caso de uso "Efetuar Pagamento".  
    7.1.3 O utilizador clica no botão "Não".  
        7.1.3.1 O sistema grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".  
        7.1.3.2 O utilizador clica no botão "OK".  
        7.1.3.3 O caso de uso volta ao ponto 3.  
7.2 O sistema não consegue processar a informação da comboBox.
    7.2.1 O sistema apresenta a messageBox com a mensagem "Erro ao efetuar a devolução." e o botão "OK".
    7.2.2 O utilizador clica no botão "OK".  
    7.2.3 O caso de uso volta ao ponto 5.

- Mensagens de Sistema
  SUC_01: "Devolução criada com sucesso!"
  ERR_01: 'O sócio 01224 entregou o livro com x dias de atraso. Valor da multa: x.xx€. Pretende efetuar o pagamento" e os botões "Sim" e "Não"'.
  ERR_02: "Erro ao efetuar a devolução."

/--------------------/

• - CRIAR RESERVA (Auxiliar) - •  
Enquadramento: O utilizador tenta criar um empréstimo de um livro que existe, mas não está disponível e clica em "Sim" na messageBox.
- Caminho Principal
1. O sistema grava a reserva do livro junto com o sócio e apresenta a messageBox com a mensagem "Reserva criada com sucesso! Assim que o livro estiver disponível será avisado!" e o botão "OK".
2. O utilizador clica no botão "OK".
3. O caso de uso termina e volta à "Janela Empéstimos".

- Caminhos Alternativos  
N/A

/--------------------/

• - ANULAR RESERVA - •
- Caminho Principal
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Titulo.Titulo.Exemplar.Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Reservas".
3. O sistema efetua o caso de uso "Listar Reservas" e apresenta a "Janela de Reservas" com a "Lista de Reservas" e com os botões "Anular Reserva" e "Voltar".
4. O utilizador clica no botão "Anular Reserva".
5. O sistema apresenta a "Janela Anular Reservas" com o text field "Código da Reserva" e os botões "Submeter" e "Voltar".
6. O utilizador introduz o código de reserva e clica no botão "Submeter".
7. O sistema verifica que o reserva existe, apaga a reserva e apresenta a messageBox com a mensagem "Reserva anulada com sucesso!" e o botão "OK".
8. O utilizador clica no botão "OK".
9. O caso de uso volta ao ponto 3.

- Caminhos Alternativos  
2.1 O utilizador clica no botão "X" para fechar a janela.  
    2.1.1 O caso de uso termina.  
4.1 O utilizador clica no botão "Voltar".  
    4.1.1 O caso de uso termina e volta à "Janela Principal".  
6.1 O utiliza clica no botão "Voltar".  
    6.1.1 O caso de uso volta ao ponto 3.  
7.1 O sistema verifica que a reserva não existe.  
    7.1.1 O sistema apresenta a messageBox com a mensagem "A reserva não existe!" e o botão "OK".  
    7.1.2 O utilizador clica no botão "OK".  
    7.1.3 O caso de uso volta ao ponto 5.  

/--------------------/

• - MODIFICAR VALORES DE CONFIGURAÇÃO - •

- Caminho Principal
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Titulo.Titulo.Exemplar.Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Configurações".
3. O sistema apresenta a "Janela de Configurações" com os campos "Máximo de dias para empréstimo", "Valor da multa diário", "Máximo de empréstimos ativos por sócio" e "Valor da anuidade" e com os botões "Submeter" e "Voltar".
4. O utilizador altera os valores que pretende e clica no botão "Submeter".
5. O sistema valida que o "Máximo de dias para empréstimo" é um valor inteiro dentro do intervalo [7, 30], que o "Valor da multa diário" é um valor decimal dentro do intervalo [0.5, 2.5], que o "Máximo de empréstimos ativos por sócio" é um valor inteiro dentro do intervalo [1, 5] e que o "Valor da anuidade" é um valor decimal dentro do intervalo [10, 100], grava os valores alterados e apresenta a messageBox com a mensagem "Valores alterados com sucesso!" e o botão "OK".
6. O utilizador clica no botão "OK".
7. O sistema apresentas a mensagem "Configurações guardadas com sucesso." e o botão "OK".
7. O caso de uso termina e volta à "Janela Principal".

- Caminhos Alternativos  
2.1 O utilizador clica no botão "Voltar".  
    2.1.1 O caso de uso termina e volta à "Janela Principal".  
5.1 O sistema valida que o "Máximo de dias para empréstimo" não é um valor inteiro dentro do intervalo [7, 30].  
    5.1.1 O sistema apresenta a messageBox com a mensagem "O valor do 'Máximo de dias para empréstimo' tem de ser um valor inteiro dentro do intervalo [7, 30]." e o botão "OK".  
    5.1.2 O utilizador clica no botão "OK".  
    5.1.3 O caso de uso volta ao ponto 3.  
5.2 O sistema valida que o "Valor da multa diário" não é um valor decimal dentro do intervalo [0.5, 2.5].  
    5.2.1 O sistema apresenta a messageBox com a mensagem "O valor do 'Valor da multa diário' tem de ser um valor decimal dentro do intervalo [0.5, 2.5]." e o botão "OK".  
    5.2.2 O utilizador clica no botão "OK".  
    5.2.3 O caso de uso volta ao ponto 3.  
5.3 O sistema valida que o "Máximo de empréstimos ativos por sócio" não é um valor inteiro dentro do intervalo [1, 5].  
    5.3.1 O sistema apresenta a messageBox com a mensagem "O valor do 'Máximo de empréstimos ativos por sócio' tem de ser um valor inteiro dentro do intervalo [1, 5]." e o botão "OK".  
    5.3.2 O utilizador clica no botão "OK".  
    5.3.3 O caso de uso volta ao ponto 3.  
5.4 O sistema valida que o "Valor da anuidade" não é um valor decimal dentro do intervalo [10, 100].  
    5.4.1 O sistema apresenta a messageBox com a mensagem "O valor do 'Valor da anuidade' tem de ser um valor decimal dentro do intervalo [10, 100]." e o botão "OK".  
    5.4.2 O utilizador clica no botão "OK".  
    5.4.3 O caso de uso volta ao ponto 3.  

- Mensagens de Sistema
1. SUC_01: "Configurações guardadas com sucesso."
2. ERR_01: "O valor do 'Máximo de dias para empréstimo' tem de ser um valor inteiro dentro do intervalo [7, 30]."
3. ERR_02: "O valor do 'Valor da multa diário' tem de ser um valor decimal dentro do intervalo [0.5, 2.5]."
4. ERR_03: "O valor do 'Máximo de empréstimos ativos por sócio' tem de ser um valor inteiro dentro do intervalo [1, 5]."
5. ERR_04: "O valor do 'Valor da anuidade' tem de ser um valor decimal dentro do intervalo [10, 100]."

/--------------------/ 