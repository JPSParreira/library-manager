Criar exemplar
===============================
CAMINHO PRINCIPAL:
1. O utilizador clica no botão "Adicionar Exemplar" da "Janela Principal".
2. O sistema cria e apresenta a janela "Adicionar Exemplar" com os seguintes campos:
    Título, mandatório, do tipo dropdown.
    Editora, mandatório, do tipo dropdown.
    Distribuidor, mandatório, do tipo dropdown.
    Ano, mandatório, do tipo inteiro.
    Edição, mandatório, do tipo texto.
    ISBN, mandatório, do tipo inteiro.
3. O utilizador preenche os campos Título, Editora, Distribuidor, Ano, Edição e ISBN, e clica no botão "Submeter".
4. O sistema valida que:
    O campo Título está preenchido e é válido (existente no sistema).
    O campo Editora está preenchido e é válido (existente no sistema).
    O campo Distribuidor está preenchido e é válido (existente no sistema).
    O campo Ano está preenchido, tem 4 digitos e está entre o ano 1000 e o ano atual.
    O campo Edição está preenchido, tem entre 3 e 30 caracteres e não é exclusivamente composto por espaços em branco.
    O campo ISBN está preenchido, é um inteiro positivo e tem 13 dígitos.
5. O sistema cria um novo "Exemplar", adiciona-o à lista de exemplares do sistema, apresenta a mensagem de sucesso S01 (Título = Título do exemplar), fecha a janela atual "Adicionar Exemplar" e retorna à janela anterior "Janela Principal".

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
    3.1.1. O sistema fecha a janela atual "Adicionar Exemplar" e retorna à janela anterior "Janela Principal".
3.2 O utilizador clica no botao "+" para adiconar uma nova editora.
    3.2.1 É executado o caso de uso "Criar Editora".
3.3 O utilizador clica no botao "+" para adiconar um novo distribuidor.
    3.3.1 É executado o caso de uso "Criar Distribuidor".
4.1. O campo "Título" não está preenchido.
    4.1.1. O sistema apresenta a mensagem de erro ERR_TITULO_01.
4.2. O campo "Editora" não está preenchido.
    4.2.1. O sistema apresenta a mensagem de erro ERR_EDITORA_01.
4.3. O campo "Distribuidor" não está preenchido.
    4.3.1. O sistema apresenta a mensagem de erro ERR_DISTRIBUIDOR_01.
4.4. O campo "Ano" não está preenchido.
    4.4.1. O sistema apresenta a mensagem de erro ERR_ANO_01.
4.5. O campo "Ano" não é um ano válido.
    4.5.1. O sistema apresenta a mensagem de erro ERR_ANO_02.
4.6. O campo "Ano" não tem 4 dígitos.
    4.6.1. O sistema apresenta a mensagem de erro ERR_ANO_03.
4.7. O campo "Edição" não está preenchido.
   4.7.1. O sistema apresenta a mensagem de erro ERR_EDICAO_01.
4.8. O campo "Edição" tem mais de 30 caracteres.
   4.8.1. O sistema apresenta a mensagem de erro ERR_EDICAO_02.
4.9. O campo "ISBN" não está preenchido.
   4.9.1. O sistema apresenta a mensagem de erro ERR_ISBN_01.
4.10. O campo "ISBN" não é um inteiro positivo.
   4.10.1. O sistema apresenta a mensagem de erro ERR_ISBN_02.
4.11. O campo "ISBN" não tem 13 dígitos.
    4.11.1. O sistema apresenta a mensagem de erro ERR_ISBN_03.

MENSAGENS DO SISTEMA:
S01: Exemplar <Título> adicionado com sucesso.

ERR_TITULO_01: O campo "Título" é mandatório.
ERR_EDITORA_01: O campo "Editora" é mandatório.
ERR_DISTRIBUIDOR_01: O campo "Distribuidor" é mandatório.
ERR_ANO_01: O campo "Ano" é mandatório.
ERR_ANO_02: O campo "Ano" não é válido.
ERR_ANO_03: O campo "Ano" deve ter 4 dígitos.
ERR_EDICAO_01: O campo "Edição" é mandatório.
ERR_EDICAO_02: O campo "Edição" deve ter no máximo 30 caracteres.
ERR_ISBN_01: O campo "ISBN" é mandatório.
ERR_ISBN_02: O campo "ISBN" deve ser um inteiro positivo.
ERR_ISBN_03: O campo "ISBN" deve ter 13 dígitos.

Criar titulo
===============================
CAMINHO PRINCIPAL:
1. O utilizador clica no botão "Adicionar Título" da "Janela Principal".
2. O sistema cria e apresenta a janela "JanelaCriarTitulo" com os seguintes campos:
    Título, mandatório, do tipo texto
    Autor, mandatório, do tipo texto.
    Género, mandatório, dropdown do tipo Genero.
    Subgénero, mandatório, dropdown do tipo Subgenero.
