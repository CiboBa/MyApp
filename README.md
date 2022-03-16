# MyApp

Aplikacja konsolowa symulująca sklep.

Funkcjonalności:
1. Sterowanie poprzez wybór klawisza przypisanego do opcji
2. Klasa abstrakcyjna User oraz dwa typy użytkownika dziedziczące po niej (Admin i StandardUser)
3. Weryfikacja logowania poprzez sprawdzenie statycznej listy użytkowników
4. Opcje Admina:
a) zarządzanie użytkownikami: dodaj, wyszukaj, edytuj, usuń
b) zarządzanie produktami: dodawanie, edycja usuwanie
- wyszukiwanie po nazwie (contains)
- wyszukiwanie po kategorii (equals)
- możliwość wejścia w wyszukany produkt (przekeirowanie do edycji)
- mozliwosć usunięcia kilku produktów na raz (po numerach id, oddzielonych spacją)
