<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Error &mdash; Yordle Gallery</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>

<nav>
  <span class="site-title">YORDLES GALLERY</span>
  <a href="/characters/">Home</a>
  <a href="/characters/about">About</a>
  <a href="/characters/add">Add a Character</a>
</nav>

<div class="page-wrapper">
  <h1 style="font-size:22px; margin-bottom:20px;">${title!"Error"}</h1>
  <div class="error-box">
    ${errorMessage!"An unexpected error occurred."}
  </div>
  <a class="back-link" href="/characters/">&larr; Back to Gallery</a>
</div>

<footer>
  Yordles Gallery -------------------------------------------------------------------------- Thomas Lambert, CSC 340.
</footer>
</body>
</html>
