<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>${title!"Yordle Gallery"}</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>

<nav>
  <span class="site-title">YORDLE GALLERY</span>
  <a href="/characters/">Home</a>
  <a href="/characters/about">About</a>
  <a href="/characters/add">Add a Character</a>
</nav>

<div class="page-header">
  <h1>${title!"Yordle Character Gallery"}</h1>
  <p>A collection of Yordle champions from League of Legends.</p>
</div>

<!-- Extra credit: search by name and filter by region/role -->
<div class="controls">
  <form method="get" action="/characters/name/placeholder" id="searchForm">
    <input type="text" id="nameInput" placeholder="Search by name..." />
    <button type="button" onclick="submitSearch()">Search</button>
  </form>

  <form method="get" action="/characters/region/placeholder" id="regionForm">
    <input type="text" id="regionInput" placeholder="Filter by region..." />
    <button type="button" onclick="submitRegion()">Region</button>
  </form>

  <form method="get" action="/characters/role" id="roleForm">
    <select id="roleSelect" name="role" onchange="submitRole()">
      <option value="">-- Filter by role --</option>
      <option value="Tank">Tank</option>
      <option value="Mage">Mage</option>
      <option value="Marksman">Marksman</option>
      <option value="Assassin">Assassin</option>
      <option value="Support">Support</option>
      <option value="Fighter">Fighter</option>
    </select>
  </form>

  <a href="/characters/" class="btn" style="background:#555;">Clear</a>
</div>

<#if characterList?has_content>
  <div class="gallery">
    <#list characterList as character>
      <div class="card">
        <img src="${character.imageUrl!''}" alt="${character.name}" />
        <div class="card-body">
          <h2>${character.name}</h2>
          <span class="role">${character.role!''}:${character.region!''}</span>
          <p>${character.description}</p>
        </div>
        <div class="card-footer">
          <a href="/characters/${character.characterId?c}">View Details &rarr;</a>
          <a class="del" href="/characters/delete/${character.characterId?c}"
             onclick="return confirm('Delete ${character.name}?')">Delete</a>
        </div>
      </div>
    </#list>
  </div>
<#else>
  <p class="no-results">No characters found.</p>
</#if>

<script>
  function submitSearch() {
    const val = document.getElementById('nameInput').value.trim();
    if (val) window.location.href = '/characters/name/' + encodeURIComponent(val);
  }
  function submitRegion() {
    const val = document.getElementById('regionInput').value.trim();
    if (val) window.location.href = '/characters/region/' + encodeURIComponent(val);
  }
  function submitRole() {
    const val = document.getElementById('roleSelect').value;
    if (val) window.location.href = '/characters/role/' + val;
  }
</script>

<footer>
  Yordles Gallery -------------------------------------------------------------------------- Thomas Lambert, CSC 340.
</footer>
</body>
</html>
