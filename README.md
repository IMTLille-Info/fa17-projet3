# Groupe 2 du jeudi



```
     ___________
._____l_______l_____.
||_____/  |  \_____||
      /   |   \
     /    |    \
    /     |     \
   /      |      \
  /       |       \
 /        |        \                DESCRIPTIF ZELFA
|         |         |
 \        |        /
   \      |      /
     \    |    /
       \  |  /
         \|/
          `    

```

Chacunes des 2 équipes est composée de 5 personnages (soit 10 joueurs simultanés potentiels)
Au début de la partie, un joueur de chaques camps compose l'équipe avec les classes suivantes :
Guerrier, Sorcier, Archer, Medic.
Les classes vous serons décrites plus tard.

Les deux équipes vont se retrouver sur une carte découpée en cases (présence d'obstacles possible),
les actions se font au tour par tour, avec l'ordre des personnages choisi aléatoirement tous les 10 tours,
soit lorsque tous les champions sont passés une fois.

Il y a 4 actions possibles par les personnages :

    --> Bouger
    --> Effectuer une rotation
    --> Lancer l'attaque
    --> Passer son tour / Fin de tour

Il est possible de réaliser chacunes de ces actions une fois au maximum lors du tour, les deux seuls moyens de finir
le tours sont soit l'action "Passer son tour / Fin de tour" ou la fin du timer de XXXX secondes.

Chacuns des personnages possède une attaque spécifique à sa classe, un nombre de points de vie précis et une capacité
de déplacement. 

Gestion des joueurs si il y a mort d'un personnage ???

----------------------------------------------------------------------------------------------------------------------
    
                 /_\
                 \\\\     ___
                  \\\\   /   \        _______________________________
                   \\\\_/ \   \      /                               \
                    \     /\__/     /  Précisions mouvement, classes, \
                     \O -/          \                                 /
                  ___/ ^ \___       / _______________________________/
                     \___/         /_/
                     _/ \_
                  __//   \\__
                 /___\/_\/___\

----------------------------------------------------------------------------------------------------------------------


--> Le Guerrier : Equipé d'une épée/Bouclier il ne peut attaquer que la case devant lui, son bouclier
    lui donnant une chance sur 6 de bloquer une attaque de front lancée contre lui. Il dispose d'un nombre de 
    points de vie suppérieur à la moyenne.

--> Le Sorcier : Il a la possibilié de lancer une boule de feu dans un rayon de 4 cases autour de lui, 
    le personnage sur la case sélectionnée et ceux sur les cases adjacentes subissent des dégats. Nous noterons
    que le fait de se balader en robe a ses inconvénients ... si il prend une attaque de dos, les dégats sont doublés

--> L'Archer : Comme son nom l'indique il va réaliser ses attaques au moyen d'un arc et de flêches. il peut lancer une 
    attaque jusqu'a 5 cases en face de lui. Son agilité lui permet de se déplacer un poil plus rapidement.

--> Le Medic : C'est le soigneur de l'équipe, son attaque est remplacée par la possibilité de redonner des points de vie
    à un allié proche (Génération aléatoire entre 1 et 4) dans un rayon de 3 cases, par contre le fait de se ballader 
    sur le champs de bataille avec son appareil IRM fait qu'il se déplace plus lentement que la moyenne.



```

|----------|------|-----------|---------------------|----------------------------------------------------------|
| Guerrier |  13  |  5 cases  |  Une case frontale  | 1 chance sur 6 de parer une attaque de front             |
|----------|------|-----------|---------------------|----------------------------------------------------------|
| Sorcier  |   8  |  5 cases  |  rayon 4 cases      | Dégats de dos X2 ET attaque de zone                      |
|----------|------|-----------|---------------------|----------------------------------------------------------|
| Archer   |   9  |  6 cases  |  5 cases frontale   |                                                          |
|----------|------|-----------|---------------------|----------------------------------------------------------|
| Medic    |   7  |  3 cases  |  rayon 3 cases      | Pas d'attaque mais peu soigner un allié (Entre 1 et 4HP) |
|----------|------|-----------|---------------------|----------------------------------------------------------|
    

```


----------------------------------------------------------------------------------------------------------------------
    
                  _
                 /_\
                 \\\\     ___
                  \\\\   /   \        _______________________________
                   \\\\_/ \   \      /                               \
                    \     /\__/     /    Spécifications techniques    \
                     \O -/          \                                 /
                  ___/ ^ \___       / _______________________________/
                     \___/         /_/
                     _/ \_
                  __//   \\__
                 /___\/_\/___\

----------------------------------------------------------------------------------------------------------------------


Zelfa est un jeu multi-joueurs basé sur la technologie client-serveur.


Le client affiche la position et les PV de tous les personnages sur le plateau.
A chaque tour, le serveur envoie les nouvelles informations aux clients, qui les affiche.