3. O utilizador preenche os campos Título, Autor, Género e Subgénero, e clica no botão "Submeter".
4. O sistema valida que:
    O campo Título está preenchido, tem entre 3 e 50 caracteres e não é exclusivamente composto por espaços em branco, é unico no sistema.
    O campo Autor está preenchido, tem entre 3 e 50 caracteres e não é exclusivamente composto por espaços em branco.
    O campo Género está preenchido e é válido.
    O campo Subgénero está preenchido e é válido.
5. O sistema cria um novo "Título", adiciona-o à lista de títulos do sistema, apresenta a mensagem de sucesso S01, fecha a janela atual "JanelaCriarTitulo" e retorna à janela anterior "Janela Principal".

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
    3.1.1. O sistema fecha a janela atual "JanelaCriarTitulo" e retorna à janela anterior "Janela Principal".
4.1. O campo "Título" não está preenchido.
    4.1.1. O sistema apresenta a mensagem de erro ERR_TITULO_01.
4.2. O campo "Título" tem menos de 3 caracteres.
    4.2.1. O sistema apresenta a mensagem de erro ERR_TITULO_02.
4.3. O campo "Título" tem mais de 50 caracteres.
    4.3.1. O sistema apresenta a mensagem de erro ERR_TITULO_03.
4.4. O campo "Título" já existe no sistema.
    4.4.1 O sistema apresenta a mensagem de erro ERR_TITULO_04.
4.5. O campo "Autor" não está preenchido.
    4.5.1. O sistema apresenta a mensagem de erro ERR_AUTOR_01.
4.6. O campo "Autor" tem menos de 3 caracteres.
    4.6.1. O sistema apresenta a mensagem de erro ERR_AUTOR_02.
4.7. O campo "Autor" tem mais de 50 caracteres.
    4.7.1. O sistema apresenta a mensagem de erro ERR_AUTOR_03.
4.8. O campo "Género" não está preenchido.
    4.8.1. O sistema apresenta a mensagem de erro ERR_GENERO_01.
4.9. O campo "Subgénero" não está preenchido.
    4.9.1. O sistema apresenta a mensagem de erro ERR_SUBGENER_01.

MENSAGENS DO SISTEMA:
S01: Título <Título> adicionado com sucesso.

ERR_TITULO_01: O campo "Título" é mandatório.
ERR_TITULO_02: O campo "Título" deve ter no mínimo 3 caracteres.
ERR_TITULO_03: O campo "Título" deve ter no máximo 50 caracteres.
ERR_TITULO_04: O Título <Título> já existe no sistema.
ERR_AUTOR_01: O campo "Autor" é mandatório.
ERR_AUTOR_02: O campo "Autor" deve ter no mínimo 3 caracteres.
ERR_AUTOR_03: O campo "Autor" deve ter no máximo 50 caracteres.
ERR_GENERO_01: O campo "Género" é mandatório.
ERR_SUBGENER_01: O campo "Subgénero" é mandatório.

Criar editora (auxiliar)
===============================
ENQUADRAMENTO: O utilizador clica no botão "+" da janela 'AdicionarTitulo' para adicionar uma nova editora.

CAMINHO PRINCIPAL:
1. O sistema cria e apresenta o dialogo "Adicionar Editora" com o campo para introdução do nome da editora, mandatório, do tipo texto.
2. O utilizador preenche o campo Nome da editora e clica no botão "Submeter".
3. O sistema valida que:
    O campo Nome está preenchido, tem entre 3 e 50 caracteres e não é exclusivamente composto por espaços em branco, é unico no sistema.
4. O sistema cria uma nova "Editora", adiciona-a à lista de editoras do sistema, apresenta a mensagem de sucesso S01 (Nome = Nome da editora), fecha o dialogo atual e retorna à janela anterior.

CAMINHOS ALTERNATIVOS:
2.1. O utilizador clica no botão "Cancel".
    2.1.1. O sistema fecha o dialogo atual "Adicionar Editora" e retorna à janela anterior.
3.1. O campo "Nome" não está preenchido.
    3.1.1. O sistema apresenta a mensagem de erro ERR_NOME_01.
3.2. O campo "Nome" tem menos de 3 caracteres.
    3.2.1. O sistema apresenta a mensagem de erro ERR_NOME_02.
3.3. O campo "Nome" tem mais de 50 caracteres.
    3.3.1. O sistema apresenta a mensagem de erro ERR_NOME_03.
3.4. O campo "Nome" já existe no sistema.
    3.4.1 O sistema apresenta a mensagem de erro ERR_NOME_04.

MENSAGENS DO SISTEMA:
S01: Editora <Nome> adicionada com sucesso.

ERR_NOME_01: O campo "Editora" é mandatório.
ERR_NOME_02: O campo "Editora" deve ter no mínimo 3 caracteres.
ERR_NOME_03: O campo "Editora" deve ter no máximo 50 caracteres.
ERR_NOME_04: O campo "Editora" já existe no sistema.

Criar distribuidor (auxiliar)
===============================
ENQUADRAMENTO: O utilizador clica no botão "+" da janela 'AdicionarTitulo' para adicionar um novo distribuidor.

