package com.tplambert.characters_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/characters")
public class CharacterUiController {
    private final CharacterService characterService;

    public CharacterUiController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping({"/",""})
    public String getAllCharacters(Model model){
        model.addAttribute("characterList", characterService.getAllCharacters());
        model.addAttribute("title", "All Characters");

        return "character-list";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model){
        Character character = characterService.getCharacterById(id);
        if(character!= null){
            model.addAttribute("character", character);
            model.addAttribute("title","Character Details");
        } else {
            model.addAttribute("errorMessage", "Character not found");
            model.addAttribute("title", "Error");
            return "error";
        }
        return "character-details";
    }

    @GetMapping("/region/{region}")
    public String getCharactersByRegion(@PathVariable String region, Model model){
        model.addAttribute("characterList", characterService.getCharactersByRegion(region));
        model.addAttribute("title", "Characters in " + region);

        return "character-list";
    }

    @GetMapping("/role/{role}")
    public String getCharactersByRole(@PathVariable String role, Model model){
        model.addAttribute("characterList", characterService.getCharactersByRole(role));
        model.addAttribute("title", "Characters with Role:" + role);

        return "character-list";
    }

    @GetMapping("/name/{name}")
    public String getCharactersByName(@PathVariable String name, Model model){
        model.addAttribute("characterList", characterService.getCharactersByName(name));
        model.addAttribute("title","Search Results for: "+ name);

        return "character-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);

        return "redirect:/characters/";
    }

    @GetMapping("/add")
    public String showAddCharacterForm(Model model){
        model.addAttribute("character", new Character());
        model.addAttribute("title", "Add New Character");
        
        return "character-form";
    }

    @PostMapping("/")
    public String addCharacter(Character character, MultipartFile picture){
        Character newCharacter = characterService.createCharacter(character);
        if (newCharacter != null){
            //add picture handler in service
            return "redirect:/characters/" + newCharacter.getCharacterId();
        } else {
            return "redirect:/characters/add/?error=true";
        }
    }

    @PostMapping("/update/{id}")
    public String updateCharacter(@PathVariable Long id, Character updatedCharacter, MultipartFile picture){
        Character character = characterService.updateCharacter(id, updatedCharacter);
        if (character!=null){
            //add picture handler in service!!
            return "redirect:/characters/" + character.getCharacterId();
        }
        else {
            return "redirect:/characters/update/" + id + "?error=true";
        }
    }

}
