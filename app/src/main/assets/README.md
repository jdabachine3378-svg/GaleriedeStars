# Images des Stars

Pour ajouter des images pour les stars, placez vos fichiers image dans ce dossier (`app/src/main/assets/`).

## Format des images
- Formats supportés: PNG, JPG, JPEG, WEBP
- Taille recommandée: 200x200 pixels ou plus (carré)
- Les images seront automatiquement redimensionnées et affichées de manière circulaire

## Nommage des fichiers
Nommez vos fichiers selon les noms des stars ou utilisez un système de numérotation:

Exemples:
- `leonardo_dicaprio.png`
- `jennifer_lawrence.jpg`
- `star_1.png`
- `star_2.png`

## Utilisation dans le code
Les images peuvent être chargées de deux manières:

1. **Depuis assets**: Utilisez `setImageAssetName("nom_fichier.png")` dans la classe Star
2. **Depuis drawable**: Utilisez `setImageResId(R.drawable.nom_image)` dans la classe Star

Le système chargera automatiquement depuis assets en priorité, puis depuis drawable si aucune image asset n'est définie.

