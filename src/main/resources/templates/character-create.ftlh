<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>${title!"Add a Character"} &mdash; Yordle Wiki</title>
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
  <h1 style="font-size:22px; margin-bottom:6px;">${title!"Add a Character"}</h1>
  <p class="page-subtitle">Fill in the details below to add a new Yordle to the gallery.</p>

  <#--  error notice  -->
  <#if RequestParameters.error??>
    <div class="notice">Something went wrong. Please check your input and try again.</div>
  </#if>

  <form method="post" action="/characters/">

    <div class="form-group">
      <label for="name">Name <span class="required">*</span></label>
      <input type="text" id="name" name="name" required />
    </div>

    <div class="form-group">
      <label for="region">region <span class="required">*</span></label>
      <input type="text" id="region" name="region" required />
    </div>

    <div class="form-group">
      <label for="role">Role <span class="required">*</span></label>
      <select id="role" name="role" required>
        <option value="">-- Select a role --</option>
        <option value="Tank">Tank</option>
        <option value="Mage">Mage</option>
        <option value="Marksman">Marksman</option>
        <option value="Assassin">Assassin</option>
        <option value="Support">Support</option>
        <option value="Fighter">Fighter</option>
      </select>
    </div>

    <div class="form-group">
      <label for="species">Species</label>
      <input type="text" id="species" name="species" placeholder="Yordle" />
    </div>

    <div class="form-group">
      <label for="age">Age</label>
      <input type="number" id="age" name="age" required step="any" />
    </div>

    <div class="form-group">
      <label for="imageUrl">Image</label>
      <input type="url" id="imageUrl" name="imageUrl"  />
    </div>

    <div class="form-group">
      <label for="description">Description <span class="required">*</span></label>
      <textarea id="description" name="description" required placeholder="A brief summary of the character, or their favorite one-liner."></textarea>
    </div>

    <div class="submit-row">
      <button class="btn-submit" type="submit">Add Character</button>
      <a class="btn-cancel" href="/characters/">Cancel</a>
    </div>

  </form>
</div>

<footer>
  Yordles Gallery -------------------------------------------------------------------------- Thomas Lambert, CSC 340.
</footer>

</body>
</html>
