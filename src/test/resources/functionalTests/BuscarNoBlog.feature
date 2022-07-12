# language: en
  Feature: Buscar artigos no blog agi bank

    Scenario: Usuario deseja buscar palavras de uma artigo específico
      Given que o usuário esteja na homepage do blog do agi
      When ele clicar na lupa
      And inserir o termo de busca "Score Serasa"
      And clicar em Pesquisar
      Then será redirecionado para tela de resultado da busca
      And será exibido o artigo "Você sabe o que é e pra que serve o Score Serasa?"

    Scenario: Usuario deseja clicar no ícone de busca
      Given que o usuário esteja na Homepage do Blog
      When ele clicar sobre a Lupa
      Then será exibida a Ferramenta de Busca
