package com.example.etablissementuniversitaire.service.impl;

import com.example.etablissementuniversitaire.entity.Classe;
import com.example.etablissementuniversitaire.entity.CoursClassroom;
import com.example.etablissementuniversitaire.entity.Niveau;
import com.example.etablissementuniversitaire.entity.Specialite;
import com.example.etablissementuniversitaire.repository.ClasseRepository;
import com.example.etablissementuniversitaire.repository.CoursClassroomRepository;
import com.example.etablissementuniversitaire.service.ICoursClassroomService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursClassroomServiceImpl implements ICoursClassroomService {
     CoursClassroomRepository coursClassroomRepository;
     ClasseRepository classeRepository;

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, int codeClasse) {
        Classe classe = classeRepository.findById(codeClasse).get();
        cc.setClasse(classe);
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void desaffecterCoursClassroomClasse(int idCours) {
        CoursClassroom cc = coursClassroomRepository.findById(idCours).get();
        cc.setClasse(null);
        coursClassroomRepository.save(cc);
    }

    @Transactional
    public void archiverCoursClassrooms() {
        coursClassroomRepository.archive();
    }

    @Override
    public int nbHeuresParSpecEtNiv(Specialite specialite, Niveau niveau) {

        int totalHeures = 0;
        List<CoursClassroom> cours = coursClassroomRepository.findBySpecialiteAndClasseNiveau(specialite, niveau);

        for (CoursClassroom c : cours) {
            totalHeures += c.getNbHeures();
        }

        return totalHeures;


    }
}
