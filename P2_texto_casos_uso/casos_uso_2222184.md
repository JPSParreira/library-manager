 Criar Sócio
===============================
CAMINHO PRINCIPAL:
1. Na "JanelaSocios", o utilizador clica no botão "Adicionar Sócio"
2. O sistema cria e apresenta a janela "JanelaCriarSocio" com os seguintes campos:
   Nome, mandatório, do tipo texto, com mínimo de 3 caracteres e máximo de 60.
   Morada, mandatório, do tipo texto, com mínimo de 3 caracteres e máximo de 60.
   Email, mandatório, do tipo texto, com mínimo de 3 caracteres e máximo de 60.
   Nif ou CC, mandatório, do tipo inteiro positivo, com 9 dígitos.
   Telemóvel, mandatório, do tipo inteiro positivo, com 9 dígitos.

3. O utilizador preenche os campos Nome, Morada, Email, Nif ou CC e Telemóvel, e clica no botão "Submeter".
4. O sistema valida que:
   O campo Nome está preenchido, tem entre 3 e 60 caracteres e não é exclusivamente composto por espaços em branco.
   O campo Morada está preenchido, tem entre 3 e 60 caracteres e não é exclusivamente composto por espaços em branco.
   O campo Email está preenchido, tem entre 3 e 60 caracteres, não é exclusivamente composto por espaços em branco e é único no sistema.
   O campo Nif ou CC está preenchido, é um inteiro positivo, tem 9 dígitos e é único no sistema.
   O campo Telemóvel está preenchido, é um inteiro positivo, tem 9 dígitos e é único no sistema.
5. O sistema cria um novo "Sócio", adiciona-o à lista de sócios do sistema, apresenta a mensagem de sucesso S01 (Sócio = Nome do Sócio), fecha a janela atual "JanelaCriarSocio" e retorna à janela anterior "JanelaSocios".


CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "Adicionar Sócio" e retorna à janela anterior "JanelaCriarSocio".

4.1. O campo "Nome" não está preenchido.
4.1.1. O sistema apresenta a mensagem de erro ERR_SOCIO_01.

4.2. O campo "Morada" não está preenchido.
4.2.1. O sistema apresenta a mensagem de erro ERR_MORADA_01.

4.3. O campo "Email" não está preenchido.
4.3.1. O sistema apresenta a mensagem de erro ERR_EMAIL_01.

4.4. O campo "Nif ou CC" não está preenchido.
4.4.1. O sistema apresenta a mensagem de erro ERR_NIFOUCC_01.

4.5. O campo "Telemóvel" não está preenchido.
4.5.1. O sistema apresenta a mensagem de erro ERR_TELEMOVEL_01.

4.6. O campo "Nome" tem menos de 3 caracteres ou mais de 60 caracteres.
4.6.1. O sistema apresenta a mensagem de erro ERR_SOCIO_02.

4.7. O campo "Morada" tem menos de 3 caracteres ou mais de 60 caracteres.
4.7.1. O sistema apresenta a mensagem de erro ERR_MORADA_02.

4.8. O campo "Email" tem menos de 3 caracteres ou mais de 60 caracteres.
4.8.1. O sistema apresenta a mensagem de erro ERR_EMAIL_02.

4.9. O campo "Nif ou CC" não tem 9 dígitos.
4.9.1. O sistema apresenta a mensagem de erro ERR_NIFOUCC_02.

4.10. O campo "Telemóvel" não tem 9 dígitos.
4.10.1. O sistema apresenta a mensagem de erro ERR_TELEMOVEL_02.

4.11. O campo "Email" já existe no sistema.
4.11.1. O sistema apresenta a mensagem de erro ERR_EMAIL_03.

4.12. O campo "Nif ou CC" já existe no sistema.
4.12.1. O sistema apresenta a mensagem de erro ERR_NIFOUCC_03.

4.13. O campo "Nome" é composto exclusivamente por espaços em branco.
4.13.1. O sistema apresenta a mensagem de erro ERR_SOCIO_03.

4.14. O campo "Morada" é composto exclusivamente por espaços em branco.
4.14.1. O sistema apresenta a mensagem de erro ERR_MORADA_03.

4.15. O campo "Email" é composto exclusivamente por espaços em branco.
4.15.1. O sistema apresenta a mensagem de erro ERR_EMAIL_04.

