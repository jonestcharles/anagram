The Java class AnagramMapper uses streams to read in
from file a list of words, and map them against a key
(their letters all lower case and w/o whitespace).

Input and output file names are passed via command line
or run configuration.

Input lines are read as a stream. For each word, a key
is created, which are the characters sorted alphabetically
after being cleaned. Each word is mapped to its key, creating
a list where there are duplicates.

The result is then printed to file. K, V pairs with a List
longer than size 1 are anagrams, and are printed to file.

Last 20 lines of output:
ahnors, [sharon, shoran]
aceiilnst, [inelastic, sciential]
adefoottu, [out of date, out-of-date]
aeioprrt, [pretoria, priorate]
cceennort, [concenter, concentre]
aeinprt, [painter, pertain, pine tar]
aeelmnortw, [water lemon, watermelon]
aeinpst, [panties, sapient]
abddeiors, [broadside, sideboard]
aaaccdefhinnnr, [canadian french, french canadian]
aefkry, [fakery, freaky]
ceiklrst, [stickler, strickle]
aeeglnrr, [erlanger, enlarger]
deiort, [editor, tie rod, triode]
ddeimn, [midden, minded]
adefilmns, [mansfield, fieldsman]
ciillnoot, [cotillion, octillion]
aceeinnprs, [spencerian, inner space]
eforrst, [forrest, forster]
bbinor, [ribbon, robbin]
aadeehmrst, [headmaster, headstream]
