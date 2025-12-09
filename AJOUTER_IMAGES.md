# Guide pour ajouter les images des stars

## 📁 Emplacement des images

Placez toutes les images dans le dossier : **`app/src/main/assets/`**

## 📋 Liste des images requises

Voici les 10 images que vous devez ajouter :

| # | Nom du fichier | Star |
|---|----------------|------|
| 1 | `leonardo_dicaprio.png` | Leonardo DiCaprio |
| 2 | `jennifer_lawrence.png` | Jennifer Lawrence |
| 3 | `tom_hanks.png` | Tom Hanks |
| 4 | `meryl_streep.png` | Meryl Streep |
| 5 | `brad_pitt.png` | Brad Pitt |
| 6 | `emma_stone.png` | Emma Stone |
| 7 | `robert_downey_jr.png` | Robert Downey Jr. |
| 8 | `scarlett_johansson.png` | Scarlett Johansson |
| 9 | `denzel_washington.png` | Denzel Washington |
| 10 | `natalie_portman.png` | Natalie Portman |

## ✅ Étapes à suivre

1. **Préparez vos images** :
   - Format : PNG (recommandé) ou JPG
   - Taille : 300x300 ou 400x400 pixels (format carré)
   - Fond transparent de préférence (pour PNG)

2. **Nommez les fichiers** :
   - Utilisez EXACTEMENT les noms indiqués dans le tableau ci-dessus
   - En minuscules
   - Avec des underscores (_) entre les mots
   - Extension .png ou .jpg

3. **Copiez les fichiers** dans :
   ```
   app/src/main/assets/
   ```

4. **Vérifiez la structure** :
   ```
   app/src/main/assets/
   ├── stars_data.json          ✅ (déjà présent)
   ├── leonardo_dicaprio.png    ⬅️ À ajouter
   ├── jennifer_lawrence.png    ⬅️ À ajouter
   ├── tom_hanks.png            ⬅️ À ajouter
   ├── meryl_streep.png         ⬅️ À ajouter
   ├── brad_pitt.png            ⬅️ À ajouter
   ├── emma_stone.png           ⬅️ À ajouter
   ├── robert_downey_jr.png     ⬅️ À ajouter
   ├── scarlett_johansson.png   ⬅️ À ajouter
   ├── denzel_washington.png    ⬅️ À ajouter
   └── natalie_portman.png      ⬅️ À ajouter
   ```

5. **Recompilez l'application** :
   - Les images seront automatiquement chargées depuis le fichier `stars_data.json`
   - L'application affichera les images des stars dans la liste

## 🔍 Vérification

Le fichier `stars_data.json` est déjà configuré avec tous les noms d'images. Vérifiez qu'il contient bien :

```json
{
  "stars": [
    {
      "id": 1,
      "name": "Leonardo DiCaprio",
      "imageAssetName": "leonardo_dicaprio.png"
    },
    ...
  ]
}
```

## ⚠️ Notes importantes

- Les noms de fichiers doivent correspondre EXACTEMENT à ceux dans `stars_data.json`
- Si une image n'est pas trouvée, l'application utilisera l'image drawable par défaut (étoile colorée)
- Les images seront automatiquement affichées de manière circulaire dans l'application
- Format PNG recommandé pour la transparence du fond

## 🎨 Description des images attendues

D'après les images que vous avez fournies :

1. **Leonardo DiCaprio** : Portrait professionnel, costume bleu marine, cravate à pois, cheveux lissés
2. **Jennifer Lawrence** : Portrait, cheveux châtains clairs volumineux, veste sombre
3. **Tom Hanks** : Portrait mi-corps, costume sombre, nœud papillon, geste de "pistolet"
4. **Meryl Streep** : Portrait professionnel, cheveux blonds ondulés, collier de perles
5. **Brad Pitt** : Portrait, cheveux bruns courts, débardeur blanc
6. **Emma Stone** : Portrait, cheveux châtains avec reflets roux, main sur collier
7. **Robert Downey Jr.** : Portrait professionnel, barbe taillée, chemise rayée, cravate jaune
8. **Scarlett Johansson** : Portrait, cheveux blonds bouclés, rouge à lèvres rouge vif
9. **Denzel Washington** : Portrait professionnel, barbe et moustache taillées, costume
10. **Natalie Portman** : Portrait en pied, robe rouge à motifs, collier scintillant

Une fois les images ajoutées, l'application les affichera automatiquement ! 🎉