4.16. O campo "Télemovel" já existe no sistema.
4.16.1. O sistema apresenta a mensagem de erro ERR_TELEMOVEL_03.


MENSAGENS DO SISTEMA:
S01: Sócio <Nome do Sócio> adicionado com sucesso.

ERR_SOCIO_01: O campo "Sócio" é mandatório.
ERR_SOCIO_02: O campo "Sócio" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.
ERR_SOCIO_03: O campo "Sócio" não pode ser composta apenas por espaços em branco.
ERR_MORADA_01: O campo "Morada" é mandatório.
ERR_MORADA_02: O campo "Morada" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.
ERR_MORADA_03: O campo "Morada" não pode ser composta apenas por espaços em branco.
ERR_EMAIL_01: O campo "Email" é mandatório.
ERR_EMAIL_02: O campo "Email" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.
ERR_EMAIL_03: O campo "Email" já existe no sistema.
ERR_EMAIL_04: O campo "Email" não pode ser composta apenas por espaços em branco.
ERR_NIFOUCC_01: O campo "Nif ou CC" é mandatório.
ERR_NIFOUCC_02: O campo "Nif ou CC" deve ter 9 dígitos.
ERR_NIFOUCC_03: O campo "Nif ou CC" já existe no sistema. 
ERR_TELEMOVEL_01: O campo "Télemovel" é mandatório.
ERR_TELEMOVEL_02: O campo "Télemovel" deve ter 9 dígitos.
ERR_TELEMOVEL_03: O campo "Télemovel" já existe no sistema.

Listar sócio
===============================
CAMINHO PRINCIPAL:
1. Na "Janela Principal", o utilizador clica no botão "Sócios"
2. O sistema cria e apresenta a janela "JanelaSocios" com os seguintes campos:
   Tabela de Sócios, com lista de Sócios proveniente dos dados da aplicação, incluído os campos:
      Cod, codigo identificador do Sócio.
      Nome, do tipo texto, com mínimo de 3 caracteres e máximo de 60.
      Dívida, tipo float positivo, com mínimo de 3 dígitos.
      Prox. anuidade, tipo data.

CAMINHO ALTERNATIVO:
2.1  O sistema apresenta uma mensagem de erro, na tabela, se não houver sócios registados.
2.1.1. O sistema apresenta a mensagem de erro ERR_LISTA_SOCIOS_01.

MENSAGENS DO SISTEMA:

ERR_LISTA_SOCIOS_01: Não existem sócios registados.

Consultar historico de emprestimos de sócio
===============================
CAMINHO PRINCIPAL:
1. Na "JanelaSocios", o utilizador clica no botão "Histórico Sócio"
2. O sistema cria e apresenta a janela "JanelaHistóricoSocio" com os seguintes campos:
      Sócio, mandatório, do tipo dropdown, com lista de sócios.
   Apresenta também uma tabela com lista de emprestimos realizados pelo Sócio, com os campos:
      Codigo, codigo identificador do emprestímo realizado.
      Título, do tipo texto.
      Data Reserva, do tipo data.
      Data Entrega, do tipo data.

3. O utilizador preenche o campo "Sócio" e clica no botão Procurar.
4. O sistema pesquisa na Lista de emprestimos do Sócios os emprestimos realizados e preenche os campos com a informação referida préviamente.

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema apresenta a janela "JanelaSocios"
3.2 O utilizador clica no botão "Procurar" sem preencher o campo "Sócio"
3.2.1 O sistema apresenta a mensagem de erro ERR_HISTORICO_01.
4.1. O sócio selecionado não tem histórico de empréstimos.
4.1.1. O sistema apresenta a mensagem de erro ERR_HISTORICO_02.

MENSAGENS DO SISTEMA:
ERR_HISTORICO_02: É necessário selecionar um "Sócio" no campo "Sócio".
ERR_HISTORICO_02: O sócio selecionado não possui histórico de empréstimos.

Pesquisar por livro
===============================
CAMINHO PRINCIPAL:
1. Na "Janela Principal", o utilizador clica no botão "Pesquisar"
2. O sistema cria e apresenta a janela "JanelaPesquisarTitulo" com o seguinte campo:
       Titulo, mandatório, do tipo texto.
