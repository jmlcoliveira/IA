vertex(1). vertex(2). vertex(3). vertex(4). vertex(5). vertex(6).
edge(1,2). edge(1,3). edge(2,4). edge(3,5). edge(4,5). edge(4,6).
threshold(3).

{select(V) : vertex(V)}N :- threshold(N).

%forma 1
:- edge(N1, N2), not select(N1), not select(N2). 

%forma 2
covered(V1, V2) :- edge(V1, V2), select(V1).
covered(V1, V2) :- edge(V1, V2), select(V2).
:- edge(V1, V2), not covered(V1, V2).

#show select/1.
