homem(miguel).
homem(joao).
homem(pedro).
homem(marco).
homem(carlos).

mulher(maria).
mulher(paula).
mulher(carla).
mulher(cristina).
mulher(ana).

clube(porto).
clube(academica).
clube(sporting).
clube(benfica).
clube(belenenses).

animal(raposa).
animal(cavalo).
animal(tartaruga).
animal(cao).
animal(gato).

bebida(agua).
bebida(cha).
bebida(leite).
bebida(sumo).
bebida(cafe).

cor(amarela).
cor(azul).
cor(vermelha).
cor(branca).
cor(verde).

casa(1).
casa(2).
casa(3).
casa(4).
casa(5).

pref(miguel,paula,5).
pref(miguel,ana,4).
pref(miguel,maria,3).
pref(miguel,carla,2).
pref(miguel,cristina,1).

pref(maria,carlos,5).
pref(maria,miguel,4).
pref(maria,marco,3).
pref(maria,joao,2).
pref(maria,pedro,1).

pref(joao,maria,5).
pref(joao,paula,4).
pref(joao,carla,3).
pref(joao,cristina,2).
pref(joao,ana,1).

pref(paula,marco,5).
pref(paula,carlos,4).
pref(paula,joao,3).
pref(paula,miguel,2).
pref(paula,pedro,1).

pref(pedro,paula,5).
pref(pedro,carla,4).
pref(pedro,ana,3).
pref(pedro,cristina,2).
pref(pedro,maria,1).

pref(carla,miguel,5).
pref(carla,marco,4).
pref(carla,joao,3).
pref(carla,pedro,2).
pref(carla,carlos,1).

pref(marco,maria,5).
pref(marco,carla,4).
pref(marco,paula,3).
pref(marco,cristina,2).
pref(marco,ana,1).

pref(cristina,pedro,5).
pref(cristina,joao,4).
pref(cristina,marco,3).
pref(cristina,miguel,2).
pref(cristina,carlos,1).

pref(carlos,ana,5).
pref(carlos,carla,4).
pref(carlos,paula,3).
pref(carlos,maria,2).
pref(carlos,cristina,1).

pref(ana,marco,5).
pref(ana,joao,4).
pref(ana,pedro,3).
pref(ana,carlos,2).
pref(ana,miguel,1).

% --- geradores ---
1{cor_casa(H, C): cor(C)}1 :- casa(H).
1{vive_em(H, P): homem(P)}1 :- casa(H).
1{adepto(C, P): homem(P)}1 :- clube(C).
1{bebe(H, B): bebida(B)}1 :- casa(H).
1{casado(H, M): mulher(M)}1 :- homem(H).
1{dona(M, A): animal(A)}1 :- mulher(M).

:- cor_casa(H1, C1), cor_casa(H2, C1), H1 != H2.
:- vive_em(H1, P1), vive_em(H2, P1), H1 != H2.
:- adepto(C1, P1), adepto(C2, P1), C1 != C2.
:- bebe(C1, B1), bebe(C2, B1), C1 != C2.
:- casado(H1, M1), casado(H2, M1), H1 != H2.
:- dona(M1, A1), dona(M2, A1), M1 != M2.
% -----------------

% --- restricoes ---
filho(miguel, joao). %1

filho(joao, pedro). %2

filho(marco, pedro). %3

filho(carlos, marco). %4

cor_casa(H1, vermelha) :- vive_em(H1, P), filho(carlos, P). %5

dona(M1, cao) :- casado(miguel, M1). %6

vive_em(1, A) :- filho(carlos, P), filho(P, A). %7

cor_casa(C1, amarela) :- vive_em(C1, P1), adepto(porto, P1). %8

%---9---
:- adepto(academica, H1), vive_em(C1, H1), dona(M1, raposa), casado(H2, M1), vive_em(C2, H2), C1==C2. %9
:- adepto(academica, H1), vive_em(C1, H1), dona(M1, raposa), casado(H2, M1), vive_em(C2, H2), C1>C2+1. %9
:- adepto(academica, H1), vive_em(C1, H1), dona(M1, raposa), casado(H2, M1), vive_em(C2, H2), C1<C2-1. %9
%-------

%---10---
:- vive_em(C1, pedro), cor_casa(C2, azul), C1==C2.
:- vive_em(C1, pedro), cor_casa(C2, azul), C1>C2+1.
:- vive_em(C1, pedro), cor_casa(C2, azul), C1<C2-1.
%--------

dona(M1, tartaruga) :- adepto(sporting, H1), casado(H1, M1). %11

bebe(C1, sumo) :- vive_em(C1, A), adepto(A, benfica). %12

bebe(C1, cha) :- vive_em(C1, P), filho(miguel, P). %13

adepto(belenenses, F) :- filho(F, marco). %14

%---15---
:- adepto(porto, H1), vive_em(C1, H1), dona(M1, cavalo), casado(H2, M1), vive_em(C2, H2), C1==C2.
:- adepto(porto, H1), vive_em(C1, H1), dona(M1, cavalo), casado(H2, M1), vive_em(C2, H2), C1>C2+1.
:- adepto(porto, H1), vive_em(C1, H1), dona(M1, cavalo), casado(H2, M1), vive_em(C2, H2), C1<C2-1.
%--------

cor_casa(C1, verde) :- bebe(C1, cafe). %16

cor_casa(C1, branca) :- cor_casa(C1+1, verde) . %17

bebe(3, leite). %18

casado(pedro, ana). %19

:- casado(carlos, maria). %20

:- casado(H1, M1), casado(H2, M2), H1!=H2, pref(H1, M1, N1), pref(H1, M2, N2), N1 < N2, pref(M1, H1, N3), pref(M1, H2, N4) , N3 < N4.

#show dona/2.
#show vive_em/2.