3. O utilizador preenche o campo "Titulo" e clica no botão "Procurar".
4. O sistema verifica se:
    Titulo, está preenchido, tem entre 3 e 50 caracteres e não é exclusivamente composto por espaços em branco.
    Procura pelo "Titulo" da lista de exemplares e lista numa tabela:
        Titulo, ISBN, Editora, Prateleira e Estante, do tipo texto.
        Estado, do tipo texto com os valores "Disponível", "Emprestado" e "Indisponível".
        Total, tipo numerico com o total de exemplares encontrados.

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "JanelaPesquisarTitulo" e retorna à janela anterior "JanelaSocios".

3.2. O utilizador clica no botão "Procurar" sem preencher o campo "Título".
3.2.1. O sistema apresenta a mensagem de erro ERR_PESQUISA_LIVRO_01.

4.1. O campo "Título" tem menos de 3 caracteres ou mais de 50 caracteres.
4.1.1. O sistema apresenta a mensagem de erro ERR_PESQUISA_LIVRO_02.

4.2. O campo "Título" é composto exclusivamente por espaços em branco.
4.2.1. O sistema apresenta a mensagem de erro ERR_PESQUISA_LIVRO_03.

4.3. Não foram encontrados exemplares correspondentes ao "Titulo" preenchido.
4.3.1. O sistema apresenta a mensagem de erro ERR_PESQUISA_LIVRO_04.

MENSAGENS DO SISTEMA:

ERR_PESQUISA_LIVRO_01: O campo "Título" é mandatório.
ERR_PESQUISA_LIVRO_02: O campo "Título" deve ter no mínimo 3 caracteres e no máximo 50 caracteres.
ERR_PESQUISA_LIVRO_03: O campo "Título" não pode ser composto apenas por espaços em branco.
ERR_PESQUISA_LIVRO_04: Não foram encontrados exemplares correspondentes ao "Titulo" preenchido.

Notificar por email sócio com dívidas
===============================
CAMINHO PRINCIPAL:
1. Na "JanelaSocios", o utilizador clica no checkbox "Filtrar sócios com dívidas".
2. O sistema apresenta o botão "Notificar sócios" e filtra a tabela para apenas apresentar os "Sócios" com valores em dívida.
3. O utilizador clica no botão "Notificar sócios".
4. O sistema envia email para todos os sócios com valores em dívida, com o valor que estes devem.

CAMINHOS ALTERNATIVOS:
2.1. Não há sócios com valores em dívida.
2.1.1. O sistema apresenta a mensagem de erro ERR_NOTIFICACAO_01.

3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual e retorna à janela anterior "Janela Principal".

3.2. O utilizador clica no checkbox "Filtrar sócios com dívidas" ficando unchecked.
3.2.1. O sistema bloqueia o botão "Notificar sócios" e apresenta alista completa de sócios.

4.1. O sistema encontra um erro ao enviar os emails (por exemplo, problema com o servidor de email).
4.1.1. O sistema apresenta a mensagem de erro ERR_NOTIFICACAO_02.

MENSAGENS DO SISTEMA:

ERR_NOTIFICACAO_01: Não há sócios com valores em dívida.
ERR_NOTIFICACAO_02: Ocorreu um erro ao enviar as notificações por email. Por favor, tente novamente mais tarde.

Pagar multa
=============================
CAMINHO PRINCIPAL:

1. Na "JanelaSocios", o utilizador clica no botão "Pagamentos".

2. O sistema cria e apresenta a janela "JanelaPagar" com os seguintes campos:
     Sócio, mandatório, do tipo ComboBox, com lista de sócios.
     Tipo, mandatório, do tipo ComboBox, com tipos de multas pendentes do sócio selecionado.
     Valor, mandatório, do tipo float positivo, representando o valor que o sócio pretende pagar.

3. O utilizador preenche os campos "Sócio", "Tipo" com o tipo "Multas", e "Valor", e clica no botão "Submeter".

4. O sistema valida que:
    O campo "Sócio" está preenchido.
    O campo "Tipo de Multa" está preenchido.
    O campo "Valor" está preenchido, é numérico e é inferior ou igual ao valor da dívida.
5. O sistema regista o pagamento e atualiza o valor da multa do sócio.
6. O sistema apresenta a mensagem de sucesso S03 e retorna à janela anterior "JanelaSocios".

CAMINHOS ALTERNATIVOS:
1.1. O utilizador clica no botão "Voltar".
1.1.1. O sistema fecha a janela atual "JanelaSocios" e retorna à janela "JanelaPrincipal".

