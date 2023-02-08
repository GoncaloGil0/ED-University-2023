# Trabalho prático de Estruturas de dados – Época de Normal

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Objetivos](#objetivos)
- [Implementação](#implementa%C3%A7%C3%A3o)
- [Iniciar o Jogo - Com o NetBeans](#iniciar-o-jogo---com-o-netbeans)
- [Extrutura dos Packages](#extrutura-dos-packages)
- [Estrutura do repositório](#estrutura-do-reposit%C3%B3rio)

## Objetivos

- Utilizar os conhecimentos sobre estruturas de dados para escolher as estruturas de dados que melhor se aplicam à resolução do problema proposto;
- Desenhar e implementar, eficaz e eficientemente, o algoritmo de resolução do problema proposto

## Implementação

- Foi utilizada a linguagem Java;
- O código foi documentado através do JavaDoc;
- Não foi utilizada nenhuma coleção da plataforma de coleções do Java

## Iniciar o Jogo - Com o NetBeans

```bash
cd C:\\${PATH_TO_THE_MAIN_CLASS_OF_THE_GAME}; "JAVA_HOME=C:\\Program Files\\Java\\jdk-18.0.2.1" cmd /c "\"C:\\Program Files\\NetBeans-14\\netbeans\\java\\maven\\bin\\mvn.cmd\" -Dexec.vmArgs= \"-Dexec.args=${exec.vmArgs} -classpath %classpath ${exec.mainClass} ${exec.appArgs}\" -Dexec.appArgs= -Dexec.mainClass=pt.ed2023.main.ED_2023 \"-Dexec.executable=C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-Dmaven.ext.class.path=C:\\Program Files\\NetBeans-14\\netbeans\\java\\maven-nblib\\netbeans-eventspy.jar\" org.codehaus.mojo:exec-maven-plugin:3.0.0:exec"
```

## Extrutura dos Packages

- pt.ed2023.dataStructures.list:
  - Contem as seguintes estruturas de dados ([Para abrir clique aqui](./src/main/java/pt/ed2023/dataStructures/list/)):
    - ArrayList
    - ArrayUnorderedList
- pt.ed2023.dataStructures.network
  - Contem as seguintes estruturas de dados ([Para abrir clique aqui](./src/main/java/pt/ed2023/dataStructures/network//)):
    - ArrayOrderedList
    - BinaryTreeNode
    - HeapNode
    - LinkedBinaryTree
    - LinkedHeap
    - LinkedNode
    - LinkedQueue
    - LinkedStack
    - MatrixGraph
    - Network
    - Pair
    - PriorityQueue
    - PriorityQueueNode
- pt.ed2023.dataStructures.execeptions
  - Contem as seguintes estruturas de dados ([Para abrir clique aqui](./src/main/java/pt/ed2023/exceptions/)):
    - ElementNotFoundException
    - EmptyCollectionException
    - NonComparableElementException
    - NullException
    - UnknownPathException
- pt.ed2023.dataStructures.gameStructures ([Para abrir clique aqui](./src/main/java/pt/ed2023/gameStructures/))
  - Caracteriza as entidades do Jogo e contem as seguintes classes:
    - Connector
    - Coordinates
    - Jogo
    - Players
    - Local
    - Portal
    - Routes
    - Team
- pt.ed2023.dataStructures.handlers 
  - Detem de todas as classes de gestão e interação com/do o jogo ([Para abrir clique aqui](./src/main/java/pt/ed2023/handlers/)):
    - apiHandler
    - fileHandler
- pt.ed2023.dataStructures.main
  - Detem da função principal do Programa ([Para abrir clique aqui](./src/main/java/pt/ed2023/main/)):
    - main

## Estrutura do repositório

- Pasta "Docs" : Contem a documentação fornecida pelos docentes da disciplina
- JavaDoc : Contem o JavaDoc do projeto ([Para abrir clique aqui](./target/site/apidocs/index.html))
- Pasta "InputFiles" : Contem os seguintes ficheiros

  - Ficheiro de importação de dados ([Para abrir clique aqui](./InputFiles/inputExemplo.json));

    ```json
        {
            "locals": [
                {
                "id": 1414,
                "type": "Portal",
                "name": "Jacqueline Kennedy Onassis Reservoir",
                "coordinates": {
                    "latitude": 40.7656918,
                    "longitude": 73.9737489
                },
                "gameSettings": {
                    "energy": 180,
                    "ownership": {
                    "player": "LoboMau"
                    }
                }
                }
            ],
            "routes": [
                {
                "from": 1414,
                "to": 5212
                }
            ],
            "Players": [
                {
                "name": "LoboMau",
                "team": "Sparks",
                "level": 5,
                "experiencePoints": 24998,
                "maxEnergy": 100,
                "currentEnergy": 70
                }
            ]
        }
    ```

  - Ficheiro resultante da exportação de dados do Jogo ([Para abrir clique aqui](./InputFiles/output.json));

    ```json
        {
            "routes": [
                {
                "from": 5212,
                "to": 1414
                }
            ],
            "players": [
                {
                "maxEnergy": 100,
                "level": 10,
                "name": "Luis",
                "experiencePoints": 24998,
                "currentEnergy": 70,
                "id": 1,
                "team": "Giants"
                }
            ],
            "locals": [
                {
                "gameSettings": {
                    "ownership": {
                    "player": 0
                    },
                    "energy": 180
                },
                "name": "Jacqueline Kennedy Onassis Reservoir",
                "coordinates": {
                    "latitude": 40.7656918,
                    "longitude": -73.9737489
                },
                "id": 1414,
                "type": "Portal"
                }
            ]
        }
    ```

  - Ficheiro resultante da exportação das rotas calculadas ([Para abrir clique aqui](./InputFiles/calculatedPaths.json));

    ```json

        {
            "calculatedPaths": [
                [{
                        "Type": "Portal",
                        "ID": 14
                    },
                    {
                        "Type": "Connector",
                        "ID": 5212
                    },
                    {
                        "Type": "Portal",
                        "ID": 1414
                    }
                ],
                [{
                        "Type": "Connector",
                        "ID": 15
                    },
                    {
                        "Type": "Portal",
                        "ID": 1411
                    },
                    {
                        "Type": "Portal",
                        "ID": 1414
                    }
                ]
            ]
        }
    ```
