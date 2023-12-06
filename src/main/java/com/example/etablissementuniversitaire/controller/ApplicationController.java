package com.example.etablissementuniversitaire.controller;

import com.example.etablissementuniversitaire.entity.*;
import com.example.etablissementuniversitaire.service.IClasseService;
import com.example.etablissementuniversitaire.service.ICoursClassroomService;
import com.example.etablissementuniversitaire.service.IUtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class ApplicationController {
     IClasseService classeService;
     ICoursClassroomService coursClassroomService;
     IUtilisateurService utilisateurService;

@PostMapping("/useradd")
 Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
    return utilisateurService.ajouterUtilisateur(utilisateur);
}

    @PostMapping("/addClasse")
    Classe ajouterClasse(@RequestBody Classe classe) {
        return classeService.ajouterClasse(classe);
    }

    @PostMapping("/ajouterCoursClassroom")
    public CoursClassroom ajouterCoursClassroom (@RequestBody CoursClassroom cc,@RequestParam("codeClasse")  Integer codeClasse){
        return coursClassroomService.ajouterCoursClassroom(cc,codeClasse);
    }
    @PutMapping("/affecterUtilisateurClasse")
    public void affecterUtilisateurClasse (@RequestParam("idUtilisateur")Integer idUtilisateur,@RequestParam("codeClasse") Integer codeClasse){
         utilisateurService.affecterUtilisateurClasse(idUtilisateur,codeClasse);
    }

    @GetMapping("/nbUtilisateursParNiveau")
    public Integer nbUtilisateursParNiveau(@RequestParam("Niveau")Niveau nv){
        return utilisateurService.nbutilisateursParNiveau(nv);
    }
    @PutMapping("/desaffecterCoursClassroomClasse")
    public void desaffecterCoursClassroomClasse(Integer idCours){
         coursClassroomService.desaffecterCoursClassroomClasse(idCours);
    }
    @PutMapping("/archive")
    void archive() {
        coursClassroomService.archiverCoursClassrooms();
    }
    public Integer nbHeuresParSpecEtNiv(@RequestParam("Specialite")Specialite sp,@RequestParam("Niveau") Niveau nv){
       return coursClassroomService.nbHeuresParSpecEtNiv(sp,nv);
    }


}