3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "JanelaPagar" e retorna à janela anterior "JanelaSocios".

3.2. O utilizador clica no botão "Submeter" sem preencher o campo "Sócio".
3.2.1. O sistema apresenta a mensagem de erro ERR_PAGAR_01.

3.3. O utilizador clica no botão "Submeter" sem preencher o campo "Tipo".
3.3.1. O sistema apresenta a mensagem de erro ERR_PAGAR_02.

3.4. O utilizador clica no botão "Submeter" sem preencher o campo "Valor".
3.4.1. O sistema apresenta a mensagem de erro ERR_PAGAR_03.

3.5. O utilizador seleciona a opção "Anuidadade" no campo "Tipo".
3.5.1 O sistema realiza o caso de uso "Pagar anuidade".

4.1. O campo "Valor" inserido é maior que o valor da dívida.
4.1.1. O sistema apresenta a mensagem de erro ERR_PAGAR_04.

4.2. O campo "Valor" inserido não é numérico.
4.2.1. O sistema apresenta a mensagem de erro ERR_PAGAR_05.

MENSAGENS DO SISTEMA:

S03: Multa paga com sucesso.
ERR_PAGAR_01: O campo "Sócio" é mandatório.
ERR_PAGAR_02: O campo "Tipo" é mandatório.
ERR_PAGAR_03: O campo "Valor" é mandatório.
ERR_PAGAR_04: O valor a ser pago deve ser inferior ou igual ao valor da dívida.
ERR_PAGAR_05: O valor inserido deve ser numérico.

Pagar anuidade 
=============================
CAMINHO PRINCIPAL


1. Na "JanelaSocios", o utilizador clica no botão "Pagamentos".

2. O sistema cria e apresenta a janela "JanelaPagar" com os seguintes campos:
   Sócio, mandatório, do tipo ComboBox, com lista de sócios.
   Tipo, mandatório, do tipo ComboBox, com tipos de multas pendentes do sócio selecionado.
   Valor, mandatório, do tipo float positivo, representando o valor que o sócio pretende pagar.

3. O utilizador preenche os campos "Sócio", "Tipo" com o tipo "Anuidade", e "Valor", e clica no botão "Submeter".

4. O sistema valida que:
   O campo "Sócio" está preenchido.
   O campo "Tipo de Multa" está preenchido.
   O campo "Valor" está preenchido, é numérico e é inferior ou igual ao valor da dívida.
5. O sistema regista o pagamento e atualiza o valor da multa do sócio.
6. O sistema apresenta a mensagem de sucesso S03 e retorna à janela anterior "JanelaSocios".

CAMINHOS ALTERNATIVOS:
1.1. O utilizador clica no botão "Voltar".
1.1.1. O sistema fecha a janela atual "JanelaSocios" e retorna à janela "JanelaPrincipal".

3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "JanelaPagar" e retorna à janela anterior "JanelaSocios".

3.2. O utilizador clica no botão "Submeter" sem preencher o campo "Sócio".
3.2.1. O sistema apresenta a mensagem de erro ERR_PAGAR_01.

3.3. O utilizador clica no botão "Submeter" sem preencher o campo "Tipo".
3.3.1. O sistema apresenta a mensagem de erro ERR_PAGAR_02.

3.4. O utilizador clica no botão "Submeter" sem preencher o campo "Valor".
3.4.1. O sistema apresenta a mensagem de erro ERR_PAGAR_03.

3.5. O utilizador seleciona a opção "Multa" no campo "Tipo".
3.5.1 O sistema realiza o caso de uso "Pagar multa".

4.1. O campo "Valor" inserido é maior que o valor da dívida.
4.1.1. O sistema apresenta a mensagem de erro ERR_PAGAR_04.

4.2. O campo "Valor" inserido não é numérico.
4.2.1. O sistema apresenta a mensagem de erro ERR_PAGAR_05.

MENSAGENS DO SISTEMA:

S03: Multa paga com sucesso.
ERR_PAGAR_01: O campo "Sócio" é mandatório.
ERR_PAGAR_02: O campo "Tipo" é mandatório.
ERR_PAGAR_03: O campo "Valor" é mandatório.
ERR_PAGAR_04: O valor a ser pago deve ser inferior ou igual ao valor da dívida.
ERR_PAGAR_05: O valor inserido deve ser numérico.
