# 🧩 Padrões de Projeto Orientados a Objetos  
## Prática – Padrão Strategy (Pesquisa na Web)

### 👩‍💻 Autoras
**Alexia Alves**  
**Maria Vitória Melo**

---

## 📘 Descrição da Questão

O exercício propôs adaptar um mecanismo de busca simulado para aplicar o **Padrão Strategy** em conjunto com o **Padrão Observer**.  
O código original notificava todos os observadores a cada consulta, sem aplicar nenhum tipo de filtragem.  
Nosso objetivo foi:

- Criar uma **interface de estratégia de filtro** (`QueryFilterStrategy`);
- Fazer com que o modelo de busca (`WebSearchModel`) utilize a Strategy antes de notificar cada observer;
- Implementar **duas estratégias concretas**:
  - `FriendQueryFilter`: notifica consultas que contenham a palavra “friend” (sem diferenciar maiúsculas/minúsculas);
  - `LongQueryFilter`: notifica consultas com mais de 60 caracteres;
- Criar **Observers especializados** para formatar a saída conforme o enunciado:
  - `FriendQueryObserver` → imprime “Oh Yes! <consulta>”
  - `LongQueryObserver` → imprime “So long... <consulta>”

O resultado final combina os padrões **Strategy + Observer**, com separação clara de responsabilidades, alta coesão e baixo acoplamento.

---

## 🧠 Uso da Inteligência Artificial (IA)

Durante o desenvolvimento, a IA foi utilizada em etapas específicas para sugerir a estrutura e ajustes de implementação.  
Todos os prompts, respostas e decisões foram documentados nos commits correspondentes, feitos na **branch master**.

### 🪶 Prompt 1 – Adaptação do WebSearchModel
> **Objetivo:** Modificar a classe `WebSearchModel` para suportar o padrão Strategy.  
> **Solução sugerida pela IA:**
> 1. Criar a interface `QueryFilterStrategy` com o método `isInteresting(String query)`.  
> 2. Alterar `addQueryObserver` para aceitar também uma Strategy.  
> 3. Modificar `notifyAllObservers` para usar a Strategy antes de notificar o Observer.  
>  
> ✅ **Resultado:** Implementação funcional sem necessidade de ajustes manuais.

---

### 🪶 Prompt 2 – Criação das Estratégias de Filtro (Friend e LongQuery)
> **Objetivo:** Implementar classes concretas que aplicam as regras de filtragem.  
> **Solução sugerida pela IA:**
> - Criar `FriendQueryFilter` (contém “friend”, ignorando maiúsculas/minúsculas).  
> - Criar `LongQueryFilter` (consultas com mais de 60 caracteres).  
>  
> **Justificativa:**  
> A criação dessas classes concretas (Strategy Concreta) isolou as regras de filtragem, aumentando a **flexibilidade e manutenibilidade** do código.  
>  
> ✅ **Resultado:** A IA entregou o código exatamente como desejado.

---

### 🪶 Prompt 3 – Criação dos Observers Concretos
> **Objetivo:** Criar observadores especializados que imprimam a saída com a formatação exigida.  
> **Solução sugerida pela IA:**
> - `FriendQueryObserver` → imprime “Oh Yes! …”  
> - `LongQueryObserver` → imprime “So long… …”  
>  
> **Justificativa:**  
> Essa abordagem garante **separação total de responsabilidades**:  
> o Strategy filtra e o Observer formata a saída.  
>  
> ✅ **Resultado:** Nenhum ajuste adicional foi necessário.

---

### 🪶 Prompt 4 – Configuração Final (Main e Snooper)
> **Objetivo:** Ajustar `Main.java` para usar os novos componentes e remover redundâncias.  
> **Solução sugerida pela IA:**
> 1. Registrar os pares `(FriendQueryObserver, FriendQueryFilter)` e `(LongQueryObserver, LongQueryFilter)`.  
> 2. Remover `new Snooper(model);` do `Main`.  
> 3. Limpar a lógica de registro em `Snooper.java`.  
>  
> **Justificativa:**  
> Esse commit conclui o projeto, garantindo **desacoplamento completo** e centralizando a montagem do grafo de objetos no cliente.  
>  
> ✅ **Resultado:** Implementação final validada com sucesso.

---

## 🧩 Histórico de Commits Principais (Branch master)

| Data | Commit | Descrição |
|------|---------|-----------|
| 06/10/2025 | `85e4587` | Adicionando código inicial e arquivos base da Questão 1 |
| 06/10/2025 | `5027e6e` | Modificando `WebSearchModel` para aplicar o padrão Strategy |
| 06/10/2025 | `9fddbb3` | Adicionando estratégias de filtro `FriendQueryFilter` e `LongQueryFilter` |
| 06/10/2025 | `134abc0` | Criando Observers concretos para formatação de saída |
| 06/10/2025 | `c596ef1` | Adicionando arquivo `Hamlet.txt` |
| 07/10/2025 | `73e3536` | Configurando `Main.java` e finalizando o padrão Strategy |

> ⚙️ Outros commits menores foram realizados para ajustes de compatibilidade e refinamento da execução.
