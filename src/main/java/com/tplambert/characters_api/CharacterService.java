package com.tplambert.characters_api;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(Character character){
        return characterRepository.save(character);
    }

    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    public Character updateCharacter(Long id, Character updateCharacter){
        return characterRepository.findById(id)
            .map(character->{
                character.setName(updateCharacter.getName());
                character.setDescription(updateCharacter.getDescription());
                character.setAge(updateCharacter.getAge());
                character.setRegion(updateCharacter.getRegion());
                character.setRole(updateCharacter.getRole());
                return characterRepository.save(character);
            })
            .orElse(null);
    }

    public Character getCharacterById(Long id){
        return characterRepository.findById(id).orElse(null);
    }

    public List<Character> getCharacterByName(String name){
        return characterRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Character> getCharacterByRegion(String region){
        return characterRepository.findByRegionContainingIgnoreCase(region);
    }

    public List<Character> getCharacterByRole(String role){
        return characterRepository.findByRole(role);
    }
    
    public List<Character> getAllCharactersSortedByRegion() {
        return characterRepository.findAllByOrderByRegionAsc();
    }

    public List<Character> getAllCharactersSortedByRole() {
        return characterRepository.findAllByOrderByRoleAsc();
    }
}
