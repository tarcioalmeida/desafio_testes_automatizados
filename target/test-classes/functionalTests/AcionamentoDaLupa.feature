# language: en
  Feature: Exibir ícone de busca na homepage do blog do agi

    Scenario: Usuario deseja clicar no ícone de busca
      Given que o usuário esteja na Homepage do Blog do Agi
      When ele clicar na Lupa
      Then será exibida a Ferramenta de Busca
