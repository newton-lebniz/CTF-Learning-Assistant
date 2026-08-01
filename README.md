# CTF Learning Assistant

A tool that teaches you the prerequisites for a CTF encoding challenge before
handing you the answer — because most decoders just give you the plaintext
and let you stay confused about *why* it worked.

**Live demo:** https://newton-lebniz.github.io/CTF-Learning-Assistant/

## Why this exists

I kept getting stuck on CTF challenges — not because I couldn't solve them,
but because I didn't know what I hadn't learned yet. Every tool I found would
decode the string and stop there. None of them explained the reasoning. So I
built one that shows the concept first and the answer second.

## What it detects and decodes

The **web version** (the live demo above, and what's actively maintained) supports:

| Encoding | Notes |
|---|---|
| Base64 | |
| Hex | |
| Binary | |
| ROT13 / Caesar | Brute-force **and** chi-squared frequency analysis (guesses the shift without trying all 26) |
| Vigenère | |
| Morse | |
| Octal | |
| A1Z26 | |
| URL encoding | |
| Base32 | Added most recently |
| Single-byte XOR | Brute-force, added most recently |

The **CLI version** (`cli-version/CTFDetector.java`) is the original Java
implementation and is currently limited to: Binary, Hex, ROT13/Caesar, Base64,
Octal. It has not yet been updated with the newer detectors — that's an open
item, not a bug.

## How it works (web version)

1. Paste in a string.
2. It's checked against detection patterns for each encoding above.
3. Before decoding, it shows the prerequisite concepts (e.g. ASCII, modular
   arithmetic for Caesar, base conversion) so you understand *why* the string
   is what it is.
4. Optionally, decode it.

For Caesar specifically: instead of brute-forcing all 26 shifts and eyeballing
which one reads like English, it uses chi-squared frequency analysis — English
letters have a stable frequency fingerprint, and the shift that produces the
closest match to that fingerprint wins. [Full writeup →](https://newton-lebniz.github.io/#writing)

## Running the CLI version locally

```bash
cd cli-version
javac CTFDetector.java
java CTFDetector
```
Paste your string when prompted. If recognized, it'll show the prerequisite
concepts, then ask `want to decode it? (y/n)`.

## Known gaps / next up

- CLI version doesn't yet match the web version's encoding coverage
- Chi-squared scoring is unreliable on short ciphertexts (not enough letters
  for the frequency fingerprint to stabilize) — a dictionary-check fallback
  for short inputs is the next fix

## Stack
Java (CLI) · JavaScript, HTML, CSS (web) · Cybersecurity fundamentals
