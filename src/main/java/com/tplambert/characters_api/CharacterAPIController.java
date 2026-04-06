package com.tplambert.characters_api;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterAPIController {
    private final CharacterService characterService;

    public CharacterAPIController(CharacterService characterService){
        this.characterService = characterService;
    }

    /**
   * Endpoint to retrieve all characters.
   *
   * @return ResponseEntity containing a collection of all characters.
   */
    @GetMapping("/")
    public ResponseEntity<List<Character>> getAllCharacters(){
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    /**
   * Endpoint to retrieve a character by their ID.
   *
   * @param id The ID of the character to retrieve.
   * @return ResponseEntity containing the character if found, or a 404 Not Found
   *         status if not found.
   */
  @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterByID(@PathVariable Long id){
        Character character = characterService.getCharacterById(id);
        if (character != null){
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
   * Endpoint to create a new character.
   *
   * @param character The character object to create, provided in the request body.
   * @return ResponseEntity containing the created character if successful, or a 404
   *         Not Found status if creation fails.
   */
    @PostMapping("/")
    public ResponseEntity<Character> createCharacter(@RequestBody Character character){
        Character newCharacter = characterService.createCharacter(character);
        if(newCharacter != null){
            return ResponseEntity.ok(newCharacter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
   * Endpoint to delete a character by their ID.
   *
   * @param id The ID of the character to delete, provided as a path variable.
   * @return ResponseEntity with no content if deletion is successful, or a 404
   *         Not Found status if the student to delete is not found.
   */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCharacter(@PathVariable Long id){
        
        if (characterService.getCharacterById(id) == null){
            return ResponseEntity.notFound().build();
        }
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

    /**
   * Endpoint to update an existing character by their ID.
   *
   * @param id             The ID of the character to update, provided as a path
   *                       variable.
   * @param character      The updated character object, provided in the request
   *                       body.
   * @return ResponseEntity containing the updated character if successful, or a 404
   *         Not Found status if the student to update is not found.
   */
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character){
        Character updatedCharacter = characterService.updateCharacter(id, character);
        if (updatedCharacter != null){
            return ResponseEntity.ok(updatedCharacter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
   * Endpoint to retrieve a characters by their region.
   *
   * @param region The region of the character to retrieve, provided as a
   *              request parameter.
   * @return ResponseEntity containing the character(s) if found, or a 404 Not Found
   *         status if not found. If no region is provided, then ResponseEntity will contain all characters sorted by region
   */
    @GetMapping("/region")
    public ResponseEntity<Collection<Character>> searchByRegion(@RequestParam(required = false)String region){
        List<Character> characters;
        if (region!= null){
            characters = characterService.getCharacterByRegion(region);
            if (characters == null) return ResponseEntity.notFound().build();
        } else {
            characters = characterService.getAllCharactersSortedByRegion();
        }
        return ResponseEntity.ok(characters);
    }
    /**
   * Endpoint to retrieve a characters by their role.
   *
   * @param role The role of the character to retrieve, provided as a
   *              request parameter.
   * @return ResponseEntity containing the character(s) if found, or a 404 Not Found
   *         status if not found. If no role is provided, then ResponseEntity will contain all characters sorted by role
   */
    @GetMapping("/role")
    public ResponseEntity<Collection<Character>> searchByRole(@RequestParam(required = false)String role){
        List<Character> characters;
        if (role!= null){
            characters = characterService.getCharacterByRole(role);
            if (characters == null) return ResponseEntity.notFound().build();
        } else {
            characters = characterService.getAllCharactersSortedByRole();
        }
        return ResponseEntity.ok(characters);
    }

    /**
   * Endpoint to search for characters by name. If the name parameter is provided,
   * it will return characters whose names contain the specified value. If the name
   * parameter is not provided, it will return all characters.
   *
   * @param name The name to search for, provided as a request parameter. This
   *             parameter is optional.
   * @return ResponseEntity containing a collection of characters that match the
   *         search criteria, or all characters if no name is provided.
   */
    @GetMapping("/search")
    public ResponseEntity<Collection<Character>> searchByName(@RequestParam(required = false) String name){
        List<Character> characters;
        if (name != null){
            characters = characterService.getCharacterByName(name);
        } else {
            characters = characterService.getAllCharacters();
        }
        return ResponseEntity.ok(characters);
    }
}
