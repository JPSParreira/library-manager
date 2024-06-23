
• - LISTAR EMPRÉSTIMOS (Auxiliar) - •  
Enquadramento: O utilizador clica no botão "Empréstimos" na "Janela Principal".
- Caminho Principal
1. O sistema percorre a lista de empréstimos e apresenta a "Janela de Empréstimos" com a "Lista de Empréstimos" e com os botões "Novo Empréstimo", "Devolução" e "Voltar".

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
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Titulo.Titulo.Exemplar.Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Empréstimos".
3. O sistema efetua o caso de uso "Listar Empréstimos" e apresenta a "Janela Empréstimos" com a "Lista de Empréstimos" e com os botões "Novo Empréstimo", "Devolução" e "Voltar".
4. O utilizador clica no botão "Novo Empréstimo".
5. O sistema apresenta a "Janela Criar Empréstimo" com as combobox "Título" e "Sócio" e o botões "Submeter" e "Voltar".
6. O utilizador seleciona um título e um sócio e clica no botão "Submeter".
7. O sistema verifica que o utilizador existe, não tem dívidas e o livro que pretende emprestar existe em stock e está disponível, grava o empréstimo e apresenta a messageBox com a mensagem "Empréstimo criado com sucesso!" e o botão "OK".
8. O utilizador clica no botão "OK".
9. O caso de uso volta ao ponto 3.

- Caminhos Alternativos  
2.1 O utilizador clica no botão "X" para fechar a janela.  
    2.1.1 O caso de uso termina.  
4.1 O utilizador clica no botão "Voltar".  
    4.1.1 O caso de uso termina.  
6.1 O utiliza clica no botão "Voltar".  
    6.1.1 O caso de uso volta ao ponto 3.  
7.1 O sistema verifica que o utilizador não existe.  
    7.1.1 O sistema apresenta a messageBox com a mensagem "O sócio não existe!" e o botão "OK".  
    7.1.2 O utilizador clica no botão "OK".  
    7.1.3 O caso de uso volta ao ponto 5.  
7.2 O sistema verifica que o utilizador tem dívidas.  
    7.2.1 O sistema apresenta a messageBox com a mensagem "O sócio tem dívidas!" e o botão "OK".  
    7.2.2 O utilizador clica no botão "OK".  
    7.2.3 O caso de uso volta ao ponto 5.  
7.3 O sistema verifica que o livro que pretende emprestar não existe.  
    7.3.1 O sistema apresenta a messageBox com a mensagem "O livro que pretende emprestar não existe." e o botão "OK".  
    7.3.2 O utilizador clica no botão "OK".  
    7.3.3 O caso de uso volta ao ponto 5.  
7.4 O sistema verifica que o livro que pretende emprestar não está disponível.  
    7.4.1 O sistema apresenta a messageBox com a mensagem "O livro que pretende emprestar não está disponível!" e os botões "Sim" e Não.  
    7.4.2.1 O utilizador clica no botão "Sim".  
        7.4.2.1.1 O caso de uso passa ao ponto 1 do caso de uso "Criar Reserva".  
    7.4.2.2 O utilizador clica no botão "Não".  
        7.4.2.2.1 O caso de uso volta ao ponto 5.  

/--------------------/

• - CRIAR DEVOLUÇÃO - •
- Caminho Principal
1. O sistema apresenta a "Janela Principal" com os botões "Empréstimos", "Reservas", "Sócios", "Configurações", "Pesquisar", "Estatísticas", "Adicionar Titulo.Titulo.Exemplar.Exemplar" e "Adicionar Título".
2. O utilizador clica no botão "Empréstimos".
3. O sistema efetua o caso de uso "Listar Empréstimos" e apresenta a "Janela Empréstimos" com a "Lista de Empréstimos" e com os botões "Novo Empréstimo", "Devolução" e "Voltar".
4. O utilizador clica no botão "Devolução".
5. O sistema apresenta a "Janela Devolver Empréstimo" com o text field "Código do empréstimo" e os botões "Submeter" e "Voltar".
6. O utilizador introduz o código de empréstimo e clica no botão "Submeter".
7. O sistema verifica que o empréstimo existe, se já foi entregue e se está a ser entregue dentro do prazo, grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".
8. O utilizador clica no botão "OK".
9. O caso de uso volta ao ponto 3.

- Caminhos Alternativos  
2.1 O utilizador clica no botão "X" para fechar a janela.  
    2.1.1 O caso de uso termina.  
4.1 O utilizador clica no botão "Voltar".  
    4.1.1 O caso de uso termina.  
6.1 O utiliza clica no botão "Voltar".  
    6.1.1 O caso de uso volta ao ponto 3.  
7.1 O sistema verifica que o empréstimo não existe.  
    7.1.1 O sistema apresenta a messageBox com a mensagem "O empréstimo não existe!" e o botão "OK".  
    7.1.2 O utilizador clica no botão "OK".  
    7.1.3 O caso de uso volta ao ponto 5.  
7.2 O sistema verifica que o empréstimo já foi devolvido.  
    7.2.1 O sistema apresenta a messageBox com a mensagem "O empréstimo já foi devolvido!" e o botão "OK".  
    7.2.2 O utilizador clica no botão "OK".  
    7.2.3 O caso de uso volta ao ponto 5.  
7.3 O sistema verifica que o empréstimo foi entregue fora do prazo.  
    7.3.1 O sistema apresenta a messageBox com a mensagem "O sócio 01224 entregou o livro com x dias de atraso. Valor da multa: x.xx€. Pretende efetuar o pagamento" e os botões "Sim" e "Não".  
    7.3.2 O utilizador clica no botão "Sim".  
        7.3.3.1 O sistema grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".  
        7.3.3.2 O utilizador clica no botão "OK".  
        7.3.2.3 O caso de uso passa ao ponto X do caso de uso "Efetuar Pagamento".  
    7.3.3 O utilizador clica no botão "Não".  
        7.3.3.1 O sistema grava a devolução, coloca o livro disponível para empréstimo e apresenta a messageBox com a mensagem "Devolução criada com sucesso!" e o botão "OK".  
        7.3.3.2 O utilizador clica no botão "OK".  
        7.3.3.3 O caso de uso volta ao ponto 8.  

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

/--------------------/