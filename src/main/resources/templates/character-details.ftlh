<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>${character.name} &mdash; Yordle Wiki</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>

<nav>
  <span class="site-title">YORDLE WIKI</span>
  <a href="/characters/">Home</a>
  <a href="/characters/about">About</a>
  <a href="/characters/add">Add a Character</a>
</nav>

<div class="page-wrapper">

  <a class="back-link" href="/characters/">&larr; Back to Gallery</a>

  <div class="detail-header">
    <img src="${character.imageUrl!''}" alt="${character.name}" />
    <div class="detail-info">
      <h1>${character.name}</h1>
      <span class="role-badge">${character.role!''}</span>
      <table class="meta-table">
        <tr><td>Region</td><td>${character.region!''}</td></tr>
        <tr><td>Species</td><td>${character.species!''}</td></tr>
        <tr><td>Role</td><td>${character.role!''}</td></tr>
        <tr><td>Age</td><td>${character.age!''}</td></tr>
        <tr><td>ID</td><td>${character.characterId?c}</td></tr>
      </table>

      <div class="action-row">
        <a class="btn-edit" href="/characters/updateForm/${character.characterId?c}">Edit</a>
        <a class="btn-delete"
           href="/characters/delete/${character.characterId?c}"
           onclick="return confirm('Delete ${character.name}?')">Delete</a>
      </div>
    </div>
  </div>

  <div class="section">
    <h2>Description</h2>
    <p>${character.description}</p>
  </div>

</div>

<footer>
  Yordles Gallery -------------------------------------------------------------------------- Thomas Lambert, CSC 340.
</footer>

</body>
</html>
