package com.tplambert.characters_api;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{
    List<Character> findByNameContainingIgnoreCase(String name);
    List<Character> findByRegionContainingIgnoreCase(String region);
    List<Character> findByRole(String role);
    List<Character> findAllByOrderByRegionAsc();
    List<Character> findAllByOrderByRoleAsc();
}
