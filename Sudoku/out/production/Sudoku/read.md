📌 Passo 1: Definindo a Estrutura Básica
Antes de começar, planeje os principais componentes do jogo:

Tabuleiro (Board): Uma matriz 9x9 para armazenar os números.

Solução (Solution): Uma matriz 9x9 com a resposta correta.

Dificuldade: Define quantos números são removidos (Fácil, Médio, Difícil).

Lógica do Jogo: Verificação de regras, geração de tabuleiros e resolução.

🛠️ Passo 2: Gerando um Tabuleiro Válido
Para criar um Sudoku válido, siga estas etapas:

A) Preencher os Blocos Diagonais 3x3
Os blocos diagonais (1,1), (2,2) e (3,3) podem ser preenchidos aleatoriamente sem conflitos.

Use um método para gerar números únicos em cada bloco.

B) Resolver o Restante do Tabuleiro (Backtracking)
Use algoritmo de backtracking para preencher as células vazias:

Encontre uma célula vazia.

Tente números de 1 a 9.

Verifique se o número é válido (sem repetição na linha, coluna ou bloco).

Se válido, avance para a próxima célula.

Se nenhum número funcionar, volte (backtrack) e tente outro.

C) Remover Números para Criar o Jogo
Após gerar uma solução completa, remova números com base na dificuldade:

Fácil: Remova ~40 números.

Médio: Remova ~50 números.

Difícil: Remova ~60 números.