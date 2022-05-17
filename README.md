# MyApp

Aplikacja konsolowa imitująca sklep (master) + JDBC zaimplementowany

Wytyczne:
1. Sterowanie poprzez wybór klawisza przypisanego do opcji
2. Klasa abstrakcyjna User oraz dwa typy użytkownika dziedziczące po niej (Admin i StandardUser)
3. Weryfikacja logowania poprzez sprawdzenie statycznej listy użytkowników
4. Statyczna lista produktów.
Opcje Admina:
- zarządzanie Użytkownikiem: dodaj, wyszukaj, edytuj, usuń
- po wejścu w danego Użytkownika, możliwość wejścia w jego zamówienia i wyszukania konkretnego zamówienia (equals)
- możliwosć edycji statusu zam.

- zarządzanie Produktem: dodaj, edytuj, usuń, wyszukaj po nazwie (contains), wyszukaj po kategorii (equals)
- możliwość wejścia w wyszukany produkt (przekeirowanie do edycji)
- mozliwosć usunięcia kilku produktów na raz (po numerach id, oddzielonych spacją)

Opcje Standardowego Użytkownika:
- wyszukiwamnie produktu po nazwie (contains) i kategorii (equals)
- możliwośc dodania wybranego produktu do koszyka
- możliwość natychmiastowego kupna wybranego produktu
- historia zamówień: nr zamówienia, status oraz kwota
- po wejściu w zamówienie, widać nazwy produktów, ich ceny oraz ilość
- możliwość zrezygnowania z zamówienia, jeśli nie jest zrealizowane

Klasa z ustawieniami sklepu (jako Singleton), a w niej przechowywane aktualne zniżki
- zarządzanie zniżkami przez Admina: dodaj, usuń, pokaż wszystkie
Konkretne klasy ze strategią zniżki:
- 50% zniżki na drugi przedmiot z danej kategorii
- 10 za każde wydane 100
- 30% na przedmiot
- podgląd zamówienia wyświetlany z zaaplikowanymi zniżkami
