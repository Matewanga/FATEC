# Sistema Secretaria Acadêmica — Emissão de Certificados

Projeto em **Java puro** (sem dependências externas) que implementa dois
padrões de projeto (design patterns) para resolver o problema da secretaria
acadêmica: emitir certificados de conclusão de forma segura e eficiente.

## Padrões de projeto utilizados

### 1. Singleton — `FilaDeImpressao`

**Problema que resolve:** só pode existir **uma única conexão** com a
impressora central. Se o sistema criasse várias filas, os documentos
sairiam misturados ou a impressora travaria.

**Como foi implementado:**
- O construtor da classe é **`private`**, ou seja, ninguém consegue criar
  a fila com `new FilaDeImpressao()` de fora da classe.
- Existe um atributo `static` que guarda a única instância já criada.
- O método público e estático `getInstancia()` é o **único ponto de
  acesso**: na primeira chamada ele cria o objeto; nas chamadas seguintes,
  ele devolve sempre o mesmo objeto já existente.
- Na `Main`, chamo `getInstancia()` duas vezes e comparo os resultados com
  `==` para provar que é sempre a mesma referência em memória.

### 2. Prototype — `Certificado`

**Problema que resolve:** a arte e os dados do curso do certificado são
"pesados" para carregar do banco de dados. Não faz sentido recarregar tudo
isso para cada aluno; o ideal é carregar uma vez e **clonar**.

**Como foi implementado:**
- A classe `Certificado` implementa a interface `Cloneable`.
- O construtor recebe apenas o **nome do curso** e simula o carregamento
  pesado da arte/layout do banco de dados (impresso no console para deixar
  visível que isso acontece só uma vez). O nome do aluno começa em branco.
- O método `clonar()` chama `super.clone()` (clonagem rasa/shallow copy
  nativa do Java), devolvendo um novo objeto **independente na memória**,
  mas com os mesmos dados (curso e arte) do original.
- `setNomeAluno()` permite personalizar cada clone individualmente, sem
  afetar o certificado original nem os demais clones.
- `getDados()` devolve o texto final pronto para impressão.

## Roteiro executado na `Main`

1. **Preparação** — obtém a instância única da `FilaDeImpressao` via
   `getInstancia()`.
2. **O Molde** — cria o `Certificado` original com `new Certificado("Engenharia de Software")`
   (nome do aluno fica em branco).
3. **A Clonagem** — usa `clonar()` duas vezes para gerar `clone1` e `clone2`.
4. **Personalização** — usa `setNomeAluno()` para dar um nome diferente a
   cada clone (`Maria Silva` e `João Souza`).
5. **Impressão** — envia `clone1.getDados()` e `clone2.getDados()` para o
   método `imprimir()` da fila única.
6. **Validação obrigatória** — imprime no console o teste
   `clone1 == clone2`, que resulta em **`false`**, provando que a
   clonagem gerou dois objetos distintos na memória (apenas com os dados
   copiados do mesmo molde).

## Estrutura do projeto

```
certificados-app/
├── README.md
└── src/
    ├── FilaDeImpressao.java   # Singleton
    ├── Certificado.java       # Prototype
    └── Main.java              # Roteiro de demonstração
```

## Como compilar e executar

Pré-requisito: JDK instalado (Java 11+).

```bash
# Dentro da pasta certificados-app
cd src
javac *.java -d ../bin
cd ../bin
java Main
```

## Saída esperada (resumo)

```
### 1) Preparação: obtendo a fila de impressão (Singleton) ###
>> [Singleton] Conexão com a impressora central estabelecida.
A fila é sempre a mesma instância? true

### 2) O Molde: criando o certificado original (Prototype) ###
>> [Prototype] Carregando arte e dados do curso "Engenharia de Software" do banco de dados...

### 3) A Clonagem: gerando dois clones a partir do original ###

### 4) Personalização: definindo o nome de cada aluno ###

### 5) Impressão: enviando os certificados para a fila única ###
--------------------------------------------------
IMPRIMINDO NA FILA ÚNICA:
Certificado de Conclusão
Curso: Engenharia de Software
Aluno: Maria Silva
Arte: Layout-Oficial-Engenharia-de-Software
--------------------------------------------------
--------------------------------------------------
IMPRIMINDO NA FILA ÚNICA:
Certificado de Conclusão
Curso: Engenharia de Software
Aluno: João Souza
Arte: Layout-Oficial-Engenharia-de-Software
--------------------------------------------------

### 6) Validação do Prototype: clone1 == clone2 ###
clone1 == clone2 -> false
(Deve ser 'false': são objetos diferentes na memória, apenas com dados clonados do mesmo molde.)
```

