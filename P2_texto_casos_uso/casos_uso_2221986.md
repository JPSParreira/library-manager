Criar exemplar
===============================
CAMINHO PRINCIPAL:
1. Na "Janela Principal", o utilizador clica no botão "Adicionar Exemplar".
2. O sistema cria e apresenta a janela "Adicionar Exemplar" com os seguintes campos:
    Título, mandatório, do tipo dropdown.
    Editora, mandatório, do tipo dropdown.
    Distribuidor, mandatório, do tipo dropdown.
    Ano, mandatório, do tipo inteiro positivo.
    Edição, mandatório, do tipo texto, com mínimo de 3 caracteres e máximo de 30.
    ISBN, mandatório, do tipo inteiro positivo, com 13 dígitos.
3. O utilizador preenche os campos Título, Editora, Distribuidor, Ano, Edição e ISBN, e clica no botão "Submeter".
4. O sistema valida que:
    O campo Título está preenchido e é válido.
    O campo Editora está preenchido e é válido.
    O campo Distribuidor está preenchido e é válido.
    O campo Ano está preenchido e é um inteiro positivo.
    O campo Edição está preenchido, tem entre 3 e 30 caracteres e não é exclusivamente composto por espaços em branco.
    O campo ISBN está preenchido, é um inteiro positivo e tem 13 dígitos.
5. O sistema cria um novo "Exemplar", adiciona-o à lista de exemplares do sistema, apresenta a mensagem de sucesso S01 (Título = Título do exemplar), fecha a janela atual "Adicionar Exemplar" e retorna à janela anterior "Janela Principal".

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "Adicionar Exemplar" e retorna à janela anterior "Janela Principal".

3.2 O utilizador clina no botao "+" para adiconar uma nova editora.
3.2.1 É executado o caso de uso "Criar Editora".

3.3 O utilizador clina no botao "+" para adiconar um novo distribuidor.
3.3.1 É executado o caso de uso "Criar Distribuidor".

4.1. O campo "Título" não está preenchido.
4.1.1. O sistema apresenta a mensagem de erro ERR_TITULO_01.

4.2. O campo "Editora" não está preenchido.
4.2.1. O sistema apresenta a mensagem de erro ERR_EDITORA_01.

4.3. O campo "Distribuidor" não está preenchido.
4.3.1. O sistema apresenta a mensagem de erro ERR_DISTRIBUIDOR_01.

4.4. O campo "Ano" não está preenchido.
4.4.1. O sistema apresenta a mensagem de erro ERR_ANO_01.

4.5. O campo "Ano" não é um inteiro positivo.
4.5.1. O sistema apresenta a mensagem de erro ERR_ANO_02.

4.6. O campo "Edição" não está preenchido.
4.6.1. O sistema apresenta a mensagem de erro ERR_EDICAO_01.

4.7. O campo "Edição" tem menos de 3 caracteres.
4.7.1. O sistema apresenta a mensagem de erro ERR_EDICAO_02.

4.8. O campo "Edição" tem mais de 30 caracteres.
4.8.1. O sistema apresenta a mensagem de erro ERR_EDICAO_03.

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
ERR_ANO_02: O campo "Ano" deve ser um inteiro positivo.
ERR_EDICAO_01: O campo "Edição" é mandatório.
ERR_EDICAO_02: O campo "Edição" deve ter no mínimo 3 caracteres.
ERR_EDICAO_03: O campo "Edição" deve ter no máximo 30 caracteres.
ERR_ISBN_01: O campo "ISBN" é mandatório.
ERR_ISBN_02: O campo "ISBN" deve ser um inteiro positivo.
ERR_ISBN_03: O campo "ISBN" deve ter 13 dígitos.

Criar titulo
===============================
CAMINHO PRINCIPAL:
1. Na "Janela Principal", o utilizador clica no botão "Adicionar Título".
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
5. O sistema cria um novo "Título", adiciona-o à lista de títulos do sistema, apresenta a mensagem de sucesso S01 (Título = Título do título), fecha a janela atual "JanelaCriarTitulo" e retorna à janela anterior "Janela Principal".

CAMINHOS ALTERNATIVOS:
3.1. O utilizador clica no botão "Voltar".
3.1.1. O sistema fecha a janela atual "JanelaCriarTitulo" e retorna à janela anterior "Janela Principal".

4.1. O campo "Título" não está preenchido.
4.1.1. O sistema apresenta a mensagem de erro ERR_TITULO_01.

4.2. O campo "Título" tem menos de 3 caracteres.
4.2.1. O sistema apresenta a mensagem de erro ERR_TITULO_02.

4.3. O campo "Título" tem mais de 50 caracteres.
4.3.1. O sistema apresenta a mensagem de erro ERR_TITULO_03.

4.4. O campo "Autor" não está preenchido.
4.4.1. O sistema apresenta a mensagem de erro ERR_AUTOR_01.

4.5. O campo "Autor" tem menos de 3 caracteres.
4.5.1. O sistema apresenta a mensagem de erro ERR_AUTOR_02.

4.6. O campo "Autor" tem mais de 50 caracteres.
4.6.1. O sistema apresenta a mensagem de erro ERR_AUTOR_03.

4.7. O campo "Género" não está preenchido.
4.7.1. O sistema apresenta a mensagem de erro ERR_GENERO_01.

4.8. O campo "Subgénero" não está preenchido.
4.8.1. O sistema apresenta a mensagem de erro ERR_SUBGENER_01.

4.9 O campo "Título" já existe no sistema.
4.9.1 O sistema apresenta a mensagem de erro ERR_TITULO_04.

MENSAGENS DO SISTEMA:
S01: Título <Título> adicionado com sucesso.

ERR_TITULO_01: O campo "Título" é mandatório.
ERR_TITULO_02: O campo "Título" deve ter no mínimo 3 caracteres.
ERR_TITULO_03: O campo "Título" deve ter no máximo 50 caracteres.
ERR_TITULO_04: O campo "Título" já existe no sistema.
ERR_AUTOR_01: O campo "Autor" é mandatório.
ERR_AUTOR_02: O campo "Autor" deve ter no mínimo 3 caracteres.
ERR_AUTOR_03: O campo "Autor" deve ter no máximo 50 caracteres.
ERR_GENERO_01: O campo "Género" é mandatório.
ERR_SUBGENER_01: O campo "Subgénero" é mandatório.


Criar distribuidor
Consultar top 10 geral
Consultar top 10 por autor
Consultar top 10 por genero
Consultar top 10 por subgenero