# Application Entrevoisins
## _Objectif de l'application_

Entrevoisins permet à des personnes d’un même quartier de se rendre des petits services : garde d’animaux, petit bricolage, troc d’objets, cours particuliers, de nombreuses options s’offrent aux utilisateurs !

- garde d’animaux
- petit bricolage
- cours particuliers...

## Identification du projet et de la mission

_Nom et nature_ : Développement d’une nouvelle fonctionnalité pour l’application Entrevoisins.

_Origine_ : Collecte de retours utilisateurs amenant au développement d’une nouvelle fonctionnalité pour l'application Entrevoisins.

_Enjeu_ : Améliorer l’expérience utilisateur.

## Analyse des fonctionnalités

> lister mes voisins

> ajouter un voisin

> suppression d’un voisin

## Cadrage des fonctionnalités implémentés
_Au clic sur un utilisateur, nouvel écran avec :_
 
 ● un bouton de retour à l'élément précédent
 
 ● l'avatar de l'utilisateur
 
 ● le nom de l'utilisateur
 
 ● un bouton d’ajout du voisin à la liste de favoris
 
 ● un onglet Favoris dans lequel les utilisateurs marqués comme favoris s’affichent.

## Tests unitaires et instrumentalisées implémentés

● Phase 1 : Développement de la fonctionnalité en suivant le cadrage.

● Phase 2 : Réalisation de 3 tests instrumentalisés :

> test vérifiant que lorsqu’on clique sur un élément de la liste, l’écran de
détails est bien lancé.

> test vérifiant qu’au démarrage de ce nouvel écran, le TextView indiquant
le nom de l’utilisateur en question est bien rempli.

> test vérifiant qu’au clic sur le bouton de suppression, la liste d’utilisateurs
compte bien un utilisateur en moins.

> test vérifiant que l’onglet Favoris n’affiche que les voisins marqués comme
favoris.

● Phase 3 : Création d’un test unitaire pour chaque fonctionnalité

_Fichier tests unitaire_:  NeighbourServiceTest.java (Entrevoisins-main\Entrevoisins\app\src\test\java\com\openclassrooms\entrevoisins\service\NeighbourServiceTest.java)

_Fichier tests instrumentalisés_: NeighboursListTest.java (Entrevoisins-main\Entrevoisins\app\src\androidTest\java\com\openclassrooms\entrevoisins\neighbour_list\NeighboursListTest.java)

# Langage et EDI
 Java, Android Studio 4.1.3 ( disponible à cette adresse https://developer.android.com/studio )

## Installation, exécution et compilation

Entrevoisins peut s'exécuter à partir d'Android studio via émulateur ou sur smartphone physique
Vous pouvez cliquer sur la flèche verte dans la barre d'icônes ou bien passer par le menu Run et l'option Run... raccourcis Alt+Maj+F10

