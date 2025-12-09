StarsGallery - Application Android

Une application Android moderne pour gérer et noter vos stars préférées (acteurs et actrices).

## 📱 Fonctionnalités

- ✨ **Splash Screen animé** : Animation fluide au démarrage de l'application
- 📋 **Liste des stars** : Affichage vertical avec RecyclerView
- 🔍 **Recherche en temps réel** : Filtrage instantané par nom via SearchView
- ⭐ **Système de notation** : Modification de la note via un popup personnalisé
- 📤 **Partage** : Menu de partage intégré dans la Toolbar
- 🖼️ **Images circulaires** : Affichage élégant avec images circulaires pour chaque star
- 🔄 **Mise à jour dynamique** : Rafraîchissement automatique après modification

##  Architecture

Le projet suit une architecture **MVC (Model-View-Controller)** avec séparation des couches :

```
app/src/main/java/com/example/app/
├── beans/          # Modèles de données (Star)
├── dao/            # Interface générique IDao
├── service/        # Logique métier (StarService)
├── adapter/        # Adaptateurs RecyclerView (StarAdapter)
├── ui/             # Activités (SplashActivity, ListActivity)
└── util/           # Utilitaires (ImageLoader, JsonLoader)
```

##  Structure du projet

```
GaleriedeStars/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/app/
│   │   │   ├── beans/Star.java
│   │   │   ├── dao/IDao.java
│   │   │   ├── service/StarService.java
│   │   │   ├── adapter/StarAdapter.java
│   │   │   ├── ui/
│   │   │   │   ├── SplashActivity.java
│   │   │   │   └── ListActivity.java
│   │   │   └── util/
│   │   │       ├── ImageLoader.java
│   │   │       └── JsonLoader.java
│   │   ├── res/
│   │   │   ├── drawable/        # Images des stars (star_1 à star_10)
│   │   │   ├── layout/           # Layouts XML
│   │   │   ├── menu/            # Menu de partage
│   │   │   └── anim/            # Animations
│   │   └── assets/
│   │       ├── stars_data.json  # Configuration des stars
│   │       └── [images PNG]     # Images des stars (optionnel)
│   └── build.gradle.kts
└── README.md
```

## 🚀 Installation

### Prérequis

- Android Studio (version récente)
- JDK 11 ou supérieur
- Android SDK (API 26 minimum)

### Étapes d'installation

1. **Cloner ou télécharger le projet**

2. **Ouvrir le projet dans Android Studio**
   - File → Open → Sélectionner le dossier du projet

3. **Synchroniser les dépendances**
   - Android Studio synchronisera automatiquement Gradle
   - Ou : File → Sync Project with Gradle Files

4. **Exécuter l'application**
   - Cliquer sur le bouton Run (▶️)
   - Ou : Run → Run 'app'

## 🖼️ Ajout d'images des stars

### Méthode 1 : Images dans le dossier drawable (recommandé)

1. Placez vos images PNG/JPG dans `app/src/main/res/drawable/`
2. Nommez-les (ex: `leonardo.png`, `jennifer.jpg`)
3. Mettez à jour `StarService.java` :
```java
stars.add(new Star(1, "Leonardo DiCaprio", 4.5f, R.drawable.leonardo));
```

### Méthode 2 : Images dans le dossier assets

1. Placez vos images dans `app/src/main/assets/`
2. Nommez-les selon le fichier `stars_data.json` :
   - `leonardo_dicaprio.png`
   - `jennifer_lawrence.png`
   - `tom_hanks.png`
   - etc.

3. Le fichier `stars_data.json` est déjà configuré avec ces noms

### Format des images

- **Format** : PNG (recommandé) ou JPG
- **Taille** : 300x300 ou 400x400 pixels (format carré)
- **Fond** : Transparent de préférence (pour PNG)

## Configuration des stars

Les stars sont configurées dans le fichier `app/src/main/assets/stars_data.json` :

```json
{
  "stars": [
    {
      "id": 1,
      "name": "Leonardo DiCaprio",
      "rating": 4.5,
      "imageResId": "star_1",
      "imageAssetName": "leonardo_dicaprio.png"
    }
  ]
}
```

### Champs disponibles

- `id` : Identifiant unique (entier)
- `name` : Nom complet de la star (string)
- `rating` : Note moyenne entre 0 et 5 (décimal)
- `imageResId` : Nom de la ressource drawable (sans préfixe R.drawable.)
- `imageAssetName` : Nom du fichier dans assets (optionnel)

## 🎨 Personnalisation

### Modifier les couleurs

Les couleurs sont définies dans `app/src/main/res/values/colors.xml`

### Modifier les thèmes

Les thèmes sont définis dans `app/src/main/res/values/themes.xml`

### Ajouter de nouvelles stars

1. Ajoutez une entrée dans `stars_data.json`
2. Ou modifiez `StarService.java` dans la méthode `initStars()`

## 🔧 Dépendances

Le projet utilise les bibliothèques suivantes :

- `androidx.appcompat:appcompat` - Support des fonctionnalités Android
- `com.google.android.material:material` - Composants Material Design
- `androidx.recyclerview:recyclerview` - RecyclerView pour les listes
- `androidx.cardview:cardview` - CardView pour les cartes
- `androidx.coordinatorlayout:coordinatorlayout` - CoordinatorLayout

Voir `gradle/libs.versions.toml` pour les versions exactes.

## 📱 Utilisation de l'application

1. **Démarrage** : L'application affiche un splash screen animé (2 secondes)

2. **Liste des stars** : 
   - Affichage de toutes les stars avec leur image et note
   - Scroll vertical pour parcourir la liste

3. **Recherche** :
   - Utilisez la barre de recherche en haut
   - Filtrage instantané par nom

4. **Modifier une note** :
   - Cliquez sur une star dans la liste
   - Un popup s'ouvre avec un RatingBar et un champ de texte
   - Modifiez la note (0 à 5) et cliquez sur "Enregistrer"

5. **Partager l'application** :
   - Cliquez sur l'icône de partage dans la Toolbar
   - Choisissez l'application de partage (Gmail, WhatsApp, etc.)

## 🐛 Dépannage

### Les images ne s'affichent pas

1. Vérifiez que les fichiers images existent dans `assets/` ou `drawable/`
2. Vérifiez que les noms correspondent exactement à ceux dans `stars_data.json`
3. Si les images assets n'existent pas, l'application utilisera automatiquement les drawables `star_1` à `star_10`

### L'application ne démarre pas

1. Vérifiez que toutes les dépendances sont synchronisées
2. Nettoyez le projet : Build → Clean Project
3. Reconstruisez : Build → Rebuild Project

### Erreur de compilation

1. Vérifiez que vous utilisez JDK 11 ou supérieur
2. Vérifiez que le SDK Android est correctement configuré
3. Synchronisez Gradle : File → Sync Project with Gradle Files




https://github.com/user-attachments/assets/dbd92dae-30fb-4798-9937-3a5dbd242b96


##  Auteur
jamila dabachine
Projet créé dans le cadre d'un cours Android.


Pour toute question ou problème, consultez la documentation Android ou les fichiers d'aide dans le dossier `assets/`.

---

**Bon développement ! 🚀**
