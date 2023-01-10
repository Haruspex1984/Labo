# Labo

J'ai tenté d'écrire mon code en respectant le design MVC.
C'était sans doute ce qui m'a posé le plus de problèmes : où mettre quoi ?
Je devais parfois appeler une méthode quelque part alors que ce que j'avais pensé mettre en paramètre de cette méthode n'était pas initialisé dans la classe appelante.

Le programme consiste en une Map qui contient des activités, qui elles-même contiennent une liste de personnes.
J'ai créé un contrôleur général qui est une suite de menu imbriqués les uns dans les autres et qui appellent les méthodes contenues dans les autres contrôleurs.
L'un gère les activités, l'autre le calendrier des activités.

Ensuite, deux vues s'occupent de mettre en forme tout ça. Le Main ne fait qu'appeler le menu général.

Dès le départ j'ai essayé de sécurisé le code pour que l'utilisateur ne puisse pas rentrer n'importe quoi dans les champs. 
J'ai utilsé des expressions régulières et des try/catch pour ça, mais il reste des inputs qui ne sont pas sécurisés pour le moment. 

Globalement je dirais que je m'attendais à galérer plus que ça. Je me suis retrouvé assez vite à formuler un besoin dans mon esprit et à la coder rapidement.
J'ai essayé le plus possible de mettre dans des méthodes ce qui était utilisé à plusieurs endroits dans le code. Ce n'est sans doute pas parfait mais je l'avais en tête.

Il n'est pour le moment pas possible de gérer les repas et les logements, ainsi que les tarifs. Mais la gestion des activités marche bien.
J'aimerais juste qu'une activité ne puisse pas être créée avant la date actuelle.


