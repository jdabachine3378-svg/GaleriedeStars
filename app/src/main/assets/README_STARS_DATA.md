# Fichier stars_data.json - Guide d'utilisation

## Description
Le fichier `stars_data.json` contient toutes les informations sur les stars, y compris leurs images. L'application charge automatiquement ces données au démarrage.

## Structure du fichier JSON

```json
{
  "stars": [
    {
      "id": 1,
      "name": "Nom de la star",
      "rating": 4.5,
      "imageResId": "star_1",
      "imageAssetName": "nom_image.png"
    }
  ]
}
```

## Champs expliqués

- **id**: Identifiant unique de la star (nombre entier)
- **name**: Nom complet de la star (chaîne de caractères)
- **rating**: Note moyenne de la star (nombre décimal entre 0 et 5)
- **imageResId**: Nom de la ressource drawable (sans le préfixe R.drawable.)
- **imageAssetName**: Nom du fichier image dans le dossier assets (optionnel)

## Comment ajouter des images

### Option 1: Images dans le dossier drawable
1. Placez vos images PNG/JPG dans `app/src/main/res/drawable/`
2. Nommez-les (ex: `leonardo.png`)
3. Dans le JSON, mettez `"imageResId": "leonardo"` (sans extension)

### Option 2: Images dans le dossier assets (recommandé)
1. Placez vos images PNG/JPG dans `app/src/main/assets/`
2. Nommez-les (ex: `leonardo_dicaprio.png`)
3. Dans le JSON, mettez `"imageAssetName": "leonardo_dicaprio.png"`

### Option 3: Les deux méthodes
Vous pouvez utiliser les deux méthodes en même temps. L'application chargera d'abord depuis assets, puis depuis drawable si l'image assets n'existe pas.

## Exemple complet

```json
{
  "stars": [
    {
      "id": 1,
      "name": "Leonardo DiCaprio",
      "rating": 4.5,
      "imageResId": "star_1",
      "imageAssetName": "leonardo_dicaprio.png"
    },
    {
      "id": 2,
      "name": "Jennifer Lawrence",
      "rating": 4.7,
      "imageResId": "star_2",
      "imageAssetName": ""
    }
  ]
}
```

## Formats d'image supportés
- PNG (recommandé pour la transparence)
- JPG/JPEG
- WEBP

## Taille recommandée
- Minimum: 200x200 pixels
- Format: Carré (1:1) pour un meilleur rendu circulaire
- Résolution: 300x300 ou 400x400 pixels pour une meilleure qualité

## Notes importantes
- Les noms de fichiers dans drawable doivent être en minuscules et sans espaces
- Les noms de fichiers dans assets peuvent contenir des underscores
- Si `imageAssetName` est vide ou absent, seule l'image drawable sera utilisée
- Si les deux sont définis, l'image assets a la priorité

