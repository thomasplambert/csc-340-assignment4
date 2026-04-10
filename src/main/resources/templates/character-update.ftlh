<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>${title!"Edit Character"} : Yordles Gallery</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>

<nav>
  <span class="site-title">YORDLE GALLERY</span>
  <a href="/characters/">Home</a>
  <a href="/characters/about">About</a>
  <a href="/characters/add">Add a Character</a>
</nav>

<div class="page-wrapper">
  <h1 style="font-size:22px; margin-bottom:6px;">${title!"Edit Character"}</h1>
  <p class="page-subtitle">Editing: ${character.name}</p>

  <#-- Show error notice if redirected back with ?error=true -->
  <#if RequestParameters.error??>
    <div class="notice">Something went wrong. Please check your input and try again.</div>
  </#if>

  <form method="post" action="/characters/update/${character.characterId?c}">

    <div class="form-group">
      <label for="name">Name <span class="required">*</span></label>
      <input type="text" id="name" name="name" required value="${character.name}" />
    </div>

    <div class="form-group">
      <label for="region">region <span class="required">*</span></label>
      <input type="text" id="region" name="region" required value="${character.region!''}" />
    </div>

    <div class="form-group">
      <label for="role">Role <span class="required">*</span></label>
      <select id="role" name="role" required>
        <option value="">-- Select a role --</option>
        <#list ["Tank", "Mage", "Marksman", "Assassin", "Support", "Fighter"] as r>
          <option value="${r}" <#if character.role?? && character.role == r>selected</#if>>${r}</option>
        </#list>
      </select>
    </div>

    <div class="form-group">
      <label for="age">Age</label>
      <input type="number" id="age" name="age" step="any" required value="${character.age!''}" />
    </div>

    <div class="form-group">
      <label for="imageUrl">Image URL</label>
      <input type="url" id="imageUrl" name="imageUrl" value="${character.imageUrl!''}" />
    </div>

    <div class="form-group">
      <label for="description">Description <span class="required">*</span></label>
      <textarea id="description" name="description" required>${character.description}</textarea>
    </div>

    <div class="submit-row">
      <button class="btn-submit" type="submit">Save Changes</button>
      <a class="btn-cancel" href="/characters/${character.characterId?c}">Cancel</a>
    </div>

  </form>
</div>

<footer>
  Yordles Gallery -------------------------------------------------------------------------- Thomas Lambert, CSC 340.
</footer>

</body>
</html>
