# Instructions pour ajouter les images des stars

## Images à ajouter dans le dossier `app/src/main/assets/`

Voici la liste des images que vous devez ajouter pour chaque star :

### 1. Leonardo DiCaprio
- **Fichier**: `leonardo_dicaprio.png`
- **Description**: Portrait professionnel, costume bleu marine, cravate à pois, cheveux lissés en arrière, barbe légère

### 2. Jennifer Lawrence
- **Fichier**: `jennifer_lawrence.png`
- **Description**: Portrait, cheveux châtains clairs volumineux, veste sombre, fond transparent

### 3. Tom Hanks
- **Fichier**: `tom_hanks.png`
- **Description**: Portrait mi-corps, costume sombre avec nœud papillon noir, geste de "pistolet" avec les doigts, fond transparent

### 4. Meryl Streep
- **Fichier**: `meryl_streep.png`
- **Description**: Portrait professionnel, cheveux blonds ondulés, collier de perles noires, fond transparent

### 5. Brad Pitt
- **Fichier**: `brad_pitt.png`
- **Description**: Portrait, cheveux bruns courts et épais, débardeur blanc, expression sérieuse

### 6. Emma Stone
- **Fichier**: `emma_stone.png`
- **Description**: Portrait, cheveux châtains avec reflets roux, main sur le collier, fond transparent

### 7. Robert Downey Jr.
- **Fichier**: `robert_downey_jr.png`
- **Description**: Portrait professionnel, cheveux châtains foncés, barbe taillée, chemise blanche rayée, cravate jaune, veste grise

### 8. Scarlett Johansson
- **Fichier**: `scarlett_johansson.png`
- **Description**: Portrait, cheveux blonds bouclés, rouge à lèvres rouge vif, haut beige/crème, fond transparent

### 9. Denzel Washington
- **Fichier**: `denzel_washington.png`
- **Description**: Portrait professionnel, cheveux courts, barbe et moustache taillées, chemise rayée, cravate grise, veste beige

### 10. Natalie Portman
- **Fichier**: `natalie_portman.png`
- **Description**: Portrait en pied, robe rouge à motifs noirs, collier scintillant, cheveux châtains, pochette noire, fond transparent

## Étapes pour ajouter les images

1. **Préparez vos images** :
   - Format : PNG (recommandé pour la transparence) ou JPG
   - Taille recommandée : 300x300 pixels ou 400x400 pixels (carré)
   - Fond transparent de préférence (pour PNG)

2. **Nommez les fichiers** exactement comme indiqué ci-dessus (en minuscules, avec underscores)

3. **Copiez les fichiers** dans le dossier :
   ```
   app/src/main/assets/
   ```

4. **Vérifiez que le fichier JSON** (`stars_data.json`) contient bien les bons noms de fichiers

5. **Recompilez l'application** - Les images seront automatiquement chargées !

## Structure du dossier assets

```
app/src/main/assets/
├── stars_data.json          (fichier de configuration)
├── leonardo_dicaprio.png    (à ajouter)
├── jennifer_lawrence.png    (à ajouter)
├── tom_hanks.png            (à ajouter)
├── meryl_streep.png         (à ajouter)
├── brad_pitt.png            (à ajouter)
├── emma_stone.png           (à ajouter)
├── robert_downey_jr.png     (à ajouter)
├── scarlett_johansson.png   (à ajouter)
├── denzel_washington.png    (à ajouter)
└── natalie_portman.png      (à ajouter)
```

## Note importante

- Les noms de fichiers doivent correspondre exactement à ceux dans `stars_data.json`
- Les images seront automatiquement affichées de manière circulaire dans l'application
- Si une image n'est pas trouvée, l'application utilisera l'image drawable par défaut (star_1, star_2, etc.)

