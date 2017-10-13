# Projet SNCF Entretien

Sujets d'attention :

- Général
    - Tests unitaires
    - Architecture
- `Main`
    - Nommage de la classe
    - Noms d'attributs
- `MainActivity`
    - Appel d'une `AsyncTask` non statique
    - Appel de l'API quand on revient de `MainWebViewActivity`
- `MainAdapter`
    - Référence vers l'activité
    - Déclaration de `MainHolder` en classe non statique
    - Utilisation de l'activité pour implémenter le `OnClickListener`
- `MainAsyncTask`
    - Gestion de la rotation
    - URL en dur
    - Gestion d'erreur
    - Utilisation de `HttpURLConnection`
    - Alternatives possible aux `AsyncTask`
- `MainWebViewActivity`
    - Constantes en dur
    - Dialogue d'attente pendant le chargement
- `activity_main.xml`
    - RAS
- `item_main.xml`
    - Utilisation de `LinearLayout`s imbriqués
- `activity_webview.xml`
    - Utilisation d'un `LinearLayout`
