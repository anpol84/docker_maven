package org.example.components.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final MyPetRepository myPetRepository;
    @Autowired
    public PetService(PetRepository petRepository, MyPetRepository myPetRepository) {
        this.petRepository = petRepository;
        this.myPetRepository = myPetRepository;
    }

    public Iterable<Pet> findAll(){
        return petRepository.findAll();
    }

    public void save(Pet pet){
        petRepository.save(pet);
    }

    public void deleteById(Long id){
        petRepository.deleteById(id);
    }

    public Optional<Pet> findById(Long id){
        return petRepository.findById(id);
    }

    public Iterable<Pet> filter(String kind, Double weight, String alias, String gender, String color, Double price){
        return myPetRepository.filter(kind, weight, alias, gender, color, price);
    }
}