CAMINHO PRINCIPAL:
1. O sistema cria e apresenta o dialogo "Adicionar Distribuidor" com o campo para introdução do nome do distribuidor, mandatório, do tipo texto.
2. O utilizador preenche o campo Nome do distribuidor e clica no botão "Submeter".
3. O sistema valida que:
    O campo Nome está preenchido, tem entre 3 e 50 caracteres e não é exclusivamente composto por espaços em branco, é unico no sistema.
4. O sistema cria um novo "Distribuidor", adiciona-o à lista de distribuidores do sistema, apresenta a mensagem de sucesso S01 (Nome = Nome do distribuidor), fecha o dialogo atual e retorna à janela anterior.

CAMINHOS ALTERNATIVOS:
2.1. O utilizador clica no botão "Cancel".
    2.1.1. O sistema fecha o dialogo atual "Adicionar Distribuidor" e retorna à janela anterior.
3.1. O campo "Nome" não está preenchido.
    3.1.1. O sistema apresenta a mensagem de erro ERR_NOME_01.
3.2. O campo "Nome" tem menos de 3 caracteres.
    3.2.1. O sistema apresenta a mensagem de erro ERR_NOME_02.
3.3. O campo "Nome" tem mais de 50 caracteres.
    3.3.1. O sistema apresenta a mensagem de erro ERR_NOME_03.
3.4. O campo "Nome" já existe no sistema.
    3.4.1 O sistema apresenta a mensagem de erro ERR_NOME_04.

MENSAGENS DO SISTEMA:
S01: Distribuidor <Nome> adicionado com sucesso.

ERR_NOME_01: O campo "Distribuidor" é mandatório.
ERR_NOME_02: O campo "Distribuidor" deve ter no mínimo 3 caracteres.
ERR_NOME_03: O campo "Distribuidor" deve ter no máximo 50 caracteres.
ERR_NOME_04: O campo "Distribuidor" já existe no sistema.

Consultar top 10 geral
===============================
CAMINHO PRINCIPAL:

1. O utilizador clica no botão "Estatisticas" na "Janela Principal".
2. O sistema cria e apresenta a janela "Estatisticas" com um lista com a informação dos 10 titulos mais empresados e ainda com os seguintes campos:
    Autor, do tipo lista.
    Género, do tipo lista.
    Subgénero, do tipo lista.
3. O utilizador clica no botão "Procurar", sem qualquer campo preenchido para obter o top 10 de titulos mais emprestados.
4. O sistema consulta a lista de titulos e verifica quais os 10 titulos mais emprestados, e atualiza a lista de titulos.

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
    3.1.1. O sistema fecha a janela atual "Estatisticas" e retorna à janela anterior "Janela Principal".
3.2 O utilizador preenche o campo Autor e clica no botão "Procurar".
    3.2.1 É executado o caso de uso "Consultar top 10 por autor".
3.3 O utilizador preenche o campo Género e clica no botão "Procurar".
    3.3.1 É executado o caso de uso "Consultar top 10 por genero".
3.4 O utilizador preenche o campo Subgénero e clica no botão "Procurar".
    3.4.1 É executado o caso de uso "Consultar top 10 por subgenero".

Consultar top 10 por autor (auxiliar)
===============================
ENQUADRAMENTO: O utilizador preenche o campo Autor e clica no botão "Procurar".

CAMINHO PRINCIPAL:
1. O sistema a lista de titulos do autor introduzido. Posteriormente, verifica quais os 10 titulos mais emprestados dessa lista, e atualiza a lista de titulos.

CAMINHOS ALTERNATIVOS:
1.1 Não existem titulos do autor introduzido.
    1.1.1 O sistema apresenta a mensagem de erro ERR_AUTOR_01.

MENSAGENS DO SISTEMA:
ERR_AUTOR_01: Não existem titulos do autor introduzido.

Consultar top 10 por genero (auxiliar)
===============================
ENQUADRAMENTO: O utilizador preenche o campo Género e clica no botão "Procurar".

CAMINHO PRINCIPAL:
1. O sistema consulta a lista de titulos e seleciona apenas os titulos do genero introduzido. Posteriormente, verifica quais os 10 titulos mais emprestados dessa lista, e atualiza a lista de titulos.

CAMINHOS ALTERNATIVOS:
1.1 Não existem titulos do genero introduzido.
    1.1.1 O sistema apresenta a mensagem de erro ERR_GENERO_01.

MENSAGENS DO SISTEMA:
ERR_GENERO_01: Não existem titulos do genero introduzido.

Consultar top 10 por subgenero (auxiliar)
===============================
ENQUADRAMENTO: O utilizador preenche o campo Subgénero e clica no botão "Procurar".

CAMINHO PRINCIPAL:
1. O sistema consulta a lista de titulos e seleciona apenas os titulos do subgenero introduzido. Posteriormente, verifica quais os 10 titulos mais emprestados dessa lista, e atualiza a lista de titulos.

CAMINHOS ALTERNATIVOS:
1.1 Não existem titulos do subgenero introduzido.
    1.1.1 O sistema apresenta a mensagem de erro ERR_SUBGENER_01.

MENSAGENS DO SISTEMA:
ERR_SUBGENER_01: Não existem titulos do subgenero introduzido.