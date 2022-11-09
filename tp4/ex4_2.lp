team(a; b; c; d; e; f).
group(g1; g2).
match(1..6).

3{in(E,G): team(E)}3:- group(G). %Um grupo G tem que conter 3 e apenas 3 equipas
1{in(E,G): group(G)}1 :- team(E). % cada equipa pertence a 1 e apenas 1  grupo

2{plays(T,M) : team(T)}2 :- match(M).
2{plays(T,M) : match(M)} :- team(T).



:- in(a,g1).
:- in(a,G), in(e,G).
:- in(e,G), in(f,G).
:- in(b,G), not in(c,G).

:- plays(T1, Ma), plays(T2, Ma), in(T1, G1), in(T2, G2), G1 != G2.
:- plays(b, 6).
:- plays(c, M1), plays(d, M2), M1+1 == M2.
:- plays(T, M1), plays(T, M2), M1+1 == M2.
plays(f, 1).
plays(f, 3).

