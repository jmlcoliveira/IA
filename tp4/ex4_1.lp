% 4.I

% factos
team(a;b;c;d;e;f).
group(g1;g2).


3{in(E,G): team(E)}3:- group(G). %Um grupo G tem que conter 3 e apenas 3 equipas
1{in(E,G): group(G)}1 :- team(E). % cada equipa pertence a 1 e apenas 1  grupo

:- in(a,g1).
:- in(a,G), in(e,G).
:- in(e,G), in(f,G).
:- in(b,G), not in(c,G).
