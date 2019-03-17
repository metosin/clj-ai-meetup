# AI Case Studies in Clojure

This repository contains example AI problems and solutions for hands-on tutorial at Clojure Tampere Meetup on March 26th, 2019.

## Problem and solution branches

The problem description is in the `master` branch. If you need some help, example solution can be found in the `solution` branch. 

## Getting started

Follow these steps to quickly setup an IDE and get coding with Clojure: 

- Clone this repository to your local computer
- Install [Clojure command line tools](https://clojure.org/guides/getting_started) (preferred), which support both Mac and Linux
  * If you are using Windows, install [Leiningen](https://leiningen.org/) instead.
- Start the Nightlight IDE using Clojure CLI:
  * `clj -m nightlight.core`
  * When using Leiningen, use the spell `lein nightlight`
- Point your browser to [`http://localhost:4000`](http://localhost:4000). Behold the IDE!
- Create a new file to the project, and turn on insta-REPL to evaluate your code as you type. 

## General Problem Solver

We will investigate General Problem Solver (GPS) in the session. We will implement the GPS in Clojure, and apply it to two example problems: [Driving to Nursery School](https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md#44-stage-4-test) and [Monkey and Bananas](https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md#412-the-new-domain-problem-monkey-and-bananas). 

Our solution will draw inspiration from the simplest GPS implementation in [Paradigms of Artificial Intelligence Programming: Case Studies in Common Lisp by Peter Norvig (1992)](https://github.com/norvig/paip-lisp). We shall modify the implementation a bit, to make it more Clojure-like and REPL-friendly.

### Example solution

Try the example GPS program using the (insta-)REPL, or try running the two examples with `clj -m gps.solver` (Linux/Mac) or `lein run` (Windows).

### Task

Create a new file `src/solver.clj` and write a means-end solver similar to [Norvig's naïve GPS solver](https://github.com/norvig/paip-lisp/blob/master/docs/chapter4.md#43-stage-3-implementation).

## License

Copyright (c) 2019 Toni Vanhala and contributors. MIT License. See [`LICENSE`](./LICENSE).
