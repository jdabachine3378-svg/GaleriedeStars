# Guide d'ajout d'images pour StarsGallery

## Méthode 1: Utiliser des images dans le dossier drawable (recommandé)

1. Placez vos images PNG/JPG dans le dossier `app/src/main/res/drawable/`
2. Nommez-les selon vos préférences (ex: `leonardo.png`, `jennifer.jpg`)
3. Mettez à jour `StarService.java` pour utiliser ces images:

```java
stars.add(new Star(1, "Leonardo DiCaprio", 4.5f, R.drawable.leonardo));
```

## Méthode 2: Utiliser des images dans le dossier assets

1. Placez vos images dans le dossier `app/src/main/assets/`
2. Nommez-les selon vos préférences (ex: `leonardo.png`, `jennifer.jpg`)
3. Mettez à jour `StarService.java` pour utiliser ces images:

```java
stars.add(new Star(1, "Leonardo DiCaprio", 4.5f, R.drawable.star_1, "leonardo.png"));
```

## Formats d'image supportés
- PNG (recommandé pour la transparence)
- JPG/JPEG
- WEBP

## Taille recommandée
- Minimum: 200x200 pixels
- Format: Carré (1:1) pour un meilleur rendu circulaire
- Résolution: 300x300 ou 400x400 pixels pour une meilleure qualité

## Exemple de mise à jour de StarService

```java
private void initStars() {
    // Méthode 1: Avec drawable
    stars.add(new Star(1, "Leonardo DiCaprio", 4.5f, R.drawable.leonardo_dicaprio));
    
    // Méthode 2: Avec assets
    stars.add(new Star(2, "Jennifer Lawrence", 4.7f, R.drawable.star_2, "jennifer_lawrence.png"));
    
    // Les deux méthodes peuvent être mélangées
}
```

## Note importante
- Les noms de fichiers dans drawable doivent être en minuscules et sans espaces
- Les noms de fichiers dans assets peuvent contenir des underscores
- L'application chargera automatiquement les images depuis assets en priorité, puis depuis drawable

