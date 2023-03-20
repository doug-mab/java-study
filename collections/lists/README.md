# Lists no Java

As Lists, como deve imaginar, é uma coleção ordenada de elementos. Esses elementos podem variar em tipos de dados diferentes, como String, int, long, boolean e classes.

**Tabela de tópicos:**
*  	[Apresentando Arrays](#apresentando-arrays)
*   [ArrayList](#arraylist)
*	[LinkedList](#linkedlist)
*	[ArrayList vs LinkedList](#arraylist-vs-linkedlist)
*	[Iterando por uma lista](#iterando-por-uma-lista)
*	[Comparators](#comparators)
	-	[Ordem Natural](#ordem-natural)
*	[Imutabilidade](#imutabilidade)


## Apresentando Arrays

Criamos uma array usando desse jeito:

```java
String[] strArr = new String[3];

strArr[0] = "Hello World"
```

Para definir que o tipo da variável é uma array, é preciso adicionar os colchetes após o type, no exemplo fizemos uma array de Strings com `String[]`, mas poderia ser qualquer outro tipo.

Após a declaração da variável, criamos a array com o `new String[3]`, o número entre os colchetes é a largura da array, em outras palavras, quantos elementos cabem nessa array.

**OBS.:** Uma forma alternativa, caso você já tenha os elementos que irá adicionar à array, seria:

```java
int[] intArr = {4, 8, 6, 4};
```

Isso criaria uma array com 4 de largura com os elementos dados nessas mesmas posições.

Para acessar os elementos, ou como chamamos, o **index** de uma array, chamamos a variável com o index que queremos entre colchetes (`strArr[0]`).

Desse jeito, é como se ao chamar `strArr[0]`, eu estivesse chamando outra variável, então podemos manipular esse valor como bem entendermos. no exemplo dado, estamos definindo o index 0 como "Hello World". Qualquer outro valor não definido manualmente será `null`.

```java
strArr[0] // "Hello World"
strArr[1] // null
strArr[2] // null
```

Talvez você tenha notado que ao criar a array, definimos a largura (ou dimensão) dela como 3 espaços, mas no exemplo só fomos até o index 2. Isso é porque a programação usa algo chamado **zero-based numbering** (também já ouvi ser chamado de **zero-index**), significa que o primeiro index não é o 1, e sim o 0. A largura da array é de 3, mas o primeiro index é o 0, então se fizer os cálculos, o ultimo item da array vai ser largura - 1, ou seja, 2.

Você também pode acessar a largura da array com o atributo `length`, que retorna a largura em int.

Você pode usar isso para iterar pela array e manipular todos os elementos, como por exemplo:

```java
// isso leria mais ou menos como
// variável "i" do tipo int é igual a 0, enquanto "i" for menor que largura da array strArr, adicione 1 ao "i"
for (int i = 0; i < strArr.length; i++) {
    System.out.println(strArr[i]);
    }
}
```

Caso você tente acessar um index fora da largura da array, você vai receber uma excessão `IndexOutOfBoundsException`

O problema das arrays tradicionais é que você está preso à largura que você escolheu, você até poderia criar uma nova array maior e passar esses elementos para ela, mas isso seria trabalhoso e repetitivo toda vez que você precisasse de mais espaço.

Além disso, não podemos acessar apenas as posições que estão ocupadas, recebemos a largura total da array sempre que usamos `length`.

É agora que entramos nas **Lists**

## ArrayList

O **ArrayList** é um tipo de coleção implementado da interface **List**, seu intuito é ser uma array dinâmica, e o limite de sua largura é a memória do seu PC. Além disso, as Lists apresentam novas facilidades como organizadores, procuradoes, filtros (através de streams) e [outros](https://docs.oracle.com/javase/8/docs/api/java/util/List.html "Interface List<E>").

**ArrayList** também usa arrays por baixo dos panos, digamos que ao criar uma ArrayList, você comece com 10 de largura. Você já preencheu esses 10 espaços e precisa adicionar mais 1, ao pedir para classe adicionar mais 1, a classe vai realocar um espaço na memória com mais espaço e copiar todos os elementos para esse novo local na memória.

A classe tem suas vantagens e desvantagens que iremos discutir em um [tópico separado](#arraylist-vs-linkedlist "ArrayList vs LinkedList").

Então, vamos lá! A classe vem do package **java.util.ArrayList**, assim como todas as outras classes que vamos usar nesse documento.

Para criar uma **ArrayList**, fazemos assim:

```java
List<String> arrList = new ArrayList<>();
```

Ao declarar a variável, usamos o tipo `List<String>`. Essas setas envolvendo o tipo String (realmente esqueci o nome desses símbolos enquanto escrevo isso) é o que chamamos de **Generics**, talvez você possa ter visto isso como `<T>`. Para resumir, o tipo passado nesse Generic será o tipo dos elementos da **ArrayList** (como se você estivesse escrevendo String[]), lembrando que os elementos também podem ser `null`.

Mais sobre Generics no [DevMedia](https://www.devmedia.com.br/usando-generics-em-java/28981 "Usando Generics em Java").

Talvez você tenha estranhado que estamos definindo o tipo da variavel como **List** ao invés de **ArrayList**. Também falaremos disso em um [tópico separado](#arraylist-vs-linkedlist "ArrayList vs LinkedList").

Diferente das arrays tradicionais, iremos acessar e manipular nossos elementos através de métodos.

```java
arrList.add("Hello World"); // Adiciona um elemento ao final da array
arrList.get(0); // Hello World
arrList.set(0, "How have you been?"); // vai definir o valor do index dado com o valor que foi passado
arrList.get(0); // How have you been?
arrList.add("Eu serei removido");
arrList.remove(1); // Remove o elemento do index dado
```

Você também pode acessar a largura da **ArrayList** através do método `size()`, e diferente das arrays tradicionais, ele vai retornar a quantidade de posições ocupadas, ao invés de todas as posições.

Existem outros métodos como `replaceAll()`, `contains()`, `clear()`, entre outros. Sinta-se livre para explorar a [documentação](https://docs.oracle.com/javase/8/docs/api/java/util/List.html "Interface List<E>") e descobrir novos métodos e utilidades.

## LinkedList
**LinkedList** usa os mesmos métodos da classe **ArrayList** pois ambos são implementações da interface **List**, o que muda entre um e outro é como ambos funcionam.

(Espero que entendam minhas ilustrações, estou bem longe de ser um designer ksks)
<img src="./images/array-list.png" width="400px" alt="Representação de um ArrayList" title="Representação de um ArrayList" /> 

Como podemos ver, uma **ArrayList** tem seu elemento posicionado por um index, e é diretamente por esse index que acessamos esse elemento.

<img src="./images/linked-list.png" width="600px" alt="Representação de um LinkedList" title="Representação de um LinkedList" /> 

Já no LinkedList seguimos uma corrente de elementos. O elemento com o HEAD é o primeiro elemento dessa lista, e todos os elementos sabem quem é seu elemento sucessor e antecessor, e o último elemento tem `null` como seu sucessor.

Diferente do ArrayList que acessamos o elemento correspondente ao index, apesar de acessarmos um elemento através de um index, na verdade ele está iterando entre os elementos até chegar na posição que desejamos.

É um loop de o elemento atual acessando o seu próximo elemento até chegarmos na posição que pedimos. Mas todo esse processo parece ser lento, então qual é a vantagem disso?

## ArrayList vs LinkedList

Ambos tem seus casos de uso.

Apesar de **ArrayList** ser de fácil acesso aos elementos, ele tem um desempenho não muito satisfatório quando falamos de removeção de elementos.

Digamos que precisamos remover o elemento correspondente ao index 2 da nossa **ArrayList**.

<img src="./images/array-list-remove.png" width="600px" alt="Processo de reposicionamento de uma ArrayList" title="Processo de reorganização de um ArrayList" /> 

Para não deixar um index vazio no meio da Array, a classe vai começar a reposicionar os elementos para preencher esse espaço vazio sem alterar sua ordem.

Esse processo em uma **ArrayList** grande vai ser bem custoso, e quanto menor for o index, mais reposicionamentos a **ArrayList** vai ter que fazer.

Já na **LinkedList**, esse processo é muito mais simples.

<img src="./images/linked-list-remove.png" width="600px" alt="Processo de reposicionamento de uma LinkedList" title="Processo de reorganização de um LinkedList" /> 

Baseado na imagem, o que acontece é que quando removemos o elemento na posição 2 da **LinkedList***, ele vai chegar na posição anterior (posição 1) e falar: "Seu sucessor não é mais o Item 492 (posição 2), agora é o Item 016 (posição 3)". A mesma coisa é feita na posição seguinte do elemento removido, avisando que seu elemento antecessor foi mudado.

Desse jeito, podemos fazer remoções e adições de elementos nas posições menores. Mas esse processo pode ser menos eficiente de acordo que as posições alteradas são mais altas, já que como vimos, o **LinkedList** precisa iterar por cada elemento até chegar na posição desejada.

Então se você não vai remoções ou adições de elementos em posições baixas na lista, use **ArrayList** por seu fácil acesso aos elementos.

Caso você precisa fazer remoções e adições de elementos em posições baixas na lista, então é recomendado usar **LinkedList** por sua fácil manipulação de elementos.

Mas caso você não esteja certo, você pode testar os 2 sem fazer muita manutenção usando **polimorfismo**.

Como vimos mais cedo, declaramos uma variável como **List** ao invés de **ArrayList** ou **LinkedList** pois ambos compartilham dos mesmos métodos da interface **List**. Em casos assim, sempre é uma boa prática usar o tipo mais genérico possível para cada caso, pois assim você poupa dores de cabeça mais na frente.

Java saber se a lista é **ArrayList** ou **LinkedList** não importa, o que importa é que as duas fazem as mesmas operações e retornam os mesmos resultados, apenas fazem isso de jeitos diferentes.

Então caso você sinta que seu processo está meio lento em relação as listas, tente mudar para outro tipo de lista.

## Iterando por uma lista

Há várias maneiras no Java de fazer a mesma coisa, um bom exemplo disso é a variedade de maneiras que você pode iterar por uma lista

O jeito mais tradicional é usando `while` ou `for` através do `size()` da lista:

```java
// Usando while
int i = 0;
while (i < arrList.size()) {
    arrList.get(i);
    i++;
}

// Usando for
for (int j = 0; j < arrList.size(); j++) {
    arrList.get(j);
}
```

Existe um jeito mais comprimido de iterar usando `for` chamado de **enhanced-for**, adicionado no Java 5:

```java
for (String str : arrList) {
    System.out.println(str);
}
```

Indo por etapas, a sintaxe é formada assim: `(tipo nomeDaVar : List)`. Esse `nomeDaVar` é a variável que vai armazenar o valor daquele index da lista que o `for` está iterando, e o tipo dessa variável deve ser o mesmo tipo da **List**.

No Java 8, foi adicionado o método `ForEach()` nas listas, esse método recebe um **Consumer** como argumento, mas se você só for usar essa iteração uma vez, então é melhor você simplesmente usar um [Lambda](https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826 "Como usar funções lambda em Java").

```java
arrList.forEach(str -> System.out.println(str));
```

## Comparators

No Java, assim como outras linguagens de programação, nos permite reordernar nossas listas como bem entendermos.

Esses métodos já são nativos, então não precisamos criar nosso próprio algoritmo de ordenação para isso.

A classe **Collections** (java.util.Collections) está no topo da hierarquia, é papai de **List**, que é papai de **ArrayList** e **LinkedList**, **Vector** e outros. Com essa classe, podemos fazer várias operações através de métodos estáticos.

Para fazer comparações, usaremos o `Collections.sort()`, existem 2 usos deste método:

O primeiro é apenas recebendo uma **List** como argumento, falaremos dele depois.

O segundo é recebendo uma **List** e um **Comparator**.

**Comparator<T>** (java.util.Comparator) é uma interface de comparação que adiciona o método `compare(T t1, T t2)`, esse método compara `t1` com `t2` (`T` é o tipo do parâmetro). Existem alguns critérios de retorno, vamos usar comparação de números como exemplo.

Se o numero `t1` for menor que o número `t2`, ou seja, estiver numa posição inferior, o método deve retornar um número negativo.

Se o número `t1` for maior que o número `t2`, ou seja, estiver numa posição superior, o método deve retornar um número positivo.

Se o número `t1` e `t2` forem iguais, então o método deve retornar 0.

Vamos ver isso na prática:

```java
class MeuComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer n1, Integer n2) {
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }    
}
```

Meio grande, não é? Se devemos retornar positivo se `n1` for maior, negativo se `n1` for menor e 0 se ambos forem iguais, então por que a gente não reescreve esse método assim?

```java
class MeuComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer n1, Integer n2) {
        return n1 - n2;
    }
}
```

Tudo bem, funciona com números. Mas e com Strings?

Quem tem um histórico em JavaScript sabe que é possivel comparar a ordem de duas strings usando os operadores matemáticos de comparação > e <, mas isso não é possivel no Java, que é uma linguagem fortemente tipada.

Então como fariamos isso? Teriamos que gerar uma Array de characteres da String e comparar 1 por 1 entre as duas para ordenar na ordem alfabética? Acredito que seria possível, mas muito trabalhoso.

Mas Java tem seus próprios métodos para resolver isso, os objetos do Java são implementações da classe **Comparable<T>**, que adiciona o método `compareTo()`. Esse método irá comparar o objeto em que está sendo chamado com um objeto dado, retornando negativo, positivo ou 0.

Se fossemos comparar 2 Strings, simplesmente usariamos o método `compareTo()` dentro do **Comparator**.

```Java
class MeuComparatorString implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
```
Para podermos usar esse **Comparator** em uma **List**, usariamos aquele método que mencionamos do **Collections**

```java
List<String> strList = new ArrayList<>();
strList.add("Laranja");
strList.add("Ameixa");
strList.add("Cacau");

System.out.println(strList); // [Laranja, Ameixa, Cacau]

Collections.sort(strList, new MeuComparatorString());

System.out.println(strList); // [Ameixa, Cacau, Laranja]
```

Assim como falamos sobre o Consumer, não tem necessidade de criar uma classe exclusiva para 1 uso, podemos resolver isso com um **Lambda**.

```java
Collections.sort(strList, (s1, s2) -> s1.compareTo(s2));
```

### Ordem Natural

No Java, temos o que chamamos de Ordem Natural que podemos implementar em nossas classes para poder fazer uma **ordenação padrão**.

Objetos do Java, como a String por exemplo, já tem sua ordem natural, então se fizermos algo como
```java
Collections.sort(strList);
```
Java automaticamente iria ordenar essa lista de String na ordem alfabética, mas o Java não sabe como deve organizar nossas classes criadas.

Para fazermos isso, devemos implementar a interface **Comparable<T>** à nossa classe, que adiciona o método `compareTo()` (o mesmo método que usamos com as Strings).

Dentro desse método, devemos escrever nossa lógica de organização. Essa lógica será usada sempre que usarmos um `Collections.sort` sem um Comparator.

```java
class Client implements Comparable<String> {
    public String nome;
    public int idade;
    
    @Override
    public int compareTo(String s) {
        return this.nome.compareTo(s.nome).
    }
}
```

Essa ordem natural recebe o nome como critério de ordenação, mas poderiamos fazer por idade também.

[Exemplo de uma classe comparável](./src/br/com/lists.test/Book.java "Book.java").

No Java 8 foi adicionado o método `sort()` à interface **List**. ela recebe um **Comparator** como argumento e faz o mesmo que o `Collections.sort()` faz.

```java
strList.sort((s1, s2) -> s1.compareTo(s2));
```

Caso queira usar a ordem natural da lista, o valor a ser passado para o `sort()` deve ser `null`. Mas isso é um pouco feio, então nesses casos é melhor usar `Collections.sort()`.

## Imutabilidade

Quando trabalhamos com classes que tem listas como atributos, é sempre importante ficar de olho na imutabilidade dessas listas para os outros fora da classe

Digamos que temos uma classe `Turma`

```java
class Turma {
    private int numero;
    private List<Aluno> alunos;
    
    public Turma(int numero, List<Aluno> alunos) {
        this.numero = numero;
        this.alunos = alunos;
    }
    
    public int getNumero() {
        return this.numeroDaTurma;
    }
    
    public List<Aluno> getAlunos() {
        return this.alunos;
    }
}
```

Uma instância dessa turma tem o número `3001` e 6 `Alunos`, mas perceba que com o método `getAlunos()` todos tem acesso a essa lista, e podem manipular ela como bem entenderem. Isso é ruim pois pode causar problemas mais pra frente, ainda mais se você trabalha em equipe. Para evitar isso, devemos definir nós mesmos o que essas pessoas podem fazer com essas listas.

Primeiramente, devemos fazer com que essa lista seja imutável para o acesso de fora.

```java
public List<Aluno> getAlunos() {
    return Collections.unmodifiableList(this.alunos);
}
```

O método `Collections.unmodifiableList(List list)` retorna uma versão não imutável de uma lista, então é como se ela fosse apenas para leitura, qualquer alteração que o desenvolvedor tentar será lançado a exceção `UnsupportedOperationException`.

Agora podemos criar métodos que fazem apenas operações que queremos que seja livre, como por exemplo:

```java
public boolean add(Aluno aluno) {
    if (aluno == null) {
        return false;
    }
    return this.alunos.add(aluno);
}
```
Podemos aproveitar esses métodos para dar alguma verificação antes de fazer a operação, no exemplo acima, criei um métodod `add()` que adiciona um aluno para lista apenas quando o aluno não é `null`.