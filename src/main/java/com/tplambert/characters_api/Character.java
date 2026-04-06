package com.tplambert.characters_api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Character{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long characterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
    
    private int age;

    private String region;

    private String role;

    public Character(){
    }
    public Character(String name, String desc, String region, String role){
        this.name = name;
        this.description = desc;
        this.region = region;
        this.role = role;
    }
    public Character(String name, String desc, int age, String region, String role){
        this.name = name;
        this.description = desc;
        this.age = age;
        this.region = region;
        this.role = role;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public void setRegion(String region){
        this.region = region;
    }
    
    public void setRole(String role){
        this.role = role;
    }

    //getters
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getAge(){
        return this.age;
    }

    public String getRegion(){
        return this.region;
    }

    public String getRole(){
        return this.role;
    }

    public long getCharacterId(){
        return this.characterId;
    }
}
